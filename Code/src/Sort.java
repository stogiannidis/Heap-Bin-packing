public class Sort{
	public static <T extends Comparable<T>> DLinkedList<T> sort(DLinkedList<T> list) {
		
		if(list.size() <= 1) {
            return list;
        }
		
		DLinkedList<T> left   = new DLinkedList<T>();
        DLinkedList<T> right  = new DLinkedList<T>();
        DLinkedList<T> result = new DLinkedList<T>();
		
		int middle = list.size() / 2;
		
		int added = 0;
        for(T item: list) {
            if(added++ < middle)
			left.add(item);
            else
			right.add(item);
        }
		left = sort(left);
        right = sort(right);

        result = merge(left, right);
		
		return result;
		
	}
	
	private static <T extends Comparable<T>> DLinkedList<T> merge(DLinkedList<T> left, DLinkedList<T> right) {
		
		DLinkedList<T> result = new DLinkedList<T>();
		 while(left.size() > 0 && right.size() > 0) {
            if(left.peekFirst().compareTo(right.peekFirst()) < 0)
				result.add(left.removeFirst());
            else
                result.add(right.removeFirst());
        }
		
		 if(left.size() > 0)
		 	result.addList(left);
        else
            result.addList(right);

        return result;
	}
	/*
	public static void main(String[] args) {
		DLinkedList<Integer> d = new DLinkedList<Integer>();
		d.add(1);
		d.add(12);
		d.add(5);
		d.add(6);
		d.add(2);
		d.add(4);
		d.add(45);
		d.add(1);
		d.add(15);
		d.add(3);
		d = sort(d);
		System.out.println(d.toString());
	}
	*/
}   