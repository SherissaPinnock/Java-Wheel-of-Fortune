package wheeloffortune;

public class Queue {
	private Node front;
	  private Node rear;

	  public Queue() {
	    front = null;
	    rear = null;
	  }

	  public Node getFront() {
	    return front;
	  }

	  public void setFront(Node front) {
	    this.front = front;
	  }

	  public Node getRear() {
	    return rear;
	  }

	  public void setRear(Node rear) {
	    this.rear = rear;
	  }

	  public void Enqueue(String letter) {
		  Node temp = new Node(letter);

	    if (temp != null) {
	      if (front == null) {
	        front = temp;
	        rear = temp;
	      } else {
	        rear.setNextNode(temp);
	        temp.setPrevNode(rear);
	        rear = temp;
	      }
	    } else {
	      System.out.println("The list is full and can not take anymore letters");
	    }
	  }


	  public String Dequeue() {
	    String dataToReturn = "";

	    if (front != null) {
	      if (front == rear) {
	        rear = null;
	      }

	      Node temp = front;
	      dataToReturn = front.getLetter();
	      front = front.getNextNode();
	      temp = null;
	    }
	    return dataToReturn;
	  }

	  public void AvaliableLetters() {
	    Queue tempQueue = new Queue();

	    while (front != null) {
	      tempQueue.Enqueue(Dequeue());
	      tempQueue.getRear().display();
	    }
	    while (tempQueue.getFront()!=null) {
	    	Enqueue(tempQueue.Dequeue());
	    }
	  }
	}

