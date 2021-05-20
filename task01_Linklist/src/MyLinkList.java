// Note：同一个文件内只能有 1 个public类


// 节点类 Node
    class LinkNode<T> {
        private T val;
        private LinkNode<T> next; // 注意与C++ 指针域区分

        public LinkNode() {
            // 空实现
        }

        // 有参构造函数
        public LinkNode(T v) {
            this.val = v;
            this.next = null;
            // next 执行默认构造
        }

        public T getVal() { return val; }
        public void setVal(T v) { this.val = v; }
        
        public LinkNode<T> getNext() { return next; }
        public void setNext(LinkNode<T> node) { this.next = node; }
    }

/*
 *********** 单链表类 ***************
 */
public class MyLinkList<T> {
    
    private int size;  // 链表长度
    private LinkNode<T> head; // 头节点, 不存储元素

    // 构造函数
    public MyLinkList() {
        this.size = 0; // 长度初始为0
        this.head = new LinkNode<>();  // 初始化头节点
        // 先不考虑尾节点
    }

    // 获取链表元素个数
    public int getSize() {
        return size;
    }

    // 获取头节点
    public LinkNode<T> getHead() {
        return head;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 头插
    public void addHead(T x){
        LinkNode<T> tmp = new LinkNode<>(x);
        tmp.setNext(head.getNext());
        head.setNext(tmp);
        ++size;
    }
    // 尾插
    public void addTail(T x){
        LinkNode<T> tmp = new LinkNode<>(x);
        LinkNode<T> p = head;
        while(p.getNext() != null) p = p.getNext(); // 工作指针指向尾节点
        p.setNext(tmp);
        ++size;
    }
    // 第 k 个元素后插入 x
    public void insert(int k, T x) {
        if (k > size || k < 0 ) {
            System.out.println("非法索引，插入失败");
            return;
        }
        LinkNode<T> pre = getKthNode(k);
        LinkNode<T> newNode = new LinkNode<>(x);
        newNode.setNext(pre.getNext());
        pre.setNext(newNode);
        ++size;
        if (k == 0){
            System.out.println("在链表头部插入元素：" + x + " 成功");
        }
        else {
            System.out.println("在链表第" + k + "个节点后插入元素：" + x + " 成功");
        }
    }

    // 查找第k个节点
    public LinkNode<T> getKthNode (int k){
        if (k > size || k < 0 || isEmpty()) {
            if (isEmpty()) {
                System.out.println("空链表，查找失败");
            }
            else {
                System.out.println("非法索引，查找失败！");
            }
            return null;
        }
        // k = 0时，返回 head
        LinkNode<T> p = head;
        while (k != 0) {
            p = p.getNext();
            --k;
        }
        return p;
    }

    // 查找值为 x 的节点, 若存在多个满足条件的节点, 返回第一个
    public LinkNode<T> searchNodeByVal(T x) {
        if (isEmpty()) return null;
        LinkNode<T> p = head.getNext();
        while(p != null) {
            if (p.getVal() == x) break;
            p = p.getNext();
        }
        if (p == null) {
            return null;
        }
        else {
            return p;
        }
    }

    // 修改第k个节点
    public void renewKthNode (int k, T x){
        LinkNode<T> p = getKthNode(k);
        // 是否查找成功
        if ( p != null ) {
            System.out.println("修改第" + k + "个节点为" + x);
            p.setVal(x);
        }
    }

    // 删除第k个节点, 返回删除的元素值
    public T deleteNodeByIdx(int k) {
        if (k > size || k < 1) {
            System.out.println("非法索引！删除失败 ");
            return null;
        }

        LinkNode<T> p = getKthNode(k-1);
        LinkNode<T> tmp = p.getNext(); // 待删除元素
        p.setNext(p.getNext().getNext());
        tmp.setNext(null);
        --size;
        System.out.println("删除元素：" + tmp.getVal() + " 成功");
        return tmp.getVal();
    }

    // 删除值为 x 的节点
    public void deleteNodeByVal(T x) {
        LinkNode<T> p = head;
        System.out.println("删除值为" + x + "的节点");
        while (p != null){
            // 循环结束条件, p.next == null 或 p.next 的值为 x
            while (p.getNext() != null && p.getNext().getVal() != x) {
                p = p.getNext();
            }
            // 未找到
            if (p.getNext() == null) return;
            // 待删除节点位于链表末尾
            else if(p.getNext().getNext() == null) {
                p.setNext(null);
            }
            else {
                LinkNode<T> tmp = p.getNext();
                p.setNext(tmp.getNext());
                tmp.setNext(null);
            }
            --size;
            p = p.getNext(); // 可能存在多个相同元素
        }
    }

    public void clear() {
        System.out.println("清空链表！");
        head.setNext(null);
        size = 0;
    }

    public boolean isContain(T x) {
        if (isEmpty()) return false;
        LinkNode<T> p = head.getNext();
        while(p != null) {
            if (p.getVal() == x) break;
            p = p.getNext();
        }
        if (p == null) {
            System.out.println("值为" + x + "的节点不存在！");
            return false;
        }
        else {
            System.out.println("值为" + x + "的节点存在！");
            return true;
        }
    }

    // 打印链表
    public void myPrintList() {
        if(isEmpty()){
            System.out.println("The list is empty! ");
        }
        else{
            for(LinkNode<T> node = head.getNext(); node != null; node = node.getNext())
                System.out.print(node.getVal() + " ");
            System.out.println();
        }
    }

    //  测试函数
    // public static void main(String[] args) {
        // // 初始化整型链表
        // MyLinkList<Integer> list = new MyLinkList<>();

        // for (int i = 1; i < 10; ++i) {
            // list.addHead(i);
        // }
        // System.out.println("list 元素个数： " + list.getSize()); // 获取长度
        // list.myPrintList();

        // int k = 2;
        // LinkNode<Integer> node = list.getKthNode(k);
        // System.out.println("第 " + k + " 个元素为：" + node.getVal());

        // // 判断元素是否存在
        // list.isContain(5);
        // list.isContain(10);

        // list.deleteNodeByIdx(2);
        // list.myPrintList();

        // list.addTail(100);
        // list.myPrintList();
        // list.addTail(2);
        // list.myPrintList();
        // System.out.println("当前链表长度：" + list.getSize());

        // list.deleteNodeByVal(2);
        // list.myPrintList();
        // System.out.println("当前链表长度：" + list.getSize());

        // list.renewKthNode(3, 999);
        // list.myPrintList();

        // list.insert(0,3);
        // list.myPrintList();
        // node = list.searchNodeByVal(100); // 返回值为100的节点
        // node.setVal(1000); // 修改节点值
        // list.myPrintList();

        // list.clear(); // 清空链表
        // list.myPrintList();
    // }
}
