package Tree;

/**
 * Created by yunlong on 2/25/16.
 */
// A binary tree node
class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BoundryTreeTraversal {
    private Node rootNode = null;
    public static void main(String [] args){
        BoundryTreeTraversal btt = new BoundryTreeTraversal();
        btt.addNode(btt.rootNode, 100);
        btt.addNode(btt.rootNode, 50);
        btt.addNode(btt.rootNode, 150);
        btt.addNode(btt.rootNode, 25);
        btt.addNode(btt.rootNode, 75);
        btt.addNode(btt.rootNode, 140);
        btt.addNode(btt.rootNode, 30);
        btt.addNode(btt.rootNode, 70);
        btt.addNode(btt.rootNode, 80);
        btt.addNode(btt.rootNode, 35);
        btt.addNode(btt.rootNode, 200);
        btt.printBoundary(btt.rootNode);
    }

    public void printBoundary(Node n){
        if(n != null){
            printRoot(n);

            if(n.left != null)
                printLeft(n.left);

            printLeaf(n);

            if(n.right != null)
                printRight(n.right);
        }
    }

    public void printRoot(Node node){
        System.out.print(node.data + "\t");
    }

    public void printLeft(Node node){
        if(node == null)
            return;

        if(node.left == null && node.right == null)
            return;

        System.out.print(node.data + "\t");

        if(node.left == null){
            printLeft(node.right);
        } else {
            printLeft(node.left);
        }
    }

    public void printRight(Node node){
        if(node == null)
            return;

        if(node.left == null && node.right == null)
            return;

        if(node.right == null){
            printRight(node.left);
            System.out.print(node.data + "\t");
        } else {
            printRight(node.right);
            System.out.print(node.data + "\t");
        }
    }

    public void printLeaf(Node node){
        if(node == null) return;

        if(node.left == null && node.right == null){
            System.out.print(node.data + "\t");
            return;
        }
        printLeaf(node.left);
        printLeaf(node.right);
    }

    //###################################################
    //##HELPING FUNCTION FOR ADDING NODE TO BINARY TREE##
    //###################################################

    private void addNode(Node rootNode, int data){
        if(rootNode==null){
            Node temp1 = new Node(data);
            this.rootNode = temp1;
        }else{
            addNodeInProperPlace(rootNode, data);
        }
    }

    private void addNodeInProperPlace(Node rootNode, int data){
        if(data>rootNode.data){
            if(rootNode.right!=null){
                addNode(rootNode.right, data);
            }else{
                Node temp1 = new Node(data);
                rootNode.right = temp1;
            }
        } else if(data<rootNode.data){
            if(rootNode.left!=null){
                addNode(rootNode.left, data);
            }else{
                Node temp1 = new Node(data);
                rootNode.left = temp1;
            }
        }
    }
}
