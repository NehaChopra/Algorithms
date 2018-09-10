package Array;

// Java program for finding maximum 
// and minimum in a matrix.
 
public class MaximumandMinimum 
{
    static final int MAX = 100;
     
    // Finds maximum and minimum 
    // in arr[0..n-1][0..n-1]
    // using pair wise comparisons
    static void maxMin(int arr[][], int n)
    {
        int min = +2147483647;
        int max = -2147483648;
     
        // Traverses rows one by one
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= n/2; j++)
            {
                // Compare elements from beginning
                // and end of current row
                if (arr[i][j] > arr[i][n - j - 1])
                {
                    if (min > arr[i][n - j - 1])
                        min = arr[i][n - j - 1];
                    if (max< arr[i][j])
                        max = arr[i][j];
                }
                else
                {
                    if (min > arr[i][j])
                        min = arr[i][j];
                    if (max< arr[i][n - j - 1])
                        max = arr[i][n - j - 1];
                }
            }
        }
        System.out.print("Maximum = "+max+
                         ", Minimum = "+min);
    }
     
    // Driver program 
    public static void main (String[] args) 
    {
        int arr[][] = {{1, 3, 4},
                       {5, 2, 9},
                       {8, 7, 6}};
        maxMin(arr, 3);
    }
}
 
// This code is contributed by Anant Agarwal.
