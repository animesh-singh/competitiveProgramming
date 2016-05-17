
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
 
	class FCTRL2
	{ 
		public static BigInteger fact[]=new BigInteger[101]; 
 		
 		public static void main(String[] args)
		throws Exception
		{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				StringBuilder res = new StringBuilder();
 
			int T = Integer.parseInt(sc.readLine());
 			BigInteger answer;
			while(T-->0)
			{
				int N = Integer.parseInt(sc.readLine());
				answer = factorial(N);
				res.append(answer+"\n");
				

	    	}
 			
	    	System.out.print(res);
	    
		} 
 
		public static BigInteger factorial(int a)
		{
			if(a==1||a==2)
			{
				fact[a]=bigint(a);
			}
			else if(fact[a]==null)
			{
				fact[a] = bigint(a).multiply(factorial(a-1));
			}
			return fact[a];
		}
 		public static BigInteger bigint(int x) 
 		{
   			 return BigInteger.valueOf(x);
		}
 	}
 
	