package test;

import java.util.Scanner;

public class boxtest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int hako = sc.nextInt();
		int hankei = sc.nextInt();
		String[] box = new String[hako];
		for (int i = 0; i < box.length; i++) {
			box[i] = sc2.nextLine();
		}
		// 判定
		boolean okng = true;
		int indexnumber = 0;
		for (String kekka : box) {
			okng = true;
			String[] bunkatu = kekka.split(" ");
			for (int j = 0; j < bunkatu.length; j++) {
				if (hankei > Integer.parseInt(bunkatu[j])) {
					okng = false;
					break;
				}
			}
			if (okng) {
				System.out.println(indexnumber+1);
			}
			indexnumber += 1;
		}
	}
}
