import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] elements = new int[T];


    for(int i=0;i<T; i++)
      elements[i] = sc.nextInt();

    int ans = getEvenValue(elements); 
    //System.out.println(ans);

  }

    
  private static int getEvenValue(int[] set)
  {
    int[] subseq = getSubSeq(set);
    /*
    int[] factsum = getFactSum(subseq);
    int answer = 0;

    for(int i=0;i<factsum.length;i++)
    {
      if( (factsum[i]&1)==0 && factsum[i]>answer)
        answer = factsum[i];
    }
    */
    return 0;
  }



  private static int[] getSubSeq(int array[])
 {  
      int[][] listSubarrays = new int[(int)Math.pow(array.length,2)][array.length];
      
      
      for(int i=0 ; i < array.length ; i++)
      {
          int row = 0;
          for(int j = i ; j < array.length ; j++  )
          {
             int column = 0;
              for(int k = i ; k < j+1 ;k++)
                {  
                  listSubarrays[row][column] = array[k];
                  column++;
                }
              System.out.println();
              row++;
          }
      } 
      
      return null;
}







}