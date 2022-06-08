package com.gfg.dsalgo.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RopeCuttingProblem {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		System.out.println("MaxRopes : " + maxRopes(num, a, b, c));
	}

	private static int maxRopes(int num, int a, int b, int c) {
		if (num == 0) {
			return 0;
		}
		if (num < a && num < b && num < c) {
			return -1;
		}
		int res1 = maxRopes(num - a, a, b, c) >= 0 ? maxRopes(num - a, a, b, c) + 1 : maxRopes(num - a, a, b, c);
		int res2 = maxRopes(num - b, a, b, c) >= 0 ? maxRopes(num - b, a, b, c) + 1 : maxRopes(num - b, a, b, c);
		int res3 = maxRopes(num - c, a, b, c) >= 0 ? maxRopes(num - c, a, b, c) + 1 : maxRopes(num - c, a, b, c);
		return Math.max(res1, Math.max(res2, res3));

	}
}

//7
//2, 3, 5
//2 2 2 not(2)
//2 2 3
