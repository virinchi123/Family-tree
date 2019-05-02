package graph;

public class Node {
int id=-1;
static int nodeCount=0;
char name=Integer.toString(id).charAt(0);
public Node()
{
	this.id = nodeCount;
	nodeCount++;
}
public Node(char name)
{
	this.name=name;
	this.id = nodeCount;
	nodeCount++;
}
}
