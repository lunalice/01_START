package test;

import java.util.Random;
import java.util.Scanner;

public class yakyu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pulus = sc.nextInt();
		String input = "";
		int boalcount = 0;
		int strikecount = 0;
		// 投球ループ
		for (int i=0;i<pulus;i++) {
			input = sc.nextLine();
			switch(input){
				case "ball":
					boalcount += 1;
					if (boalcount==4) {
						System.out.println("fourball!");
						System.exit(0);
					}else {
						System.out.println("ball!");
					}
					break;
				case "strike":
					
					strikecount += 1;
					if (strikecount==3) {
						System.out.println("out!");
						System.exit(0);
					}else {
						System.out.println("strike!");
					}
					break;
			}
		}
	}

}
