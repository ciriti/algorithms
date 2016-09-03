package it.car.tree.august2016;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by carmeloiriti, 31/08/16.
 */
public class BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree in which
     * the depth of the two subtrees of every node never differ by more than 1.
     * LINK - https://leetcode.com/problems/balanced-binary-tree/
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else
                sb.append("n,");
        }

        return sb.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] arr = data.replaceAll("(\\[|\\])", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> quque = new LinkedList<>();
        quque.add(root);
        for (int i = 1; i < arr.length; i++){
            TreeNode tmp = quque.poll();
            if(!arr[i].equals("n")){
                tmp.left = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.left);
            }
            if(!arr[++i].equals("n")){
                tmp.right = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.right);
            }

        }

        return root;

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(deep(root.left) - deep(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int deep(TreeNode node){
        if (node == null)
            return 0;
        return 1 + Math.max(deep(node.left), deep(node.right));
    }





    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);
        TreeNode cinque = new TreeNode(5);
        TreeNode sei = new TreeNode(6);
        TreeNode sette = new TreeNode(7);
        TreeNode m_uno = new TreeNode(-1);
        TreeNode nove = new TreeNode(9);

        root.left = due;
        root.right = tre;
        tre.left = quatt;
        tre.right = cinque;
        due.left = sette;
        due.right = nove;


        BalancedBinaryTree tree = new BalancedBinaryTree();
        TreeNode test = tree.deserialize("[1,2,2,3,n,n,3,4,n,n,4]");
        TreeNode test1 = tree.deserialize("[1,n,2,n,3]");
        System.out.println(tree.isBalanced(tree.deserialize("[1,2,2,3,n,n,3,4,n,n,4]")) == false?"SUCCESS":"ERROR");
        System.out.println(tree.isBalanced(tree.deserialize("[1,n,2,n,3]")) == false?"SUCCESS":"ERROR");

//        System.out.println(tree.deep(root));

    }



}
