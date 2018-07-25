
public class Guessing 
{
	public static void main(String[] args)
	{
		//if(args.length==0)
		//{
			//System.out.println("Usage: java Hangman <answer>");
			//System.err.println(" answer is required");
			//System.exit(1);
		//}
		Decoder code = new Decoder ("legendary");
		Prompter prompter = new Prompter(code);
		while (code.getRemainingTries()>0  && !code.isWon())
		{
			prompter.displayMessage();
			prompter.displayProgress();
			prompter.promptForGuess();
		}
		prompter.displayOutcome();
	}
}
