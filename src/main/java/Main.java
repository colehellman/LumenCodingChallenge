import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    String parent;
    String number;
    String name;
    Node left, right;

    public Node(String parent, String number, String name) {
        this.parent = parent;
        this.number = number;
        this.name = name;
        left = right = null;
    }
}

class FamilyTree {
    Node root;
    FamilyTree(String parent, String number, String name) {
        root = new Node(parent, number,name);
    }

    FamilyTree() {
        root = null;
    }

    void inorder(Node root){
        if(root==null)
            return;
        System.out.println(root.name);
        inorder(root.left);
        inorder(root.right);
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = new Scanner(new File("src/main/resources/family.txt"));
        read.useDelimiter("\\|");
        String parent, name, node, number;
        FamilyTree tree = new FamilyTree();
        Map<String, Node> mp = new HashMap<>();
        while(read.hasNext())
        {
            node = read.next();
            String[] array = node.split(",");
            parent = array[0];
            number = array[1];
            name = array[2];
            Node temp = new Node(parent, number, name);
            if(parent.equalsIgnoreCase("null"))
                 tree.root = temp;
            else{
                    Node parentNode = mp.get(parent);
                    if(parentNode.left == null)
                        parentNode.left = temp;
                    else
                        parentNode.right = temp;
            }
            mp.put(number, temp);
        }
        read.close();
        tree.inorder(tree.root);

    }
}
