import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

	static int minimumSwaps(int[] arr) {
        int n = arr.length;
        int output = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0;i<n;i++){
            map.put(arr[i], i);
        }
        for(int i=0;i<n;i++){
            
            if(arr[i]!=i+1){
                //getting index of original value
                int index = map.get(i+1);
                //swaping
                ++output;
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                
                //updating hashmap values
                map.put(arr[i],i);
                map.put(temp, index);
            }
        }
        return output;
    }
    

}

public class movesRequiredToSort {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arr[] = {2,3,4,1,5};
        int swaps = Result.minimumSwaps(arr);
        System.out.println(swaps);
        

        
    }
}
