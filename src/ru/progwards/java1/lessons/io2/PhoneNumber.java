package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone)  {
        String zPhone = "";

        for (char c : phone.toCharArray()) {
            if(Character.isDigit(c)) {
                zPhone += c;
            }
        }
        if (zPhone.length() == 11 || zPhone.length() == 10) {
            if(zPhone.substring(0, 1).equals("8") || zPhone.substring(0, 1).equals("7")) {
                zPhone = zPhone.substring(1);
            }
        }
        else {
            throw new RuntimeException("Not length 10 or 11");
        }

        return "+7(" + zPhone.substring(0, 3) + ")" + zPhone.substring(3, 6) + "-" + zPhone.substring(6);
    }
}