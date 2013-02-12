import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class _MainTest extends TestCase {
	Random r;
	Main m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r = new Random();
		m = new Main();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandom() {
		for (int f = 0; f < 100; f++) {
			int numberOfInput = r.nextInt(20) + 1;
			int[] A = new int[numberOfInput];
			for (int i = 0; i < numberOfInput; i++) {
				A[i] = r.nextInt(30);
			}
			int key = r.nextInt(30);
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int i : A) {
				a.add(i);
			}
//			System.out.println((a.contains(key)) ? 1 : 0);
			assertEquals((a.contains(key)) ? 1 : 0, m.ComboSearch(A, key));
		}
	}

	@Test
	public void testPair() {
		// int[] v1 = {1,2};
		// int[] v2 = {9,10};
		// int[] v3 = {8,6};
		// int[] v4 = {7,5};
		// int[] v5 = {4,5};
		// int[] k = { 1, 10 };

		int[][] tupler = { { 1, 2 }, { 9, 10 }, { 8, 6 }, { 7, 3 }, { 4, 5 },
		 { 11, 12 }, { 19, 20 }, { 18, 16 }, { 17, 13 }, { 14, 15 },
		 { 21, 22 }, { 28, 30 }, { 28, 26 }, { 27, 23 }, { 24, 25 },
		 { 31, 32 }, { 39, 40 }, { 38, 36 }, { 37, 33 }, { 34, 35 },
		 { 1, 29 } };

		ArrayList<Array> testSuite = new ArrayList<Array>();

		// No one changed
		int[] array = new int[tupler.length];
		for (int f = 0; f < tupler.length; f++) {
			array[f] = tupler[f][0];
		}
		testSuite.add(new Array(array));

		for (int i = 0; i < tupler.length; i++) {
			array = new int[tupler.length];
			for (int j = 0; j < tupler.length; j++) {
				if (j == i) {
					array[j] = tupler[j][1];
				} else {
					array[j] = tupler[j][0];
				}
			}
			testSuite.add(new Array(array));
		}

		for (int j = 0; j <= tupler.length -1; j++) { // looping through all
													// values
			array = new int[tupler.length];
			for (int f = 0; f < j; f++) { // Not changing values
				array[f] = tupler[f][0];
			}
			array[j] = tupler[j][1];
			for (int n = j + 1; n < tupler.length; n++) {
				int[] array1 = new int[tupler.length];
				for (int i = 0; i <= j; i++) {
					array1[i] = array[i];
				}
				for (int m = j + 1; m < tupler.length; m++) {
					if (m == n) {
						array1[m] = tupler[m][1];
					} else {
						array1[m] = tupler[m][0];
					}
				}
				testSuite.add(new Array(array1));
			}
		}

		for (Array testCase : testSuite) {
			array = new int[tupler.length - 1];
			for (int i = 0; i < tupler.length -1; i++)
				array[i] = testCase.array[i];
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int i : array) {
				a.add(i);
			}
			 System.out
			 .println((a.contains(testCase.array[tupler.length - 1])) ? 1 : 0);
			assertEquals((a.contains(testCase.array[tupler.length - 1])) ? 1
					: 0,
					m.ComboSearch(array, testCase.array[tupler.length - 1]));
		}
	}

	private class Array {
		public int[] array;

		public Array(int[] array) {
			this.array = array;
		}

		@Override
		public String toString() {

			String s = "Array: [";
			for (int i : array)
				s += "" + i + " ";
			s += "] \n";
			return s;
		}
	}

}
