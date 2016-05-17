import java.io.*;

class ANUWTA
{
	// http://www.codechef.com/problems/ANUWTA
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);   
		
		long T = Long.parseLong(br.readLine());
		
		for(long t = 0; t < T; t++)
		{
			
			long N = Long.parseLong(br.readLine());
			pw.println((N * (N + 1) / 2) + N);
			
		}
		
		pw.close();
	}
} 