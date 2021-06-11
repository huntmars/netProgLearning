/**
 * @FileName MyArrayList_Simplify.java
 * @Date 2021/06/09
 * @Author huntmars
 * @Des  A simplified class which implements MyList interface
 */
public class MyArrayList_Simplify<E> implements MyList<E>{
    /**
     * a constant value representing default capacity of the list
     */
    private static final int INIT_SIZE = 16;

    /**
     * capacity of list
     */
    private int mCapacity;

    /**
     * size of list, representing the num of current elements in the list
     */
    private int mSize;

    /**
     * An array to store list elements
     */
    private E[] mArr;

    /**
     * @description: Constructor without parameters
     */
    public MyArrayList_Simplify() {
        mCapacity = INIT_SIZE;
        mSize = 0;
        mArr = (E[])new Object[INIT_SIZE];
    }
    /**
     * @description: Constructor with parameters
     * @param init_capacity: initial capacity of list
     */
    public MyArrayList_Simplify(int init_capacity) throws Exception {
        if ( init_capacity < 0 ){
            throw new Exception("Invalid capacity input. ");  // 初始化失败
        }
        mCapacity = init_capacity;
        mSize = 0;
        mArr = (E[]) new Object[init_capacity];
    }

    /**
     * @description: expand the capacity of list if necessary
     */
    private void expandCapacity() throws Exception {
        if (mSize < mCapacity) return; // 不需要扩容
        int newCapacity = mSize >= Integer.MAX_VALUE/2 ? Integer.MAX_VALUE : mSize * 2;
        // 扩容失败
        if ( newCapacity == mCapacity ) {
            throw new Exception("数组容量已达上限");
        }
        else {
            E[] newArr = (E[]) new Object[newCapacity];
            System.arraycopy(mArr, 0, newArr, 0, mSize);
            mCapacity = newCapacity;
            mArr = newArr;
        }
    }

    /**
     * @description: get current size of list
     */
    @Override
    public int size() {
        return mSize;
    }

    /**
     * @description: get the value of list element with subscript idx
     * @param idx: Array subscript , start from 0
     * @return  the value of list element with subscript idx
     */
    @Override
    public E get(int idx) {
        if (idx < 0 || idx >= mSize) throw new IndexOutOfBoundsException();
        return mArr[idx];
    }

    /**
     * @description: insert an element at given position
     * @param idx: insert position
     * @param val: element to be inserted
     */
    @Override
    public void insert(int idx, E val) throws Exception {
        if (idx < 0 || idx >= mSize) throw new IndexOutOfBoundsException(); // Invalid insert position
        expandCapacity();
        System.arraycopy(mArr, idx, mArr, idx + 1, mSize - idx);
        mArr[idx] = val;
        ++mSize;
    }

    /**
     * @description: add an element at the end of list
     * @param val: element to be added
     */
    @Override
    public void add(E val) throws Exception {
        expandCapacity();
        mArr[mSize++] = val;
    }

    /**
     * @description: judge whether an element exists in the list
     * @param val: element to be judge
     */
    @Override
    public boolean isContains(E val) {
        for (E x : mArr) {
            if (val.equals(x)){
                return true;
            }
        }
        return false;
    }

    /**
     * @description: remove an element with given subscript in the list
     * @param idx: subscript of the element to be removed
     */
    @Override
    public E removeAt(int idx) {
        if (idx < 0 || idx >= mSize || this.isEmpty()) throw new IndexOutOfBoundsException();
        E ret = mArr[idx];
        mArr[idx] = null;
        if (idx != mSize - 1) {
            System.arraycopy(mArr, idx+1, mArr, idx, mSize - idx);
        }
        mSize--;
        return ret;
    }

    /**
     * @description: remove all elements with given value in the list
     * @param val: value of the element to be removed
     * @return flag: true for successfully remove
     *               false for the value does not exist in the list
     */
    @Override
    public boolean remove(E val) {
        boolean flag = false;
        // 从后往前遍历, 避免元素覆盖
        for (int i = mSize-1; i >= 0; i--) {
            if(mArr[i].equals(val)){
                removeAt(i);
                if (!flag) flag = true;
            }
        }
//        if(isContains(val)) flag = false;
        return flag;
    }

    /**
     * @description: judge if the list is empty
     * @return   true for the empty list
     *           false for there are elements in the list
     */
    @Override
    public boolean isEmpty() {
        return mSize == 0;
    }
}
