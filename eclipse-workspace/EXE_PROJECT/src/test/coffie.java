package test;

import java.util.Scanner;

public class coffie {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double nedan = sc.nextInt();
		double waribiki = sc.nextInt();
		waribiki = waribiki / 100;
		waribiki = 1-waribiki;
		System.out.println(waribiki);
		double kaisu = nedan;
		while (nedan != 0) {
			nedan = (int) Math.floor(nedan * waribiki);
			kaisu = kaisu + nedan;
		}
		System.out.println((int) kaisu);
	}
}
