package it.car.carte;

public interface IDeck {
	
	/**
	 * mischia
	 */
	void shuffle();
	
	/**
	 * ha la prossima carta
	 * @return
	 */
	public boolean hasNext();
	
	/**
	 * dammi la prossima carta
	 * @return
	 */
	public Object next();
	
	/**
	 * elimina la prossima carta
	 */
	public void remove();

}
