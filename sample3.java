import java.io.*;
import java.util.*;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String start[] = str.split("-",-1);
        int start_date[] = new int[4];

        str = br.readLine();
        String current[] = str.split("-",-1);
        int current_date[] = new int[3];

        for(int i=0;i<start.length;i++)
        {
            start_date[i] = Integer.parseInt(start[i]);
            current_date[i] = Integer.parseInt(current[i]);
        }

       
    }
}
