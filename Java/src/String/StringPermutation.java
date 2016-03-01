package String;

import java.util.ArrayList;

/**
 * Created by yunlong on 2/29/16.
 */
public class StringPermutation {
    public void permutation(String str) {
        permutation("", str);
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++){
                System.out.println("i: " + i + " n: " + n);
                System.out.println("Prefix: " + prefix);
                System.out.println("str: " + str);
                System.out.println("str.charAt(i): " + str.charAt(i));
                System.out.println("str.substring(0, i): " + str.substring(0, i));
                System.out.println("str.substring(i+1, n): " + str.substring(i+1, n));
                System.out.println();
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }


    public static void main(String [] args){
        String test1 = "ab";

        StringPermutation sp = new StringPermutation();
        sp.permutation(test1);
    }
}
