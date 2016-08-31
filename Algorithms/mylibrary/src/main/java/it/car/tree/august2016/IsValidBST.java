package it.car.tree.august2016;

import static android.R.attr.left;

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

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode root, int rangeLeft, int rangeRight) {
        if(root == null)
            return true;

        if(root.val > rangeRight || root.val < rangeRight){
            return false;
        }

        return (isValidBST(root.left, rangeLeft, root.val) && isValidBST(root.right, root.val, rangeRight));
    }

    public static void main(String args[]){
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

//        root.right = otto;

//        due.left =  zero ;
//        due.right = quatt ;
//
//        quatt.left = tre ;
//        quatt.right = cinque ;
//
//        otto.left = sette;
//        otto.right = sei;

        dieci.left = cinque;
        dieci.right = quindici;

        quindici.left = undici;
        quindici.right = venti;

        IsValidBST treeCheck = new IsValidBST();

        System.out.println(treeCheck.isValidBST(dieci));



    }

}
