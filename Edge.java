package graph;

public class Edge {
Node[] nodes = new Node[2];
int weight=1;
int type;
public Edge(Node a,Node b)
{
	nodes[0]=a;
	nodes[1]=b;
}
/*public Edge(Node a,Node b,int weight)
{
	this.weight=weight;
	nodes[0]=a;
	nodes[1]=b;
}*/
/** Creates an edge between nodes a,b and assigns weight according to first int param and type according to second int param.
 * Should be used sparingly and only for edges which merit special weights and unusual relationships
 * @param a
 * @param b
 * @param weight
 * @param type
 */
public Edge(Node a,Node b,int weight,int type)
{
	this.weight=weight;
	nodes[0]=a;
	nodes[1]=b;
	this.type=type;
}
/**Creates an edge between nodes a,b and assigns a weight to the edge based on relationship type as follows: 
 * parent/child/spouse : 1
 * sibling : 2
 * foster parent/child :4 */
public Edge(Node a,Node b,int type)
{
	this.type=type;
	nodes[0]=a;
	nodes[1]=b;
	this.type=type;
	if(type==1 || type==2 || type==3)//parent/child/spouse relationship
	{
		weight = 1;
	}
	else if(type==4)//sibling 
	{
		weight = 2;
	}
	else if(type==5||type ==6)//foster parent/child
	{
		weight = 4;
	}
}
/** takes a node as parameter and returns true if node is part of the graph*/
public boolean contains(Node a)
{
	if(nodes[0].equals(a)||nodes[1].equals(a))
	{
		return true;
	}
	return false;
}
/**takes a node as parameter and returns the node in the edge which is not the one passed as parameter */
public Node getCounter(Node a)
{
	if(nodes[0].equals(a))
	{
		return nodes[1];
	}
	if(nodes[1].equals(a))
	{
		return nodes[0];
	}
	return new Node();
}
}
