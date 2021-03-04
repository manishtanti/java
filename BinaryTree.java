import java.util.Stack;

public class BinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
        
    }

    public static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data + "  ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void main(String[] args)throws Exception{
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root= new Node(arr[0],null,null);
        Pair rp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rp);
        int idx=0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==1){
                if(arr[++idx]!=null){
                    Node ln=new Node(arr[idx],null,null);
                    top.node.left=ln;
                    st.push(new Pair(ln,1));
                }
                
                top.state++;
            } else if(top.state==2){
                if(arr[++idx]!=null){
                    Node rn = new Node(arr[idx],null,null);
                    top.node.right=rn;
                    st.push(new Pair(rn,1));
                }
                
                top.state++;
            } else{
                st.pop();
            }
        }
        
        preorder(root);
    }
    
}
