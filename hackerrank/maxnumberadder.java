import java.io.*;
public class CandidateCode 
{ 

/*
		5#9#6#4#6#8#0#7#1#5


*/

    public static String validtrianglesum(String input1)
    {
       String ans = "";
       int line_no = 1;
       int line_char = 1;
       long sum = 0;
       int max = -1;
       
       //if last position contains #
       if(input1.charAt(input1.length()-1) == '#')
       {
       	return "Invalid";
       }

       // for each character
       for(int i=0;i<input1.length();i++)
       {
           // if position is odd then
           if((i & 1)!=0)
           {
               //odd position should contain #
               if(input1.charAt(i) != '#')
               {
                   return "Invalid";
               }
           }
           else
           {
               //if even position is a number
               if(input1.charAt(i) > 47 && input1.charAt(i) < 58)
               {
                   int temp = input1.charAt(i) - '0';
                   
                   if(line_char==0)
                   {
                   	  //go to next line
                       line_no++;
                       line_char = line_no-1;
                       //add the max number to sum
                       sum +=max;
                       max=-1;                    
                   }
                   else
                   {
                   	line_char--;
                   }
                   if(temp>max)
                   {
                   	max = temp;
                   }
               }
               else
               {
                   //odd char not a number
                   return "Invalid";
               }
           }           
       }
       if(line_char != 0)
       {
       	return "Invalid";
       }
       ans = "" +(sum+max);
       return ans;
    }
    
    
}