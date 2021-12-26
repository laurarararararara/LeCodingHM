/**
 * 单链表的基本操作
 * @param <E>
 */
class SingleLinekdListTakeHead<E> {

    protected Node<E> head;//头节点

    class Node<E> {
        protected E data;//数据域
        protected Node<E> next;//next引用域

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }


    //初始化head
    public SingleLinekdListTakeHead() {
        head = new Node(new Object(), null);
    }

    //在head之后直接插入一个节点，头插法
    public void addHead(E element) {
        Node<E> newNode = new Node(element, null);
        newNode.next = head.next;//先让新添加的节点的下一个指向原head节点指向的
        head.next = newNode;//再让head节点指向新节点
    }

    //尾插法
    public void addTail(E element) {
        Node<E> newNode = new Node(element, null);
        Node<E> tail = head;//定义一个节点从头走到尾
        //tail走到当前链表的尾部
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.next=null;
    }

    /**
     * 固定位置插入一个节点
     * 判断参数合法性
     * 找到pos位置的前一个节点
     * @param pos  固定位置
     * @param element  元素
     */
    public void addPos(int pos, E element) {
        if (pos <= 0 || pos > getLength()) {
            return;
        }
        Node<E> prev = head.next;
        int index = 1;

        while (index++ < pos - 1) {
            prev = prev.next;
        }
        Node<E> newNode = new Node<>(element, null);
        newNode.next = prev.next;
        prev.next = newNode;
    }
    //删除元素为element的节点
    public boolean remove(E element) {
        //如果只有一个头结点，返回false
        if (head.next == null) {
            return false;
        }
        //找到该元素所对应的节点 + 该元素所对应的节点的前一个
        //从头结点开始遍历
        Node<E> tmp = head;

        while (tmp != null) {
            if (tmp.next != null && tmp.next.data == element) {
                //tmp.next是我们要删除的节点 tmp是删除节点的前一个
                tmp.next = tmp.next.next;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //设置某个位置的值为newElement
    public void set(int pos, E newElement){
        if(pos <= 0 || pos > getLength()){
            return;
        }
        //找pos位置的节点
        Node<E> tmp = head.next;
        for(int i=1; i < pos; i++){
            tmp = tmp.next;
        }
        tmp.data = newElement;
    }
    //得到某个元素的值
    public E get(E element){
        Node<E> tmp = head.next;//从有效节点开始遍历

        while(tmp != null){
            if(tmp.data == element){
                return tmp.data; //找到的话，返回该节点
            }
            tmp = tmp.next;
        }
        return null;
    }
    //返回长度
    public int getLength() {
        Node<E> tmp = head.next;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    //打印栈
    public String toString() {
        StringBuilder strs = new StringBuilder();

        Node<E> tmp = head.next;
        while (tmp != null) {
            strs.append(tmp.data + " ");
            tmp = tmp.next;
        }
        return strs.toString(); //strs是StringBuilder类型，应该添加toString方法，才能返回String类型的
    }
    //判断是否有环
    public boolean hasCycle() {
	        //声明两个节点从头开始遍历节点==
        Node quick = head;
        Node slow = head;
        //当快指针能够走到头表示无环
        while(quick!=null&&quick.next!=null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick==slow){
                return true;
            }
        }
        return false;
    }
    // 判断链表成环，并且求出环内节点
    public Node<E> isLoop(){
        Node<E> fast = head , slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return fast;
            }
        }
        return null;
    }
    //返回环的入口
    public Node<E> getIntersectNode(){
        Node<E> meet =isLoop();
        if(meet == null){
            return null;
        }
        Node<E> p = meet;
        Node<E> q = head;
        while (p!=q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public Node<E> getHead(Node head, int n){
        Node<E> fast = head , slow = head;
        // 先让快指针走n步
        while(n--!=0){
            fast=fast.next;
        }
        // 如果快指针走到了最后说明删除的是第一个节点,就返回head.next就好
        if(fast==null){
            return head.next;
        }
        // 使得slow每次都是在待删除的前一个节点, 所以要先让fast先走一步
        fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // 因为已经保证了是待删除节点的前一个节点, 直接删除即可
        slow.next=slow.next.next;
        return head;
    }
    //合并两个有序链表
    public Node<Integer> mergeTwoLists(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node<Integer> res = l1.data < l2.data ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.data >= l2.data ? l1 : l2);
        return res;
    }

    /**合并k个有序链表, l1:0>mid的链表 l2:mid+1>right
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * @param lists
     * @return
     */
    public Node mergeKLists(Node[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length/2;
        Node[] l1 = new Node[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        Node[] l2 = new Node[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }
    /**
     * 两两交换链表中的节点
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     */
    public Node swapPairs(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}

public class Linked {
    //逆置链表
    public static <E> void reversePrint(SingleLinekdListTakeHead.Node head) {
        if (head == null) {
            return;
        }
        //提取重复的逻辑
        reversePrint(head.next);
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        SingleLinekdListTakeHead<Integer> list=new SingleLinekdListTakeHead();
        list.addHead(3);
        list.addHead(5);
        list.addHead(8);
        System.out.println(list.toString());//8 5 3
        reversePrint(list.head);


        list.addTail(1);
        list.addTail(2);
        list.addTail(4);
        System.out.println(list.toString());//8 5 3 1 2 4

        list.addPos(2, 100); //在2 号位置加入元素100
        System.out.println(list.toString());
        list.addPos(0, 1000);
        System.out.println(list.toString());

        list.remove(4);
        System.out.println("删除值为4的元素:"+list.toString());

        list.set(2,2);//true,把2号元素的值改为2
        System.out.println("把2号元素的值改为2:"+list.toString());
        System.out.println(list.get(3));
    }

}
