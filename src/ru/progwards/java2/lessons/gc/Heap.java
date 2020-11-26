package ru.progwards.java2.lessons.gc;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Heap {
    private byte h[];
    private int mhs;

    public List<Integer> lb = new ArrayList<>();
    public List<Integer> fb = new ArrayList<>();
    public HashMap<Integer, Integer> hb = new HashMap<>();

    public Heap(int maxHeapSize) {
        mhs = maxHeapSize;
        this.h = new byte[ mhs ];
        fb.add(0);
        hb.put(0, mhs);
    }

    private void copy_block(int in, int to, int size) {
        for (int i = 0; i < size; i++) {
            h[ in + i ] = h[ to + i ];
        }
    }

    public void compact() {
        AtomicInteger busy = new AtomicInteger();

        lb.stream().sorted(Integer::compareTo).reduce(-1, (o1, o2) -> {
            if ( o1 == -1 ) {
                if ( o2 == 0 ) {
                    int size = hb.get(o2);
                    hb.put(0, size);
                    busy.addAndGet(size);
                    return o2;
                }
                else {
                    int size = hb.get(o2);
                    copy_block(o2, 0, size);
                    lb.remove(o2);
                    hb.remove(o2);
                    hb.put(0, size);
                    busy.addAndGet(size);
                    return 0;
                }
            }
            else {
                int size_o1 = hb.get(o1);
                int size_o2 = hb.get(o2);
                int start_o2 = o1 + size_o1;
                copy_block(o2, start_o2, size_o2);
                lb.remove(o2);
                hb.remove(o2);
                lb.add(start_o2);
                hb.put(start_o2, size_o2);
                busy.addAndGet(size_o2);
                return start_o2;
            }
        });

        fb.clear();
        fb.add(busy.get());
        hb.put(busy.get(), mhs - busy.get());
    }

    public void defrag() {
        fb.stream().sorted(Integer::compareTo).reduce((o1, o2) -> {
            if ( o1 + hb.get(o1) == o2 ) {
                hb.put(o1, hb.get(o1) + hb.get(o2));
                hb.remove(o2);
                fb.remove(o2);
                return o1;
            }

            return o2;
        });
    }

    public void free(int ptr) throws InvalidPointerException {
        for (Integer sb: lb) {
            if (sb.equals(ptr)) {
                lb.remove(sb);
                fb.add(sb);
                return;
            }
        }

        throw new InvalidPointerException("Неверный указатель - " + ptr);
    }

    public int malloc(int size) throws OutOfMemoryException {
        boolean compact = true;

        do {
            Integer result = fb.stream().reduce((o1, o2)->{
                int r1 = hb.get(o1) - size;
                int r2 = hb.get(o2) - size;

                if (r1 < 0) return o2;
                if (r2 < 0) return o1;

                if (r1 < r2) return o1;
                else return o2;

            }).orElse(-1);

            if ( hb.get(result) != null ) {
                if (hb.get(result).equals(size)) {
                    lb.add(result);
                    fb.remove(result);
                    return result;
                }

                if (0 < hb.get(result).compareTo(size)) {
                    lb.add(result);
                    fb.remove(result);
                    int ostIndex = result + size;
                    fb.add(ostIndex);
                    hb.put(ostIndex, hb.get(result) - size);
                    hb.put(result, size);
                    return result;
                }

                if (compact && 0 > hb.get(result).compareTo(size)) {
                    compact();
                    compact = false;
                } else {
                    throw new OutOfMemoryException("Нет свободного блока подходящего размера - " + size);
                }
            }
            else if (compact) {
                compact();
                compact = false;
            }
            else {
                throw new OutOfMemoryException("Нет свободного блока подходящего размера - " + size);
            }
        } while(true);
    }

    public static void main(String[] args) {
        Heap hp = new Heap(200);
        int r;

        try {
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);
            r = hp.malloc(20);

            hp.free(20);
            hp.free(60);
            hp.free(120);
//            hp.free(121);

            hp.malloc(30);

            System.out.println(hp.lb);
            System.out.println("==============================");
            System.out.println(hp.fb);
            System.out.println("==============================");
            System.out.println(hp.hb);
            System.out.println("==============================");
            System.out.println("==============================");

            hp.free(0);
            hp.free(80);
            hp.free(100);

            System.out.println(hp.lb);
            System.out.println("==============================");
            System.out.println(hp.fb);
            System.out.println("==============================");
            System.out.println(hp.hb);
            System.out.println("==============================");
            System.out.println("==============================");

            hp.defrag();

            System.out.println(hp.lb);
            System.out.println("==============================");
            System.out.println(hp.fb);
            System.out.println("==============================");
            System.out.println(hp.hb);
            System.out.println("==============================");
            System.out.println("==============================");

        }
        catch (OutOfMemoryException | InvalidPointerException $exception) {
            System.out.println($exception.getMessage());
        }
    }
}
