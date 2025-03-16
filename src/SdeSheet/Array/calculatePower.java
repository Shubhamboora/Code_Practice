package SdeSheet.Array;

public class calculatePower {

    public static void main(String[] args) {
        int x = 2, p = -10;
        System.out.println("Normal ittration O(n):" + findPowerByIttration(x, p));
        System.out.println(" BinaryExponentiation O(log n):"+ BinaryExponentiation(x, p));
    }

    public static double findPowerByIttration(int value, int power){
        double tempValue = value;
        boolean isNegetive = false;
        if ( power < 0 ){
            power *= -1;
            isNegetive = true;
        }

        for (int i = 1; i < power; i++){
            tempValue *= value;
        }

        if (isNegetive){
            tempValue = 1.0/tempValue;
        }

        return tempValue;
    }

    public static double BinaryExponentiation(int value, int power){
        double answer = 1.0;
        long tempPower = power;

        if (tempPower < 0 ) tempPower *= -1;
        while(tempPower>0){

            if (tempPower % 2 == 1){
                answer = answer * value;
                tempPower--;
            }else{
                value = value * value;
                tempPower /= 2;
            }
        }

        if (power < 0){
            answer = 1.0 / answer;
        }

        return answer;
    }
}
