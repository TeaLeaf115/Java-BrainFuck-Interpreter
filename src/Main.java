import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Main {
	static final char[] array = new char[30_000];
	static int i = 0;
	
	public static void main(String[] args) {
		try {
			String data = "";
			
			Scanner fNameInp = new Scanner(System.in);
			
			System.out.println("What file do you want to run?:");
			File f = new File(fNameInp.nextLine());
			while (!f.exists() || f.isDirectory() || !f.getName().substring(f.getName().indexOf('.')).equals(".bf")) {
				System.out.println("That file either does not exist, is a directory or is not a BrainFuck file.\nPlease try again: ");
				f = new File(fNameInp.nextLine());
			}
			for (int i = 0; i <= 1_000; i++) {
				System.out.printf("\033[%dA",1); // Move up
				System.out.print("\033[2K"); // Erase line content
			}
			
			Scanner inp = new Scanner(f);
			while (inp.hasNextLine())
				data += inp.nextLine();
			inp.close();
			data = data.replaceAll("[^+\\-<>,.\\[\\]]", "");
			handleData(data.toCharArray());
			fNameInp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void handleData(char[] chArr) throws Exception {
		Stack<Integer> loopStack = new Stack<>();
		for (int j = 0; j < chArr.length; j++) {
			switch (chArr[j]) {
				case ('>') -> i++;
				case ('<') -> {
					i--;
					if (i < 0)
						i = array.length - 1;
				}
				case ('+') -> array[i]++;
				case ('-') -> array[i]--;
				case ('.') -> System.out.print(array[i]);
				case (',') -> array[i] = (char) System.in.read();
				case ('[') -> loopStack.push(j);
				case (']') -> {
					if (loopStack.isEmpty())
						throw new BrainFuckNotOpenedLoopException();
					int loopStart = loopStack.pop() + 1;
					while (array[i] != 0)
						handleData(Arrays.copyOfRange(chArr, loopStart, j));
				}
				default -> {}
			}
		}
		if (!loopStack.isEmpty())
			throw new BrainFuckNotClosedLoopException();
	}
	
	protected static class BrainFuckNotOpenedLoopException extends Exception{}
	
	protected static class BrainFuckNotClosedLoopException extends Exception {}
}
