package it.car.carte;

class Card implements ICard{
	private final int mySuit;     // ensure immutable, make final
	private final int myRank;
	private static final String[] suitStrings = {
		"spades", "hearts", "diamonds", "clubs"	
	};

	private String myName;

	private static final String[] rankStrings = {
		"dummy","ace","two","three","four","five",
		"six","seven","eight","nine","ten",
		"jack","queen","king"	
	};
	public Card(int suit, int rank){
		mySuit = suit;
		myRank = rank;
		myName = rankStrings[getRank()]+" of "+
				suitStrings[getSuit()];
	}
	public int getSuit() {
		return mySuit;
	}

	public int getRank() {
		return myRank;
	}
	public String toString(){
		return myName;
	}

//	public int compareTo(Object o) {
//		ICard other = (ICard) o;
//		int rdiff = getRank() - other.getRank();
//		if (rdiff == 0) {
//			return getSuit() - other.getSuit();
//		}
//		else {
//			return rdiff;
//		}
//	}

	public boolean equals(Object o){
		return compareTo((ICard)o) == 0;
	}
	
	@Override
	public int compareTo(ICard another) {
		// TODO Auto-generated method stub
		int diff = this.myRank - another.getRank();
		if(diff==0){
			diff = this.mySuit - another.getSuit();
			return diff;
		}
		return diff;
	}

}