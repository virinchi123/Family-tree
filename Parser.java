package tree;
import java.io.*;
import java.util.*;
public class Parser {
public Person parse(String filepath) throws IOException
{
	try {
		FileReader fl = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fl);
		Person person=new Person();
		person.path=filepath;
		while(br.ready())
		{
			String line=new String(br.readLine());
			StringTokenizer st=new StringTokenizer(line,";");
			while(st.hasMoreTokens())
			{
				String token=new String(st.nextToken());
				StringTokenizer st2=new StringTokenizer(token);
				String token2 = new String(st.nextToken());
					if(token2.equals("name"))
					{
						token2=st2.nextToken();
						person.name=token2;
					}
					else if(token2.equals("id"))
					{
						token2=st2.nextToken();
						person.id=Integer.parseInt(token2);
					}
					else if(token2.equals("bio"))
					{
						token2=st2.nextToken();
						person.bio=token2;
					}
					else if(token2.equals("dob"))//convert the date stored in string format to a Date object.
					{
						token2=st2.nextToken();
						person.dob=Integer.parseInt(token2);
					}
					else if(token2.equals("id"))
					{
						token2=st2.nextToken();
						person.dod=Integer.parseInt(token2);
					}
			}
		}
		return person;
	}catch(IOException e)
	{
		System.out.println(e);
		Person person = new Person();
		
		return person;
	}
}
}
