import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) {

    }
    private static class Node{
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    //层序遍历第一种方法
    //在一棵二叉树里面，层序遍历时先将根结点放入队列，当根结点的左和右不为空时，就弹出队首元素，再将根节点的左和右入队列，
    // 继续弹出队首元素，如此循环，直至层序遍历完该二叉树，若根结点的左和右为空的话，弹出队首元素后，打印，结束循环。
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>(); //需要引入Queue包
        queue.offer(root);//当根结点不为空时，就将根结点入队列
        while(!queue.isEmpty()){ //当队列不为空时
            Node cur=queue.poll();//弹出队首元素，并将队首元素赋值给cur
            System.out.print(cur.val+" ");//打印队首元素
            if(cur.left!=null){
                queue.offer(cur.left);//如果根节点的左孩子不为空，就将该左孩子入队列
            }
            if(cur.right!=null){
                queue.offer(cur.right);//如果根节点的右孩子不为空，就将该右孩子入队列
            }
        }
        System.out.println();
    }
    //层序遍历第二种方法：返回值为list类型
    //将每一层的数据都放进一个list中，然后将这些list再放进一个大的list中
    public static List<List<Character>> levelOrder1(Node root){
        List<List<Character>> ret=new LinkedList<>();  //ret是大的list
        if(root==null){return ret;}
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);//将根结点入队列
        while(!queue.isEmpty()){
            // 1.求当前队列的大小,size
            int size=queue.size();//求队列当前的大小
            List<Character> list=new ArrayList<>();
            // 2.while(size>0)  ---->控制当前每一层的数据个数
            while(size>0) {
                Node cur = queue.poll();//当队列里有元素时，就将该队列的首元素出队列
                if(cur!=null){  //当cur的值不为空时
                    list.add(cur.val);//就将cur里的元素放进list里
                    if(cur.left!=null){
                        queue.offer(cur.left);//将cur.left入队列
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
                size--;//刚刚队列里面有一个元素，现在--后就没有了，所以跳出这层循环
            }
            ret.add(list);//将list里的元素放进大的list中
        }
        return ret;//最终队列为空时，循环终止，返回大list，若是代码看不懂就将代码仔细的口头运行一遍，会懂的！
    }
}
