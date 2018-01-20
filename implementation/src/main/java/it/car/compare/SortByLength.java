package it.car.compare;

import java.util.Comparator;

public class SortByLength implements Comparator<Auto>{

	@Override
	public int compare(Auto lhs, Auto rhs) {
		// TODO Auto-generated method stub
		return lhs.length - rhs.length;
	}

}
