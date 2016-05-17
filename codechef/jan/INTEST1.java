import java.util.*;

	class INTEST1
	{ 
 		
		public static void main(String[] args)
		throws Exception
		{
			Scanner in = new Scanner(System.in);
 			
 			int n = in.nextInt();
 			double k = in.nextDouble();
 			int count=0;
 			while(n-->0)
 			{
 				double ti = in.nextDouble();
 				if(ti%k==0)
 				{
 					count++;
 				}
 			}

 			System.out.print(count);
 		}
 

 		
 	}
 