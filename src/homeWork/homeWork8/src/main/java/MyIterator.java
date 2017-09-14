

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MyIterator<T> implements Iterator<T> {
    private List<T> list;
    private int count;

    public MyIterator(List<T> list) {
        this.list = list;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count != list.size();
    }

    @Override
    public T next() {
        if (count == list.size()) {
            return null;
        } else {
            return list.get(count++);
        }
    }

    @Override
    public void remove() {
        list.remove(count);
    }

   /* @Override
    public void forEachRemaining(Consumer<? super T> action) {

        while (this.hasNext())
            this.next();

    }
*/
}
