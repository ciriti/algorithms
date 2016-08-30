package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciriti on 30/08/16.
 */

public class LowestCommonAncestorBT {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        recursive(root, p, pList);
        recursive(root, q, qList);

        TreeNode res = null;
        int dim = Math.min(pList.size(), qList.size());
        for(int i = 0; i < dim; i ++){
            if(i == dim-1){
                res = pList.size() < qList.size()? pList.get(i):qList.get(i);
            }else if(pList.get(i).val != qList.get(i).val){
                return pList.get(i-1);
            }

        }
        return res;
    }

    public void recursive(TreeNode node, TreeNode target, List<TreeNode> list){
        if(node == null) return;

        list.add(node);

        if(node.val == target.val){
            list.add(target);
            return;
        }else if(target.val > node.val){
            recursive(node.right, target, list);
        }else{
            recursive(node.left, target, list);
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(6);
        TreeNode due = new TreeNode(2);
        TreeNode otto = new TreeNode(8);
        TreeNode cinque = new TreeNode(5);
        TreeNode sette = new TreeNode(7);
        TreeNode nove = new TreeNode(9);
        TreeNode zero = new TreeNode(0);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);

        root.left = due;
        root.right = otto;

        due.left =  zero ;
        due.right = quatt ;

        quatt.left = tre ;
        quatt.right = cinque ;

        otto.left = sette;
        otto.right = nove;

        LowestCommonAncestorBT lca = new LowestCommonAncestorBT();

        System.out.println(lca.lowestCommonAncestor(root, due, otto));
        System.out.println(lca.lowestCommonAncestor(root, due, quatt));

    }

}
