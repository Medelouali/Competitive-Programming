package com.adria.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsSearch {
    public static void main(String[] args) {
        DfsSearch.Node root=new DfsSearch.Node(0);
        DfsSearch.Node root1=new DfsSearch.Node(1);
        DfsSearch.Node root2=new DfsSearch.Node(2);
        DfsSearch.Node root3=new DfsSearch.Node(3);
        root.addNeiborsNodes(List.of(root1, root2, root3));

        DfsSearch.Node root4=new DfsSearch.Node(4);
        DfsSearch.Node root5=new DfsSearch.Node(5);
        DfsSearch.Node root6=new DfsSearch.Node(6);
        root4.addNeiborsNodes(List.of(root5, root6));
        root3.addNeiborsNodes(List.of(root4));

        DfsSearch.Node root7=new DfsSearch.Node(7);
        DfsSearch.Node root8=new DfsSearch.Node(8);
        DfsSearch.Node root9=new DfsSearch.Node(9);
        root7.addNeiborsNodes(List.of(root8, root9));
        root4.addNeiborsNodes(List.of(root7));
        root7.addNeiborsNodes(List.of(root));

        bfsSearch(root);
    }

    public static void bfsSearch(DfsSearch.Node root){
        Queue<DfsSearch.Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            DfsSearch.Node currentNode=queue.poll();
            currentNode.processNode();
            currentNode.visitNode();
            for(DfsSearch.Node node: currentNode.getNeighborsNodes()){
                if(!node.isVisited)queue.add(node);
            }
        }
    }
}
