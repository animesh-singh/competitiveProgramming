import java.util.*;
import java.io.*;


class CHEFRP
{
	public static void main(String[] args)
	throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0)
		{
			int N = Integer.parseInt(br.readLine());
			long count=0;
			boolean flag=false;
			int item = 0;
			if(N==1)
			{
				item = Integer.parseInt(br.readLine());				
				if(item<2)
				{
					flag=true;
				}
				else
				{
					count=2;
				}
			}
			else
			{
				while(N-->0)
				{
					item = Integer.parseInt(br.readLine());				
					if(item<2)
					{
						flag=true;
					}
					else
					{
						count+=item;
					}
				}
			}

			if(flag)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(count);
			}
		}
	}
} 
