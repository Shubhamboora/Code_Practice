package SdeSheet.Array;

import java.util.ArrayList;
import java.util.List;

public class findMajorityElement2 {

    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> list = new ArrayList<>();

        int value1 = Integer.MIN_VALUE;
        int value2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (count1 == 0 && value2 != arr[i]) {
                count1++;
                value1 = arr[i];
            } else if (count2 == 0 && value1 != arr[i]) {
                count2++;
                value2 = arr[i];
            } else if (value1 == arr[i]) count1++;
            else if (value2 == arr[i]) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value1) count1++;
            if (arr[i] == value2) count2++;
        }

        int min = (arr.length / 3) + 1;

        if (count1 >= min) list.add(value1);
        if (count2 >= min) list.add(value2);

        list.forEach((value) -> {
            System.out.println(value);
        });
    }
}
