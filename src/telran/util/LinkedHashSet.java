package telran.util;

import java.util.Iterator;


import telran.util.LinkedList.Node;

public class LinkedHashSet<T> extends AbstractCollection<T> implements Set<T> {
	HashMap<T, Node<T>> map = new HashMap<>();
	LinkedList<T> list = new LinkedList<>();
	
	private class LinkedHashSetIterator implements Iterator<T> {
		Iterator<T> listIterator = list.iterator();
		T Element;
		
		@Override
		public boolean hasNext() {
			return listIterator.hasNext();
		}

		@Override
		public T next() {
			return Element = listIterator.next();
		}
		
		@Override
		public void remove() {
			map.remove(Element);
			listIterator.remove();
			size--;
		}
	}
	
	@Override
	public boolean add(T element) {
		boolean res = false;
		if (list.add(element)) {
			Node<T> getNode = list.getNode(size());
			if (map.putIfAbsent(element, getNode) == null) {				
				res = true;
				size++;
			} else {
				list.removeNode(getNode);
			}
		}
		return res;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		Node<T> removedNode = map.remove(pattern);
		if (removedNode != null) {
			list.removeNode(removedNode);
			res = true;
			size--;
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		return list.contains(pattern);
	}
	@Override
	public T get(T pattern) {
		return contains(pattern) ? null : pattern;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedHashSetIterator();
	}
	

	

}