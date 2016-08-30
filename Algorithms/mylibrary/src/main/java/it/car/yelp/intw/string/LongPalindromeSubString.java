package it.car.yelp.intw.string;

import java.util.Arrays;

public class LongPalindromeSubString {

	public static void main(String args[]){
		System.out.println(longestPalindrome("miycvxmqggnmmcwlmizfojwrurwhwygwfykyefxbgveixykdebenzitqnciigfjgrzzbtgeazyrbiirmejhdwcgjzwqolrturjlqpsgunuqerqjevbheblmbvgxyedxshswsokbhzapfuojgyfhctlaifrisgzqlczageirnukgnmnbwogknyyuynwsuwbumdmoqwxprykmazghcpmkdcjduepjmjdxrhvixxbfvhybjdpvwjbarmbqypsylgtzyuiqkexgvirzylydrhrmuwpmfkvqllqvekyojoacvyrzjevaupypfrdguhukzuqojolvycgpjaendfetkgtojepelhcltorueawwjpltehbbjrvznxhahtuaeuairvuklctuhcyzomwrrznrcqmovanxmiyilefybkbveesrxkmqrqkowyrimuejqtikcjfhizsmumajbqglxrvevexnleflocxoqgoyrzgqflwiknntdcykuvdcpzlakljidclhkllftxpinpvbngtexngdtntunzgahuvfnqjedcafzouopiixw"));
//		System.out.println(longestPalindrome("assa"));
	}


	public static String longestPalindrome(String s) {
		String res = "";
		String tmp = "";
		char[] a = s.toCharArray();
		for(int i = 0; i < s.length(); i++){
			tmp = getPalindrome(a, i, i);
			if(tmp.length() > res.length()){
				res = tmp;
			}
			tmp = getPalindrome(a, i, i+1);
			if(tmp.length() > res.length()){
				res = tmp;
			}
		}
		return res;
	}

	static String getPalindrome(char[] s, int x, int y){
		while(x>=0 && y<s.length){
			if(s[x] != s[y]){
				break;
			}
			x--;
			y++;
		}
		char[] tmp = Arrays.copyOfRange(s, x+1, y);
		return String.valueOf(tmp);
	}

}
