/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

/**
 *
 * @author Yunlong
 */
public class atoi {
    //set a integer for checking overflow
    public static final int maxDiv10 = Integer.MAX_VALUE/10;
    
    public static int atoi(String str){
        //declare two pointer, start and end
        //trim leading and ending spaces.
        int i=0, n=str.length();
        while(i<n && Character.isWhitespace(str.charAt(i))) i++;

        //determine the sign of current integer
        int sign = 1;
        if(i<n && str.charAt(i)=='+') i++;
        else if(i<n && str.charAt(i)=='-'){
            sign = -1;
            i++;
        }

        
        int num = 0;
        while(i<n && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            //consider the condition with overflow          2^31
            if(num > maxDiv10 || num == maxDiv10 && digit == 8){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
    
    public static void main(String[]args){
        System.out.println(atoi("-12345"));
        System.out.println(atoi("234567"));
        System.out.println(atoi("+234234"));
        System.out.println(atoi("234234234234234234234234234"));
    }
}
