package app;

import java.util.Comparator;


public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	private int partition(int low, int high){ //partition method sorts each partition accordingly

		int mid = (low + high) / 2;
		list.swap(high, mid);
		int storeIndex = low;

		for (int i = low; i < high; i++){

			if (list.compare(i, high, comparator) <= 0){
				list.swap(i, storeIndex);
				storeIndex++;
			}
		}

		list.swap(storeIndex, high);
		return storeIndex;
	}

	public void quickSort(int lowIndex, int highIndex){ //new method where recursive can be done

		if (highIndex > lowIndex){ //as long as the lower index remains lower than the high, than it is not sorted yet
			
			int lowEndIndex = partition(lowIndex, highIndex);
			quickSort(lowIndex, lowEndIndex - 1);
			quickSort(lowEndIndex + 1, highIndex);
		}

	}

	@Override
	public SwapList<T> sort() {
		// TODO sort

		if (list.size() == 0){
			return list;
		}
		quickSort(0, list.size()-1); //using first index as lowest and last index as highest
		return list;
	}
}
