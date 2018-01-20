package it.car.compare;

public class Auto implements Comparable<Auto>{
	
	/**
	 * Compare current person with specified person
	 * 0 is the same; negative questo oggetto e' piu' piccolo; positive viceversa
	 */

	@Override
	public int compareTo(Auto another) {
		// TODO Auto-generated method stub
		return this.length-another.length;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		// Include a hash for each field.
		result = 31 * result + targa.hashCode();
		result = 31 * result + matricola;
		return result;
	}


	String targa;
	int matricola;
	int length;

	public Auto(String targa, int matricola, int length) {
		super();
		this.targa = targa;
		this.matricola = matricola;
		this.length = length;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}

}
