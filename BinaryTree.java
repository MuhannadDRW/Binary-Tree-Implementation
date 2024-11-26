
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}


public class BinaryTree {

    Node parent;
    Node root;

    public void insert(int data){
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data){

        if (root == null){
            root = new Node(data);
        }
        else if(data > root.data){
            root.right = insertRec(root.right, data);
        }
        else if (data < root.data) {
            root.left = insertRec(root.left, data);
        }

        return root;
    }

    public void inOrderShow(){
        inOrderShowRec(root);
    }

    private void inOrderShowRec(Node root){
        if(root != null){
            inOrderShowRec(root.left);
            System.out.print(root.data + " ");
            inOrderShowRec(root.right);
        }
    }


    public void delete(int data){
        Node delete = find(root, data);
        if (delete.data > root.data){
            root.right = delete.right;
            if(delete.left != null){
                delete.right.left.left = delete.left;
            }
        }
        else if (delete.data < root.data){
            root.left = delete.right;
            if(delete.left != null){
                delete.right.left.left = delete.left;
            }
        }
        else{
            root = delete.right;
            if(delete.left != null){
                if(root.left == null) {
                    root.left = delete.left;
                }
                else {
                    root.left.left = delete.left;
                }
            }
        }

    }

    private Node find(Node root, int data){
        if(root.data < data){
            parent = root;
            root = find(root.right, data);
        }

        else if(root.data > data){
            parent = root;
            root = find(root.left, data);
        }

        return root;
    }



}
