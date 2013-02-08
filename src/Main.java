import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.BinaryRefAddr;
import javax.naming.ldap.SortControl;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader;

		reader = new BufferedReader(new InputStreamReader(System.in));
		Main main = new Main();
		String type = reader.readLine();
		if (type.equals("search")) {
			String[] arrayString = reader.readLine().trim().split("\\s+");
			int key = Integer.parseInt(reader.readLine().trim());
			int[] A = new int[arrayString.length];
			for (int i = 0; i < arrayString.length; i++) {
				A[i] = Integer.parseInt(arrayString[i]);
			}

			System.out.println("" + main.BinarySearch(A, key));
		} else if (type.equals("sort")) {
			String[] arrayString = reader.readLine().trim().split("\\s+");
			int[] A = new int[arrayString.length];
			for (int i = 0; i < arrayString.length; i++) {
				A[i] = Integer.parseInt(arrayString[i]);
			}
			A = main.Sort(A);
			for (int i : A) {
				System.out.print(i + " ");
			}
			System.out.println("");
		} else if (type.equals("combo")) {
			String[] arrayString = reader.readLine().trim().split("\\s+");
			int key = Integer.parseInt(reader.readLine().trim());
			int[] A = new int[arrayString.length];
			for (int i = 0; i < arrayString.length; i++) {
				A[i] = Integer.parseInt(arrayString[i]);
			}

			System.out.println("" + main.ComboSearch(A, key));
		}
	}

	public int ComboSearch(int[] A, int key) {
		// TODO Auto-generated method stub
		return BinarySearch(Sort(A), key);
	}

	public int BinarySearch(int[] A, int key) {
		int x;
		int l = 0; //Mutation 4: l = 1 should be l=0;
		int r = A.length - 1;
		
		if (A.length == 0 || key < A[l] || key > A[r]) { 
			return 0;
		}
		do {
			x = (l + r) / 2;
			if (key < A[x]) { // Mutation 5: > should be <;
				r = x - 1; // Mutation 1: r = x should be r=x-1;
			} else {
				l = x + 1;
			}
		} while (key != A[x] && l <= r); // Mutation 3: || should be && (last);

		if (key == A[x]) {
			return 1;
		} else {
			return 0;
		}
	}

	public int[] Sort(int[] A) {
		int tmp;

		for (int i = 1; i < A.length; i++) { //Mutation 2: int i = 0 should be int i = 1
			tmp = A[i];
			int j;
			for (j = i - 1; (j >= 0) && A[j] > tmp; j--) {
				A[j + 1] = A[j];
			}
			A[j + 1] = tmp;//Mutation 6: A[j] = tmp should be A[j+1] = tmp
		}

		return A;
	}

}
