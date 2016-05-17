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


class CSUB
{
	
	
	public static void main(String[] args)
	throws Exception
	{
		OutputStream output = System.out;
		FasterWriter out = new FasterWriter(output);	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());

		while(T-->0)
		{
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			long no=0;
			for(int i=0;i<N;i++)
			{
				if(str.charAt(i)=='1')
				{
					no++;
				}
			}
			no = no*(no+1)/2;

			out.println(no);
		}

		out.close();
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

