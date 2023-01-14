package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> extends AbstractCollection<T> implements Set<T> {
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
		Node<T> current;

		public TreeSetIterator() {
			if (root != null) {
				current = getLeastNode(root);
			} else {
				current = root = null;
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
			if (current.right != null) {
				current = getLeastNode(current.right);
			} else {
				current = getParent(current);
			}
			return res;
		}

		private Node<T> getLeastNode(Node<T> node) {
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}

		private Node<T> getParent(Node<T> node) {
			while (node.parent != null && node.parent.left != node) {
				node = node.parent;
			}
			return node.parent;
		}

	}

	private Node<T> root;
	private Comparator<T> comp;

	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}

	@SuppressWarnings("unchecked")
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	@Override
	public boolean add(T element) {
		boolean res = false;
		Node<T> newNode = new Node<>(element);
		Node<T> parentOrNode = getParentOrNode(element);
		int resOfCompar = 0;
		if (parentOrNode == null) {
			root = newNode;
		} else if ((resOfCompar = comp.compare(element, parentOrNode.obj)) != 0) {
			if (resOfCompar > 0) {
				parentOrNode.right = newNode;
			} else {
				parentOrNode.left = newNode;
			}
			res = true;
			newNode.parent = parentOrNode;
		}
		size++;
		return res;
	}

	private Node<T> getParentOrNode(T element) {
		Node<T> current = root;
		Node<T> parent = null;
		while (current != null) {
			parent = current;
			int resOfCompar = comp.compare(element, current.obj);
			if (resOfCompar == 0) {
				break;
			}
			current = choiceOfMoving(current, resOfCompar);
		}
		return parent;
	}

	private Node<T> choiceOfMoving(Node<T> current, int resOfCompar) {
		return current = resOfCompar > 0 ? current.right : current.left;
	}

	@Override
	public boolean remove(T pattern) {
		// Not implemented yet
		return false;
	}

	@Override
	public boolean contains(T pattern) {
		Node<T> node = getParentOrNode(pattern);
		int resOfCompar = comp.compare(pattern, node.obj);
		return node != null && resOfCompar == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new TreeSetIterator();
	}

}
