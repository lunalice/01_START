package test;

import java.util.Scanner;

public class tadanomi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		boolean okng = true;
		while (okng) {
			line = sc.nextLine();
			if (2 <= line.length() && line.length() <= 100) {
				okng = false;
			}
		}
		String buff = line.substring(0, 1);
		String mozi = line.replaceAll(buff, "");
		System.out.println(mozi.length());
		System.out.println(line.length());
		System.out.println((line.length()-mozi.length()));
		if ((line.length()-mozi.length()) == line.length()) {
			System.out.println("NG");
		} else {
			System.out.println("OK");
		}
	}
}