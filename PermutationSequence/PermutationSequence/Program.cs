using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PermutationSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(PermuationSequence.getPermutation(3, 6));
            Console.ReadKey();
        }
    }

    class PermuationSequence 
    {
        public static String getPermutation(int n, int k)
        {

            // initialize all numbers
            ArrayList numberList = new ArrayList();
            for (int i = 1; i <= n; i++)
            {
                numberList.Add(i);
            }

            // change k to be index
            k--;

            // set factorial of n
            int mod = 1;
            for (int i = 1; i <= n; i++)
            {
                mod = mod * i;
            }

            String result = "";

            // find sequence
            for (int i = 0; i < n; i++)
            {
                mod = mod / (n - i);
                // find the right number(curIndex) of
                int curIndex = k / mod;
                // update k
                k = k % mod;

                // get number according to curIndex
                result += numberList[curIndex];
                // remove from list
                numberList.RemoveAt(curIndex);
            }

            return result.ToString();
        }
    }
}
