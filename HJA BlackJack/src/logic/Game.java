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
	
	private boolean ganaJugador;
	
	// CUANTO DINERO HA GANADO EN UNA EJECUCION
	int dineroGanado;
	
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
		dineroGanado = 0;
		// NUMERO RANDOM
		rand = new Random();
		// FUNCION PARA GENERAR MAZOS
		initMazo();
		lJugador = new ArrayList<Card>();
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
	
	
	// CUANTO DINERO QUIERE APOSTAR EL JUGADOR
	// 1ER ESTADO ANTES DE SACAR CARTAS
	// MI IDEA ES PONER EL DINERO, Y CUANDO TERMINAS DARLE A SIGUIENTE PARA
	// PASAR AL SIGUIENTE ESTADO, QUE ES REPARTIR CARTAS AL JUGADOR
	
	

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
		}
		// LAS 2 CARTAS ALEATORIAS SON PARES
		//if(x % 2 == 0 && y % 2 == 0) anyPair = true;
		// LAS 2 CARTAS SUMAN 21 => BJ
		if(sumaJugador == 21) bjJugador = true;
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
			lJugador.add(c);
			mazo.remove(num);
		}
		// LAS 2 CARTAS SUMAN 21 => BJ
		if(sumaDealer == 21) bjDealer = true;
		// LAS 2 PRIMERAS CARTAS DEL JUGADOR Y DEALER SON MAYORES QUE 18
		if(sumaDealer > 18 && sumaJugador > 18) hot3 = true;
		
		// QUITARLAS DEL MAZO

	}

	// EL JUGADOR QUIERE 1 CARTA MAS, (HIT)
	// AQUI TE PUEDES PASAR, BUSTJUGADOR Y PIERDES
	public void dameCarta(){
		// CARTA ALEATORIA
		//sumaJugador += cartaAleatoria;
		if (sumaJugador > 21) bustJugador = true;
		

	}

	// EL JUGADOR NO QUIERE MAS CARTAS Y SE PLANTA
	public void plantar(){
		// PASA AL SIGUIENTE ESTADO, NO HACE NADA MAS
	}


	// COGE CARTAS HASTA QUE LLEGAR A 17 O MAS
	// SI SACA MAS DE 21 PIERDE BUSTDEALER
	// SI SU SUMA ES DE 17, 18, 19, 20, 21 NO COGE MAS
	public void dealer(){

		while(sumaDealer < 17){
			// x CARTA ALEATORIA
			//sumaDealer += x;
		}
		
		if(sumaDealer > 21) bustDealer = true;

		// QUIEN GANA?
		// ganaJugador = true;
		// ganaJugador = false;
	}

	/*
	public void recompensas(){
		// DINERO APOSTADO *2
		// EJ: 10 APOSTADOS, GANAS AL DEALER TE DAN 20, TUS 10 Y LOS 10 GANADOS
		if(apuestaNormal > 0 && ganaJugador){
			dineroGanado+=apuestaNormal*2;
		}
		// DINERO APOSTADO *3
		if(apuestaBustIt > 0 && bustDealer){
			dineroGanado+=apuestaBustIt*3;
		}
		// DINERO APOSTADO *4
		if(apuestaAnyPair > 0 && anyPair){
			dineroGanado+=apuestaAnyPair*4;
		}
		// DINERO APOSTADO *3
		if(apuestaHot3 > 0 && hot3){
			dineroGanado+=apuestaHot3*3;
		
		}
		
	}
	*/
	
	public List<Card> getPlayerCards(){
		return lJugador;
	}
	
	public List<Card> getDealerCards(){
		return lDealer;
	}

}
