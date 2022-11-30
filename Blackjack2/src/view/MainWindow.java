package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Card;
import logic.Game;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Game game;
	private JPanel tablero;
	
	private List<JLabel> apuestas;
	
	private int modo;
	
	private boolean fin;
	private int estado;
	
	private List<JLabel> playerCards;
	private List<JLabel> dealerCards;	
	
	JButton money1;
	JButton money2;
	JButton money5;
	JButton money25;
	JButton money100;
	
	JButton hitButton;
	JButton standButton;
	
	JLabel balanceDinero;
	
	public MainWindow(Game g) {
		money1 = new JButton("Money1");
		money2 = new JButton("Money2");
		money5 = new JButton("Money5");
		money25 = new JButton("Money25");
		money100 = new JButton("Money100");
		
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		balanceDinero =  new JLabel("Dinero");
		
		game = g;
		initGUI();
	}
	
	private void initGUI()  {
		tablero = new Tablero();
		apuestas = new ArrayList<JLabel>();
		modo = 1;
		
		fin = false;
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
				game.dameCarta();
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
				bustItStrategy();
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
				vegasStrategy();
			}
		});
		VegasStrategyButton.setOpaque(true);
		VegasStrategyButton.setContentAreaFilled(false);
		VegasStrategyButton.setBorderPainted(false);
		VegasStrategyButton.setIcon(loadImage("resources/Strategies/VegasStrategy.png"));
		tablero.add(VegasStrategyButton);
		
		
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
				game.repartirJugador();
				pintarCartasJugador();	//addPlayerCard();			
				monedasNoVisibles();
				estado++;
				
				break;
			case 1: // 2do SACA 2 CARTAS AL DEALER
				game.repartirDealer();
				addDealerCard();
				estado++;
				break;
			case 2: //3ro PREGUNTA QUE QUIERE HACER EL JUGADOR
				// BOTONES DE HIT (PEDIR OTRA CARTA) Y STAND (PARAR)
				modosJugadorVisibles();				
				break;
			case 3:  // TURNO DEL DEALER, COGE CARTAS HASTA QUE SUME 17 O MAS
				modosJugadorNoVisibles();
				game.dealer();	
				estado++;
				break;
			case 4: // RECOMPENSAS FINALES
				game.recompensas();
				reset();
				monedasVisibles();
				//balanceDinero.setText(Double.toString(game.dineroGanado));
				estado = 0; // VUELVE AL INICIO
				break;
			default: 				
			break;
		}
	}
	
	private void reset() {
				
		
		// RESETEAR LAS JLABEL DEL DINERO APOSTADO EN CADA MODO
		for(int i = 0; i<4; i++) {
			apuestas.get(i).setText(Integer.toString(game.apuestasDinero[modo]));
		}
		
		// ELIMINAR LAS CARTAS DEL JUGADOR DEL TABLERO
		for(int i = 0; i < game.lJugador.size(); i++) {
			//JLabel aux = game.getPlayerCards().get(i).toImage();
			tablero.remove(playerCards.get(0));
			//playerCards.remove(i);
		}
		
		// ELIMINAR LAS CARTAS DEL DEALER DEL TABLERO
		for(int i = 0; i < game.lDealer.size(); i++) {
			//JLabel aux = game.getDealerCards().get(i).toImage();
			tablero.remove(dealerCards.get(i));
			dealerCards.remove(i);
		}
		game.reset(); // RESET DE LAS APUESTAS Y VALORES INICIALES
	}
	
	private void pintarCartasJugador() {
		List<Card> board = game.getPlayerCards();
		int posX = 770;
		int i = 0;
		for (Card card : board) {
			JLabel carta = card.toImage();
			playerCards.add(carta);
			tablero.add(playerCards.get(i));
			carta.setBounds(posX, 670, 75, 110);
			posX += 90;
			i++;
		}
		
	}
	
	
	private void addDealerCard() {
		/*JLabel carta = game.getPlayerCards().get(0).toImage();
			
		dealerCards.add(carta);
		carta.setBounds(770, 100, 75, 110);	
		tablero.add(dealerCards.get(0));*/
		
	}

	protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
		
	
	
	
	
	
	
	// ESTRATEGIAS
	
	// APOSTAR A QUE SE PASA EL DEALER, 
	//	 	APOSTAR x Y SI PIERDES APOSTAR EL DOBLE, SI GANAS OTRA VEZ x. ASI n VECES
	private void bustItStrategy() {
		int n = 100;
		int x = 5;
		int aux = x;
		
		for(int j = 0; j < n; j++) {
			game.apuestasDinero[2] = aux;
			
			game.repartirJugador();	
			game.repartirDealer();
			// NINGUNA CARTA AL JUGADOR
			game.dealer();						
			game.recompensas();
			
			System.out.println("Iteracion " + (j+1));
			System.out.print("Jugador: ");
			for(int i =0; i < 2; i++) {
				System.out.print(game.lJugador.get(i).getValue() + " ");
			}
			if (game.bjJugador) System.out.println("BLACKJACK DEL JUGADOR");
			System.out.println();
			System.out.print("Dealer: ");
			for(int i =0; i < game.lDealer.size(); i++) {
				System.out.print(game.lDealer.get(i).getValue() + "("+ game.lDealer.get(i).getNValue() +")"+" ");
			}
			if (game.bjDealer) System.out.println("BLACKJACK DEL DEALER");
			System.out.println();
			System.out.println("DINERO ACTUAL -> " + game.dineroGanado);
			System.out.println("DINERO GASTADO EN ESTA TIRADA -> " + aux);
			System.out.println();
			
			if(!game.bustDealer) aux *= 2;
			else aux = x;
			
			game.reset();
			
			
		}
		
	}
	
	private void vegasStrategy() {
		int n = 100;
		int x = 5;
		//int aux = x;
		
		for(int j = 0; j < n; j++) {
			game.apuestasDinero[1] = x;
			
			game.repartirJugador();	
			game.repartirDealer();
			
			// ESTRATEGIA DE LAS VEGAS (TABLA QUE DICE CUANDO JUGAR)
			if(game.sumaJugador <= 18 && (game.lJugador.get(0).getNValue() == 11 || 
					game.lJugador.get(1).getNValue() == 11)) { // SOFT PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			else if(game.sumaJugador <= 11) { // HARD PAIR
				while(game.sumaJugador <= 11) {
					game.dameCarta();
				}
			}
			 			
			
			game.dealer();						
			game.recompensas();			
			
			System.out.println("Iteracion " + (j+1));
			System.out.print("Jugador: ");
			for(int i =0; i < game.lJugador.size(); i++) {
				System.out.print(game.lJugador.get(i).getValue() + " ");
			}
			if (game.bjJugador) System.out.println("BLACKJACK DEL JUGADOR");
			System.out.println();
			System.out.print("Dealer: ");
			for(int i =0; i < game.lDealer.size(); i++) {
				System.out.print(game.lDealer.get(i).getValue() + "("+ game.lDealer.get(i).getNValue() +")"+" ");
			}
			if (game.bjDealer) System.out.println("BLACKJACK DEL DEALER");
			System.out.println();
			System.out.println("DINERO ACTUAL -> " + game.dineroGanado);
			System.out.println();
			
			game.reset();
			
			
		}
		
	}
	
	
	
	// PEDIR CARTA SI LA SUMA DEL JUGADOR ES <= 11
	
	
	
	
	

}