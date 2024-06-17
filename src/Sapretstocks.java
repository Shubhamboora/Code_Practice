import java.util.Arrays;

public class Sapretstocks {

    public static void main(String[] args) {

        Arrays.stream(Sapretstocks.arr).forEach(a -> {
            if (a.matches("^[a-zA-Z]+$")) System.out.print(a + ",");
        });
    }

    static String arr[] = new String[]{};
}
