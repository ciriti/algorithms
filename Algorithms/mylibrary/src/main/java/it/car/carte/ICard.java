package it.car.carte;

public interface ICard extends Comparable<ICard> 
{ 
	public static final int SPADES = 0; 
	public static final int HEARTS = 1; 
	public static final int DIAMONDS = 2; 
	public static final int CLUBS = 3; 
	
	/**
	 * @return il seme
	 */
	public int getSuit();
	
	/**
	 * @return il valore numerico della carta
	 */
	public int getRank(); 
} 

