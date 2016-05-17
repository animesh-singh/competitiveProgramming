import java.io.*;
import java.util.*;



class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        while(N-->0)
        {
            String str = br.readLine();
            String[] word = str.split(" ",2);

            if(word[0].length() != word[1].length())
            {
                System.out.println("NO");
            }
            else
            {     
                char[] char1 = word[0].toCharArray();
                Arrays.sort(char1);
                String word1 = new String(char1);
                char[] char2 = word[1].toCharArray();
                Arrays.sort(char2);
                String word2 = new String(char2);
                if(word1.equals(word2))
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");

                }
            }

        }    





    }
}
