/**
 * A small list ADT used by multiple implementations in CS 2050.
 *
 * @param <E> the type of element stored in the list
 */
public interface SimpleList<E> {

    void add(E value);

    void add(int index, E value);

    E get(int index);

    E remove(int index);

    int size();

    boolean isEmpty();
}
