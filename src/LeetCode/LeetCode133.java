package LeetCode;

import java.util.*;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", neighbors=" + neighbors + "]";
	}

}

public class LeetCode133 {

	 public Node cloneGraph(Node node) {
	     if(node == null) return node;
	     
	     // Use BFS algorithm to traverse the graph and get all nodes.
	     ArrayList<Node> nodes = getNodes(node);
	     
	     // Copy nodes, store the old->new mapping information in a HashMap.
	     HashMap<Node, Node> mapping = new HashMap<>();
	     for(Node n : nodes) {
	     	mapping.put(n, new Node(n.val, new ArrayList<Node>()));
	     }
	     
	     // Copy neighbors
	     for(Node n : nodes) {
	     	Node newNode = mapping.get(n);
	     	for(Node neighbor : n.neighbors) {
	     		Node newNeighbor = mapping.get(neighbor);
	     		newNode.neighbors.add(newNeighbor);
	     	}
	     }
	     System.out.println(mapping.get(node));
	     return mapping.get(node);
	 }
	 
	 public ArrayList<Node> getNodes(Node node) {
	 	Queue<Node> queue =  new LinkedList<>();
	 	HashSet<Node> set =  new HashSet<>();
	 	
	 	queue.offer(node);
	 	set.add(node);
	 	
	 	while(!queue.isEmpty()) {
	 		Node head = queue.poll();
	 		for(Node neighbor : head.neighbors) {
	 			if(!set.contains(neighbor)) {
	 				queue.offer(neighbor);
	 				set.add(neighbor);
	 			}
	 		}
	 	}
	 	
	 	return new ArrayList<Node>(set);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode133 s = new LeetCode133();
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a.neighbors.add(b);
		a.neighbors.add(c);
		b.neighbors.add(a);
		b.neighbors.add(d);
		c.neighbors.add(a);
		c.neighbors.add(d);
		d.neighbors.add(b);
		d.neighbors.add(c);
		s.cloneGraph(a);
	}

}
