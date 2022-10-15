package lab7.singlylinkedset;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SinglyLinkedSet<E> implements Set<E> {
    private Node<E> head;
    private int size;

    public SinglyLinkedSet() {
        this.head = null;
        this.size = 0;
    }

    public SinglyLinkedSet(E element) {
        this.head = new Node<>(element);
        this.size = 1;
    }

    public SinglyLinkedSet(Collection<? extends E> c) {
        this.head = null;
        this.size = 0;
        this.addAll(c);
    }

    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            head = new Node<>(e, head);
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int sizeBefore = size;
        for (E e : c) {
            this.add(e);
        }
        return size != sizeBefore;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            head = null;
            size = 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean contains(Object o) {
        for (E e : this) {
            if (Objects.equals(o, e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set<?> set = (Set<?>) o;
        return this.size() == set.size() && this.containsAll(set);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (E e : this) {
            hashCode += e.hashCode();
        }
        return hashCode;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Set.super.forEach(action);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;
            private Node<E> previous;
            private Node<E> previousPrevious;
            private boolean nextCalled;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E element = current.getData();
                previousPrevious = previous;
                previous = current;
                current = current.getNext();
                nextCalled = true;
                return element;
            }

            @Override
            public void remove() {
                if (previous == null || !nextCalled) {
                    throw  new IllegalStateException();
                }
                if (previousPrevious == null) {
                    head = current;
                } else {
                    previousPrevious.setNext(current);
                }
                size--;
                nextCalled = false;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                Iterator.super.forEachRemaining(action);
            }
        };
    }

    @Override
    public boolean remove(Object o) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E currentElement = iterator.next();
            if (Objects.equals(o, currentElement)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int sizeBefore = size;
        for (Object o : c) {
            remove(o);
        }
        return size != sizeBefore;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int sizeBefore = size;
        for (E e : this) {
            if (!c.contains(e)) {
                remove(e);
            }
        }
        return size != sizeBefore;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Spliterator<E> spliterator() {
        return Set.super.spliterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (E e : this) {
            array[index] = e;
            index++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] result = a;
        if (this.size() > result.length) {
            result = new Object[this.size()];
        }
        int index = 0;
        for (E e : this) {
            result[index] = e;
            index++;
        }
        if (result.length > index) {
            result[index] = null;
        }
        return (T[]) result;
    }

    @Override
    public String toString() {
        return "SinglyLinkedSet{" +
                "elements=" + Arrays.toString(this.toArray()) +
                ", size=" + size +
                '}';
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Set.super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return Set.super.removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return Set.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return Set.super.parallelStream();
    }
}
