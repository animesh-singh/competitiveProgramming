import java.io.*;
import java.util.*;
import java.lang.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	HashMap map = new HashMap();
        map.put('a', "2");
        map.put('b', "2");
        map.put('c', "2");
        map.put('d', "3");
        map.put('e', "3");
        map.put('f', "3");
        map.put('g', "4");
        map.put('h', "4");
        map.put('i', "4");
        map.put('j', "5");
        map.put('k', "5");
        map.put('l', "5");
        map.put('m', "6");
        map.put('n', "6");
        map.put('o', "6");
        map.put('p', "7");
        map.put('q', "7");
        map.put('r', "7");
        map.put('s', "7");
        map.put('t', "8");
        map.put('u', "8");
        map.put('v', "8");
        map.put('w', "9");
        map.put('x', "9");
        map.put('y', "9");
        map.put('z', "9");

		String num[] = br.readLine().split(",");

       	String number = new String("");
       	for(int i=0;i<num.length;i++)
       	{
       		number.concat(num[i]);
       	}
       	int final_number = Integer.parseInt(number);


        String words[] = br.readLine().split(",");
		
		String answers[] = new String[100];
		int x=0;

		for(int i=0;i<words.length;i++)
		{
			String val = new String("");
			
			for(int j=0;j<words[i].length();j++)
			{
				val.concat(((String)map.get(words[i].charAt(j))));
			}
			int value = Integer.parseInt(val);

			if(final_number == value)
			{
				answers[x] = words[i];
				x++;
			}
		}
		Arrays.sort(answers);
		for(int i=0;i<answers.length;i++)
		{
			System.out.println(answers[i]);
		}
    }
}
