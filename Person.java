package tree;
import Logger.SystemLog;
import graph.Node;
import java.io.*;
import java.util.*;
public class Person extends Node {
//File file;
String name,path,bio;
int id=0;
Date dob,dod;
public Person()
{
	
}
public Person(String path) throws IOException
{
	try {
	SystemLog log=new SystemLog("C:\\Users\\raovi\\OneDrive\\Desktop\\Family Tree");
	File file = new File(path);
	if(!file.exists())
	{
		log.log("Log file not found");
		file.createNewFile();
		log.log("File Created");
	}
	Parser parser=new Parser();
	this.assign(parser.parse(path));
	log.log("Person "+this.id+" created!");
	}catch(IOException e)
	{
		System.out.println(e);
	}
}
/**takes an object of the Person class as parameter and overwrites all the fields of current object with those of parameter*/
public void assign(Person person)
{
	this.bio=person.bio;
	this.name=person.name;
	this.dob=person.dob;
	this.dod=person.dod;
	this.id=person.id;
	this.path=person.path;
}
}
