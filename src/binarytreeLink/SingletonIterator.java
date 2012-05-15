
package binarytreeLink;

import java.util.Iterator;

class SingletonIterator<T> implements Iterator<T> {
  private T value;

  public SingletonIterator(T value) {
    this.value = value;
  }

  public boolean hasNext() {
    return value != null;
  }

  public T next() {
//    if (value == null)
//      throw new NoSuchElementException();
    T result = value;
    value = null;
    return result;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}