package graph;
import java.util.ArrayList;
import tree.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Graph {
Set<Node> Nodes = new HashSet<Node>();
Set<Edge> Edges = new HashSet<Edge>();
/**Takes a node as parameter and adds it as disconnected node to the graph 
 * @param New
 */
public void addNode(Node New)
{
	Nodes.add(New);
}
/**takes 2 nodes as params and creates an edge between the two nodes and adds it to the graph
 * @param a
 * @param b
 */
public void addEdge(Node a,Node b)
{
	Edge edge = new Edge(a,b);
	Edges.add(edge);
}
/**takes 2 nodes and relationship type as param and adds the resultant edge to the graph. Method also creates any implied edges 
 * that might have to be added.
 * For example, if an edge is created between a,b of type 1, ie)a is the child of b, then an edge is created between b,a of type 2
 * ie) b is the parent of a.
 * @param a source node for directed edge
 * @param b destination node for directed edge
 * @param w relationship type
 */
public void addEdge(Node a,Node b,int w)
{
	Edge edge = new Edge(a,b,w);
	Edges.add(edge);
	if(w==1)
	{
		Edge edge2 = new Edge(b,a,2);
		Edges.add(edge2);
	}
	else if(w==2)
	{
		Edge edge2 = new Edge(b,a,1);
		Edges.add(edge2);
	}
	else if(w==3)
	{
		Edge edge2 = new Edge(b,a,3);
		Edges.add(edge2);
	}
	else if(w==5)
	{
		Edge edge2 = new Edge(b,a,6);
		Edges.add(edge2);
	}
	else if(w==6)
	{
		Edge edge2 = new Edge(b,a,5);
		Edges.add(edge2);
	}
}
/**Takes an edge as parameter and deletes the edge from the graph
 * @param e
 */
public void deleteEdge(Edge e)
{
	if(Edges.contains(e))
	{
		Edges.remove(e);
	}
}
/**Takes a node as parameter and deletes it from the graph and also any edges associated with that node.
 * @param a
 */
public void deleteNode(Node a)
{
	Iterator<Edge> iterator=Edges.iterator();
	while(iterator.hasNext())
	{
		Edge e = iterator.next();
		if(e.nodes[0].equals(a) || e.nodes[1].equals(a) )
		{
			this.deleteEdge(e);
		}
	}
	Nodes.remove(a);
}
/**Takes a node as param and returns true if that node is present in the graph and false otherwise.
 * 
 * @param a is the node which is being checked
 * @return true if node is present in the graph and false otherwise
 */
public boolean contains(Node a)
{
	Iterator<Node> iterator = Nodes.iterator();
	while(iterator.hasNext())
	{
		Node b=iterator.next();
		if(b.equals(a))
		{
			return true;
		}
	}
	return false;
}
/*
 * removed since this doesn't apply to given application
public boolean contains(char a)
{
	Iterator<Node> iterator = Nodes.iterator();
	while(iterator.hasNext())
	{
		Node b=iterator.next();
		if(b.name==a)
		{
			return true;
		}
	}
	return false;
}*/
/**takes id of a person as parameter and tells us if a person with that id is present or not
 * 
 * @param a is the node which is being checked
 * @return true if a is present in the Graph object and false otherwise
 */
public boolean contains(int a)
{
	Iterator<Node> iterator = Nodes.iterator();
	while(iterator.hasNext())
	{
		Node b=iterator.next();
		if(b.id==a)
		{
			return true;
		}
	}
	return false;
}
/**takes 2 nodes as parameter and returns true if there is an edge present between them.
 * 
 * @param a
 * @param b
 * @return true if an edge is present from a to b
 */
public boolean contains(Node a,Node b)
{
	Edge x = new Edge(a,b);
	//Edge y=new Edge(b,a);
	Iterator<Edge> iterator=Edges.iterator();
	while(iterator.hasNext())
	{
		Edge z=iterator.next();
		if(z.equals(x)/*||z.equals(y)*/)
		{
			return true;
		}
	}
	return false;
}
/*
 * removed since method doesn't apply to given application
public Node getNode(char a)
{
	Iterator<Node> iterator = Nodes.iterator();
	Node c=new Node();
	while(iterator.hasNext())
	{
		Node b=iterator.next();
		if(b.name==a)
		{
			return b;
		}
	}
	return c;
}
*/
/**Takes id of a node as parameter and returns the node object for that person.
 * 
 * @param a
 * @return the Node object which has the same id as a.
 */
public Node getNode(int a)
{
	Iterator<Node> iterator = Nodes.iterator();
	Node c=new Node();
	while(iterator.hasNext())
	{
		Node b=iterator.next();
		if(b.id==a)
		{
			return b;
		}
	}
	return c;
}
/** prints the names of all the peeople in the family to console */
public void displayVertices()
{
	Iterator<Node> iterator = Nodes.iterator();
	while(iterator.hasNext())
	{
		System.out.println(iterator.next().name);
	}
}
/* incomplete useless method
public void eulerPath()
{
	for(int i=0;i<Nodes.size();i++)
	{
		Set<Node> visited = new HashSet<Node>();
		Iterator<Node> iterator=Nodes.iterator();
		Iterator<Edge> iteratore=Edges.iterator();
		Node h=new Node();
		h=iterator.next();
		visited.add(h);
		for(int j=0;j<Edges.size();j++)
		{
			Edge k=iteratore.next();
			if(k.contains(h))
			{
				if(visited.contains(k.getCounter(h))==false)
				{
					visited.add(k.getCounter(h));
				}
			}
		}
	}
}*/
/** Iterates through the graph and prints all the edges present in the graph to console in the following format:
 * "a.name b.name relationshipType weight" where a is the source node of directed edge and b is the destination node of directed edge
 * 
 */
public void displayEdges()
{
	Iterator<Edge> iterator = Edges.iterator();
	while(iterator.hasNext())
	{
		Edge b=iterator.next();
		System.out.println(b.nodes[0].name+" "+b.nodes[1].name+" "+b.type +" " + b.weight);
	}
}
/**
 * Prints the vertices and edges in Graph to the console by invoking displayVertices() and displayEdges() in that order.
 */
public void summarise()
{
	this.displayVertices();
	this.displayEdges();
}
/** gets the relationship between two persons passed as parameters in the given family tree
 * 
 * @param a 
 * @param b
 * @return an ArrayList object which contains the list of persons to be traversed from Person a in order to reach Person b
 */
public ArrayList<Person> getRelationship(Person a, Person b)
{
	ArrayList<Person> path = new ArrayList<Person>();
	int NoOfVertices = Nodes.size();
	int i=0;
	int[] distance = new int[NoOfVertices];
	ArrayList<Person> predecessor = new ArrayList<Person>();
	/* Bellman-Ford algorithm used to calculate closest relationship*/
	while(i<NoOfVertices)//initialise distance to a very large number.
	{
		distance[i]=99999999;
	}
	distance[a.getId()]=0;
	
	if(Nodes.contains(a) && Nodes.contains(b))
	{
		Iterator<Edge> iterator = Edges.iterator();
		int a_id,b_id=0;
		while(iterator.hasNext())
		{
			Edge edge = iterator.next();
			a_id = edge.nodes[0].id;
			b_id = edge.nodes[1].id;
			if((distance[a_id]+edge.weight)<distance[b_id])
			{
				distance[b_id]=distance[a_id]+edge.weight;
				predecessor.set(b_id, a);
			}
		}
		b_id = b.getId();
		while(true)
		{
			Person c = predecessor.get(b_id);
			//path.set(NoOfVertices, c);
			path.add(c);
			//NoOfVertices--;
			if(c.equals(a))
			{
				break;
			}
			b_id=distance[c.getId()];
		}
	}
	return path;
}
}
