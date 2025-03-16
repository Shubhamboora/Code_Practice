package SdeSheet.Array;

public class findMajorityElement {

    public static void main(String[] args) {

        int arr[] = {1,1,1,2,3,1,4,4};

        int value = 0, count = 0;

        for(int i = 0; i < arr.length; i++){

            if ( count == 0 ){
                value = arr[i];
                count++;
            }else if (value == arr[i]) count++;
            else count--;
        }

        int count2 = 0;
        for (int i = 0; i < arr.length; i++){
            if ( arr[i] == value ) count2++;
        }

        if ( arr.length/2 <= count2 ) System.out.println("majority element is: " + value);
        else System.out.println(-1);
    }
}
