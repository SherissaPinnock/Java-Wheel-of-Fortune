package wheeloffortune;

//import java.io.*;
//import java.util.*;
import java.util.Random;

public class Wheel {
	private  Node head;
	private Node tail;
	
	
	//Default constructor
	public Wheel() {
		this.head=null;
		this.tail=null;
	}
	
	//Primary Constructor
	public Wheel(Node head, Node tail) {
		//this.head=head;
		this.tail=tail;
	}
	//Getters and Setters
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	} 
	//Method that adds card to the wheel
	public void addCard(Card dataToAdd){  
        //Create new node  
        Node newNode = new Node(dataToAdd);  
        //Checks if the list is empty.  
        if(head == null) {  
             //If list is empty, both head and tail would point to new node.  
            head = newNode;  
            tail = newNode;  
            newNode.setNextNode(head);  
        }  
        else {  
            //tail will point to new node.  
            tail.setNextNode(newNode);  
            //New node will become new tail.  
            tail = newNode;  
            //Since, it is circular linked list tail will point to head.  
            tail.setNextNode(head);  
        }  
    }  
	
	public void addCard(Node node) {
        //Checks if the list is empty.  
        if(head == null) {  
             //If list is empty, both head and tail would point to new node.  
            head = node;  
            tail = node;  
            node.setNextNode(head);  
        }  
        else {  
            //tail will point to new node.  
            tail.setNextNode(node);  
            //New node will become new tail.  
            tail = node;  
            //Since, it is circular linked list tail will point to head.  
            tail.setNextNode(head);  
        }  
	}
	//Method that displays the cards in the wheel
	public void displayCards() { 
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Cards in the Wheel: ");  
             do{  
                //Prints each node by incrementing pointer.  
                System.out.print(" "+ current.getData().getValue());  
                current = current.getNextNode();  
            }while(current != head);  
            System.out.println();  
        }  
    }  
	
	//This method spins the wheel
	public Card spinWheel() {
		
		Node currentNode = head;
			for (int i=0; i< generateRandomSpace(); i++) {
				 currentNode = currentNode.getNextNode();
			}
			if (currentNode.getData().getType().contains("Bankrupt")) {
				System.out.println("Whoops, You landed on bankrupt!");
					
			}
			else if (currentNode.getData().getType().contains("Lose a Turn")){
				System.out.println("Oh no, You lost your turn!");
				
			}
			else {
			System.out.println("You landed on "+ currentNode.getData().getValue());
			
			}
			return currentNode.getData();
		
	}
	
	public int generateRandomSpace() {
		Random rand = new Random(System.currentTimeMillis());
		int spacesToMove= rand.nextInt(100 - 50 + 1) + 50;
		//System.out.println(spacesToMove);
		return spacesToMove;
	}

		
	}

