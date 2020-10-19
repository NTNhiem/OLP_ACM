package BerSUBall;

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
		int res = 0;
		int[] boys = new int[102];
		for (int i = 0; i < n; i++) {
			boys[sc.nextInt()]++;
		}
		int m = sc.nextInt();
		int[] girls = new int[102];
		for (int i = 0; i < m; i++) {
			girls[sc.nextInt()]++;
		}
		
		for (int i = 1; i <= 100; i++) {
			res += doPair(boys, girls, i, i-1);
			res += doPair(boys, girls, i, i);
			res += doPair(boys, girls, i, i+1);
		}
		System.out.println(res);
	}
	
	static int doPair(int[] boys, int[] girls ,int boyPos , int girlPos ) {
		int boyNumber = boys[boyPos];
		int girlNumber = girls[girlPos];
		
		int pair = girlNumber <= boyNumber? girlNumber : boyNumber;
		boys[boyPos] -= pair;
		girls[girlPos] -= pair;
		return pair;
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
