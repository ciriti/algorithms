package it.car.wayfair.tree;

/**
 * Created by ciriti on 25/09/16.
 */

public class ValidateBinarySearchTree {

    /**
     * LINK - https://leetcode.com/problems/validate-binary-search-tree/
     */

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

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode n, long lowLim, long upLimit) {

        if(n == null){
           return true;
        }

        if(n.val <= lowLim || n.val >= upLimit)
            return false;

        return isValidBST(n.left, lowLim, n.val) && isValidBST(n.right, n.val, upLimit);
    }

    public static void main(String args[]){
//        TreeNode rootSymm = deserialize("[1,2,2,3,4,4,3]");
//        TreeNode rootNotSymm = deserialize("[1,2,2,null,3,null,3]");
//        System.out.println(isValidBST(rootSymm) == true?"SUCCES":"ERROR");
//        System.out.println(isSymmetric(rootNotSymm) == false?"SUCCES":"ERROR");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(10);

        TreeNode rootNOTValid = new TreeNode(1);
        rootNOTValid.left = new TreeNode(-1);
        rootNOTValid.right = new TreeNode(-10);

        System.out.println(isValidBST(rootNOTValid) == false?"SUCCES":"ERROR");
        System.out.println(isValidBST(root) == true?"SUCCES":"ERROR");
    }

}
