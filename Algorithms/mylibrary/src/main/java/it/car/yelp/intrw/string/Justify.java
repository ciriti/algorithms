package it.car.yelp.intrw.string;


public class Justify {
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String args[]){
		String test = "ciao io   sono c";
		String res = justify(test, 20);
		System.out.println(res.length() + " [" + res + "]");
	}

	private static String justify(String test, int max) {
		test = test.replaceAll("[ ]+", " ");
		StringBuffer sb = new StringBuffer(test);
		int index = 1;
		while(sb.length() != max){
			if(index == sb.length()){
				index = 1;
			}else{
				if(sb.charAt(index) != ' ' && sb.charAt(index-1) == ' '){
					sb.insert(index-1,  ' ');
					index++;
				}
				index++;
			}
		}
		// TODO Auto-generated method stub
		return sb.toString();
	}
	
}
