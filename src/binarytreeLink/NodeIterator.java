
package binarytreeLink;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NodeIterator<T> implements Iterator<T> {
  private final LinkedList<Iterator<T>> iters;

  public NodeIterator(Node<T> node) {
    iters = new LinkedList<Iterator<T>>();
    
    if (node.left.x != null)
      iters.add(node.left.x.iterator());
    if (node.getVal() != null)
      iters.add(new SingletonIterator<T>(node.getVal()));
    if (node.right.x != null)
      iters.add(node.right.x.iterator());
  }

  public boolean hasNext() {
    while (!iters.isEmpty() && !iters.getFirst().hasNext())
      iters.removeFirst();
    return !iters.isEmpty();
  }

  public T next() {
    return iters.getFirst().next();
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
