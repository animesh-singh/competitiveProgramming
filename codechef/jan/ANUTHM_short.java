import java.util.*;
import java.io.*;

class ANUTHM
	{ 
 
		public static void main(String[] args)
		throws Exception
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer s = new StringBuffer();
			int T = Integer.parseInt(br.readLine());
			while(T-->0)
			{
			int M = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int count=N+M-1;
			s.append(count+"\n");
	    	}
	    	System.out.print(s);
	    }
 
 }
 