package tree;
import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Parser {
public Person parse(String filepath) throws IOException,ParseException
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
					else if(token2.equals("dob")) //convert the date stored in string format to a Date object.
					{
						try {							
						token2=st2.nextToken();
						SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy");
						person.dob=formatter.parse(token2);
						}catch(ParseException e)
						{
							System.out.println(e);
						}
					}
					else if(token2.equals("dod"))
					{
						try {
						token2=st2.nextToken();
						SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy");
						person.dod=formatter.parse(token2);
						}catch(ParseException e)
						{
							System.out.println(e);
						}
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
