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
 
	class GLBEGA
	{ 
 		
 		static int A,B,C,M,N;
 		
 		int ans = 0;
 		
 		
 		public GLBEGA(int M,int N)
 		{
 			
 		}
 	

		public static void main(String[] args)
		throws Exception
		{
				InputStream input = System.in;
				OutputStream output = System.out;
				FasterReader in = new FasterReader(input);
				FasterWriter out = new FasterWriter(output);

 				M = in.nextInt();
 				N = in.nextInt();

 				GLBEGA obj = new GLBEGA(M,N);
 			
 				 A = in.nextInt();
 				 B = in.nextInt();
 				 C = in.nextInt();
				
				out.println(obj.function(M,N));
				out.close();

		} 


		public int function(int x,int y)
		{
			
			if(x==0 && y==0)
			{
				return 0;
			}
			int z = (x+y)%2;

				int func = A*x*x + B*y*y + C*x*y;
			
					if(x<1 && y>0)
					{
						ans = function(x,y-1) + func;
					}

					else if(y<1 && x>0)
					{	
						ans = function(x-1,y+1) + func;
					}
					
					else if(z==0)
					{
						int tmp1 = function(x-1,y+1);
						int tmp2 = function(x,y-1);
						ans = Math.max(tmp1,tmp2) + func;
					}
				
					else if(z==1)
					{
					
						int tmp1 = function(x-1,y+1);
						int tmp2 = function(x,y-1);
						ans = Math.min(tmp1,tmp2) + func;
					}

			
			return ans;
		} 
		
 	}
 
	class FasterReader 
	{
			private InputStream stream;
			private byte[] buffer = new byte[1024];
			private int curChar;
			private int numChars;
			private SpaceCharFilter filter;
	 
			public FasterReader(InputStream stream) 
			{
				this.stream = stream;
			}
	 
			public interface SpaceCharFilter 
			{
				public boolean isSpaceChar(int ch);
			}
	 
			public int read() 
			{
				if (numChars == -1)
					throw new InputMismatchException();

				if (curChar >= numChars) 
				{
					curChar = 0;
					try 
					{
						numChars = stream.read(buffer);
					} 
					catch (IOException e) 
					{
						throw new InputMismatchException();
					}
					
					if (numChars <= 0)
						return -1;
				}
				return buffer[curChar++];
			}
	 
			public int nextInt() 
			{
				int c = read();

				while (isSpaceChar(c))
					c = read();

				int sgn = 1;
				
				if (c == '-') 
				{
					sgn = -1;
					c = read();
				}
				int res = 0;
				
				do 
				{
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					
					res *= 10;
					res += c - '0';
					c = read();

				} while (!isSpaceChar(c));
				
				return res * sgn;
			}
	 
			public String readString() 
			{
				int c = read();

				while (isSpaceChar(c))
					c = read();
				
				StringBuilder res = new StringBuilder();
				
				do 
				{
					res.appendCodePoint(c);
					c = read();

				} while (!isSpaceChar(c));
				
				return res.toString();
			}
	 
			public boolean isSpaceChar(int c) 
			{
				if (filter != null)
					return filter.isSpaceChar(c);
			
				return isWhspace(c);
			}

			public static boolean isWhspace(int c) 
			{
				return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
			}
	 
			public String next() 
			{
				return readString();
			}
	 
	 		public float nextFloat() 
			{
				return Float.parseFloat(readString());
			}

			public Long nextLong() 
			{
				return Long.parseLong(readString());
			}
		 
			public Double nextDouble() 
			{
				return Double.parseDouble(readString());
			}
		}
	 


		class FasterWriter 
		{
			private final PrintWriter writer;
	 
			public FasterWriter(OutputStream output) 
			{
				writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(output)));
			}
	 
			public FasterWriter(Writer writer) 
			{
				this.writer = new PrintWriter(writer);
			}
	 
			public void print(Object... obj) 
			{
				for (int i = 0; i < obj.length; i++) 
				{
					if (i != 0)
						writer.print(" ");
					
					writer.print(obj[i]);
				}
			}
	 
			public void println(Object... obj) 
			{
				print(obj);
				writer.println();
			}
	 
			public void close() 
			{
				writer.close();
			}
	 
		} 
 
 