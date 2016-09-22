package it.car.tree.august2016;

/**
 * Created by ciriti on 31/08/16.
 */

public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode node, long rangeLeft, long rangeRight) {
        if(node == null) return true;
        if( rangeLeft >= node.val || node.val >= rangeRight) return false;
        return isValidBST(node.left, rangeLeft, node.val) && isValidBST(node.right, node.val, rangeRight);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        TreeNode uno = new TreeNode(1);
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


        due.left = uno;
        due.right = tre;


        IsValidBST treeCheck = new IsValidBST();

        System.out.println(treeCheck.isValidBST(due));



    }

}
