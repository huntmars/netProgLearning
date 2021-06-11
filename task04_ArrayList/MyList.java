/*
 * Date: 2021/06/10
 * Auth: darkwill
 * Desc: A list interface with basic method
 */

public interface MyList<T>{

    int size();

    T get(int idx);

    void insert(int idx, T val) throws Exception;

    void add(T val) throws Exception;

    boolean isContains(T val);

    T removeAt(int idx);

    boolean remove(T val);

    boolean isEmpty();
}
