package it.car.yelp.interview.string;

public class PageSites {
	
	public static void main(String args[]){
		int numPage = 30;
		int selected = 28;
		System.out.println(selectedPage(numPage, selected));
	}

	private static String selectedPage(int numPage, int selected) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 30; i++){
			sb.append((i==selected?"(":"") +i + (i==selected?")":"") + (i<numPage?" ":""));
		}
		return sb.toString();
	}
	

}
