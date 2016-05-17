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
 
	class FCTRL
	{ 
		
		public static void main(String[] args)
		throws Exception
		{
				InputStream inputStream = System.in;
				OutputStream outputStream = System.out;
				FastReader in = new FastReader(inputStream);
				OutputWriter out = new OutputWriter(outputStream);	
 				StringBuilder stb = new StringBuilder();
 
 			int T = in.nextInt();

 			int values[] = new int[10];
 				
 			for(int i=0;i<10;i++)
 			{
 				double exponent = Math.pow(10,(i));

 				values[i] = find_fact(exponent);
 			}
			
			while(T-->0)
			{
				String str = in.readString();
				int length = str.length();
				int count=0;
				for(int i=0;i<length;i++)
				{
					//int x = (str.charAt(i)-48) * (int)Math.pow(10,(length-i-1));
					if(i == (length-1))
					{
						if((str.charAt(i)-48)>=5)
						{
							count+=1;
						}
						else{//do nothing
						}
					}
					else
					{
						if(str.charAt(i)=='6')
						{
							count += (str.charAt(i)-48) * values[length-i-1] + (str.charAt(i)-48) -2 ;
						}
						else if(str.charAt(i)=='0')
						{
							//do nothing
						}
						else 
						{
							count += (str.charAt(i)-48) * values[length-i-1] + (str.charAt(i)-48) -1 ;
						}
					}

				}
	    		stb.append(count+"\n");
	    	}
	    	System.out.print(stb);
	    }

	    public static int find_fact(double fact)
	    {
				int count=0;
				while(fact!=0)
				{
					count = count + (int) fact/5;
					fact=fact/5;
				}		
				return count;
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
 
 