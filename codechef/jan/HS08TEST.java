import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
	class HS08TEST
	{ 
 		
		public static void main(String[] args)
		throws Exception
		{
			InputStream inputStream = System.in;
			OutputStream outputStream = System.out;
			FastReader in = new FastReader(inputStream);
			OutputWriter out = new OutputWriter(outputStream);	
 			
 			
 			int withdraw_amount = in.nextInt() * 100;
 			String str = in.readString();
 			str = str.replace(".","");
 			int total_amount = Integer.parseInt(str);
 
 			if( withdraw_amount%500 == 0 && (total_amount) > (withdraw_amount +50) )
 			{
 				
 					total_amount = total_amount  - 50 - withdraw_amount;	
 			}
 			else
 			{
 				//do nothing(fuck this shit);
 			}
 					int dollars = total_amount / 100;
   					int cents = total_amount % 100;
    				System.out.print(dollars + "." + ( (cents>10) ? "":"0" ) + cents);
 		}
 	}
 
	class FastReader 
	{
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
	 
	class OutputWriter 
	{
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
 
 