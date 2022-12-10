package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RandomStrategyClassDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private int estado; // 0 o 1
	
	
	private JCheckBox Hot3;
	private JCheckBox Normal;
	private JCheckBox BustIt;
	private JCheckBox AnyPair;
	
	private JTextField money;
	private JTextField reps;
	private JTextField interval;
	
	
	
	public RandomStrategyClassDialog(Frame parent) {
		super(parent, true);
		initGUI();		
	}
	
	public RandomStrategyClassDialog() {		
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
		
		// MODOS --------------------------------------------------------------------------------
		JPanel ModesPanel = new JPanel();
		ModesPanel.setAlignmentX(LEFT_ALIGNMENT);
		mainPanel.add(ModesPanel);
		
		Hot3 = new JCheckBox("Hot3");
	    Hot3.setBounds(100,100, 50,50); 
	    ModesPanel.add(Hot3);
	    
	    Normal = new JCheckBox("Normal");
	    Normal.setBounds(100,100, 50,50); 
	    ModesPanel.add(Normal);
	    
	    BustIt = new JCheckBox("BustIt");
	    BustIt.setBounds(100,100, 50,50); 
	    ModesPanel.add(BustIt);
	    
	    AnyPair = new JCheckBox("AnyPair");
	    AnyPair.setBounds(100,100, 50,50); 
	    ModesPanel.add(AnyPair);	    
	    
	    
		
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
		
		interval = new JTextField(10);
		
		JLabel intervalSpace = new JLabel("");
		
		interPanel.add(intervalSpace);
		
		interPanel.add(interval);
		
		// ---------------------------------------------------------------------------------------
		
		// BOTONES -------------------------------------------------------------------------------
		
		JPanel buttonsPanel = new JPanel();
		mainPanel.add(buttonsPanel);		
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 0;
				RandomStrategyClassDialog.this.setVisible(false);
			}
		});
		buttonsPanel.add(cancelButton);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado = 1;
				RandomStrategyClassDialog.this.setVisible(false);	
			}
		});
		buttonsPanel.add(okButton);

		setPreferredSize(new Dimension(380, 280));
		pack();
		setResizable(false);
		setVisible(false);
		
	}
	
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
	
	public int getinterval() {
		return Integer.parseInt(interval.getText());
	}
	
	public boolean getHot3() {
		return Hot3.isSelected();
	}
	
	public boolean getNormal() {
		return Normal.isSelected();
	}
	
	public boolean getBustIt() {
		return BustIt.isSelected();
	}
	
	public boolean getAnyPair() {
		return AnyPair.isSelected();
	}

}
