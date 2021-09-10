package GeeksForGeeks.Stacks;

public interface InterfaceStack <E> {
    int size();
    boolean isEmpty();
    void push(E data);
    E pop();
    E peek();//returns top element . We can use E for generics
}
