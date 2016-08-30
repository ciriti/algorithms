package it.car.yelp.intw.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JustifyText {

	/**
	 * Funziona!!!
	 * LINK - https://leetcode.com/problems/text-justification/
	 * @param args
	 */

    public static void main(String args[]){
        String[] text = new String[]{"What","must","be","shall","be."};//"This", "is", "an", "example", "of", "text", "justification."};

        List<String> list = fullJustify(text, 12);
        for(String s : list){
            System.out.println("size[" + s.length() + "] " + s);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        Stack<String> stack = new Stack<>();
        List<StringBuffer> res = new ArrayList<>();
        List<String> res1 = new ArrayList<>();

        if(words.length==0){
            return  res1;
        }

        if(words.length==1){
            res1.add(addPadding(new StringBuffer(words[0]), maxWidth).toString());
            return res1;
        }


        for(int i = words.length-1; i>=0; i--){
            stack.push(words[i]);
        }

        StringBuffer sb = new StringBuffer();

        while(!stack.isEmpty()){
            if(stack.peek().length() + (maxWidth>1?1:0) + sb.length() <= maxWidth || stack.peek().length() == maxWidth && sb.length() == 0){
                sb.append((sb.length()==0?"":" ") + stack.pop());
            }else{
                res.add(sb);
                sb = new StringBuffer();
            }
        }

        if(sb.length()>0)
            res.add(sb);

        for(int i = 0; i < res.size()-1; i++){
            res1.add(addPadding(res.get(i), maxWidth).toString());
        }

        res1.add(addPaddingLast(res.get(res.size()-1), maxWidth).toString());

        return res1;
    }

    private static StringBuffer addPadding(StringBuffer sb, int maxWidth) {
        int index = 1;
        while(sb.length() != maxWidth){
            if(index == sb.length() && (sb.toString().split(" ")).length>1){
                index = 1;
            }else if(sb.toString().split(" ").length==1 || sb.toString().split(" ").length==0){
            	sb.append(' ');
            }else{
                if(sb.charAt(index) != ' ' && sb.charAt(index-1) == ' '){
                    sb.insert(index-1,  ' ');
                    index++;
                }
                index++;
            }
        }

        return sb;
    }
    
    private static StringBuffer addPaddingLast(StringBuffer sb, int maxWidth) {
    	while(sb.length() != maxWidth){
    		sb.append(' ');
    	}
    	return sb;
    }

}