package it.car.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastHashMap
{


	public static void main(String[] args)
	{
		Map<String,String> countryCode = new HashMap<String,String>();
		countryCode.put("India", "+91");
		countryCode.put("UK", "+44");

		/**
		 * FALLISCE!!!
		 */
		Iterator<String> iterator = countryCode.keySet().iterator();

		while (iterator.hasNext())
		{
			System.out.println(countryCode.get(iterator.next()));
			countryCode.put("USA", "+11");			
		}
		
		/**
		 * NON FALLISCE!!!
		 */
		ConcurrentHashMap<String,String> countryCodeCC = new ConcurrentHashMap<>(countryCode);
		
		Iterator<String> iteratorCC = countryCodeCC.keySet().iterator();

		while (iteratorCC.hasNext())
		{
			System.out.println(countryCodeCC.get(iteratorCC.next()));
			countryCodeCC.put("USA", "+11");			
		}

	}	

}