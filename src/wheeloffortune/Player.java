package wheeloffortune;

import java.util.Random;

public class Player{
	private int playerNum;
  	private String playerName;
  	private int roundTotal;
  	private int grandTotal;

  //Default Constructor 
  	public Player()
  	{
  		playerNum= 0; 
  		playerName= "?";
  		grandTotal= 0; 	
  	}
  
    //Primary Constructor 
  	public Player(int playerNum, String playerName,int grandTotal)
  	{
  		this.playerNum= playerNum; 
  		this.playerName= playerName; 
  		this.grandTotal= grandTotal; 
  	}

    //Copy Constructor 
  	public Player(Player obj)
  	{
  		this.playerNum= obj.playerNum;
  		this.playerName= obj.playerName;
  		this.grandTotal= obj.grandTotal;
  	}

    //Getters & Setters 
  	public int getPlayerNum() 
  	{
  		return playerNum;
  	}
  	public void setPlayerNum(int playerNum) 
  	{
  		this.playerNum = playerNum;
  	}
  	public String getPlayerName()
  	{
  		return playerName;
  	}
  	public void setPlayerName(String playerName) 
  	{
  		this.playerName = playerName;
  	}
  	public float getGrandTotal()
  	{
  		return grandTotal;
  	}
  	public void setGrandTotal(int grandTotal)
  	{
  		this.grandTotal = grandTotal;
  	}
  	public void Display()
  	{
  		System.out.println("--------PLAYER DATA------");
  		System.out.println("Player Number:" + playerNum + "\nPlayer Name: "+ 
      playerName + "\nPlayer Grand Total: "+ grandTotal);
  	}
  	
	
	//This method calculates the player's round total
		public int addRoundTotal(int amount) {
			roundTotal+=amount;
			return roundTotal;
			
		}
	//This method calculates the players round total
		public int addGrandTotal(int amount) {
			grandTotal+=amount;
			return grandTotal;
		}
	
	public int getRoundTotal() {
		return roundTotal;
	}

	public void setRoundTotal(int roundTotal) {
		this.roundTotal = roundTotal;
	}
}
