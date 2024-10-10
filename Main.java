import java.util.Random;

public class Main {
	  
	  
	  public static void main(String[] args) {
		  
		  Random rnd = new Random();
		  
		  long total_tries = 100000000; //adjust the tries the program does
		  int bet = 1; // entry cost for each player
		  long percentage = total_tries/100;
		  float avrg_loss;
		  int x;
		  int total_playerwin = 0;
		  long player_money[] = new long[37];
		  for (int p = 0; p < 37; p++) {
			  player_money[p] = 0; // initialize  players
		  }
		  
		  
		  //return if total_tries doesn't match the rules
		  if(total_tries < 100 || total_tries%100 != 0) {
			  System.out.println("Number must above 99 and shouldn't have comma when divided by 100");
			  System.exit(0);
		  }
		  
		  for(long i=0; i < total_tries; i++) {
			  
			  
			  
			  
			  
			  //What to test
			  x = rnd.nextInt(37); //random winner
			  for(int j=0; j < 37; j++) {
				  if(j != x && j != 36) {
				  player_money[j] -= bet; //bet entry cost.. except for person 37 (=bank)
				  }
			  }
			  if(x != 36) {
				  player_money[x] += 35 * bet;
			  }
			  else {
				  player_money[x] += 36 * bet;  
			  }
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  //Check status
			  if(i%percentage == 0) {
				  System.out.println((i/percentage) + "%");
			  }
		  }
		  
		  // check after
		  System.out.println();
		  System.out.println(" Result: (bet was: "+bet+"$)");
		  System.out.println();
		  for(int pl = 0; pl < 37; pl++) {
			  if(pl < 36) {
			  System.out.println(" Player "+(pl+1)+" made "+player_money[pl]+"$");
			  total_playerwin += player_money[pl];
			  
			  } else {  
				  System.out.println();
				  System.out.println(" Bank made: "+player_money[pl]+"$");
			  }
		  }
		  avrg_loss = (float)player_money[36]/(float)total_tries;

		  System.out.println();
		  System.out.println("Average loss of money per round: "+avrg_loss+"$ (Bet amount was "+bet+"$)");
		  System.out.println("All players together (except bank) made: "+total_playerwin+"$");

		 
		  
	  }
}
