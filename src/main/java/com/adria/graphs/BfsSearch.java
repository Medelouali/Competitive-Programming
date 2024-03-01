package com.adria.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsSearch {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        root.addNeiborsNodes(List.of(root1, root2, root3));

        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        root4.addNeiborsNodes(List.of(root5, root6));
        root3.addNeiborsNodes(List.of(root4));

        Node root7 = new Node(7);
        Node root8 = new Node(8);
        Node root9 = new Node(9);
        root7.addNeiborsNodes(List.of(root8, root9));
        root4.addNeiborsNodes(List.of(root7));
        root7.addNeiborsNodes(List.of(root));


        bfsSearch(root);
    }

    public static void bfsSearch(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode=queue.poll();
            currentNode.processNode();
            currentNode.visitNode();
            for(Node node: currentNode.getNeighborsNodes()){
                if(!node.isVisited)queue.add(node);
            }
        }
    }
}
