package Practice;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(ZigzagConversion.convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        List<StringBuilder> list = new ArrayList<>();
        int size = Math.min(numRows, s.length());

        //Initializing StringBuilder into list acc to numRows
        for (int i = 0; i < size; i++) list.add(new StringBuilder());

        boolean movingDown = true;
        list.get(0).append(s.charAt(0));
        int builder = 1;


        //Result: PAHNAPLSIIGYIR
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.get(builder).append(ch);

            //If working on last stringBuilder of list movement need to be reversed.
            if (builder == size - 1) {
                builder--;
                movingDown = false;
                continue;
            }
            //If working on first stringBuilder of list movement need to be reversed.
            if (builder == 0) {
                builder++;
                movingDown = true;
                continue;
            }
            //++, -- based upon movement direction.
            builder += movingDown ? 1 : -1;

        }

        StringBuilder result = new StringBuilder();
        list.forEach(str -> result.append(str));

        return result.toString();
    }


}
