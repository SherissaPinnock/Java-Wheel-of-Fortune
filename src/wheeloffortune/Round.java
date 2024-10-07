package wheeloffortune;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Round {
	private String category; 
	private String puzzle; 
	private int [] roundTotal; //roundTotal is an array that will have an index of 3
	
	
	//Default Constructor 
	public Round()
	{
		category= "?"; 
		puzzle= "?";
		roundTotal= new int [] {0,0,0};
		
	}
	
	//Primary Constructor 
	public Round(String category, String puzzle, int[] roundTotal)
	{
		this.category= category; 
		this.puzzle= puzzle;
		
		for(int i= 0; i<3; i++)
		{
			this.roundTotal[i]= roundTotal[i]; 
		}
	
	}
	

	//Copy Constructor 
	public Round(Round obj)
	{
		this.category= obj.category; 
		this.puzzle= obj.puzzle;
		this.roundTotal= obj.roundTotal;
	}
	
	 public void getRandomPuzzle() {
		    Random random = new Random();
		    int puzzle_count=10;
			int rand = random.nextInt(puzzle_count);
		    int idx = 0;
		    Scanner read= null;
		    try {
		    	Scanner inFileStream = new Scanner(new File("src/Puzzles.txt"));
		        //Scanner read = new Scanner(file, StandardCharsets.UTF_8);

		        while (inFileStream.hasNextLine()) {
		            category = inFileStream.nextLine();
		            puzzle = inFileStream.nextLine();
		            if (idx == rand) break;
		            idx++;
		        }
		    } catch (FileNotFoundException e) {
		        System.out.println("The file could not be found");
		    } catch(Exception e) {
		        System.out.println("A problem has occurred" + e.getMessage());
		    }
		  }

		  public void displayPuzzle() {
		      System.out.println(
		              "Category: " + category +
		              "\nPuzzle: " + puzzle
		      );
		  }
		  
		  public String getPuzzleForRound() {
			    Random random = new Random();
			    int puzzle_count=10;
				int rand = random.nextInt(puzzle_count);
			    int idx = 0;
			    Scanner read= null;
			    try {
			    	Scanner inFileStream = new Scanner(new File("src/Puzzles.txt"));
			        //Scanner read = new Scanner(file, StandardCharsets.UTF_8);

			        while (inFileStream.hasNextLine()) {
			            category = inFileStream.nextLine();
			            puzzle = inFileStream.nextLine();
			            if (idx == rand) break;
			            idx++;
			        }
			    } catch (FileNotFoundException e) {
			        System.out.println("The file could not be found");
			    } catch(Exception e) {
			        System.out.println("A problem has occurred" + e.getMessage());
			    }
			    return puzzle;
			  }

			 
	//Getters & Setters
	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getPuzzle() 
	{
		return puzzle;
	}

	public void setPuzzle(String puzzle) 
	{
		this.puzzle = puzzle;
	}
	public int[] getRoundTotal()
	{
		return roundTotal; 
	}
	public void setRoundTotal(int[] roundTotal)
	{
		this.roundTotal= roundTotal; 
	}
	
}
