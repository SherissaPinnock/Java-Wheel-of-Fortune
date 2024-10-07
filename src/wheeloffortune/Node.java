package wheeloffortune;

public class Node {
	private Card data;
	private String letter;
	private Node nextNode;
	private Node prevNode;
	private Node current; 
	//Primary 1
		public Node(Card data, Node nextNode) {
			this.data=data;
			this.nextNode=nextNode;
		}
		
		//Primary 2
		public Node(Card data) {
			this.data=data; 
			this.nextNode=null;
		}
		//Copy
		public Node(Node obj) {
			this.data=obj.data;
			this.nextNode=obj.nextNode;
		}
		
		public Node(String type, int value) {
			this.data= new Card(type, value);
			this.nextNode=null;
		}
	
	
	public Node(String letter) {
			this.letter=letter;
		}

	public Card getData() {
		return data;
	}
	
	public void setData(Card data) {
		this.data = data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getCurrent() {
		return current;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}
	public void display() {
	    System.out.print(" "+ letter);
	  }
}
