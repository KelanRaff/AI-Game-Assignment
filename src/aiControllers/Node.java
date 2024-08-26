package aiControllers;

import java.util.ArrayList;
import java.util.Collection;

public class Node<E> {
	private boolean visited = false;
	private boolean goal = false;
	private Collection<Node<E>> children = new ArrayList<>();
	
	private E data;
	
	public Node(E data) {
		this.data = data;
	}
	
	public Node(E data, boolean goal) {
		this(data);
		this.goal = goal;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isGoal() {
		return goal;
	}
	
	public E getData() {
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public Node<E>[] children(){
		return (Node[]) children.toArray(new Node[children.size()]);
	}
	
	public void addChild(Node<E> child){
		children.add(child);
	}
}
