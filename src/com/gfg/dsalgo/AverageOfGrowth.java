package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class AverageOfGrowth {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("SIP Amount : ");
		int sipAmt = Integer.parseInt(br.readLine());
		System.out.println("Yearly Increase : ");
		int yearlyIncrease = Integer.parseInt(br.readLine());
		System.out.println("Years for which avg req : ");
		int years = Integer.parseInt(br.readLine());

		int avgSipAmt = sipAmt;
		int totalSipAmt = sipAmt;
		System.out.println("Year : 0, Sip Amt : " + avgSipAmt);
		for (int i = 1; i < years; i++) {
			avgSipAmt += avgSipAmt * yearlyIncrease/100;
			totalSipAmt += avgSipAmt;
			System.out.println("Year : " + i + ", Sip Amt : " + avgSipAmt + ", Total Amt : " + totalSipAmt);
		}
		System.out.println("Avg SIP Amt : " + totalSipAmt / years);

	}
}
