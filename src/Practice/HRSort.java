package Practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    
	 static int activityNotifications(int[] expenditure, int d) {;

     int notificationCount = 0;

     int[] data = new int[201];
     for (int i = 0; i < d; i++) {
         data[expenditure[i]]++;
     }

     for (int i = d; i < expenditure.length; i++) {

         double median = getMedian(d, data);

         if (expenditure[i] >= 2 * median) {
             notificationCount++;

         }

         data[expenditure[i]]++;
         data[expenditure[i - d]]--;

     }

     return notificationCount;

 }

 private static double getMedian(int d, int[] data) {
     double median = 0;
     if (d % 2 == 0) {
         Integer m1 = null;
         Integer m2 = null;
         int count = 0;
         for (int j = 0; j < data.length; j++) {
             count += data[j];
             if (m1 == null && count >= d/2) {
                 m1 = j;
             }
             if (m2 == null && count >= d/2 + 1) {
                 m2 = j;
                 break;
             }
         }
         median = (m1 + m2) / 2.0;
     } else {
         int count = 0;
         for (int j = 0; j < data.length; j++) {
             count += data[j];
             if (count > d/2) {
                 median = j;
                 break;
             }
         }
     }
     return median;
 }

}
public class HRSort {
    public static void main(String[] args) {
        
    	List<Integer> li = new ArrayList<>();
    	
    	int arr[] = {2,3,4,2,3,6,8,4,5};
    	int notifications = Result.activityNotifications(arr, 4);
    	System.out.println(notifications);
    }
}
