package com.adria.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node{
    int data;
    boolean isVisited;
    List<Node> neighborsNodes =new ArrayList();

    Node(int data){
        this.data=data;
    }

    Node(int data, List<Node> neighborsNodes){
        this.data=data;
        this.neighborsNodes = neighborsNodes;
    }

    public static void dfsSearch(Node root){
        Stack<Node> dfsStack=new Stack<>();
        dfsStack.push(root);

        while(!dfsStack.isEmpty()){
            Node currentNode=dfsStack.pop();
            currentNode.processNode();
            currentNode.visitNode();
            for(Node node: currentNode.getNeighborsNodes()){
                if(!node.isVisited) dfsStack.push(node);
            }
        }
    }

    public int getData(){
        return this.data;
    }

    public List<Node> getNeighborsNodes(){
        return this.neighborsNodes;
    }

    public void visitNode(){
        this.isVisited=true;
    }

    public void addNeiborsNodes(List<Node> nodes){
        this.neighborsNodes.addAll(nodes);
    }

    public void processNode(){
        System.out.println("Processing node with data "+getData());
    }
}
