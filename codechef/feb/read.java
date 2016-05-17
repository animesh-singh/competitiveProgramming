import java.util.*;
import java.io.*;

class read
{
	public static void main(String asd[]) throws IOException
	{

		File file = new File("C:/Users/Animesh/Desktop/email.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		StringBuilder strbldr = new StringBuilder();
		
		while ((line = br.readLine()) != null) 
		{
   			if(line.startsWith("Email : "))
   			{
   				strbldr.append(line.substring(8) + ", ");
   			}
   			else if (line.startsWith("Email:")) 
   			{
   				strbldr.append(line.substring(6) + ", ");
   			}
   			else if (line.startsWith("Email")) 
   			{
   				strbldr.append(line.substring(5) + ", ");
   			}

		}
		
		File file123 = new File("email123.txt");
		file123.createNewFile();
		FileWriter writer = new FileWriter(file123);
		
		writer.write(strbldr.toString()); 
     	writer.flush();
      	writer.close();
		br.close();

	}


}