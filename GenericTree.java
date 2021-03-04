import java.util.*;
public class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }

    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child:node.children){
            str+=child.data + ", ";
        }
        str+=".";
        System.out.println(str);
        for(Node child:node.children){
            display(child);
        }
    }

    public static int GenericTreeSize(Node node){
        int s=0;

        for(Node child:node.children){
            s+=GenericTreeSize(child);
        }
        return 1+s;
    }
    public static int Maximum(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child:node.children){
            int temp=Maximum(child);
            max = Math.max(max,temp);
        }
        return Math.max(max,node.data);
    }
    public static int Height(Node node){
        int h=-1;
        for(Node child:node.children){
            h=Math.max(h,Height(child));
        }
        return 1 + h;
    }
    public static boolean find(Node node,int val){
        if(node.data==val){
            return true;
        }
        for(Node child:node.children){
            if(find(child,val)){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> rootToNodePath(Node node,int val){
        if(node.data==val){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(node.data);
            return temp;
        }
        for(Node child:node.children){
            ArrayList<Integer> ptc = rootToNodePath(child, val);
            if(ptc.size()>0){
                ptc.add(node.data);
                return ptc;
            }

        }
        ArrayList<Integer> nf = new ArrayList<>();
        return nf;
    }
    
    public static void PreAndPostOrder(Node node){
        Stack<Pair> st = new Stack<>();
        Pair rp=new Pair(node, -1);
        st.push(rp);
        String pre="";
        String post="";

        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==-1){
                pre += top.node.data+"  ";
                top.state++;
            } else if(top.state==top.node.children.size()){
                post+=top.node.data+"  ";
                st.pop();
            } else{
                st.push(new Pair(top.node.children.get(top.state),-1));
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }
    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }else{
                Node temp=new Node();
                temp.data=arr[i];
                 if(st.size()>0){
                    st.peek().children.add(temp);
                 } else{
                    root=temp;
                 }
                 st.push(temp);
            }
        }
        // display(root);
        // System.out.println(GenericTreeSize(root));

        // System.out.println(Maximum(root));

        // System.out.println(Height(root));

        // System.out.println(find(root,30));

        // ArrayList<Integer> li = new ArrayList<>();
        // li = rootToNodePath(root,30);
        // System.out.println(li);

        PreAndPostOrder(root);
    }
    
}
