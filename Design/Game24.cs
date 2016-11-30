using System;
using System.Collections.Generic;
namespace Game24
{
    class Program
    {
        Random rnd = new Random();
        public int[] getRandom4Cards()
        {
            int[] result = new int[4];
            int i = 0;
            while (i < 4)
            {
                int cardNum = rnd.Next(1, 14);
                result[i++] = cardNum;
            }
            //print out cards
            foreach (var x in result)
            {
                Console.Write(x + "\t");
            }
            Console.WriteLine();
            return result;
        }

        public void solve()
        {
            int[] cards = getRandom4Cards();
            List<string> results = new List<string>();
            caculate(cards, "", results);

            foreach (var result in results)
            {
                Console.WriteLine(result);
            }
            Console.WriteLine();
        }

         static void caculate(int[] a, string result, List<string> results) {
           if (a.Length == 0) return;
           if (a.Length == 1) {
               if (a[0] == 24) {
                   results.Add(result);
               }
               return;
           }
           for (int i=0; i<a.Length;i++) {
               for (int j=i+1;j<a.Length;j++) {
                   //i and j indicate two numbers selected for calculation

                   //create a new array to store new result
                   int[] b = new int[a.Length - 1];

                   //copy over unused values from a to b before calculation
                   for (int k=0; k<i; k++) {            //before i, no positions shifted
                       b[k] = a[k];
                   }
                   for (int k=i+1; k<j; k++) {          //in between, position shifted left by 1
                       b[k-1] = a[k]; 
                   }
                   for (int k=j+1; k<a.Length; k++) {   //after j, position shifted left by 2
                       b[k-2] = a[k];
                   }
                
                   //addition, a+b = b+a
                   b[a.Length-2] = a[i] + a[j]; 
                   caculate(b, result + ", " + a[i] + "+" + a[j], results);
               
                   //two different result can be calcuated in substraction
                   //a-b, b-a
                   b[a.Length-2] = a[i] - a[j]; 
                   caculate(b, result + ", " + a[i] + "-" + a[j], results);
               
                   b[a.Length-2] = a[j] - a[i];
                   caculate(b, result + ", " + a[j] + "-" + a[i], results);
               
                   //multiplication, a*b=b*a
                   b[a.Length-2] = a[i] * a[j];
                   caculate(b, result + ", " + a[i] + "*" + a[j], results);
                
                   //division is more complicated, a/b and b/a
                   //divisor can not be 0 and also divisor must be divisible by divident (d1 % d2 == 0)
                   if (a[i] != 0 && a[j] % a[i] == 0) {
                       b[a.Length-2] = a[j] / a[i];
                       caculate(b, result + ", " + a[j] + "/" + a[i], results);
                   }
               
                   if (a[j] != 0 && a[i] % a[j] == 0) {
                       b[a.Length-2] = a[i] / a[j];
                       caculate(b, result + ", " + a[i] + "/" + a[j], results);
                   }
               }
           }     
       }
        static void Main(string[] args)
        {
            Program p = new Program();
            p.solve();
            Console.ReadKey();
        }
    }
}
