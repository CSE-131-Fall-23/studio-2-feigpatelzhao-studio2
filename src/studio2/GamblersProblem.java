package studio2;
import java.lang.Math;
import java.util.Scanner;

public class GamblersProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Balance: ");
		double cash = in.nextDouble();
		System.out.print("Win Chance: ");
		double chance = in.nextDouble();
		chance = chance / 100;
		System.out.print("Upper Limit: ");
		double win = in.nextDouble();
		System.out.print("Lower Limit: ");
		int lose = in.nextInt();
		System.out.print("Number of Days ");
		int days = in.nextInt();
		int sim = 0;
		double rand = 0;
		double winner = 0;
		double balance;
		for (int i = 0; i < days; i++)
		{
			sim = 0;
			balance = cash;
			
			while (balance < win && balance > lose)
			{
				rand = Math.random();
				if (rand > chance)
				{
					
					balance = balance - 1;
					sim++;
				
				}
				else if (rand < chance)
				{
					balance = balance + 1;
					
					sim++;
				}
				else
				{
					balance = balance + 0;
					
					sim++;
				}
			}
			
			if (balance >= win)
			{
				winner++;
				System.out.println("You Win! " + sim);
				
			}
			if (balance <= lose)
			{	
				System.out.println("You Lose! " + sim);
			}
		}
		
		double ruin = 0;
		if (chance == .50)
		{
			ruin = 1 - (cash / win);
		}
		else
		{
			double a = (1 - chance) / (chance);
			ruin = (Math.pow(a, cash) - Math.pow(a, win)) / (1 - Math.pow(a, win));
		}
		System.out.println("expected " + ruin);
		double real = winner / days;
		System.out.println("real " + real);
	}

}
