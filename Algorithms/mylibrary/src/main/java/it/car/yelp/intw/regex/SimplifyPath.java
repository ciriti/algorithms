package it.car.yelp.intw.regex;

import java.util.Stack;

public class SimplifyPath {

	/**
	 * Given an absolute path for a file (Unix-style), simplify it. 
	 * 
	 * For example, 
	 * path = "/home/", => "/home" 
	 * path = "/a/./b/../../c/", => "/c"
	 * 
	 * LINK - https://leetcode.com/problems/simplify-path/
	 * 
	 * @param path
	 * @return
	 */

	public static String simplifyPath(String path) {
	       
	       if(path == null) return path;
			
			if(!path.matches("^/(.*)$")) 
				return "";

			String s = path.replaceAll("/{2,}", "/");
			s = s.length() > 1 ? s.replaceAll("^(.*)/$", "$1"):s;
			
			if(s.length() == 1|| s.length() == 0) return s;

			String[] split = s.split("/");
			Stack<String> stack = new Stack<>();

			for(int i = 1; i < split.length; i++){
				if(split[i].equals("..")){
					if(!stack.isEmpty())
						stack.pop();
				}else if(split[i].equals(".")){
					// do nothing
				}
				else{
					stack.push(split[i]);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("/");
			for(int i = 0; i < stack.size(); i++){
				if(!stack.get(i).equals("."))
					sb.append(stack.get(i) + "/");
			}
			
			s = sb.length()>1?sb.toString().substring(0, sb.length()-1):sb.toString();

			return s;
	    }

	public static void main(String args[]){
		System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

}
