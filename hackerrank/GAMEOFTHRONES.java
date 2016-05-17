import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution 
{

    public static void main(String[] args) 
    {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        String ans;

        LinkedList list = new LinkedList();

        for(int i=0;i<=inputString.length();i++)
        {
            char a = inputString.charAt(i);

            if(list.indexOf(a)==-1)
            {
                list.addLast(a);
            }
            else
            {
                list.remove(list.indexOf(a));
            }
        }
        
        if(list.size()>1)
        {
            ans = "NO";
        }
        else
        {
            ans = "YES";
        }
        System.out.println(ans);
        myScan.close();
    }
}
