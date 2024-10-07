package wheeloffortune;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class Game extends Wheel{
	private Round round;
	private Queue guessedLetters;
	private Player currentPlayer; 
	private Player player1;
	private Player player2;
	private Player player3;
	private boolean isCurrentPlayerTurn;
	private boolean isPuzzleSolved;
	private boolean puzzleHasAllVowels;
	private static final int VOWEL_COST = 250;
	private String[] puzzleState;
	final static String ESC = "\033[";
	
	public void menu() {
		player1= new Player();
		player2= new Player();
		player3= new Player();
		
		System.out.println("*****************LET'S PLAY WHEEL OF FORTUNE!**********************");
		int choice = 0;
		do {
			System.out.println("Choose your path "+ "\n1. View game rules"+ "\n2. Start Game");
			Scanner read= new Scanner(System.in);
			//Exception Handling
			try {
				choice=read.nextInt();
			} catch(Exception e) {
				System.err.println("INVALID INPUT");
			}
			
			switch (choice) {
				case 1:
					viewRules();
				case 2:
					for (int i = 0; i < 20; ++i) System.out.println(); //creates spaces
					System.out.println("Player 1 please enter your name: "); 
					read = new Scanner(System.in);
					player1.setPlayerName(read.nextLine());
					
					System.out.println("Player 2 please enter your name: ");
					player2.setPlayerName(read.nextLine());
					
					System.out.println("Player 3 please enter your name: ");
					player3.setPlayerName(read.nextLine());
					setPuzzleSolved(false);
					
					//Making a round object
					round= new Round();
		
					//Loops 3 times for loop
					for (int i=1; i<4; i++) {
						round.getRandomPuzzle();
						loadPuzzle();
						guessedLetters= new Queue();
						isPuzzleSolved=false;
						puzzleHasAllVowels=false;
						System.out.println("\n**************ROUND "+ i+"*****************\n");
						
						//Prints the blank puzzle
						System.out.println("THE CATEGORY IS: "+ round.getCategory());
						for (int x=0; x<puzzleState.length; x++) {
							System.out.print("_ ");
						}
		
						
						//Displaying Player's Grand Total
						System.out.println("\n\n"+player1.getPlayerName()+ "'s Grand Total: "+ player1.getGrandTotal()+"\n" 
								+player2.getPlayerName()+ "'s Grand Total: "+ player2.getGrandTotal()+"\n"+
								player3.getPlayerName()+ "'s Grand Total: "+ player3.getGrandTotal()+"\n");
						while (!isPuzzleSolved) {
							for (int y = 1; y < 4; y++) {
								switch(y) {
									case 1: currentPlayer = player1;
											break;
									case 2: currentPlayer = player2;
											break;
									case 3: currentPlayer = player3;
											break;
								}
							playerTurn(currentPlayer);
							if (isPuzzleSolved) break;
						}	
							
					}//end while
						//Here we call the method addGrantTotal to accumulate the winning player's round total
						
			
						//resets player round total for new round
						player1.setRoundTotal(0);
						player2.setRoundTotal(0);
						player3.setRoundTotal(0);
					}
					//Here we call the function to find the winner after 3 rounds
					findWinner();
					endGame();
						break;
				case 3:
					break;
					
				default:
					System.out.println("\nINVALID INPUT\n");	
					
				}		
			} while (choice<1 || choice>3);
			
		} 
	

		
		
	
	//This method allows the player to view the rules
	public void viewRules() {
		System.out.println("\t\t\t|******GAME PLAY*****|");
		  
		  System.out.println("\n---->Game starts with the first player spinning the wheel (Select option 1 to Spin Wheel)");
		  
		  System.out.println("\n---->If it lands on the bankrupt then you will both lose your turn and the money allocated in that round will change to 0");
		  
		  System.out.println("\n---->But if it lands on lose a turn then it will pass to the next player ");
		  
		  System.out.println("\n---->You are allowed to guess a letter in the puzzle or attempt to solve the puzzle");
		 
		  System.out.println("\n---->If option 2 is selected then you are able to enter a letter and the number of occurrences for that letter will show else you will lose your turn");
		 
		  System.out.println("\n---->If the letter entered is in the puzzle, then the occurrences will be revealed and you are allowed to either spin again, buy a vowel or solve the puzzle.");
		  
		  System.out.println("\n---->Based on the number of occurrences of that letter it will be multiplied by the value of the card you landed on when the wheel was spinned");
		  
		  System.out.println("\n---->However, if the letter guessed is not in the puzzle or you failed to solve the puzzle then you will lose your turn and it will pass to the next layer");
		  
		  System.out.println("\n---->The rules above will continue until the three rounds are done and the winner of the game is revealed"); 
		 
		  System.out.println("\n\t\t---->ENJOY THE GAME<-----");

	}
	private void playerTurn(Player currentPlayer) {
		//Initializing Card
		Card card1= new Card("Money", 2500);
		Card card2= new Card("Lose a Turn", 0);
		Card card3= new Card("Money", 600);
		Card card4= new Card("Money", 700);
		Card card5= new Card("Money", 600);
		Card card6= new Card("Money", 650);
		Card card7= new Card("Money", 500);
		Card card8= new Card("Money", 700);
		Card card9= new Card("Bankrupt", 0);
		Card card10= new Card("Money", 600);
		Card card11= new Card("Money", 550);
		Card card12= new Card("Money", 500);
		Card card13= new Card("Money", 600);
		Card card14= new Card("Bankrupt", 0);
		Card card15= new Card("Money", 650);
		Card card16= new Card("Money", 850);
		Card card17= new Card("Money", 700);
		Card card18= new Card("Lose a Turn", 0);
		Card card19= new Card("Money", 800);
		Card card20= new Card("Money", 500);
		Card card21= new Card("Money", 650);
		Card card22= new Card("Money", 500);
		Card card23= new Card("Money", 900);
		Card card24= new Card("Bankrupt", 0);
		

		//Adding cards to wheel
		Wheel wheel= new Wheel();
		Node node= new Node(card1);
		wheel.addCard(node);
		wheel.addCard(card2);
		wheel.addCard(card3);
		wheel.addCard(card4);
		wheel.addCard(card5);
		wheel.addCard(card6);
		wheel.addCard(card7);
		wheel.addCard(card8);
		wheel.addCard(card9);
		wheel.addCard(card10);
		wheel.addCard(card11);
		wheel.addCard(card12);
		wheel.addCard(card13);
		wheel.addCard(card14);
		wheel.addCard(card15);
		wheel.addCard(card16);
		wheel.addCard(card17);
		wheel.addCard(card18);
		wheel.addCard(card19);
		wheel.addCard(card20);
		wheel.addCard(card21);
		wheel.addCard(card22);
		wheel.addCard(card23);
		wheel.addCard(card24);
	
		wheel.setHead(node);
		
		
		isCurrentPlayerTurn = true;
		System.out.println("");
		int value=0;
		Scanner read= new Scanner(System.in);
		//loops as long as it is the player's turn
		while (isCurrentPlayerTurn) {
			System.out.println(player1.getPlayerName()+"'s round total: "+ player1.getRoundTotal() + "\n"+
					player2.getPlayerName()+"'s round total: "+ player2.getRoundTotal()+ "\n"+
					player3.getPlayerName()+"'s round total: "+ player3.getRoundTotal());
			
			int option=0;
			do {
				System.out.println("\n**********" + currentPlayer.getPlayerName() + "'S TURN.***************");
				System.out.println("\nPress 1 to spin  \nPress 2 to buy vowel  \nPress 3 to solve puzzle");
				//Exception Handling
				try {
					option = read.nextInt();
				} catch (Exception e){
					System.err.println("INVALID INPUT");
				}
				
				System.out.println("");
				
				switch(option) {
				case 1: 
						Card currentCard=wheel.spinWheel();
						value=currentCard.getValue();
						if (value==0) {
							isCurrentPlayerTurn=false;
							if (currentCard.getType().equals("Bankrupt")) {
								currentPlayer.setRoundTotal(0);
							}
						}
						else {
							guessConsonant(value);
						}
						break;
				case 2: buyVowel(0);
						break;
				case 3: solvePuzzle();
						break;
				default:
					System.out.println("\nINVALID INPUT\n");
				}
				
				System.out.println("");
				if (isPuzzleSolved==true) break; // If the player guessed the phrase correctly, the turn ends.
			}while (option<1 || option>3);
			
			}
			
	}
	
	public void loadPuzzle() {
		String puzzle= round.getPuzzle();
		puzzleState=new String[puzzle.length()];
		for (int i=0; i<round.getPuzzle().length(); i++) {
			puzzleState[i]= "_ ";
		}
		
	}
	//This method allows the user to buy a vowel
	private void buyVowel(int value) {
		Scanner read= new Scanner(System.in);
		
		//Checks to see if they have enough money to buy a vowel
		if (currentPlayer.getRoundTotal() >= VOWEL_COST) {
			if (puzzleHasAllVowels) {
				System.out.println("There are no more vowels");
				return;
			}
			currentPlayer.addRoundTotal(-VOWEL_COST); // Charges the player the cost of the vowel.
			
			while(true) { // Prompts user to enter a letter until a vowel is entered.
				String guess;
				System.out.println("Enter vowel: ");
				guess=read.nextLine();
				if (isLegalGuess(guess) && isVowel(guess)) {
					trackPlayerGuess(guess, value);
					return;
				} else if (guess.length() == 1 && ! isVowel(guess)){
					System.out.println("Please enter a vowel.");
				}
			}
		} else {
			System.out.println("You cannot afford to buy a vowel."); // If player's balance is too low, does not let the player buy a vowel.
		}
		
	}


	//This method allows the user to guess consonants
	private void guessConsonant(int value) {
		while(true) {
			Scanner read= new Scanner(System.in);
			System.out.println("Please enter a consonant: ");
			String guess=read.nextLine();
			if (isLegalGuess(guess) && ! isVowel(guess)) {
				trackPlayerGuess(guess, value);
				return;
			} 
		}
	}
	
	
	public void solvePuzzle()
	{
		Scanner read= new Scanner(System.in);
		if (currentPlayer.getRoundTotal()==0) {
			System.out.println("You cannot solve the puzzle without money");
		}
		else {
			System.out.println("Enter a guess: ");
			String guess=read.nextLine();
			if (guess.toUpperCase().equals(round.getPuzzle())) {
				System.out.println("You guessed: "+ guess);
				System.out.println("THAT'S CORRECT " + currentPlayer.getPlayerName()+ "! YOU WON THE ROUND!");
				isPuzzleSolved=true;
				isCurrentPlayerTurn=false;
				currentPlayer.addGrandTotal(currentPlayer.getRoundTotal());
			}
			else {
				System.out.println("That's not it!");
				isCurrentPlayerTurn=false;
			}
		}
	}
	
	//This method validates whether a guess is legal
	private boolean isLegalGuess (String guess) {
		char guessch = Character.toUpperCase(guess.charAt(0));
		String playerGuesses = null;
		if (guess.length() != 1 || ! Character.isLetter(guessch)) { // Ensures entry is a single letter.
    		System.out.println("That guess is illegal. Try again.");
    		return false;
		} else { // Ensures the letter has not been guessed already.
				Queue tempQueue= new Queue();
				System.out.println("You guessed "+ guessch);
				while (guessedLetters.getFront()!= null) {
					String letter= guessedLetters.Dequeue();
					if (guess.toUpperCase().equals(letter)) {
						System.out.println("The letter " + guessch + " has already been guessed.");
						return false;
					}
					tempQueue.Enqueue(letter);
				}
				while(tempQueue.getFront()!=null) {
					guessedLetters.Enqueue(tempQueue.Dequeue());
				}
			
    		return true;
    	}
    }
	
	//This method checks if the guess is a vowel
	private boolean isVowel(String guess) {
    	char guessch = Character.toUpperCase(guess.charAt(0));
		return guessch == 'A' || guessch == 'E' || guessch == 'I' || guessch == 'O' || guessch == 'U';
	}
	
	//This method adds the guessed letters into a queue and checks if the guess is correct
	 private void trackPlayerGuess(String guess, int value) {
		 int occurrences=0;
		 int actualVowelCount=0;
		 int puzzleStateVowelCount=0;
		 guessedLetters.Enqueue(guess.toUpperCase());
		 System.out.println("LETTERS GUESSED: ");
		 guessedLetters.AvaliableLetters();
		 if (round.getPuzzle().contains(guess.toUpperCase())) {
			 System.out.println("\nThat's correct!");
			 for(int i=0; i<round.getPuzzle().length(); i++) {
				 char letter= round.getPuzzle().charAt(i);
				 
				 if (letter==guess.toUpperCase().charAt(0)) {
					 puzzleState[i]=guess;
					 occurrences++;
					 
				 }

				 //counts the number of vowels in the puzzle
				 if(isVowel(String.valueOf(letter))) {
					 actualVowelCount++;
				 }
				 
				 //
				 if (isVowel(puzzleState[i])) {
					 puzzleStateVowelCount++;
				 }
			 }
			 if (actualVowelCount==puzzleStateVowelCount) {
				 System.out.println("There are no more vowels in the puzzle");
				 puzzleHasAllVowels=true;
			 }
			 currentPlayer.addRoundTotal((value* occurrences)); //Multiplies card value by occurrences
			 //updates the puzzle state array
			 for (int i=0; i<puzzleState.length; i++) {
				 System.out.print(puzzleState[i].toUpperCase());
			 }
		 }
		 else {
			 System.out.println("\nSorry wrong guess! ");
			 isCurrentPlayerTurn=false;
		 }
	 }
	
	
	private void resetVariables() {
		isCurrentPlayerTurn = false;
		isPuzzleSolved=false;
	}
	public boolean isPuzzleSolved() {
		return isPuzzleSolved;
	}
	
	public void setPuzzleSolved(boolean isPuzzleSolved) {
		this.isPuzzleSolved = isPuzzleSolved;
	}
	//This method finds the winner
	public void findWinner() {
		if (player1.getGrandTotal() > player2.getGrandTotal() && player1.getGrandTotal() > player3.getGrandTotal()) {
			System.out.println("" + player1.getPlayerName() +" WINS THE WHOLE GAME WITH A SCORE OF "+ player1.getGrandTotal());
		} else if (player2.getGrandTotal() > player1.getGrandTotal() && player2.getGrandTotal() > player3.getGrandTotal()) {
			System.out.println("" + player2.getPlayerName() +"  WINS THE WHOLE GAME WITH A SCORE OF "+ player2.getGrandTotal());
		} else if (player3.getGrandTotal() > player1.getGrandTotal() && player3.getGrandTotal() > player2.getGrandTotal()) {
			System.out.println("" + player3.getPlayerName() +"  WINS THE WHOLE GAME WITH A SCORE OF "+ player3.getGrandTotal());
		} else {
			System.out.println("Tie game!");
		}
	}
	
	public void endGame() {
		Scanner read= new Scanner (System.in);
		int choice;
		//After the game has ended we prompt them to end game or start a new one
		do {
			System.out.println("\nPress 1 to terminate game  \nPress 2 to start a new game");
			choice=read.nextInt();
				if (choice==1) {
					System.out.println("\nGAME HAS BEEN TERMINATED\n");
					break;
				}
				if (choice==2) {
					menu();
				}
				else {
					System.out.println("\nINVALID INPUT\n");
				}
			
		} while (choice!=-1);
	}
}
