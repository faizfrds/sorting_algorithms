package app;

import java.util.Comparator;


public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	private int partition(int low, int high){

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

	public void quickSort(int lowindex, int highIndex){

		if (highIndex > lowindex){

			int lowEndIndex = partition(lowindex, highIndex);
			quickSort(lowindex, lowEndIndex - 1);
			quickSort(lowEndIndex + 1, highIndex);
		}

	}

	@Override
	public SwapList<T> sort() {
		// TODO sort

		if (list.size() == 0){
			return list;
		}

		quickSort(0, list.size()-1);
		return list;
	}
}
