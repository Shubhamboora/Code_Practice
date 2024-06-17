package Practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static boolean isPrime(List<Integer> list, int n) {
//		for(int i=2;i<n/2+1;i++) {
//			if(n%i==0) {
//				return false;
//			}
//		}
//		return true;

        int check = n / 2 + 1, i = 0;
        while (list.get(i) < check) {
            if (n % list.get(i) == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    public static String solution(int i) {
        // Your code here
        int n = i;
        StringBuilder primes = new StringBuilder("2357");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        if (n == 0 || n == 1) {
            primes.append("1113");
            return primes.substring(n, n + 5);
        }
        for (int j = 2; j <= n / 2 + 1; j++) {
            int one = 6 * j - 1;
            int two = 6 * j + 1;
            if (isPrime(list, one)) {
                list.add(one);
                primes.append(Integer.toString(one));
            }
            if (isPrime(list, two)) {
                list.add(two);
                primes.append(Integer.toString(two));
            }
            if (primes.length() >= n + 5) {
                break;
            }
        }

        for (int j = 0; j < primes.length(); j++) {
            if (j == n) {
                System.out.print(" ");
            }
            System.out.print(primes.charAt(j));
            if (j == n + 4) {
                System.out.print(" ");
            }
        }

        return primes.substring(n, n + 5).toString();
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = Solution.solution(i);
        System.out.println(s);
    }
}
