package aiControllers;

public class Maze{
	private static Maze maze = new Maze();
	private Node<String> source;
	
	Maze() {
		init();
	}
	
	public static Maze getInstance(){
		return maze;
	}
	
	public Node<String> getSource(){
		return source;
	}
	
	private void init() {
		source = new Node<>("S");
		var finish = new Node<String>("T", true);
		var start = new Node<String>("1");
		var room2 = new Node<String>("2");
		var room3 = new Node<String>("3");
		var room4 = new Node<String>("4");
		start.addChild(source);
		start.addChild(room2);
		start.addChild(room3);
		
		room2.addChild(start);
		
		room3.addChild(start);
		room3.addChild(room4);
		
		room4.addChild(room3);
		room4.addChild(finish);
	}
}