public class CSArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_CAPACITY = 4;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public CSArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E value) {
        // TODO: student implementation
    }

    @Override
    public void add(int index, E value) {
        // TODO: student implementation
    }

    @Override
    public E get(int index) {
        // TODO: student implementation
        return null;
    }

    @Override
    public E remove(int index) {
        // TODO: student implementation
        return null;
    }

    @Override
    public int size() {
        // TODO: student implementation
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO: student implementation
        return false;
    }

    /**
     * Returns a simple view of every backing-array slot for debugging.
     */
    public String debugView() {
        StringBuilder view = new StringBuilder();
        view.append("size: ").append(size).append(System.lineSeparator());
        view.append("capacity: ").append(data.length).append(System.lineSeparator());

        for (int index = 0; index < data.length; index++) {
            view.append(index).append(": ").append(data[index]);
            if (index < data.length - 1) {
                view.append(System.lineSeparator());
            }
        }

        return view.toString();
    }

    // Private helper methods may be added by students.
}
