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
	private int[] apuestasDinero = {0, 0, 0, 0, 0, 0};
	private int modo;
	
	private boolean fin;
	private int estado;
	
	private List<JLabel> playerCards;
	private List<JLabel> dealerCards;
	
	public MainWindow(Game g) {
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
				jugar();				
			}
		});
		tablero.add(siguiente);
		add(tablero);
		
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
		add(tablero);
		
		JLabel HT3Dinero = new JLabel();
		HT3Dinero.setFont(new Font("Arial", Font.PLAIN, 25));
		HT3Dinero.setForeground(Color.white);
		HT3Dinero.setBounds(660, 770, 120, 100);
		apuestas.add(HT3Dinero);
		add(HT3Dinero);
		
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
		add(tablero);
		
		JLabel normalDinero = new JLabel();
		normalDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		normalDinero.setForeground(Color.white);
		normalDinero.setBounds(760, 770, 120, 100);
		apuestas.add(normalDinero);
		add(normalDinero);
		
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
		add(tablero);
		
		JLabel bustItDinero = new JLabel();
		bustItDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		bustItDinero.setForeground(Color.white);
		bustItDinero.setBounds(870, 770, 120, 100);
		apuestas.add(bustItDinero);
		add(bustItDinero);
		
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
		add(tablero);
		
		JLabel anyPairDinero = new JLabel();
		anyPairDinero.setFont(new Font("Arial", Font.PLAIN, 25));
		anyPairDinero.setForeground(Color.white);
		anyPairDinero.setBounds(980, 770, 120, 100);
		apuestas.add(anyPairDinero);
		add(anyPairDinero);
		
		// DIBUJAR APUESTAS
		
		for (int i = 0; i < 4; i++) {
			apuestas.get(i).setText(Integer.toString(apuestasDinero[i]));
		}
		
		// FICHAS (MONEDAS)
		// FICHA 1
		JButton money1 = new JButton("Money1");
		money1.setBounds(20, 850, 90, 64);
		money1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apuestasDinero[modo] += 1;
				apuestas.get(modo).setText(Integer.toString(apuestasDinero[modo]));
			}
		});
		money1.setOpaque(true);
		money1.setContentAreaFilled(false);
		money1.setBorderPainted(false);
		money1.setIcon(loadImage("resources/Money/1_money.png"));
		tablero.add(money1);
		add(tablero);
		
		
		
		// FICHA 2
		JButton money2 = new JButton("Money2");
		money2.setBounds(120, 850, 90, 64);
		money2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apuestasDinero[modo] += 2;
				apuestas.get(modo).setText(Integer.toString(apuestasDinero[modo]));
			}
		});
		money2.setOpaque(true);
		money2.setContentAreaFilled(false);
		money2.setBorderPainted(false);
		money2.setIcon(loadImage("resources/Money/2_money.png"));
		tablero.add(money2);
		add(tablero);
		
		
		// FICHA 5
		JButton money5 = new JButton("Money5");
		money5.setBounds(220, 850, 90, 64);
		money5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apuestasDinero[modo] += 5;
				apuestas.get(modo).setText(Integer.toString(apuestasDinero[modo]));
			}
		});
		money5.setOpaque(true);
		money5.setContentAreaFilled(false);
		money5.setBorderPainted(false);
		money5.setIcon(loadImage("resources/Money/5_money.png"));
		tablero.add(money5);
		add(tablero);
		
		
		// FICHA 25
		JButton money25 = new JButton("Money25");
		money25.setBounds(320, 850, 90, 64);
		money25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apuestasDinero[modo] += 25;
				apuestas.get(modo).setText(Integer.toString(apuestasDinero[modo]));
			}
		});
		money25.setOpaque(true);
		money25.setContentAreaFilled(false);
		money25.setBorderPainted(false);
		money25.setIcon(loadImage("resources/Money/25_money.png"));
		tablero.add(money25);
		add(tablero);
		
		
		// FICHA 100
		JButton money100 = new JButton("Money100");
		money100.setBounds(420, 850, 90, 64);
		money100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apuestasDinero[modo] += 100;
				apuestas.get(modo).setText(Integer.toString(apuestasDinero[modo]));
			}
		});
		money100.setOpaque(true);
		money100.setContentAreaFilled(false);
		money100.setBorderPainted(false);
		money100.setIcon(loadImage("resources/Money/100_money.png"));
		tablero.add(money100);
		add(tablero);
		
		setSize(1713,1013); 
		setVisible(true);
	}
	
	private void jugar() {
		switch(estado) {
			case 0: // 1ro SACA 2 CARTAS AL JUGADOR
				game.repartirJugador();
				addPlayerCard();
				addPlayerCard();
				break;
			case 1: // 2do SACA 2 CARTAS AL DEALER
				game.repartirDealer();
				addDealerCard();
				addDealerCard();
				break;
			case 2: //3ro PREGUNTA QUE QUIERE HACER EL JUGADOR
			// CARTA MAS, DIVIDIR SI PUEDE SOLO PUEDE DIVIDIR CON 2 CARTAS PARES, PLANTARSE
				//if(normalButton) dameCarta();			
				//else if(dividirButton() && lJugador.size() == 2) divide();
				//else if(plantarButton) plantarse();
				break;
			case 3:  // TURNO DEL DEALER, COGE CARTAS HASTA QUE SUME 17 O MAS
				game.dealer();		
				break;
			case 4: // RECOMPENSAS FINALES
				//game.recompensas();
				estado = 0; // VUELVE AL INICIO
				break;
			default: 				
			break;
		}
	}
	
	private void addPlayerCard() {
		JLabel carta = game.getPlayerCards().get(0).toImage();
		carta.setBounds(200, 75, 75, 110);
		playerCards.add(carta);
		tablero.add(carta);	
	}
	
	private void addDealerCard() {
		JLabel carta = game.getPlayerCards().get(0).toImage();
		carta.setBounds(400, 75, 75, 110);
		dealerCards.add(carta);
		tablero.add(carta);	
	}

	protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
		
	private void pintarCartasJugadores() {		
		//List<Player> players = game.getCartasPlayers();
		
		// JUGADOR	
		/*JLabel carta1j1 = players.get(0).getFirstCard().toImage();
		tablero.add(carta1j1);
		carta1j1.setBounds(400, 75, 75, 110);
		JLabel carta2j1 = players.get(0).getSecondCard().toImage();
		tablero.add(carta2j1);
		carta2j1.setBounds(480, 75, 75, 110);
		
		JLabel porcentajeJ1 = new JLabel(game.getPorcentajes(0)+"%");		
		porcentajeJ1.setForeground(Color.white);
		porcentajeJ1.setBounds(440, 95, 100, 100);
		tablero.add(porcentajeJ1);
		
		
		
		// DEALER
		JLabel carta1j2 = players.get(1).getFirstCard().toImage();
		tablero.add(carta1j2);
		carta1j2.setBounds(880, 75, 75, 110);
		JLabel carta2j2 = players.get(1).getSecondCard().toImage();
		tablero.add(carta2j2);
		carta2j2.setBounds(960, 75, 75, 110);
		
		JLabel porcentajeJ2 = new JLabel(game.getPorcentajes(1)+"%");		
		porcentajeJ2.setForeground(Color.white);
		porcentajeJ2.setBounds(920, 105, 100, 100);
		tablero.add(porcentajeJ2);*/
		
		
		
	}

}
