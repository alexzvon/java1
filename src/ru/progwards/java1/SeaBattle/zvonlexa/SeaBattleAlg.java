package ru.progwards.java1.SeaBattle.zvonlexa;

import ru.progwards.java1.SeaBattle.SeaBattle;

import java.util.Arrays;

public class SeaBattleAlg {
    SeaBattle seaBattle;
    int[][] seaField = new int[10][10];
    int[] point = new int[2];
    int miss = 0;

    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    private void hitBusy(int x, int y) {
        int point_x;
        int point_y;

        point_x = x - 1;
        point_y = y - 1;
        setPointBusy(point_x, point_y, 1);

        point_x = x - 1;
        point_y = y + 1;
        setPointBusy(point_x, point_y, 1);

        point_x = x + 1;
        point_y = y - 1;
        setPointBusy(point_x, point_y, 1);

        point_x = x + 1;
        point_y = y + 1;
        setPointBusy(point_x, point_y, 1);
    }

    private void setPointBusy(int x, int y, int z) {
        if(x > 0 && x < 10 && y > 0 && y < 10) {
            seaField[y][x] = z;
        }
    }

    private boolean nextStep() {
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if(seaField[y][x] == 0) {
                    point[0] = x;
                    point[1] = y;

                    return true;
                }
            }
        }

        return false;
    }

    public void battleAlgorithm(SeaBattle sB) {
        seaBattle = sB;
        miss = 0;

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                seaField[y][x] = 0;
            }
        }

        System.out.println(seaBattle);



        for (int y = 0; y < seaBattle.getSizeX(); y++) {
        	for (int x = 0; x < seaBattle.getSizeY(); x++) {
        	    point[0] = y;
        	    point[1] = x;

//        	    while(nextStep()) {
                    if (seaField[point[1]][point[0]] == 0) {

                        SeaBattle.FireResult fireResult = seaBattle.fire(point[0], point[1]);

                        if (fireResult != SeaBattle.FireResult.MISS) {
                            if (++miss >= 20) {
                                return;
                            }

                            if (fireResult != SeaBattle.FireResult.HIT) {
                                seaField[point[1]][point[0]] = -1;
                                hitBusy(point[0], point[1]);
                            }

                            if (fireResult != SeaBattle.FireResult.DESTROYED) {
                                seaField[point[1]][point[0]] = -1;
                            }

//                            hitBusy(point[0], point[1]);
                        } else {
                            seaField[point[1]][point[0]] = 1;
                        }


                        System.out.println("============================================");
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Arrays.toString(seaField[i]));
                        }
                        System.out.println("============================================");

                    }

//                }

            }
        }
    }

    // функция для отладки
    public static void main(String[] args) {
    	System.out.println("Sea battle");

    	SeaBattle seaBattle = new SeaBattle(true);
    	new SeaBattleAlg().battleAlgorithm(seaBattle);
    	System.out.println(seaBattle.getResult());

//        test();

    }

    public static void test() {
        SeaBattleAlg alg = new SeaBattleAlg();
        int result = 0;

        int prob;

        for (int i = 0; i < 2; i++) {
            SeaBattle seaBattle = new SeaBattle(true);
            alg.battleAlgorithm(seaBattle);

            prob = (int) seaBattle.getResult();

            System.out.println(prob);

            result += prob;
        }

//        System.out.println(result / 1000);
        System.out.println(result);
    }
}

