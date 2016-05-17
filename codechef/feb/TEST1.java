	import java.io.*;
	import java.util.*;


	class TEST2
	{
		
	public static void main(String asd[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int value=0;
		
		while(value!=42)
		{
			value = Integer.parseInt(br.readLine());

			System.out.println(value);
		}

	}


	}