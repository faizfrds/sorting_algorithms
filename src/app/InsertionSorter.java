package app;

import java.util.Comparator;


public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO sort

		for (int i = 1; i < list.size(); ++i) {

			int j = i;

			while (j > 0 && list.compare(j, j-1, comparator) < 0) {
				
				// Swap numbers[j] and numbers[j - 1]
		
				list.swap(j, j-1);
				
				--j;
			}
		}

		return list;
	}


}
