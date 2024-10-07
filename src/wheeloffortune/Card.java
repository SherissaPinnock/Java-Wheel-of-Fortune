package wheeloffortune;

public class Card {
	private String type;
	private int value;
	
	
	public String getType() {
		return type;
	}
	
	//Default Constructor
	public Card() {
		this.type="";
		this.value=0;
	}
	//Primary Constructor
	public Card(String type, int value) {
		this.type=type;
		this.value=value;
	}
	
	//Getters and Setters
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	} 
}
