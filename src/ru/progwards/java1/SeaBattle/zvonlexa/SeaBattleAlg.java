package ru.progwards.java1.SeaBattle.zvonlexa;

import ru.progwards.java1.SeaBattle.SeaBattle;

public class SeaBattleAlg {
    int[][] seaField = new int[10][10];
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
        setPointBusy(point_x, point_y);

        point_x = x - 1;
        point_y = y + 1;
        setPointBusy(point_x, point_y);

        point_x = x + 1;
        point_y = y - 1;
        setPointBusy(point_x, point_y);

        point_x = x + 1;
        point_y = y + 1;
        setPointBusy(point_x, point_y);
    }

    private void setPointBusy(int x, int y) {
        if(x > 0 && x < 10 && y > 0 && y < 10) {
            seaField[ y ][ x ] = 0;
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        miss = 0;

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                seaField[y][x] = 1;
            }
        }

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
        	for (int x = 0; x < seaBattle.getSizeY(); x++) {
        	    if (seaField[ y ][ x ] == 1) {
                    SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                    if (fireResult != SeaBattle.FireResult.MISS) {
                        if (++miss >= 20) {
                            return;
                        }
                        hitBusy(x, y);
                    }
                }

                seaField[ y ][ x ] = 0;
            }
        }
    }

    // функция для отладки
    public static void main(String[] args) {
    	System.out.println("Sea battle");

//    	SeaBattle seaBattle = new SeaBattle(true);
//    	new SeaBattleAlg().battleAlgorithm(seaBattle);
//    	System.out.println(seaBattle.getResult());

        test();

    }

    public static void test() {
        SeaBattleAlg alg = new SeaBattleAlg();
        int result = 0;

        for (int i = 0; i < 1000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            result += seaBattle.getResult();
        }

        System.out.println(result / 1000);
    }
}

