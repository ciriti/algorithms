package it.car.tree;

/**
 * Created by ciriti on 21/08/16.
 */

public class Trie {

    public static final int ALPHABET_SIZE = 'z' - 'a';

    Node root = null;

    public static int charToIndex(char c){
        return 'z' - c;
    }

    public static class Node{
        Node[] children = new Node[ALPHABET_SIZE];
//        boolean isLeaf;
        char val;

        public Node(char val) {
            this.val = val;
        }
    }

    public Trie() {
        this.root = new Node('*');
    }

    public Node getRoot(){
        return  root;
    }

    public void insert(String s){
        recursiveInsert(root, s);
    }

    void recursiveInsert(Node n, String s){
        if(s.length() == 0){
            return;
        }

        char c = s.charAt(0);

        if( null == n.children[charToIndex(c)]){
            n.children[charToIndex(c)] = new Node(c);
        }

//        if(){
//
//        }
        recursiveInsert(n.children[charToIndex(c)], s.length() > 1 ? s.substring(1) : s);
    }

}
