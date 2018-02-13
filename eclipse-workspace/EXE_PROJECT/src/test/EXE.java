package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EXE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pulus = sc.nextInt();
		int mainas = sc.nextInt();
		List<String> hantei = new ArrayList<String>();
		String outputString = "";
		Random rnd = new Random();
		int kekka = 0;
		// プラス作成
		for (int i = 0; i < pulus; i++) {
			kekka = 500;
			int hidari = 0;
			int migi = 0;
			while (kekka >= 100 || hantei.contains(hidari + " + " + migi + " =")
				|| hantei.contains(migi + " + " + hidari + " =")) {
				hidari = rnd.nextInt(99);
				migi = rnd.nextInt(99);
				kekka = hidari + migi;
			}
			if (hantei.contains(hidari + " + " + migi + " =")) {
				hantei.add(migi + " + " + hidari + " =");
			} else {
				hantei.add(hidari + " + " + migi + " =");
			}
			System.out.println(hidari + " + " + migi + " =");
		}
		// マイナス作成
		List<String> hanteimainasu = new ArrayList<String>();
		for (int i = 0; i < mainas; i++) {
			kekka = 500;
			int hidari = 0;
			int migi = 0;
			while (kekka >= 100 || kekka <= -1 || hanteimainasu.contains(hidari + " - " + migi + " =")
					|| hanteimainasu.contains(migi + " - " + hidari + " =")) {
				hidari = rnd.nextInt(99);
				migi = rnd.nextInt(99);
				kekka = hidari - migi;
			}
			if(hanteimainasu.contains(hidari + " - " + migi + " =")) {
				hanteimainasu.add(migi + " - " + hidari + " =");
			}else {
				hanteimainasu.add(hidari + " - " + migi + " =");
			}
			System.out.println(hidari + " - " + migi + " =");
		}
	}
}
