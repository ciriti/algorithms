package it.car.wayfair.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static android.R.id.list;

/**
 * Created by ciriti on 25/09/16.
 */

public class SymmetricTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static TreeNode deserialize(String data) {

        String[] arr = data.replaceAll("(\\[|\\])", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> quque = new LinkedList<>();
        quque.add(root);
        for (int i = 1; i < arr.length; i++){
            TreeNode tmp = quque.poll();
            if(!arr[i].equals("null")){
                tmp.left = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.left);
            }
            if(!arr[++i].equals("null")){
                tmp.right = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.right);
            }

        }

        return root;

    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root, true).equals(dfs(root, false));
    }

    public static String dfs(TreeNode root, boolean firstLeft){

        StringBuilder sb = new StringBuilder();
        TreeNode empty = new TreeNode(Integer.MAX_VALUE);

        Stack<TreeNode> stack =  new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            String val = n.val == Integer.MAX_VALUE?"n":String.valueOf(n.val);
            sb.append(val);
            if(n.val == Integer.MAX_VALUE)continue;
            if(firstLeft){
                stack.add(n.left==null?empty:n.left);
                stack.add(n.right==null?empty:n.right);
            }else{
                stack.add(n.right==null?empty:n.right);
                stack.add(n.left==null?empty:n.left);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]){
        TreeNode rootSymm = deserialize("[1,2,2,3,4,4,3]");
        TreeNode rootNotSymm = deserialize("[1,2,2,null,3,null,3]");
        System.out.println(isSymmetric(rootSymm) == true?"SUCCES":"ERROR");
        System.out.println(isSymmetric(rootNotSymm) == false?"SUCCES":"ERROR");
    }

}
