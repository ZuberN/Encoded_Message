import java.util.Scanner;

public class Prompter 
{
	private Decoder code;
	private Scanner scanner;
	
	public Prompter (Decoder code)
	{
		this.code=code;
	}
	
	public boolean promptForGuess()
	{
		Scanner scanner = new Scanner(System.in);
		boolean isHit=false;
		boolean isAcceptable=false;
		
		do
		{
			System.out.print("Enter a letter: ");
			String guessInput=scanner.nextLine();
			
			try
			{
				isHit=code.applyGuess(guessInput);
				isAcceptable=true;
			} catch(IllegalArgumentException iae)
			{
				System.out.println(iae.getMessage());
			}
		}while (!isAcceptable);
		return isHit;
	}
	
	public void displayMessage()
	{
		System.out.println("Welcome agent, we have recovered an encoded message that needs to be deciphered!");
		System.out.println("You have 6 attempts to guess the letters that make up the code. Time to get busy!");
		System.out.println("");
	}
	
	public void displayProgress()
	{
		System.out.printf("You have %d tries left to solve: %s %n", code.getRemainingTries(),code.getCurrentProgress());
	}
	
	public void displayOutcome()
	{
		if(code.isWon())
		{
			System.out.printf("Congratulations! You broke the code, %s.", code.getAnswer());
		}else
		{
			System.out.printf("Oh no! The code remains unbroken!");
		}
	}
}


