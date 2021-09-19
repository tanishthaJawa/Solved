package sheetSolutions.searchSort;

public class findMiddleWithMinComparisons {
    public static int middleOfThree(int a, int b,
                                    int c)
    {
        // x is positive if a is greater than b.
        // x is negative if b is greater than a.
        int x = a - b;
        int y = b - c; // Similar to x
        int z = a - c; // Similar to x and y.

        // Checking if b is middle (multiplication ofx and y
        // will be  positive)
        long k=(long)x*y;
        long k1= (long) x *z;
        if (k > 0){
            return b;
        }


            // Checking if c is middle (x and z
            // both are positive)

        else if (k1 > 0){
            return c;
        }

        else
            return a;
    }

    // driver code
    public static void main(String[] args)
    {
        int a = 34123 ,b=371229,c= 826272;
        System.out.println( middleOfThree(a, b, c) );
    }
}
