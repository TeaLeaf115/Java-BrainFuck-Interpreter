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
			File f = new File("bf_files/[YOUR FILE HERE].bf"); // PUT YOUR FILE HERE
			Scanner inp = new Scanner(f);
			while (inp.hasNextLine())
				data += inp.nextLine();
			inp.close();
			data = data.replaceAll("[^\\+\\-\\<\\>\\,\\.\\[\\]]", "");
			handleData(data.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void handleData(char[] chArr) throws Exception {
		Stack<Integer> loopStack = new Stack<>();
		for (int j = 0; j < chArr.length; j++) {
			switch (chArr[j]) {
				case ('>'):
					i++;
					break;
				case ('<'):
					i--;
					break;
				case ('+'):
					array[i]++;
					break;
				case ('-'):
					array[i]--;
					break;
				case ('.'):
					System.out.print(array[i]);
					break;
				case (','):
					array[i] = (char) System.in.read();
					break;
				case ('['):
					loopStack.push(j);
					break;
				case (']'):
					if (loopStack.isEmpty())
						throw new BrainFuckNotOpenedLoopException();
					int loopStart = loopStack.pop() + 1;;
					while (array[i] != 0)
						handleData(Arrays.copyOfRange(chArr, loopStart, j));
					break;
				default:
					break;
			}
		}
		if (!loopStack.isEmpty())
			throw new BrainFuckNotClosedLoopException();
	}
	
	protected static class BrainFuckNotOpenedLoopException extends Exception {
		public BrainFuckNotOpenedLoopException() {
			super();
		}
	}
	
	protected static class BrainFuckNotClosedLoopException extends Exception {
		public BrainFuckNotClosedLoopException() {
			super();
		}
	}
}