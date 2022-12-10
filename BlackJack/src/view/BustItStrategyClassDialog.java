package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BustItStrategyClassDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private int estado; // 0 o 1
	
	private JTextField money;
	private JTextField reps;
	private JTextField bet;
	
	
	public BustItStrategyClassDialog(Frame parent) {
		super(parent, true);
		initGUI();		
	}
	
	public BustItStrategyClassDialog() {		
		super();
		initGUI();		
	}
	
	private void initGUI() {
		estado = 0;		
		
		setTitle("Add parameters");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);				
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 18)));
					    		
		// IDENTIFIER PANEL (PARA QUE QUEDE BIEN COMO EN LA FOTO) --------------------------------
		JPanel moneyPanel = new JPanel();
		moneyPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(moneyPanel);
		
		
		JLabel identifier = new JLabel("Money:");
		identifier.setAlignmentX(LEFT_ALIGNMENT);
		moneyPanel.add(identifier);
		
		money = new JTextField(10);
		
		
		JLabel moneySpace = new JLabel("  ");
		
		moneyPanel.add(moneySpace);
		
		moneyPanel.add(money);
		
		// ---------------------------------------------------------------------------------------
		
		// ITINERARY PANEL (PARA QUE QUEDE BIEN COMO EN LA FOTO) ---------------------------------
		JPanel repsPanel = new JPanel();
		repsPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(repsPanel);
		
		
		JLabel repsJLabel = new JLabel("Reps:");
		repsJLabel.setAlignmentX(LEFT_ALIGNMENT);
		repsPanel.add(repsJLabel);
		
		reps = new JTextField(10);
		
		JLabel itineraySpace = new JLabel("    ");
		
		repsPanel.add(itineraySpace);
		
		repsPanel.add(reps);
		
		// INTERVALO ---------------------------------------------
		
		JPanel interPanel = new JPanel();
		interPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(interPanel);
		
		
		JLabel intervalJLabel = new JLabel("Interval:");
		intervalJLabel.setAlignmentX(LEFT_ALIGNMENT);
		interPanel.add(intervalJLabel);
		
		bet = new JTextField(10);
		
		JLabel intervalSpace = new JLabel("");
		
		interPanel.add(intervalSpace);
		
		interPanel.add(bet);
		
		// ---------------------------------------------------------------------------------------
		
		// BOTONES -------------------------------------------------------------------------------
		
		JPanel buttonsPanel = new JPanel();
		mainPanel.add(buttonsPanel);		
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 0;
				BustItStrategyClassDialog.this.setVisible(false);
			}
		});
		buttonsPanel.add(cancelButton);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 1;
				BustItStrategyClassDialog.this.setVisible(false);	
			}
		});
		buttonsPanel.add(okButton);

		setPreferredSize(new Dimension(380, 280));
		pack();
		setResizable(false);
		setVisible(false);
		
	}
	/*
	private void initGUI() {
		estado = 0;		
		
		setTitle("Add parameters");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
			
		mainPanel.add(Box.createRigidArea(new Dimension(0, 18)));
				
		// MONEY PANEL (PARA QUE QUEDE BIEN COMO EN LA FOTO) --------------------------------
		JPanel moneyPanel = new JPanel();
		moneyPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(moneyPanel);
		
		
		JLabel identifier = new JLabel("Money:");
		identifier.setAlignmentX(LEFT_ALIGNMENT);
		moneyPanel.add(identifier);
		
		money = new JTextField(10);
				
		JLabel moneySpace = new JLabel("");
		
		moneyPanel.add(moneySpace);
		
		moneyPanel.add(money);
		
		// ---------------------------------------------------------------------------------------
		// REPS PANEL (PARA QUE QUEDE BIEN COMO EN LA FOTO) ---------------------------------
		JPanel repsPanel = new JPanel();
		repsPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(repsPanel);
				
		JLabel repsJLabel = new JLabel("Reps:");
		repsJLabel.setAlignmentX(LEFT_ALIGNMENT);
		repsPanel.add(repsJLabel);
		
		reps = new JTextField(10);
		
		JLabel itineraySpace = new JLabel("");
		
		repsPanel.add(itineraySpace);
		
		repsPanel.add(reps);
		
		// ---------------------------------------------------------------------------------------
		// BET PANEL (PARA QUE QUEDE BIEN COMO EN LA FOTO) ---------------------------------
		JPanel betPanel = new JPanel();
		betPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(betPanel);
				
		JLabel betsJLabel = new JLabel("Bet:");
		betsJLabel.setAlignmentX(LEFT_ALIGNMENT);
		betPanel.add(betsJLabel);
		
		bet = new JTextField(10);
		
		JLabel betsSpace = new JLabel("");
		
		betPanel.add(betsSpace);
		
		betPanel.add(bet);
		
		// ---------------------------------------------------------------------------------------
		// BOTONES -------------------------------------------------------------------------------
		
		JPanel buttonsPanel = new JPanel();
		mainPanel.add(buttonsPanel);		
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 0;
				BustItStrategyClassDialog.this.setVisible(false);
			}
		});
		buttonsPanel.add(cancelButton);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 1;
				BustItStrategyClassDialog.this.setVisible(false);	
			}
		});
		buttonsPanel.add(okButton);

		setPreferredSize(new Dimension(320, 300));
		pack();
		setResizable(false);
		setVisible(false);
		
	}
	
	*/
	public int open() {
		setLocation(getParent().getLocation().x + 300, getParent().getLocation().y + 360);

		setVisible(true);
		return estado;
	}
	
	
	public int getMoney() {
		return Integer.parseInt(money.getText());
	}
	
	public int getReps() {
		return Integer.parseInt(reps.getText());
	}	
	
	public int getBet() {
		return Integer.parseInt(bet.getText());
	}

}
