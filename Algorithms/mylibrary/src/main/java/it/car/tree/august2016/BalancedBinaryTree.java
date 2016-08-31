package it.car.tree.august2016;

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
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return Math.abs(countDeep(root.left)-countDeep(root.right)) <= 1;
    }

    public int countDeep(TreeNode node) {
        if(node == null)return 1;
        return Math.max(countDeep(node.left), countDeep(node.right)) + 1;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode otto = new TreeNode(8);
        TreeNode cinque = new TreeNode(5);
        TreeNode sette = new TreeNode(7);
        TreeNode nove = new TreeNode(9);
        TreeNode zero = new TreeNode(0);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);
        TreeNode sei = new TreeNode(6);
        TreeNode dieci = new TreeNode(10);
        TreeNode undici = new TreeNode(11);
        TreeNode quindici = new TreeNode(15);
        TreeNode venti = new TreeNode(20);

        dieci.left = cinque;
        dieci.right = quindici;

        quindici.right = undici;
        undici.left = sette;


        BalancedBinaryTree binaryTree = new BalancedBinaryTree();

        System.out.println(binaryTree.isBalanced(dieci));
    }


}
