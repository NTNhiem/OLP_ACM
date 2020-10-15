package DZYLovesSequences;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int n = sc.nextInt();
		long[] sequence = new long[n];
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = sc.nextLong();
		}
		int result = 0;
		if (n <= 2) {
			result = n;
		} else {
			result = solve(sequence, n);
		}
		System.out.println(result);
	}
 
	static int solve(long[] sequence, int n) {
		int max = Integer.MIN_VALUE;
		int[] lengthL = new int[n];
		int[] lengthR = new int[n];
		lengthL[1] = lengthLeft(sequence, 1);
		for (int i = 2; i < lengthL.length; i++) {
			if (sequence[i - 1] > sequence[i - 2]) {
				lengthL[i] = lengthL[i - 1] + 1;
			} else {
				lengthL[i] = 1;
			}
		}
		lengthR[n - 2] = lengthRight(sequence, n - 2);
		for (int i = n - 3; i >= 0; i--) {
			if (sequence[i + 1] < sequence[i + 2]) {
				lengthR[i] = lengthR[i + 1] + 1;
			} else {
				lengthR[i] = 1;
			}
		}
		for (int i = 1; i < sequence.length - 1; i++) {
 
			if (sequence[i + 1] - sequence[i - 1] >= 2) {
				max = Math.max(max, lengthL[i] + lengthR[i] + 1);
			} else {
				max = Math.max(max, Math.max(lengthL[i], lengthR[i]) + 1);
			}
		}
		max = Math.max(max, Math.max(lengthL[0], lengthR[0]) + 1);
		max = Math.max(max, Math.max(lengthL[n - 1], lengthR[n - 1]) + 1);
		return max;
	}
 
	static int lengthLeft(long[] sequence, int i) {
		int length = 1;
		int j = i - 1;
		if (j - 1 < 0) {
			return 1;
		}
		while (j - 1 >= 0) {
			if (sequence[j] > sequence[j - 1]) {
				length++;
			} else {
				break;
			}
			j--;
		}
		return length;
	}
 
	static int lengthRight(long[] sequence, int i) {
		int length = 1;
		int j = i + 1;
		if (j + 1 >= sequence.length) {
			return 1;
		}
		while (j + 1 < sequence.length) {
			if (sequence[j] < sequence[j + 1]) {
				length++;
			} else {
				break;
			}
			j++;
		}
		return length;
	}
 
	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;
 
		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}
 
		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}
 
		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
		}
 
		public String nextLine() throws IOException {
			return reader.readLine();
		}
 
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
 
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
