import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1;i<=N;i++)
        {
        	for(int j=i;j<N;j++)
        	{
        		System.out.print("#");
        	}
        	System.out.println();
        }
    }
}