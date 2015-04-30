using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NumberOfIsland
{
    class Program
    {
        static void Main(string[] args)
        {
            char[,] islands = new char[,]
	        {
	            {'0', '1', '0', '1', '1'},
	            {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
	        };
            NumberOfIsland ni = new NumberOfIsland(islands);
            Console.WriteLine(ni.toString());
            Console.ReadKey();
        }
    }

    class NumberOfIsland
    {
        private char[,] islands;
        public NumberOfIsland(char[,] islands)
        {
            this.islands = islands;
        }

        public int numIslands(char[,] grid)
        {
            // if no grid exists or grid size is 0
            // width = grid.GetLength(0)
            // height = grid.GetLength(1)
            if (grid == null || grid.GetLength(1) == 0 || grid.GetLength(0) == 0) return 0;
            int count = 0;

            for (int i = 0; i < grid.GetLength(1); i++)
            {
                for (int j = 0; j < grid.GetLength(0); j++)
                {
                    if (grid[i, j] == '1')
                    {
                        count++;
                        merge(grid, i, j);
                    }
                }
            }
            return count;
        }

        public void merge(char[,] grid, int i, int j)
        {
            //validity checking
            if (i < 0 || j < 0 || i > grid.GetLength(1) - 1 || j > grid.GetLength(0) - 1) return;

            //if current cell is water or visited
            if (grid[i, j] != '1') return;

            //set visited cell to '2'
            grid[i, j] = '2';

            //merge all adjacent land
            merge(grid, i - 1, j);
            merge(grid, i + 1, j);
            merge(grid, i, j - 1);
            merge(grid, i, j + 1);
        }

        public string toString()
        {
            return "The number of islands is: " + numIslands(islands) + "\n" + printOutArray();
        }

        private string printOutArray()
        {
            string result = "";
            for (int i = 0; i < islands.GetLength(1); i++)
            {
                for (int j = 0; j < islands.GetLength(0); j++)
                {
                    result += islands[i, j] + "\t";
                }
                result += "\n";
            }
            return result;
        }
    }
}
