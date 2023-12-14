package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Game {
	
	private static final String cardValue[] = {"2","3","4","5","6","7","8","9","10","jack","queen", "king","ace"};
	private static final String cardSuit[] = {"clubs", "diamonds","hearts", "spades"};
	
	// LISTA DE CARTAS, EN BLACKJACK SON 4 MAZOS, 208 CARTAS
	public List<Card> mazo;
	public List<Card> lMazos;
	
	// CARTAS DE JUGADOR, DEALER
	public List<Card> lJugador;
	public List<Card> lDealer;
	
	// SUMA DE LOS VALORES DE LAS CARTAS
	public int sumaDealer;
	public int sumaJugador;

	// ESTADO DE LA EJECUCION 
	public int estado;
	
	// NUMERO RANDOM PARA ESCOGER UNA CARTA ALEATORIA
	public Random rand;

	// BOOLEANO PARA SABER SI ALGUNO SE HA PASADO DE 21
	public boolean bustJugador;	
	public boolean bustDealer;
	
	public int premioJugador;
	public boolean anyPair;
	public boolean hot3;

	// BOOLEANO PARA MARCAR SI HAY BLACKJACK PARA CADA JUGADOR
	// 2 PRIMERAS CARTAS SUMAN 21
	public boolean bjJugador;
	public boolean bjDealer;
	
	// BOLEANO PARA TERMINAR LA EJECUCION
	public boolean fin;	
	
	public boolean ganaJugador;
	public boolean empate;
	
	public int[] apuestasMoney = {0, 0, 0, 0};
	
	// CUANTO money HA GANADO EN UNA EJECUCION
	public double moneyGanado;
	public double moneyGanadoIt;
	public double moneyGastado;
	
	public double moneyMaximo;
	
	private boolean aceJugador;
	private boolean aceDealer;
		
	public Game() {
		// SUMA DE CARTAS DEL JUGADOR Y DEALER
		sumaDealer = 0;
		sumaJugador = 0;
		
		bustJugador = false;
		// MODOS 
		bustDealer = false;
		anyPair = false;
		hot3 = false;
		
		// BLACK JACK
		bjJugador = false;
		bjDealer = false;
		
		// SE ACABA LA EJECUCION
		fin = false;
		
		ganaJugador = false;
		// CUANTO GANA 		
		moneyGanado = 0;
		moneyGastado = 0;
		moneyGanadoIt = 0;
		moneyMaximo = 0;
		
		aceJugador = false;
		aceDealer = false;
		
		// NUMERO RANDOM
		rand = new Random();
		// FUNCION PARA GENERAR MAZOS
		initMazo();
		lJugador = new ArrayList<Card>();
		lDealer = new ArrayList<Card>();
		lMazos = new ArrayList<Card>();
	}
	
	// FUNCION QUE JUNTA 4 MAZOS EN UNO 
	public void initMazo(){
		mazo = new LinkedList<Card>();
		for (int r = 0; r < 4; r++)
			for (int s = 0; s < 4; s++)
				for (int c = 0; c < 13; c++)
					mazo.add(new Card(cardValue[c],cardSuit[s],c+2));		
	}

	// REPARTE 2 CARTAS AL JUGADOR
	// SE MIRA SI HAY BLACKJACK, (21, A VALE 11)
	// SE MIRA SI HAY PAREJA EN LAS 2 PRIMERAS CARTAS (QUE SON LAS QUE SE REPARTEN EN ESTA FUNCION)
	// SE MIRA SI SACA >= 19 PARA EL MODO HOT3
	public void repartirJugador(){
		// 2 CARTAS ALEATORIAS DEL MAZO x, y
		for (int i = 0; i < 2; i++) {			
			int num = rand.nextInt(mazo.size());
			Card c = mazo.get(num); //Repartimos la primera carta
			lJugador.add(c);
			mazo.remove(num);
			sumaJugador += c.getNValue();
			
			if(lJugador.get(i).getNValue() == 11) {
				aceJugador = true;
			}
		}
		// LAS 2 CARTAS ALEATORIAS SON PARES
		if(lJugador.get(0).getNValue() % 2 == 0 && lJugador.get(1).getNValue() % 2 == 0) 
			anyPair = true;
		// LAS 2 CARTAS SUMAN 21 => BJ
		if(sumaJugador == 21) bjJugador = true;
		else if(sumaJugador == 22) { // 2 ACES
			aceJugador = true;
			sumaJugador = 12;
		}
		// QUITARLAS DEL MAZO

	}

	// REPARTE 2 CARTAS AL DEALER
	// SE MIRA SI HAY HAY BLACKJACK
	// MIRA SI SACA >= 19 PARA EL MODO HOT3
	public void repartirDealer(){
		// 2 CARTAS ALEATORIAS DEL MAZO
		for (int i = 0; i < 2; i++) {
			int num = rand.nextInt(mazo.size());
			Card c = mazo.get(num); //Repartimos la primera carta
			lDealer.add(c);
			mazo.remove(num);
			sumaDealer += c.getNValue();
			
			if(lDealer.get(i).getNValue() == 11) {
				aceDealer = true;
			}
		}
		// LAS 2 CARTAS SUMAN 21 => BJ
		if(sumaDealer == 21) bjDealer = true;
		else if(sumaDealer == 22) { // 2 ACES
			aceDealer = true;
			sumaDealer = 12;
		}
		// LAS 2 PRIMERAS CARTAS DEL JUGADOR Y DEALER SON MAYORES QUE 18
		if(sumaDealer > 18 && sumaJugador > 18) hot3 = true;
	}

	
	// EL JUGADOR QUIERE 1 CARTA MAS, (HIT)
	// AQUI TE PUEDES PASAR, BUSTJUGADOR Y PIERDES
	public void dameCarta(){
		// CARTA ALEATORIA
		int num = rand.nextInt(mazo.size());
		Card c = mazo.get(num); 
		lJugador.add(c);
		mazo.remove(num);
		sumaJugador += c.getNValue();	
		//if(c.getNValue() == 11) aceJugador = true;
		
		if(sumaJugador > 21) {
			if(aceJugador) {
				aceJugador = false;
				sumaJugador -= 10;
			}
			else bustJugador = true;	
			
			if(c.getNValue() == 11) {			
				if(sumaJugador > 21) sumaJugador -= 10;						
				else aceJugador = true;
				
				bustJugador = false;
			}
		}
	}
	
	


	// COGE CARTAS HASTA QUE LLEGAR A 17 O MAS
	// SI SACA MAS DE 21 PIERDE BUSTDEALER
	// SI SU SUMA ES DE 17, 18, 19, 20, 21 NO COGE MAS
	public void dealer(){
		
		while(sumaDealer < 17){
			int num = rand.nextInt(mazo.size());
			Card c = mazo.get(num); //Repartimos la primera carta
			lDealer.add(c);
			mazo.remove(num);
			sumaDealer += c.getNValue();
			if(c.getNValue() == 11) aceDealer = true;
			
			if(sumaDealer > 21) {
				if(aceDealer) {
					int aux = 0;
					for (Card carta : lDealer) {
						if(carta.getNValue() == 11) {
							if(aux == 0) carta.setNValue(1);
							aux++;
						}
					}
					
					if(aux > 1) aceDealer = true;
					else aceDealer= false;
					
					sumaDealer -= 10;									
				}
				else bustDealer = true;	
			}
			
		}
		
		
		
		

		// QUIEN GANA?
		if (sumaDealer > sumaJugador) ganaJugador = false; // GANA DEALER
		else if(sumaDealer < sumaJugador) ganaJugador = true; // GANA JUGADOR
		else {
			if(bjJugador && !bjDealer) ganaJugador = true; // EMPATAN A PUNTOS PERO GANA JUGADOR
			else if(!bjJugador && bjDealer) ganaJugador = false; // EMPATAN A PUNTOS PERO GANA DEALER
			else empate = true; // EMPATA			
		}
	}
	
	public void reset() {
		lJugador.clear();
		lDealer.clear();
		
		sumaDealer = 0;
		sumaJugador = 0;		
		bustJugador = false;
		bustDealer = false;
		anyPair = false;
		hot3 = false;
		bjJugador = false;
		bjDealer = false;
		fin = false;		
		ganaJugador = false;
		moneyGastado = 0;
		moneyGanadoIt = 0;
		empate = false;
		aceDealer = false;
		aceJugador = false;
		
		if(lMazos.size() <= 5) {
			lMazos.clear();
			initMazo();
		}
		
		for(int i = 0; i < 4; i++) {
			apuestasMoney[i] = 0;
		}
		
	}	

	public void money() {
		for(int i = 0; i < 4;i++) {
			moneyGastado += apuestasMoney[i];
		}
	}
	
	public void recompensas(){
		
		//money();
		
		// NORMAL: *2 (X2.5 BLACKJACK)		
		if(apuestasMoney[1] > 0 && (ganaJugador || empate || bustDealer)){
			double aux = 2;
			if(bjJugador) aux = 2.5;			
			if(empate) aux = 1;
			moneyGanadoIt+=apuestasMoney[1]*aux;
		}
		// BUST-IT: *AUX
		if(apuestasMoney[2] > 0 && bustDealer){
			int aux = 2;
			if(lDealer.size() == 4) aux = 3;
			else if(lDealer.size() == 5) aux = 9;
			else if(lDealer.size() == 6) aux = 26;
			else if(lDealer.size() == 7) aux = 101;
			moneyGanadoIt+=apuestasMoney[2]*aux;
		}
		// ANY PAIR *7
		if(apuestasMoney[3] > 0 && anyPair){
			moneyGanadoIt+=apuestasMoney[3]*7;
		}
		// HOT-3: *3
		if(apuestasMoney[0] > 0 && hot3){
			moneyGanadoIt+=apuestasMoney[0]*3;		
		}
		
		moneyGanado += moneyGanadoIt;
		moneyGanado -= moneyGastado;
	}
	
	
	public List<Card> getPlayerCards(){
		return lJugador;
	}
	
	public List<Card> getDealerCards(){
		return lDealer;
	}

}