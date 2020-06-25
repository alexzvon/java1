package ru.progwards.java1.lessons.io2;

public class PhoneNumber {

    public static void main(String[] args) {

        String phone = "79991112233";
        System.out.println(format(phone));

        phone = "8(999)111-22-33";
        System.out.println(format(phone));

        phone = "8 999 111 22 33";
        System.out.println(format(phone));
    }

    public static String format(String phone)  {
        String zPhone = "";

        for (char c : phone.toCharArray()) {
            if(Character.isDigit(c)) {
                zPhone += c;
            }
        }
        if (zPhone.length() == 11 || zPhone.length() == 10) {
//            if (zPhone.charAt(0) == 7 || zPhone.charAt(0) == 8) {
//                int[] a_copy = new int[a.length];
                System.arraycopy(zPhone, 1, zPhone, 0, zPhone.length() - 1);
//            }
        }
        else {
            throw new RuntimeException("Not length 10 or 11");
        }

        return zPhone;
    }
}

//    Создать статический метод public static String format(String phone),
//        который форматирует телефон под формат +7(999)111-2233, входящий формат может быть различным:
//        - 79991112233
//        - 8(999)111-22-33
//        - 8 999 111 22 33
//
//        формальное задание на форматирование:
//        - выделить все цифры, отбросить все разделители
//        - проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
//        - убрать спереди 8
//        - добавить, если нужно +7
//        - отформатировать под выходной шаблон
