package logic;

import java.util.Random;

public class Strategies {
	
	// TODO explain all the functions
	
	private Game game;
	
	public Strategies(Game game) {
		this.game = game;
	}
	
	// TODO UPDATE
	void printData(int it, double actualMoney, double betMoney) {
		
		System.out.println("Iteration " + (it+1));
		System.out.print("Player: ");
		for(int i = 0; i < game.lJugador.size(); i++) {
			System.out.print(game.lJugador.get(i).getValue() + "("+ game.lJugador.get(i).getNValue() +")"+" ");
		}
		if (game.bjJugador) System.out.print(" PLAYER's BLACKJACK\n");
		System.out.print("Dealer: ");
		for(int i = 0; i < game.lDealer.size(); i++) {
			System.out.print(game.lDealer.get(i).getValue() + "("+ game.lDealer.get(i).getNValue() +")"+" ");
		}
		if (game.bjDealer) System.out.print(" DEALER's BLACKJACK \n");
		System.out.println("ACTUAL MONEY -> " + actualMoney);
		System.out.println("MONEY SPENT ON THIS RUN-> " + betMoney);
		if(game.bustDealer || (game.bjJugador && !game.bjDealer) || game.ganaJugador) {
			System.out.println("PLAYER WINS");
		}
		else if(game.bustJugador|| (!game.bjJugador && game.bjDealer) || !game.ganaJugador) {
			System.out.println("DEALER WINS");
		}
		else System.out.println("DRAW");
		System.out.println("\n");
		
	}
	
	private void printResults(double money, double wallet) {
		double percentage = (money/wallet)*100;
		percentage = percentage-100;
		
		System.out.println("Actual money: " + money + '\n' + 
						   "Maximum money obtained: " + game.moneyMaximo + '\n' + 
						   "Percentages of Profit/Loss: "+ Math.round(percentage*100.0)/100.0 + "%\n");		
	}
	
	// APOSTAR A QUE SE PASA EL DEALER, 
		//	 	APOSTAR x Y SI PIERDES APOSTAR EL DOBLE, SI GANAS OTRA VEZ x. ASI n VECES	
	public void bustItStrategyLimited(double wallet, int reps, double bet) {
		int n = reps;
		double aux = bet;
		
		double money = wallet;		
		int j = 0;		
		while(j < n && money > 0) {	
			game.apuestasMoney[2] =  (int) aux;
			
			game.money();
			game.repartirJugador();	
			game.repartirDealer();
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			int moneyGanado = (int) game.moneyGanadoIt;
			money += moneyGanado;
			money -= aux;
			
			printData(j, money, aux);
			
			if(!game.bustDealer) aux *= 2;
			else aux = bet;
			
			if(aux > money) aux = money;
			
			game.reset();
			game.moneyMaximo = Math.max(game.moneyMaximo, money);
			j++;
		}

		printResults(money, wallet);
	}
	
	public void vegasStrategy(double wallet, int reps) {
		int n = reps;
		int x = 5;
		double aux = x;
		
		game.moneyMaximo = wallet;		
		double money = wallet;		
		int j = 0;		
		while(j < n && money > 0) {	
			game.apuestasMoney[1] = x;
			game.money();
			
			game.repartirJugador();	
			game.repartirDealer();
			
			// ESTRATEGIA DE LAS VEGAS (TABLA QUE DICE CUANDO JUGAR)
			if(game.sumaJugador <= 18 && (game.lJugador.get(0).getValue().equals("ace") || 
					game.lJugador.get(1).getValue().equals("ace"))) { // SOFT PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			else if(game.sumaJugador <= 11) { // HARD PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			int moneyGanado = (int) game.moneyGanadoIt;
			money += moneyGanado;
			money -= aux;
										
			printData(j, money, aux);
						
			if(aux > money) aux = (int) money;
			
			game.reset();
			game.moneyMaximo = Math.max(game.moneyMaximo, money);
			j++;
		}	
		
		printResults(money, wallet);
	}	
	
	public void vegas2Strategy(double wallet, int reps) {
		int n = reps;
		
		game.moneyMaximo = wallet;		
		double money = wallet;		
		int j = 0;		
		while(j < n && money > 12) {	
			game.apuestasMoney[0] = 2;			
			game.apuestasMoney[1] = 6;
			game.apuestasMoney[2] = 3;
			game.apuestasMoney[3] = 1;
			game.money();
			
			game.repartirJugador();	
			game.repartirDealer();
			
			// ESTRATEGIA DE LAS VEGAS (TABLA QUE DICE CUANDO JUGAR)
			if(game.sumaJugador <= 18 && (game.lJugador.get(0).getValue().equals("ace") || 
					game.lJugador.get(1).getValue().equals("ace"))) { // SOFT PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			else if(game.sumaJugador <= 11) { // HARD PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			int moneyGanado = (int) game.moneyGanadoIt;
			money += moneyGanado;
			money -= 12;					
				
			printData(j, money, 12);	
			
			game.reset();
			game.moneyMaximo = Math.max(game.moneyMaximo, money);
			j++;
		}
		
		printResults(money, wallet);		
	}		
	
	public void RandomStrategy(double wallet, int reps, int interval, 
			boolean Hot3, boolean Normal, boolean BustIt, boolean AnyPair) {
		
		int n = reps;		
		game.moneyMaximo = wallet;		
		double money = wallet;		
		int j = 0;		
		while(j < n && money > 0) {	
			Random rand = new Random();
			int randomNum = 0;
			
			if(Hot3) {
 				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasMoney[0] = randomNum;			
			}
			if(Normal) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasMoney[1] = randomNum;
			}
			if(BustIt) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasMoney[2] = randomNum;
			}
			if(AnyPair) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasMoney[3] = randomNum;
			}
			game.money();
			
			game.repartirJugador();	
			game.repartirDealer();
			
			// ESTRATEGIA DE LAS VEGAS (TABLA QUE DICE CUANDO JUGAR)
			if(game.sumaJugador <= 18 && (game.lJugador.get(0).getValue().equals("ace") || 
					game.lJugador.get(1).getValue().equals("ace"))) { // SOFT PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			else if(game.sumaJugador <= 11) { // HARD PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			int moneyGanado = (int) game.moneyGanadoIt;
			money += moneyGanado;
			money -= randomNum;								
						
			printData(j, money, randomNum);
			
			game.reset();
			game.moneyMaximo = Math.max(game.moneyMaximo, money);
			j++;
		}
		
		printResults(money, wallet);		
	}
	
}
