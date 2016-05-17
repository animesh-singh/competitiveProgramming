import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) throws IOException
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0)
        {
        	int N = Integer.parseInt(br.readLine());
        	int ans=0;
        	for(int i=1;i<N;i++)
        	{
        		ans*=2;
        		ans++;
        	}
        	System.out.println(ans);
        }




    }
}