package com.company;

import java.io.IOException;

public class Utilities {
    public static int inputInt() throws IOException {
        String temp = DataInput.getString();
        for (int i = 0; i < temp.length(); i++) {
            if ((temp.charAt(i) > 57 && temp.charAt(i) < 48)) {
                System.out.print("Дозволено використовувати тільки цифри: ");
                temp = DataInput.getString();
                i = 0;
            }
        }
        return Integer.parseInt(temp);
    }

    public static String inputString() throws IOException {
        String temp = DataInput.getString();
        for (int i = 0; i < temp.length(); i++) {
            if (!((temp.charAt(i) >= 65 && temp.charAt(i) <= 90) || (temp.charAt(i) >= 97 && temp.charAt(i) <= 122)) || temp.charAt(0) < 65 || temp.charAt(0) > 90) {
                System.out.print("Дозволено використовувати тільки літери англійського алфавіту(перша літера повинна бути великою): ");
                temp = DataInput.getString();
                i = 0;
            }
        }
        return temp;
    }
}
