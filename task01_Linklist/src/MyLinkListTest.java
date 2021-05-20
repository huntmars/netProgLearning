
// test类
public class MyLinkListTest {
    
    public static void main(String[] args) {
        // 初始化整型链表
        MyLinkList<Integer> list = new MyLinkList<>();

        for (int i = 1; i < 10; ++i) {
            list.addHead(i);
        }
        System.out.println("list 元素个数： " + list.getSize()); // 获取长度
        list.myPrintList();

        int k = 2;
        LinkNode<Integer> node = list.getKthNode(k);
        System.out.println("第 " + k + " 个元素为：" + node.getVal());

        // 判断元素是否存在
        list.isContain(5);
        list.isContain(10);

        // 按索引删除元素
        list.deleteNodeByIdx(2);
        list.myPrintList();

        // 尾插
        list.addTail(10);
        list.myPrintList();
        list.addTail(2);
        list.myPrintList();

        // 在指定位置插入元素
        list.insert(5,3);
        list.myPrintList();

        // 按值删除元素
        list.deleteNodeByVal(2);
        list.myPrintList();
        // System.out.println("当前链表长度：" + list.getSize());

        // 修改第k个元素的值
        k = 3;
        list.renewKthNode(k, 0);
        list.myPrintList();

        // 按值查找链表节点
        node = list.searchNodeByVal(3); // 返回值为3的节点
        node.setVal(11); // 修改节点值
        list.myPrintList();

        list.clear(); // 清空链表
        list.myPrintList();
    }
}
