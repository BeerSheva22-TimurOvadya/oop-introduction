package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> extends AbstractCollection<T> implements Sorted<T> {
	static private class Node<T> {
		T obj;
		Node<T> parent;
		Node<T> left;
		Node<T> right;

		Node(T obj) {
			this.obj = obj;
		}
	}

	private class TreeSetIterator implements Iterator<T> {
		Node<T> current = root;
		Node<T> prev = root;
		boolean flNext = false;

		TreeSetIterator() {
			if (current != null) {
				current = getLeastNode(current);
			}
		}

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T res = current.obj;
			prev = current;
			current = getNextCurrent(current);
			flNext = true;
			return res;
		}
		
		@Override
		public void remove() {
			if (!flNext) {
				throw new IllegalStateException();
			}
			if (prev.left != null && prev.right != null) {
				current = prev;
			}
			removeNode(prev);
			flNext = false;
			
		}

	}

	private Node<T> root;
	private Comparator<T> comp;

	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}

	private Node<T> getNextCurrent(Node<T> current) {

		return current.right == null ? getGreaterParent(current) : getLeastNode(current.right);
	}

	private Node<T> getGreaterParent(Node<T> current) {
		while (current.parent != null && current.parent.left != current) {
			current = current.parent;
		}
		return current.parent;
	}

	private Node<T> getLeastNode(Node<T> current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
	

	@SuppressWarnings("unchecked")
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	@Override
	public boolean add(T element) {
		boolean res = false;
		Node<T> parent = getNode(element);
		int compRes = 0;
		if (parent == null || (compRes = comp.compare(element, parent.obj)) != 0) {
			res = true;
			size++;
			Node<T> node = new Node<>(element);
			node.parent = parent;
			if (parent == null) {
				root = node;
			} else {
				if (compRes < 0) {
					parent.left = node;
				} else {
					parent.right = node;
				}
			}
		}

		return res;
	}

	private Node<T> getNode(T element) {
		Node<T> current = root;
		Node<T> parent = null;
		int compRes;
		while (current != null && (compRes = comp.compare(element, current.obj)) != 0) {
			parent = current;
			current = compRes < 0 ? current.left : current.right;
		}
		return current == null ? parent : current;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;		
		Node<T> node = getNode(pattern);
		if (node != null && comp.compare(node.obj, pattern) == 0) {
			res = true;
			removeNode(node);
		}		
		return res;
	}

	private void removeNode(Node<T> node) {
		if ( node.right != null && node.left != null) {
			removeParentNode(node);
		} else {
			removeChildrenNode(node);
		}
		size--;		
	}

	private void removeChildrenNode(Node<T> node) {
		Node<T> child = node.left != null ?  node.left : node.right ;
		Node<T> parent = node.parent;	
		if (child != null) {
			child.parent = parent;
		}
		else if(parent == null) {
			root = child;
		} else {
			if (parent.left != node) {
				parent.right = child;
			} else {				
				parent.left = child;
			}
		}		
		
	}

	private void removeParentNode(Node<T> node) {
		Node<T> replacement = getLeastNode(node.right);
		node.obj = replacement.obj;
		removeChildrenNode(replacement);
		
	}

	@Override
	public boolean contains(T pattern) {
		Node<T> node = getNode(pattern);
		return node != null && comp.compare(pattern, node.obj) == 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new TreeSetIterator();
	}

	@Override
	public T floor(T element) {
		if (root == null) {
			return null;
		}
		Node<T> res = getNode(element);
		int compRes = comp.compare(element, res.obj);
		if (res != null && compRes < 0) {
			res =  getLessParent(res);
		}
		return res != null ? res.obj : null;
	}

	private Node<T> getLessParent(Node<T> node) {
		while (node.parent != null && node.parent.right != node) {
			node = node.parent;
		}
		return node.parent;
	}

	@Override
	public T ceiling(T element) {
		if (root == null) {
			return null;
		}
		Node<T> res = getNode(element);
		int compRes = comp.compare(element, res.obj);
		if (res != null && compRes > 0) {
			res =  getGreaterParent(res);
		}
		return res != null ? res.obj : null;
	}

	@Override
	public T first() {
		return root == null ? null : getLeastNode(root).obj;
	}

	@Override
	public T last() {		
		if (root == null) {			
			return null;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root.obj;
	}

}