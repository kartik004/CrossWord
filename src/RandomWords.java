import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomWords {

	private static char[][] randomStrings;
	private static int ros;
	private static int col;
	public static StringBuilder first = new StringBuilder();
	public static ArrayList<String> arrayList1 = new ArrayList<>();
	public static ArrayList<String> arrayList2 = new ArrayList<>();
	public static ArrayList<String> arrayList3 = new ArrayList<>();
	public static LinkedList<String> listDictionary = new LinkedList<>();
	public static AvlTree<String> avlTreeDictionary = new AvlTree<>();
	public static QuadraticProbingHashTable<String> probingHashDictionary = new QuadraticProbingHashTable<>();
	public static PrintWriter pw1, pw2, pw3;
	public static File file1, file2, file3;

	public static char[][] randomWords(int rows, int cols) {
		ros = rows;
		col = cols;
		
		randomStrings = new char[ros][col];

		Random random = new Random();

		for (int i = 0; i < randomStrings.length; i++) {
			for (int j = 0; j < randomStrings[0].length; j++) {

				randomStrings[i][j] = (char) ('a' + random.nextInt(26));
				System.out.print(randomStrings[i][j] + " ");
			}

			System.out.println();

		}
		return randomStrings;

	}

	public static void Moves(Object object) {
		first = new StringBuilder();
		for (int i = 0; i < randomStrings.length; i++) {
			for (int j = 0; j < randomStrings[i].length; j++) {
				first.setLength(0);
				/////// DOWN
				/////// MOVEMENT//////////////////////////////////////////////////
				/////// /////////
				for (int r = i, c = j; r < randomStrings.length; r++) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				////// RIGHT MOVEMENT
				////// ///////////////////////////////////////////////////////////
				for (int r = i, c = j; c < randomStrings[i].length; c++) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				///// UP
				///// MOVEMENT///////////////////////////////////////////////////////////////
				for (int r = i, c = j; r >= 0; r--) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				// LEFT
				// MOVEMENT////////////////////////////////////////////////////////////////
				for (int r = i, c = j; c >= 0; c--) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				// DIAGONAL RIGHT
				// MOVEMENT////////////////////////////////////////////////////////
				for (int r = i, c = j; c < randomStrings.length && r < randomStrings.length; c++, r++) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				// DIAGONAL LEFT DOWN
				// MOVEMENT////////////////////////////////////////////////////
				for (int r = i, c = j; c >= 0 && r < randomStrings.length; c--, r++) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				// DIAGONAL LEFT DOWN
				// MOVEMENT/////////////////////////////////////////////////////
				for (int r = i, c = j; c >= 0 && r >= 0; c--, r--) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
				first.setLength(0);
				// DIAGONAL LEFT UP
				// MOVEMENT//////////////////////////////////////////////////////////
				for (int r = i, c = j; c < randomStrings[i].length && r >= 0; c++, r--) {
					first.append(randomStrings[r][c]);
					if (object instanceof LinkedList<?>) {
						matchLinkList(first.toString());
					} else if (object instanceof AvlTree<?>) {
						matchAvlTree(first.toString());
					} else if (object instanceof QuadraticProbingHashTable<?>) {
						matchHashTree(first.toString());
					}
				}
			}
		}
	}

	static {
		file1 = new File("MatchedWords_LinkedList.txt");
		file2 = new File("MatchedWords_Tree.txt");
		file3 = new File("MatchedWords_Hash.txt");

		try {
			pw1 = new PrintWriter(file1);
			pw2 = new PrintWriter(file2);
			pw3 = new PrintWriter(file3);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////// MACTHING STRINGS
	/////////////////////////////////////////////////////// WITH LINKLIST
	/////////////////////////////////////////////////////// DICTIONARY/////////////////////////////////////////
	public static void matchLinkList(String str) {

		if (listDictionary != null) {
			for (Iterator iterator = listDictionary.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				if (str.equals(string)) {
					pw1.println(str);
					arrayList1.add(str);
				}
			}
		} else
			System.out.println("LinkList is Empty");
	}

	/////////////////////////////////////////////////////// MACTHING STRINGS
	/////////////////////////////////////////////////////// WITH AVL
	/////////////////////////////////////////////////////// DICTIONARY/////////////////////////////////////////
	public static void matchAvlTree(String str) {

		if (avlTreeDictionary.contains(str)) {
			pw2.println(str);
			arrayList2.add(str);
		}
	}

	/////////////////////////////////////////////////////// MACTHING STRINGS
	/////////////////////////////////////////////////////// WITH HASH TABLE
	/////////////////////////////////////////////////////// DICTIONARY/////////////////////////////////////////
	public static void matchHashTree(String str) {
		if (probingHashDictionary.contains(str)) {
			pw3.println(str);
			arrayList3.add(str);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RandomWords randomWords = new RandomWords();
		Scanner scanner = new Scanner(System.in);
		BufferedReader bufferedReader = null;
		String line = null;
		try {
			bufferedReader = new BufferedReader(
					new FileReader("C:\\Users\\Kartik Rajput\\workspace\\ProjectCrossWord\\Dictionary.txt"));
			while ((line = bufferedReader.readLine()) != null) {

				// System.out.println(line);
				listDictionary.add(line);
				avlTreeDictionary.insert(line);
				probingHashDictionary.insert(line);

			}
		} catch (FileNotFoundException fnfex) {
			System.out.println(fnfex.getMessage() + " " + "File Not Found");
			System.exit(0);
		}

		System.out.println("Enter the number of Rows");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of Columns");
		int cols = scanner.nextInt();
		randomWords.randomWords(rows, cols);

		long start = System.currentTimeMillis();
		randomWords.Moves(avlTreeDictionary);
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Number of records" + " " + arrayList2.size());
		System.out.println("For AVL Tree, Elapsed time in ms: " + (end - start));
		System.out.println();

		/*
		 * for (Iterator iterator = arrayList2.iterator(); iterator.hasNext();)
		 * { String string = (String) iterator.next();
		 * System.out.println("AVLTree" + " " + string);
		 * 
		 * }
		 */

		start = System.currentTimeMillis();
		randomWords.Moves(probingHashDictionary);
		end = System.currentTimeMillis();
		System.out.println("Number of records" + " " + arrayList3.size());
		System.out.println("For Hash Table, Elapsed time in ms: " + (end - start));
		System.out.println();

		start = System.currentTimeMillis();
		randomWords.Moves(listDictionary);
		end = System.currentTimeMillis();
		end = System.currentTimeMillis();
		System.out.println("Number of records:" + " " + arrayList1.size());
		System.out.println("For List, Elapsed time in ms: " + (end - start));
		System.out.println();

		// System.out.println("Hello");
		/*
		 * for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();)
		 * { String string = (String) iterator.next();
		 * System.out.println("LinkList" + " " + string);
		 * 
		 * }
		 */

		pw1.close();
		pw2.close();
		pw3.close();

		System.out.println("The matched words are in the following files: ");
		System.out.println("a) Linked List- " + file1.getAbsolutePath());
		System.out.println("b) Tree- " + file2.getAbsolutePath());
		System.out.println("c) Hash Table- " + file3.getAbsolutePath());
	}

}
