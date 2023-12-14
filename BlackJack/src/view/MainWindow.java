package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import logic.Card;
import logic.Game;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Game game;
	private JPanel tablero;
	
	private List<JLabel> apuestas;
	
	private int modo;	
	private int estado;
	
	private List<JLabel> playerCards;
	private List<JLabel> dealerCards;	
	
	private int xJugador;
	private int iJugador;
	
	JButton money1;
	JButton money2;
	JButton money5;
	JButton money25;
	JButton money100;
	
	JButton hitButton;
	JButton standButton;
	
	JLabel balanceDinero;
	
	JLabel cartaReversa;
	
	public MainWindow(Game g) {
		money1 = new JButton("Money1");
		money2 = new JButton("Money2");
		money5 = new JButton("Money5");
		money25 = new JButton("Money25");
		money100 = new JButton("Money100");
		
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		balanceDinero =  new JLabel("Dinero");
		
		xJugador = 950;
		iJugador = 2;
		
		game = g;
		initGUI();
	}
	
	private void initGUI()  {
		tablero = new Tablero();
		apuestas = new ArrayList<JLabel>();
		modo = 1;
		
		estado = 0;
		
		playerCards = new ArrayList<JLabel>();
		dealerCards = new ArrayList<JLabel>();
		
		// BOTON DE SIGUIENTE
		JButton siguiente = new JButton("Siguiente");
		siguiente.setBounds(50, 40, 90, 30);
		siguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jugarGUI();				
			}
		});
		tablero.add(siguiente);
		
		
		// BOTON HT3
		JButton HT3 = new JButton("HT3");
		HT3.setBounds(625, 850, 90, 64);
		HT3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modo = 0;
			}
		});
		HT3.setOpaque(true);
		HT3.setContentAreaFilled(false);
		HT3.setBorderPainted(false);
		HT3.setIcon(loadImage("resources/Games/HT3.png"));
		tablero.add(HT3);
		
		
		JLabel HT3Dinero = new JLabel();
		HT3Dinero.setFont(new Font("Arial", Font.PLAIN, 25));
		HT3Dinero.setForeground(Color.white);
		HT3Dinero.setBounds(660, 770, 120, 100);
		apuestas.add(HT3Dinero);
		tablero.add(HT3Dinero);
		
		// BOTON DE NORMAL
		JButton normal = new JButton("Normal");
		normal.setBounds(735, 850, 90, 64);
		normal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modo = 1;
			}
		});;
		normal.setOpaque(true);
		normal.setContentAreaFilled(false);
		normal.setBorderPainted(false);
		normal.setIcon(loadImage("resources/Games/Normal.png"));
		tablero.add(normal);
		
		
		JLabel normalDinero = new JLabel();
		normalDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		normalDinero.setForeground(Color.white);
		normalDinero.setBounds(760, 770, 120, 100);
		apuestas.add(normalDinero);
		tablero.add(normalDinero);
		
		// BOTON BUST-IT
		JButton bustIt = new JButton("BustIt");
		bustIt.setBounds(845, 850, 90, 64);
		bustIt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modo = 2;
			}
		});
		bustIt.setOpaque(true);
		bustIt.setContentAreaFilled(false);
		bustIt.setBorderPainted(false);
		bustIt.setIcon(loadImage("resources/Games/BustIt.png"));
		tablero.add(bustIt);
	
		
		JLabel bustItDinero = new JLabel();
		bustItDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		bustItDinero.setForeground(Color.white);
		bustItDinero.setBounds(870, 770, 120, 100);
		apuestas.add(bustItDinero);
		tablero.add(bustItDinero);
		
		// BOTON ANYPAIR
		JButton anyPair = new JButton("AnyPair");
		anyPair.setBounds(955, 850, 90, 64);
		anyPair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modo = 3;
			}
		});
		anyPair.setOpaque(true);
		anyPair.setContentAreaFilled(false);
		anyPair.setBorderPainted(false);
		anyPair.setIcon(loadImage("resources/Games/AnyPair.png"));
		tablero.add(anyPair);
	
		
		JLabel anyPairDinero = new JLabel();
		anyPairDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		anyPairDinero.setForeground(Color.white);
		anyPairDinero.setBounds(980, 770, 120, 100);
		apuestas.add(anyPairDinero);
		tablero.add(anyPairDinero);
		
		// DIBUJAR APUESTAS
		
		for (int i = 0; i < 4; i++) {
			apuestas.get(i).setText(Integer.toString(game.apuestasDinero[i]));
		}
		
		// FICHAS (MONEDAS)
		// FICHA 1
		//JButton money1 = new JButton("Money1");
		money1.setBounds(20, 850, 90, 64);
		money1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasDinero[modo] += 1;
				apuestas.get(modo).setText(Integer.toString(game.apuestasDinero[modo]));
			}
		});
		money1.setOpaque(true);
		money1.setContentAreaFilled(false);
		money1.setBorderPainted(false);
		money1.setIcon(loadImage("resources/Money/1_money.png"));
		tablero.add(money1);
	
		
		
		
		// FICHA 2
		//JButton money2 = new JButton("Money2");
		money2.setBounds(120, 850, 90, 64);
		money2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasDinero[modo] += 2;
				apuestas.get(modo).setText(Integer.toString(game.apuestasDinero[modo]));
			}
		});
		money2.setOpaque(true);
		money2.setContentAreaFilled(false);
		money2.setBorderPainted(false);
		money2.setIcon(loadImage("resources/Money/2_money.png"));
		tablero.add(money2);
		
		
		
		// FICHA 5
		//JButton money5 = new JButton("Money5");
		money5.setBounds(220, 850, 90, 64);
		money5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasDinero[modo] += 5;
				apuestas.get(modo).setText(Integer.toString(game.apuestasDinero[modo]));
			}
		});
		money5.setOpaque(true);
		money5.setContentAreaFilled(false);
		money5.setBorderPainted(false);
		money5.setIcon(loadImage("resources/Money/5_money.png"));
		tablero.add(money5);

		
		
		// FICHA 25
		//JButton money25 = new JButton("Money25");
		money25.setBounds(320, 850, 90, 64);
		money25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasDinero[modo] += 25;
				apuestas.get(modo).setText(Integer.toString(game.apuestasDinero[modo]));
			}
		});
		money25.setOpaque(true);
		money25.setContentAreaFilled(false);
		money25.setBorderPainted(false);
		money25.setIcon(loadImage("resources/Money/25_money.png"));
		tablero.add(money25);
		
		
		
		// FICHA 100
		//JButton money100 = new JButton("Money100");
		money100.setBounds(420, 850, 90, 64);
		money100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasDinero[modo] += 100;
				apuestas.get(modo).setText(Integer.toString(game.apuestasDinero[modo]));
			}
		});
		money100.setOpaque(true);
		money100.setContentAreaFilled(false);
		money100.setBorderPainted(false);
		money100.setIcon(loadImage("resources/Money/100_money.png"));
		tablero.add(money100);
		
		
		
		
		//JButton hitButton = new JButton("Hit");
		hitButton.setBounds(1050, 850, 123, 35);
		hitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(game.sumaJugador< 21) {
					game.dameCarta();
					pintaCartasExtraJugador();
				}
				else {
					estado++;
					jugarGUI();	
				}
				
				
			}
		});
		hitButton.setOpaque(true);
		hitButton.setContentAreaFilled(false);
		hitButton.setBorderPainted(false);
		hitButton.setIcon(loadImage("resources/Games/Hit_Button.png"));
		tablero.add(hitButton);
		hitButton.setVisible(false);
		
		
		//JButton standButton = new JButton("Stand");
		standButton.setBounds(1050, 888, 123, 35);
		standButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado++;
				jugarGUI();	
			}
		});
		standButton.setOpaque(true);
		standButton.setContentAreaFilled(false);
		standButton.setBorderPainted(false);
		standButton.setIcon(loadImage("resources/Games/Stand_Button.png"));
		tablero.add(standButton);
		standButton.setVisible(false);
			
		JLabel balance = new JLabel("Balance");
		balance.setText("Balance: ");
		balance.setFont(new Font("Arial", Font.PLAIN, 25));
		balance.setForeground(Color.white);
		balance.setBounds(20, 900, 120, 100);		
		tablero.add(balance);
		
		//JLabel balanceDinero = new JLabel("Dinero");
		balanceDinero.setText(Double.toString(game.dineroGanado));
		balanceDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		balanceDinero.setForeground(Color.white);
		balanceDinero.setBounds(140, 900, 120, 100);		
		tablero.add(balanceDinero);
		
		
		// ESTRATEGIAS
		JButton BustItStrategyButton = new JButton("BustItStrategy");
		BustItStrategyButton.setBounds(1250, 850, 65, 43);
		BustItStrategyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//bustItStrategy();
				bustItClass();
			}
		});
		BustItStrategyButton.setOpaque(true);
		BustItStrategyButton.setContentAreaFilled(false);
		BustItStrategyButton.setBorderPainted(false);
		BustItStrategyButton.setIcon(loadImage("resources/Strategies/BustItStrategy.png"));
		tablero.add(BustItStrategyButton);
		
		JButton VegasStrategyButton = new JButton("BustItStrategy");
		VegasStrategyButton.setBounds(1330, 850, 85, 53);
		VegasStrategyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vegas1Class();
			}
		});
		VegasStrategyButton.setOpaque(true);
		VegasStrategyButton.setContentAreaFilled(false);
		VegasStrategyButton.setBorderPainted(false);
		VegasStrategyButton.setIcon(loadImage("resources/Strategies/VegasStrategy.png"));
		tablero.add(VegasStrategyButton);
		
		JButton Vegas2StrategyButton = new JButton("BustItStrategy");
		Vegas2StrategyButton.setBounds(1420, 850, 85, 53);
		Vegas2StrategyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vegas2Class();
			}
		});
		Vegas2StrategyButton.setOpaque(true);
		Vegas2StrategyButton.setContentAreaFilled(false);
		Vegas2StrategyButton.setBorderPainted(false);
		Vegas2StrategyButton.setIcon(loadImage("resources/Strategies/VegasStrategy.png"));
		tablero.add(Vegas2StrategyButton);
		
		
		JButton RandomStrategyButton = new JButton("RandomStrategy");
		RandomStrategyButton.setBounds(1510, 850, 70, 60);
		RandomStrategyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				RandomClass();
			}
		});
		RandomStrategyButton.setOpaque(true);
		RandomStrategyButton.setContentAreaFilled(false);
		RandomStrategyButton.setBorderPainted(false);
		RandomStrategyButton.setIcon(loadImage("resources/Strategies/RandomStrategy.png"));
		tablero.add(RandomStrategyButton);
		
		
		add(tablero);
		setSize(1713,1013); 
		setVisible(true);
	}
	
	private void monedasNoVisibles() {
		money1.setVisible(false);
		money2.setVisible(false);
		money5.setVisible(false);
		money25.setVisible(false);
		money100.setVisible(false);
	}
	
	private void monedasVisibles() {
		money1.setVisible(true);
		money2.setVisible(true);
		money5.setVisible(true);
		money25.setVisible(true);
		money100.setVisible(true);
	}
	
	private void modosJugadorNoVisibles() {
		hitButton.setVisible(false);
		standButton.setVisible(false);
	}
	
	private void modosJugadorVisibles() {
		hitButton.setVisible(true);
		standButton.setVisible(true);
	}
	
	
	
	private void jugarGUI() {
		switch(estado) {			
			case 0: // 1ro SACA 2 CARTAS AL JUGADOR
				game.dinero();
				if(game.dineroGastado > 0) {
					game.repartirJugador();
					pintarCartasJugador();	//addPlayerCard();			
					monedasNoVisibles();
					estado++;		
				}
						
				break;
			case 1: // 2do SACA 2 CARTAS AL DEALER
				game.repartirDealer();
				pintarCartasDealer();
				estado++;
				modosJugadorVisibles();	
				break;
			case 2: //3ro PREGUNTA QUE QUIERE HACER EL JUGADOR
				// BOTONES DE HIT (PEDIR OTRA CARTA) Y STAND (PARAR)
							
				break;
			case 3:  // TURNO DEL DEALER, COGE CARTAS HASTA QUE SUME 17 O MAS
				modosJugadorNoVisibles();
				game.dealer();	
				pintarDemasCartasDealer();
				estado++;
				break;
			case 4: // RECOMPENSAS FINALES
				game.recompensas();
				reset();
				monedasVisibles();
				balanceDinero.setText(Double.toString(game.dineroGanado));
				estado = 0; // VUELVE AL INICIO
				break;
			default: 				
			break;
		}
	}
	
	private void reset() {	
		// ELIMINAR LAS CARTAS DEL JUGADOR DEL TABLERO
		int tam = playerCards.size();
		for(int i = 0; i < tam; i++) {	
			tablero.remove(playerCards.get(0));
			playerCards.remove(0);
			//JLabel aux = game.getPlayerCards().get(0).toImage();
			//tablero.remove(aux);
		}
		
		// ELIMINAR LAS CARTAS DEL DEALER DEL TABLERO
		tam = dealerCards.size();
		for(int i = 0; i < game.lDealer.size()+1; i++) {
			tablero.remove(dealerCards.get(0));
			dealerCards.remove(0);
			
		}
		repaint();
		game.reset(); // RESET DE LAS APUESTAS Y VALORES INICIALES	
		// RESETEAR LAS JLABEL DEL DINERO APOSTADO EN CADA MODO
		for(int i = 0; i<4; i++) {
			apuestas.get(i).setText(Integer.toString(game.apuestasDinero[modo]));
		}
		
		xJugador = 950;
		iJugador = 2;
	}
	
	private void pintarCartasJugador() {
		List<Card> board = game.getPlayerCards();
		int posX = 770;
		int i = 0;
		for (Card card : board) {
			playerCards.add(card.toImage());
			tablero.add(playerCards.get(i));	
			playerCards.get(i).setBounds(posX, 670, 75, 110);					
			posX += 90;
			i++;
		}
		
	}
	
	
	private void pintarCartasDealer() {		
		dealerCards.add(game.getDealerCards().get(0).toImage());
		tablero.add(dealerCards.get(0));			
		dealerCards.get(0).setBounds(770, 50, 75, 110);				
		
		cartaReversa = new JLabel(new ImageIcon("resources/Cards/reverse_card.png"));
		tablero.add(cartaReversa);			
		cartaReversa.setBounds(850, 50, 75, 114);		
	}
	
	private void pintarDemasCartasDealer() {		
		tablero.remove(cartaReversa);	
		int posX = 850;
		int i = 1;
		
		List<Card> board = game.getDealerCards();
		board.remove(0);
		
		for (Card card : board) {
			dealerCards.add(card.toImage());
			tablero.add(dealerCards.get(i));	
			dealerCards.get(i).setBounds(posX, 50, 75, 110);					
			posX += 80;
			i++;
		}			
	}
	
	private void pintaCartasExtraJugador(){		
		playerCards.add(game.getPlayerCards().get(iJugador).toImage());
		tablero.add(playerCards.get(iJugador));
		playerCards.get(iJugador).setBounds(xJugador, 670, 75, 110);	
		
		xJugador += 90;
		iJugador++;		
		if(game.sumaJugador >= 21) {
			estado++;
			jugarGUI();
		}
			
	}
	

	protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
	
	
	// ESTRATEGIAS
	
	// APOSTAR A QUE SE PASA EL DEALER, 
	//	 	APOSTAR x Y SI PIERDES APOSTAR EL DOBLE, SI GANAS OTRA VEZ x. ASI n VECES	
	private void bustItStrategyLimited(double cartera, int reps, double bet) {
		int n = reps;
		double aux = bet;
		
		double dinero = cartera;		
		int j = 0;		
		while(j < n && dinero > 0) {	
			game.apuestasDinero[2] =  (int) aux;
			
			game.dinero();
			game.repartirJugador();	
			game.repartirDealer();
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			int dineroGanado = (int) game.dineroGanadoIt;
			dinero += dineroGanado;
			dinero -= aux;
			
			imprimirDatos(j, dinero, aux);
			
			if(!game.bustDealer) aux *= 2;
			else aux = bet;
			
			if(aux > dinero) aux = dinero;
			
			game.reset();
			game.dineroMaximo = Math.max(game.dineroMaximo, dinero);
			j++;
		}
		double porcentaje = (dinero/cartera)*100;
		porcentaje = porcentaje-100;
		
		System.out.println("Dinero actual: " + dinero);
		System.out.println("Maximo dinero conseguido: " + game.dineroMaximo);
		System.out.println("Porcentaje de perdidas/ganacias: "+ Math.round(porcentaje*100.0)/100.0 + "%");
	}
	
	private void vegasStrategy(double cartera, int reps) {
		int n = reps;
		int x = 5;
		double aux = x;
		
		game.dineroMaximo = cartera;		
		double dinero = cartera;		
		int j = 0;		
		while(j < n && dinero > 0) {	
			game.apuestasDinero[1] = x;
			game.dinero();
			
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
			int dineroGanado = (int) game.dineroGanadoIt;
			dinero += dineroGanado;
			dinero -= aux;
										
			imprimirDatos(j, dinero, aux);
						
			if(aux > dinero) aux = (int) dinero;
			
			game.reset();
			game.dineroMaximo = Math.max(game.dineroMaximo, dinero);
			j++;
		}
		double porcentaje = (dinero/cartera)*100;
		porcentaje = porcentaje-100;
		
		System.out.println("Dinero actual: " + dinero);
		System.out.println("Maximo dinero conseguido: " + game.dineroMaximo);
		System.out.println("Porcentaje de perdidas/ganacias: "+ Math.round(porcentaje*100.0)/100.0 + "%");
		
	}	
	
	
	private void vegas2Strategy(double cartera, int reps) {
		int n = reps;
		
		game.dineroMaximo = cartera;		
		double dinero = cartera;		
		int j = 0;		
		while(j < n && dinero > 12) {	
			game.apuestasDinero[0] = 2;			
			game.apuestasDinero[1] = 6;
			game.apuestasDinero[2] = 3;
			game.apuestasDinero[3] = 1;
			game.dinero();
			
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
			int dineroGanado = (int) game.dineroGanadoIt;
			dinero += dineroGanado;
			dinero -= 12;					
				
			imprimirDatos(j, dinero, 12);	
			
			game.reset();
			game.dineroMaximo = Math.max(game.dineroMaximo, dinero);
			j++;
		}
		double porcentaje = (dinero/cartera)*100;
		porcentaje = porcentaje-100;
		
		System.out.println("Dinero actual: " + dinero);
		System.out.println("Maximo dinero conseguido: " + game.dineroMaximo);
		System.out.println("Porcentaje de perdidas/ganacias: "+ Math.round(porcentaje*100.0)/100.0 + "%");
		
	}		
	
	
	private void RandomStrategy(double cartera, int reps, int interval, 
			boolean Hot3, boolean Normal, boolean BustIt, boolean AnyPair) {
		
		int n = reps;		
		game.dineroMaximo = cartera;		
		double dinero = cartera;		
		int j = 0;		
		while(j < n && dinero > 0) {	
			Random rand = new Random();
			int randomNum = 0;
			
			if(Hot3) {
 				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasDinero[0] = randomNum;			
			}
			if(Normal) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasDinero[1] = randomNum;
			}
			if(BustIt) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasDinero[2] = randomNum;
			}
			if(AnyPair) {
				randomNum = rand.nextInt((interval - 1) + 1) + 1;
				game.apuestasDinero[3] = randomNum;
			}
			game.dinero();
			
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
			int dineroGanado = (int) game.dineroGanadoIt;
			dinero += dineroGanado;
			dinero -= randomNum;								
						
			imprimirDatos(j, dinero, randomNum);
			
			game.reset();
			game.dineroMaximo = Math.max(game.dineroMaximo, dinero);
			j++;
		}
		double porcentaje = (dinero/cartera)*100;
		porcentaje = porcentaje-100;
		
		System.out.println("Dinero actual: " + dinero);
		System.out.println("Maximo dinero conseguido: " + game.dineroMaximo);
		System.out.println("Porcentaje de perdidas/ganacias: "+ Math.round(porcentaje*100.0)/100.0 + "%");
		
	}
	
	void imprimirDatos(int it, double dineroActual, double dineroApostado) {
		
		System.out.println("Iteracion " + (it+1));
		System.out.print("Jugador: ");
		for(int i = 0; i < game.lJugador.size(); i++) {
			System.out.print(game.lJugador.get(i).getValue() + "("+ game.lJugador.get(i).getNValue() +")"+" ");
		}
		if (game.bjJugador) System.out.print(" BLACKJACK DEL JUGADOR");
		System.out.println();
		System.out.print("Dealer: ");
		for(int i = 0; i < game.lDealer.size(); i++) {
			System.out.print(game.lDealer.get(i).getValue() + "("+ game.lDealer.get(i).getNValue() +")"+" ");
		}
		if (game.bjDealer) System.out.print(" BLACKJACK DEL DEALER");
		System.out.println();
		System.out.println("DINERO ACTUAL -> " + dineroActual);
		System.out.println("DINERO GASTADO EN ESTA TIRADA -> " + dineroApostado);
		if(game.bustDealer || (game.bjJugador && !game.bjDealer) || game.ganaJugador) {
			System.out.println("GANA EL JUGADOR");
		}
		else if(game.bustJugador|| (!game.bjJugador && game.bjDealer) || !game.ganaJugador) {
			System.out.println("GANA EL DEALER");
		}
		else System.out.println("EMPATE");
		System.out.println();
	}
	
	public void bustItClass() {				
		BustItStrategyClassDialog BustItDialog = new BustItStrategyClassDialog((this));						
		int estado = BustItDialog.open();		
		int dinero = 0, reps = 0, bet = 0;
		
		
		if (estado == 1) {			
			dinero = BustItDialog.getMoney();
			reps = BustItDialog.getReps();
			bet = BustItDialog.getBet(); 
			
			try {						
				 if (dinero >= 1) {
					 bustItStrategyLimited(dinero,reps, bet);
				 } else {
					 JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
								"Negative money...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				 }
			 
			} catch (Exception e) {
				JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
						"Something went wrong ...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				
			}			
			
		} 
	}
	
	public void vegas1Class() {				
		VegasStrategy1ClassDialog VegasDialog = new VegasStrategy1ClassDialog((this));						
		int estado = VegasDialog.open();		
		int dinero = 0;
		int reps = 0;
		
		if (estado == 1) {			
			dinero = VegasDialog.getMoney();
			reps = VegasDialog.getReps();
			
			try {						
				 if (dinero >= 1) {
					 vegasStrategy(dinero, reps);
				 } else {
					 JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
								"Negative money...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				 }
			 
			} catch (Exception e) {
				JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
						"Something went wrong ...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				
			}			
			
		} 
	}
	
	public void vegas2Class() {				
		VegasStrategy1ClassDialog VegasDialog = new VegasStrategy1ClassDialog((this));						
		int estado = VegasDialog.open();		
		int dinero = 0;
		int reps = 0;
		
		if (estado == 1) {			
			dinero = VegasDialog.getMoney();
			reps = VegasDialog.getReps();
			
			try {						
				 if (dinero >= 1) {
					 vegas2Strategy(dinero, reps);
				 } else {
					 JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
								"Negative money...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				 }
			 
			} catch (Exception e) {
				JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
						"Something went wrong ...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				
			}			
			
		} 
	}
	
	public void RandomClass() {				
		RandomStrategyClassDialog RandomDialog = new RandomStrategyClassDialog((this));						
		int estado = RandomDialog.open();		
		int dinero = 0;	
		int reps = 0;
		int interval = 0;
		boolean Hot3, Normal, BustIt, AnyPair;
		
		
		if (estado == 1) {			
			dinero = RandomDialog.getMoney();
			reps = RandomDialog.getReps();
			interval = RandomDialog.getinterval();
			
			Hot3 = RandomDialog.getHot3();
			Normal = RandomDialog.getNormal();
			BustIt = RandomDialog.getBustIt();
			AnyPair = RandomDialog.getAnyPair();
			
			try {						
				 if (dinero >= 1) {
					 RandomStrategy(dinero, reps, interval, Hot3, Normal, BustIt, AnyPair);
				 } else {
					 JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
								"Negative money...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				 }
			 
			} catch (Exception e) {
				JOptionPane.showMessageDialog((Frame) SwingUtilities.getWindowAncestor(this), 
						"Something went wrong ...",	"ERROR", JOptionPane.ERROR_MESSAGE);
				
			}			
			
		} 
	}
	
	

}