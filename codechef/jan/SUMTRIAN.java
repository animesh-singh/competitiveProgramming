import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.math.BigInteger;
 
	class SUMTRIAN
	{ 
		int cell[][];
		int memo[][];
		boolean visited[][];

		public SUMTRIAN(int N)
		{
			cell	= new int[N][N];
			memo	= new int[N][N];
			visited = new boolean[N][N];
		}
 		
		public static void main(String[] args)
		throws Exception
		{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				OutputStream outputStream = System.out;
				OutputWriter out = new OutputWriter(outputStream);	
 				StringBuilder stb = new StringBuilder();
				
			int T = Integer.parseInt(br.readLine());
 			int N = 0;
 			String[] s;
			
			while(T-- > 0)
			{
				N = Integer.parseInt(br.readLine());
				SUMTRIAN object = new SUMTRIAN(N);

				for(int i=0;i<N;i++)
				{
					s = (br.readLine()).split(" ");
					for(int j=0;j <s.length ;j++)
					{
						object.cell[i][j] = Integer.valueOf(s[j]);
					}
					
				}
				int ans = object.solve(0,0,N);
				stb.append(ans+"\n");
				
			}
				out.print(stb);
				out.close();
		}

		public int solve(int i,int j,int norows)
		{
			if(i > norows-1)
			{
				return 0;
			}
			if(visited[i][j])
			{
				return memo[i][j];
			}

			int tmp1 = solve(i+1,j,norows);
			int tmp2 = solve(i+1,j+1,norows);
			
			int ans = Math.max(tmp1,tmp2) + cell[i][j];
			
			memo[i][j] = ans;
			
			visited[i][j] = true;
			
			return ans;
		}

	} 
 

 	

	 
		class OutputWriter {
			private final PrintWriter writer;
	 
			public OutputWriter(OutputStream outputStream) {
				writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
			}
	 
			public OutputWriter(Writer writer) {
				this.writer = new PrintWriter(writer);
			}
	 
			public void print(Object... objects) {
				for (int i = 0; i < objects.length; i++) {
					if (i != 0)
						writer.print(" ");
					writer.print(objects[i]);
				}
			}
	 
			public void println(Object... objects) {
				print(objects);
				writer.println();
			}
	 
			public void close() {
				writer.close();
			}
	 
		} 
 
 