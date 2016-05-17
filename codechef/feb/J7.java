import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.text.DecimalFormat;

class J7
	{ 
 		
		public static void main(String[] args)
		throws Exception
		{
				InputStream input = System.in;
				OutputStream output = System.out;
				FasterReader in = new FasterReader(input);
				FasterWriter out = new FasterWriter(output);	
 				
 				DecimalFormat f = new DecimalFormat("##.00");

				int T = in.nextInt();

				while(T-->0)
				{
					Double P = in.nextDouble();
					Double S = in.nextDouble();
					
					Double sqrt = Math.sqrt(P*P-24.0*S);
					double b1 = (P+sqrt)/12.0;
					double b2 = (P-sqrt)/12.0;

					double l1 = P / 4.0 - b1 * 2.0;
					double l2 = P / 4.0 - b2 * 2.0;
				
					double vol1 = l1 * b1 * b1;
					double vol2 = l2 * b2 * b2;

					if(vol1>vol2)
						out.println(f.format(vol1));
					
					else
						out.println(f.format(vol2));
				}
				out.close();
		} 


 		
 	}

































/*modified version of fast read and write by Animesh Singh*/
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
 
 