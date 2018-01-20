package it.car.carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck implements Iterator<ICard> , IDeck{
	
	protected ArrayList<ICard> myCardList;
	protected int myIndex;

	public Deck(){
		myCardList = new ArrayList<ICard>();

		for(int suit = ICard.SPADES; suit <= ICard.CLUBS; suit++){
			for (int rank = 1; rank <= 13; rank++){
				myCardList.add(new Card(suit,rank));
			}
		}
		shuffle();
	}

	@Override
	public boolean hasNext() {
		return myIndex < myCardList.size();
	}

	@Override
	public ICard next() {
		ICard card = (ICard) myCardList.get(myIndex);
		myIndex++;
		return card;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		Collections.shuffle(myCardList);
		myIndex = 0;
	}
	
	public static void main(String args[]){
		Deck deck = new Deck();
		while(deck.hasNext()){
			System.out.println(((Card)deck.next()).toString());
		}
	}
}

