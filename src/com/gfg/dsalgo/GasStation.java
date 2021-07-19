package com.gfg.dsalgo;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int extraGasReq = 0;
		for (int i = 0; i < gas.length; i++) {
			if (canCompleteCircuit(gas, cost, i, extraGasReq)) {
				return i;
			}
			extraGasReq += cost[i] - gas[i];
		}
		return -1;
	}

	public boolean canCompleteCircuit(int[] gas, int[] cost, int point, int extraGasReq) {
		int count = 0;
		int gasRem = 0;
		while (count <= gas.length) {
			gasRem += gas[point];
			if (gasRem < cost[point])
				return false;
			gasRem -= cost[point];
			if (point == gas.length - 1) {
				if (gasRem >= extraGasReq)
					return true;
				else
					return false;
			} else {
				point++;
			}
			count++;
		}
		return true;
	}
}