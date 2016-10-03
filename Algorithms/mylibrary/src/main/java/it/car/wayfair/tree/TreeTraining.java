package it.car.wayfair.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ciriti on 29/09/16.
 */

public class TreeTraining {

    Node root;

    public TreeTraining(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return root;
    }

    public Node deserialize(List<Integer> nodes){
        Node root = new Node(nodes.get(0));
        deserializerec(root, new LinkedList<>(nodes.subList(1, nodes.size()))  );
        return root;
    }

    void deserializerec(Node n , Queue<Integer> nodes){
        Integer val = nodes.poll();
        if(val != null){
            n.left = new Node(val);
            deserializerec(n.left, nodes);
        }
        val = nodes.poll();
        if(val != null){
            n.rigth = new Node(val);
            deserializerec(n.rigth, nodes);
        }

    }


    public List<Integer> serializeTree(){

        LinkedList<Integer> nodes = new LinkedList<>();
        serRecInorde(root, nodes);

        for(int i = nodes.size()-1; i >= 0; i--){
            if(nodes.get(i) == null){
                nodes.removeLast();
            }else
                break;

        }

        return nodes;
    }

    private void serRecInorde(Node n, List<Integer> nodes){
        nodes.add(n.val);
        if(n.left != null){
            serRecInorde(n.left, nodes);
        }else{
            nodes.add(null);
        }
        if(n.rigth != null){
            serRecInorde(n.rigth, nodes);
        }else{
            nodes.add(null);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root.left = n2;
        root.rigth = n3;
        n2.rigth = n4;

        TreeTraining tree = new TreeTraining(root);

        List<Integer> list = tree.serializeTree();

        System.out.println("Serialized: " + list.toString());

        System.out.println(tree.deserialize(list));


    }

    public static class Node{
        int val;
        Node left;
        Node rigth;

        public Node(int val){
            this.val = val;
        }

    }


}
