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
 
	class Knock
	{ 
 		
		public static void main(String[] args)
		throws Exception
		{
			InputStream inputStream = System.in;
			OutputStream outputStream = System.out;
			FastReader in = new FastReader(inputStream);
			OutputWriter out = new OutputWriter(outputStream);	
 			StringBuilder res = new StringBuilder();
 			
 			int N=0;
 			int Rn = 0,x=0,y=0;
 			int answer=0,ans=0;
 			int gcd[][] = new int[1000][1000];
 			
 			int T = in.nextInt();

 			while(T-->0)
 			{
 				N = in.nextInt();
 				
 				if(N<=10)
 				{
 					if(N<3){Rn = 1;}
 					else if(N<5){Rn = 3;}	
 					else if(N<7){Rn = 5;}
 					else {Rn = 7;}
 				}
 				else
 				{
 					Rn = func_rn(N);
 				}
 				for(int i=0; i<5*Rn;i++)
 				{
 					for(int j=0;j<5*Rn;j++)
 					{
						gcd[i][j]=gcd(i,j);

 						if(gcd[i][j] == Rn)
						{
							ans = gcd[i][j];
							
							if(ans<gcd[i][j])
							{
								ans = gcd[i][j];
								x=i;y=j;
							}

						}
 					
 					}
 				}

 				answer = (int)Math.pow(x,y) % (int)Math.pow(10,9);
 				res.append(answer);

 			}
 		
 		System.out.print(res+"\n");	

 		}

				
				public static int gcd(int K, int M) 
				{
 		     		int k = Math.max(K,M);
    				int m = Math.min(K,M);
      
    				while (m != 0) 
    				{
       					int r = k % m;
       					k = m;
      					m = r;
    				}
      
      				return k;
      			}

 				public static int func_rn(int a)
 				{
 					int first = (int)Math.ceil(a/4);
 					int second = (int)Math.ceil(a/5);
 					int third = (int)Math.ceil(a/10);
 					
 					int z = (int) Math.ceil((int)Math.pow(2,first)) * func_rn(second) * func_rn(third);

 					return z;
 				} 
 

 		
 	}
 
	class FastReader {
			private InputStream stream;
			private byte[] buf = new byte[1024];
			private int curChar;
			private int numChars;
			private SpaceCharFilter filter;
	 
			public FastReader(InputStream stream) {
				this.stream = stream;
			}
	 
			public static boolean isWhitespace(int c) {
				return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
			}
	 
			public int read() {
				if (numChars == -1)
					throw new InputMismatchException();
				if (curChar >= numChars) {
					curChar = 0;
					try {
						numChars = stream.read(buf);
					} catch (IOException e) {
						throw new InputMismatchException();
					}
					if (numChars <= 0)
						return -1;
				}
				return buf[curChar++];
			}
	 
			public int nextInt() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				int sgn = 1;
				if (c == '-') {
					sgn = -1;
					c = read();
				}
				int res = 0;
				do {
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					res *= 10;
					res += c - '0';
					c = read();
				} while (!isSpaceChar(c));
				return res * sgn;
			}
	 
			public String readString() {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				StringBuilder res = new StringBuilder();
				do {
					res.appendCodePoint(c);
					c = read();
				} while (!isSpaceChar(c));
				return res.toString();
			}
	 
			public boolean isSpaceChar(int c) {
				if (filter != null)
					return filter.isSpaceChar(c);
				return isWhitespace(c);
			}
	 
			public String next() {
				return readString();
			}
	 
			public interface SpaceCharFilter {
				public boolean isSpaceChar(int ch);
			}
	 
		public Long readLong() {
			return Long.parseLong(readString());
			}
		 
			public Double readDouble() {
			return Double.parseDouble(readString());
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
						writer.print(' ');
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
 
 