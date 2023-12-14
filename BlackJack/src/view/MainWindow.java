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
import logic.Strategies;

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
	
	private Strategies strats;
	
	JButton[] moneyButtons;
	/*JButton money1;
	JButton money2;
	JButton money5;
	JButton money25;
	JButton money100;*/
	
	JButton hitButton;
	JButton standButton;
	
	JLabel balanceMoney;
	
	JLabel cartaReversa;
	
	public MainWindow(Game g) {
		moneyButtons = new JButton[5];
		moneyButtons[0] = new JButton("Money1");
		moneyButtons[1] = new JButton("Money2");
		moneyButtons[2] = new JButton("Money5");
		moneyButtons[3] = new JButton("Money25");
		moneyButtons[4] = new JButton("Money100");
		
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		balanceMoney =  new JLabel("Money");
		
		xJugador = 950;
		iJugador = 2;
		
		game = g;
		strats=new Strategies(game);
		
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
		
		
		JLabel HT3Money = new JLabel();
		HT3Money.setFont(new Font("Arial", Font.PLAIN, 25));
		HT3Money.setForeground(Color.white);
		HT3Money.setBounds(660, 770, 120, 100);
		apuestas.add(HT3Money);
		tablero.add(HT3Money);
		
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
		
		
		JLabel normalMoney = new JLabel();
		normalMoney.setFont(new Font("Arial", Font.PLAIN, 25));
		normalMoney.setForeground(Color.white);
		normalMoney.setBounds(760, 770, 120, 100);
		apuestas.add(normalMoney);
		tablero.add(normalMoney);
		
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
	
		
		JLabel bustItMoney = new JLabel();
		bustItMoney.setFont(new Font("Arial", Font.PLAIN, 25));
		bustItMoney.setForeground(Color.white);
		bustItMoney.setBounds(870, 770, 120, 100);
		apuestas.add(bustItMoney);
		tablero.add(bustItMoney);
		
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
	
		
		JLabel anyPairMoney = new JLabel();
		anyPairMoney.setFont(new Font("Arial", Font.PLAIN, 25));
		anyPairMoney.setForeground(Color.white);
		anyPairMoney.setBounds(980, 770, 120, 100);
		apuestas.add(anyPairMoney);
		tablero.add(anyPairMoney);
		
		// DIBUJAR APUESTAS
		
		for (int i = 0; i < 4; i++) {
			apuestas.get(i).setText(Integer.toString(game.apuestasMoney[i]));
		}
		
		// FICHAS (MONEDAS)
		// FICHA 1
		//JButton money1 = new JButton("Money1");
		moneyButtons[0].setBounds(20, 850, 90, 64);
		moneyButtons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasMoney[modo] += 1;
				apuestas.get(modo).setText(Integer.toString(game.apuestasMoney[modo]));
			}
		});
		moneyButtons[0].setOpaque(true);
		moneyButtons[0].setContentAreaFilled(false);
		moneyButtons[0].setBorderPainted(false);
		moneyButtons[0].setIcon(loadImage("resources/Money/1_money.png"));
		tablero.add(moneyButtons[0]);
	
		
		
		
		// FICHA 2
		//JButton money2 = new JButton("Money2");
		moneyButtons[1].setBounds(120, 850, 90, 64);
		moneyButtons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasMoney[modo] += 2;
				apuestas.get(modo).setText(Integer.toString(game.apuestasMoney[modo]));
			}
		});
		moneyButtons[1].setOpaque(true);
		moneyButtons[1].setContentAreaFilled(false);
		moneyButtons[1].setBorderPainted(false);
		moneyButtons[1].setIcon(loadImage("resources/Money/2_money.png"));
		tablero.add(moneyButtons[1]);
		
		
		
		// FICHA 5
		//JButton money5 = new JButton("Money5");
		moneyButtons[2].setBounds(220, 850, 90, 64);
		moneyButtons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasMoney[modo] += 5;
				apuestas.get(modo).setText(Integer.toString(game.apuestasMoney[modo]));
			}
		});
		moneyButtons[2].setOpaque(true);
		moneyButtons[2].setContentAreaFilled(false);
		moneyButtons[2].setBorderPainted(false);
		moneyButtons[2].setIcon(loadImage("resources/Money/5_money.png"));
		tablero.add(moneyButtons[2]);

		
		
		// FICHA 25
		//JButton money25 = new JButton("Money25");
		moneyButtons[3].setBounds(320, 850, 90, 64);
		moneyButtons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasMoney[modo] += 25;
				apuestas.get(modo).setText(Integer.toString(game.apuestasMoney[modo]));
			}
		});
		moneyButtons[3].setOpaque(true);
		moneyButtons[3].setContentAreaFilled(false);
		moneyButtons[3].setBorderPainted(false);
		moneyButtons[3].setIcon(loadImage("resources/Money/25_money.png"));
		tablero.add(moneyButtons[3]);
		
		
		
		// FICHA 100
		//JButton money100 = new JButton("Money100");
		moneyButtons[4].setBounds(420, 850, 90, 64);
		moneyButtons[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.apuestasMoney[modo] += 100;
				apuestas.get(modo).setText(Integer.toString(game.apuestasMoney[modo]));
			}
		});
		moneyButtons[4].setOpaque(true);
		moneyButtons[4].setContentAreaFilled(false);
		moneyButtons[4].setBorderPainted(false);
		moneyButtons[4].setIcon(loadImage("resources/Money/100_money.png"));
		tablero.add(moneyButtons[4]);
		
		
		
		
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
		
		//JLabel balanceMoney = new JLabel("Money");
		balanceMoney.setText(Double.toString(game.moneyGanado));
		balanceMoney.setFont(new Font("Arial", Font.PLAIN, 25));
		balanceMoney.setForeground(Color.white);
		balanceMoney.setBounds(140, 900, 120, 100);		
		tablero.add(balanceMoney);
		
		
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
	
	private void changeVisibilityCoins(boolean bool) {
		for(JButton b: moneyButtons) {
			b.setVisible(bool);
		}		
	}
	
	/*private void monedasNoVisibles() {
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
	}*/
	
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
				game.money();
				if(game.moneyGastado > 0) {
					game.repartirJugador();
					pintarCartasJugador();	//addPlayerCard();			
					changeVisibilityCoins(false);
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
				changeVisibilityCoins(true);
				balanceMoney.setText(Double.toString(game.moneyGanado));
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
		// RESETEAR LAS JLABEL DEL Money APOSTADO EN CADA MODO
		for(int i = 0; i<4; i++) {
			apuestas.get(i).setText(Integer.toString(game.apuestasMoney[modo]));
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
	
	
	
	public void bustItClass() {				
		BustItStrategyClassDialog BustItDialog = new BustItStrategyClassDialog((this));						
		int estado = BustItDialog.open();		
		int Money = 0, reps = 0, bet = 0;
		
		
		if (estado == 1) {			
			Money = BustItDialog.getMoney();
			reps = BustItDialog.getReps();
			bet = BustItDialog.getBet(); 
			
			try {						
				 if (Money >= 1) strats.bustItStrategyLimited(Money,reps, bet);
				 else {
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
		int Money = 0;
		int reps = 0;
		
		if (estado == 1) {			
			Money = VegasDialog.getMoney();
			reps = VegasDialog.getReps();
			
			try {						
				 if (Money >= 1) strats.vegasStrategy(Money, reps);
				 else {
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
		int Money = 0;
		int reps = 0;
		
		if (estado == 1) {			
			Money = VegasDialog.getMoney();
			reps = VegasDialog.getReps();
			
			try {						
				 if (Money >= 1) strats.vegas2Strategy(Money, reps);
				 else {
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
		int Money = 0;	
		int reps = 0;
		int interval = 0;
		boolean Hot3, Normal, BustIt, AnyPair;
		
		
		if (estado == 1) {			
			Money = RandomDialog.getMoney();
			reps = RandomDialog.getReps();
			interval = RandomDialog.getinterval();
			
			Hot3 = RandomDialog.getHot3();
			Normal = RandomDialog.getNormal();
			BustIt = RandomDialog.getBustIt();
			AnyPair = RandomDialog.getAnyPair();
			
			try {						
				 if (Money >= 1) strats.RandomStrategy(Money, reps, interval, Hot3, Normal, BustIt, AnyPair);
				 else {
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