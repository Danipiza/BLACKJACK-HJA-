package logic;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	
	private String value;
	private String suit;
	private int nValue;
	
	public Card(String v, String s, int n) {
		value = v;
		suit = s;
		if (value.equals("ace")) nValue = 11;
		else if (n > 10) nValue = 10;
		else nValue = n;
	}
		
	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;
	}
	
	public int getNValue() {
		return nValue;
	}
	
	public void setNValue(int x) {
		nValue = x;
	}
	
	public String toString() {
		return "Value: " + value + "; Suit: " +suit + " ; n = " + nValue;
	}
	
	public JLabel toImage() {
		return new JLabel(new ImageIcon("resources/icons/" + value + "_of_" + suit + ".png"));
	}

}