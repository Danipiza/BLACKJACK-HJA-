package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton siguiente;
	private JPanel tablero;
	
	// GAMES
	private JButton normal;
	private JButton HT3;
	private JButton anyPair;
	private JButton bustIt;
	
	// DINERO
	private JButton money1;
	private JButton money2;
	private JButton money5;
	private JButton money25;
	private JButton money100;
	
	public MainWindow(Game g) {
		game = g;
		initGUI();
	}
	
	private void initGUI()  {
		tablero = new Tablero();
		
		// BOTON DE SIGUIENTE
		siguiente = siguienteButton();
		tablero.add(siguiente);
		add(tablero);
		
		// BOTON DE NORMAL
		normal = normalButton();
		normal.setOpaque(true);
		normal.setContentAreaFilled(false);
		normal.setBorderPainted(false);
		normal.setIcon(loadImage("resources/Games/Normal.png"));
		tablero.add(normal);
		add(tablero);
		
		// BOTON HT3
		HT3 = HT3Button();
		HT3.setOpaque(true);
		HT3.setContentAreaFilled(false);
		HT3.setBorderPainted(false);
		HT3.setIcon(loadImage("resources/Games/HT3.png"));
		tablero.add(HT3);
		add(tablero);
		
		// BOTON BUST-IT
		bustIt = busItButton();
		bustIt.setOpaque(true);
		bustIt.setContentAreaFilled(false);
		bustIt.setBorderPainted(false);
		bustIt.setIcon(loadImage("resources/Games/BustIt.png"));
		tablero.add(bustIt);
		add(tablero);
		
		// BOTON ANYPAIR
		anyPair = anyPairButton();
		anyPair.setOpaque(true);
		anyPair.setContentAreaFilled(false);
		anyPair.setBorderPainted(false);
		anyPair.setIcon(loadImage("resources/Games/AnyPair.png"));
		tablero.add(anyPair);
		add(tablero);
		
		// FICHAS (MONEDAS)
		money1 = money1Button();
		money1.setOpaque(true);
		money1.setContentAreaFilled(false);
		money1.setBorderPainted(false);
		money1.setIcon(loadImage("resources/Money/1_money.png"));
		tablero.add(money1);
		add(tablero);
		
		money2 = money2Button();
		money2.setOpaque(true);
		money2.setContentAreaFilled(false);
		money2.setBorderPainted(false);
		money2.setIcon(loadImage("resources/Money/2_money.png"));
		tablero.add(money2);
		add(tablero);
		
		money5 = money5Button();
		money5.setOpaque(true);
		money5.setContentAreaFilled(false);
		money5.setBorderPainted(false);
		money5.setIcon(loadImage("resources/Money/5_money.png"));
		tablero.add(money5);
		add(tablero);
		
		money25 = money25Button();
		money25.setOpaque(true);
		money25.setContentAreaFilled(false);
		money25.setBorderPainted(false);
		money25.setIcon(loadImage("resources/Money/25_money.png"));
		tablero.add(money25);
		add(tablero);
		
		money100 = money100Button();
		money100.setOpaque(true);
		money100.setContentAreaFilled(false);
		money100.setBorderPainted(false);
		money100.setIcon(loadImage("resources/Money/100_money.png"));
		tablero.add(money100);
		add(tablero);
		
		
		
		setSize(1713,1013); 
		setVisible(true);
	}
	
	private JButton siguienteButton() {
		JButton aux = new JButton("Siguiente");
		aux.setBounds(50, 40, 90, 30);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		return aux;
	}
	
	private JButton normalButton() {
		JButton aux = new JButton("Normal");
		aux.setBounds(735, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton HT3Button() {
		JButton aux = new JButton("HT3");
		aux.setBounds(625, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton anyPairButton() {
		JButton aux = new JButton("AnyPair");
		aux.setBounds(955, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton busItButton() {
		JButton aux = new JButton("BustIt");
		aux.setBounds(845, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton money1Button() {
		JButton aux = new JButton("Money1");
		aux.setBounds(20, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton money2Button() {
		JButton aux = new JButton("Money2");
		aux.setBounds(120, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton money5Button() {
		JButton aux = new JButton("Money5");
		aux.setBounds(220, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton money25Button() {
		JButton aux = new JButton("Money25");
		aux.setBounds(320, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
	}
	
	private JButton money100Button() {
		JButton aux = new JButton("Money100");
		aux.setBounds(420, 850, 90, 64);
		aux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return aux;
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
