package it.car.yelp.interview.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSample {
	
	// crete a class 
	public static class Company{
		String name;
		int rank;

		public Company(String name, int rank){
			this.name = name;
			this.rank = rank;
		}

		public String getName(){
			return this.name;
		}

		public int getRank(){
			return this.rank;
		}

		public String toString(){
			return this.name + " " + this.rank;
		}

		public static Comparator<Company> RANK_COMPARATOR  = new Comparator<Company>(){

			public int compare(Company a, Company b){

				if(a.rank == b.rank) 
					return 0;

				if(a.rank < b.rank) 
					return -1;

				return 1;
			}
		};
		
		public static final Comparator<Company> NAME_COMPARATOR = new Comparator<Company>(){
			public int compare(Company a, Company b){
				return a.name.compareTo(b.name);
			}
		};

	}
	
	/**
	 * main to test
	 * @param args
	 */
	public static void main(String[] args) {

		Company[] companies = new Company[10];
		for(int i = 10; i > 0; i --){
			companies[10 - i] = new Company("Company_" + i, i);
		}

		Arrays.sort(companies, Company.NAME_COMPARATOR);

		for(Company c : companies){
			System.out.println(c);
		}

	}
}
