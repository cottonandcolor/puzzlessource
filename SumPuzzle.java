
package com.triangle;

import java.io.PrintStream;

public class SumPuzzle
{

    public SumPuzzle()
    {
    }

    public int findSum(int data[])
    {
        if(data.length == 0)
            return 0;
        int numrows = data.length;
        int sum = data[0];
        int index = 1;
        int increment = 0;
        if(numrows >= 2)
            sum += data[1];
        for(int r = 3; r <= numrows; r++)
        {
            if(r % 2 != 0)
                increment++;
            if(r % 2 != 0)
                index = index + increment + (r - 1);
            else
                index += r - 1;
            if(index >= data.length)
                break;
            sum += data[index];
            System.out.println((new StringBuilder("index :")).append(index).append("sum ").append(sum).toString());
        }

        return sum;
    }

    public static void main(String args[])
    {
        int data[] = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
            11, 12, 13, 14, 15
        };
        (new SumPuzzle()).findSum(data);
    }
}
