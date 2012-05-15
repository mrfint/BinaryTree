
package binarytreeLink;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NodeIterator<T> implements Iterator<T> {
  private final List<Iterator<T>> iters;

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
    while (!iters.isEmpty() && !iters.get(0).hasNext())
      iters.remove(0);
    return !iters.isEmpty();
  }

  public T next() {
    if (!hasNext()) System.out.println("No such element");
    return iters.get(0).next();
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
