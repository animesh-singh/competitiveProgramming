import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double number;
        while(t-->0)
        {
            number = sc.nextDouble();
            
            if(isPrime(number))
                System.out.println("Prime");
            else
                System.out.println("Not prime");               
        }
    }

    
    // using the ASK primality test 
    private static boolean isPrime(double num)
    {
        if(num == 1)
            return false;
        else if(num == 2)
            return true;
        else if(num == 3)
            return true;
        
            
        else
        {
        	// breakpoint <= log2(n)
            double temp = Math.log(num) / Math.log(2) ;
            int breakpoint = (int) ( temp_1 - (temp_1%1) );
            
            // Test #1
            //If num = a^b for integers a > 1 and b > 1, output composite.
            
            for(int i=2 ; i <= breakpoint ; i++ )
            {
                double check_1 = Math.pow(num,(1/i));
               
               //If check_1 is integer, return composite
                if( (check_1 % 1)  > 0)
                {
                    return false;
                    //System.out.println(check_1 % 1);
                }
            }



            //Test #2
            //Find the smallest r such that Or(n) > (log2 n)2.

            temp = Math.pow( (Math.log(num)/Math.log(2)) , 2);
            int maxk = (int) ( temp_2 - (temp_2%1) );

            temp = Math.max( 3 , Math.pow( (Math.log(num)/Math.log(2)) , 5) );
            int maxr = (int) ( temp_3 - (temp_3%1) );

            boolean nextR = true;
            int r;
            for(r=2; nextR && r < maxr ; r++)
           	{
           		nextR = false;
           		for(int j=1; (!nextR) && k < maxk ; k++)
           		{	
           			nextR = ( Math.pow(num,j)%r == 1 || Math.pow(num,j)%r == 0 )
           		}
           	}
           	// loop over increments by 1
           	r--;
        
        	//Test #3
            //If 1 < gcd(a,n) < n for some a ≤ r, output composite.
            
            for(int a = r ; a > 1 ; a--)
           	{
           		long gcd = gcd( (long) a ,num);

           		if( gcd > 1 && gcd < num )
           			return false;
           	}

			
			//Test #4  
           	// If n ≤ r, output prime.
           	// (* this step may be omitted if n > 5690034 *)

           	if(num <= r)
           		return true;


           	//Test #5
           	// For a = 1 to lfloor(sqrt(log_2(n))  do
			// if (X+a)n≠ Xn+a (mod Xr − 1,n), output composite;
 
           	for(int a = 1; a < )






            return true;
        }         

    }


    static long gcd(long a, long b)
    {
    	a = Math.abs(a); 
    	b = Math.abs(b);
    	return (b==0) ? a : gcd(b, a%b);
  	}

}