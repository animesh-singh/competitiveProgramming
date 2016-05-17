import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
 
	class TSORT
	{ 
 		
 		public static void main(String[] args)
		throws Exception
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 			PrintWriter out = new PrintWriter(System.out);
    
			int T = Integer.parseInt(in.readLine());
			int a[] = new int[T];
			int i;
			for(i=0;i<T;i++)
			{
				a[i] = Integer.parseInt(in.readLine());
	    	}
	    	Arrays.sort(a);
 			for(i=0;i<T;i++)
			{
				out.println(a[i]); 
	    	}
	    	out.close();
	 	}   

} 
 