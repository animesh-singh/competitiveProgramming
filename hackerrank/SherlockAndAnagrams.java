import java.io.*;
import java.util.*;

public class Solution
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		int length;
		while(n-->0)
		{
			str = br.readLine();
			length = str.length();
			if(length<2)
			{
				System.out.println("0");
				continue;
			}
			else
			{
				System.out.println(countAnagrams(str,length));
			}
		}
	}

	private static int countAnagrams(String str, int length)
	{
		int count=0;
		for(int i=0;i<length;i++)
		{
			
			for(int j = i; j < length-1 ; j++)
			{
				//System.out.println(str.charAt(j)+" and substring : "+str.substring(i,j+1));
				count += searchAnagram(str,length,i+1,str.substring(i,j+1));
			}
		}             
		return count;
	}


	private static int searchAnagram(String str,int length,int start, String subString)
	{
		int subLength = subString.length();
		int[] countString = new int[26];
		int[] countSubString = new int[26];
		int count=0;
	
		int i;
		for(i = 0 ; i < subLength && (start+i) < length ; i++)
		{
			countString[str.charAt(start+i)-97]++;
			countSubString[subString.charAt(i)-97]++;
			//System.out.println("String charAt : "+str.charAt(start+i)+" ... subString charAt : "+subString.charAt(i));
		}

		
		int n;
		for(n = (start+i) ; n < length ; n++)
		{
			if(isAnagram(countString,countSubString))
			{
				count++;
			}
			countString[str.charAt(start)-'a']--;
			countString[str.charAt(n)-'a']++;
			start++;
		}
		
		if(n == length)
		{
			if(isAnagram(countSubString,countString))
				count++;
		}


		
		return count;
	}

	private static boolean isAnagram(int array1[], int array2[]) {
		for (int i=0; i<26; i++)
		{
			if (array1[i] != array2[i])
				return false;
		}
		return true;
	}
}