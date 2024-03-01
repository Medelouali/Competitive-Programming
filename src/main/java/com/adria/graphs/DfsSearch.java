package com.adria.graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class DfsSearch {
    public static void main(String[] args) {
        Node root=new Node(0);
        Node root1=new Node(1);
        Node root2=new Node(2);
        Node root3=new Node(3);
        root.addNeiborsNodes(List.of(root1, root2, root3));

        Node root4=new Node(4);
        Node root5=new Node(5);
        Node root6=new Node(6);
        root4.addNeiborsNodes(List.of(root5, root6));
        root3.addNeiborsNodes(List.of(root4));

        Node root7=new Node(7);
        Node root8=new Node(8);
        Node root9=new Node(9);
        root7.addNeiborsNodes(List.of(root8, root9));
        root4.addNeiborsNodes(List.of(root7));
        root7.addNeiborsNodes(List.of(root));

        Node.dfsSearch(root);
    }

    public static class Node{
        int data;
        boolean isVisited;
        List<Node> neiborsNodes=new ArrayList();

        Node(int data){
            this.data=data;
        }

        Node(int data, List<Node> neiborsNodes){
            this.data=data;
            this.neiborsNodes=neiborsNodes;
        }

        public static void dfsSearch(Node root){
            Stack<Node> dfsStack=new Stack<>();
            dfsStack.push(root);

            while(!dfsStack.isEmpty()){
                Node currentNode=dfsStack.pop();
                currentNode.processNode();
                currentNode.visitNode();
                for(Node node: currentNode.getNeiborsNodes()){
                    if(!node.isVisited) dfsStack.push(node);
                }
            }
        }

        public int getData(){
            return this.data;
        }

        public List<Node> getNeiborsNodes(){
            return this.neiborsNodes;
        }

        public void visitNode(){
            this.isVisited=true;
        }

        public void addNeiborsNodes(List<Node> nodes){
            this.neiborsNodes.addAll(nodes);
        }

        public void processNode(){
            System.out.println("Processing node with data "+getData());
        }
    }
}
