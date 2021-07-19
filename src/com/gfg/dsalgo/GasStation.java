package com.gfg.dsalgo;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Optimal solution
		int tank = 0;
		for (int i = 0; i < gas.length; i++)
			tank += gas[i] - cost[i];
		if (tank < 0)
			return -1;

		int start = 0;
		int accumulate = 0;
		for (int i = 0; i < gas.length; i++) {
			int curGain = gas[i] - cost[i];
			if (accumulate + curGain < 0) {
				start = i + 1;
				accumulate = 0;
			} else
				accumulate += curGain;
		}

		return start;
	}

	public int canCompleteCircuitNaive(int[] gas, int[] cost) {
		int gasReqBefPath = 0;
		for (int i = 0; i < gas.length; i++) {
			if (canCompleteCircuit(gas, cost, i, gasReqBefPath)) {
				return i;
			}
			gasReqBefPath += cost[i] - gas[i];
		}
		return -1;
	}

	public boolean canCompleteCircuit(int[] gas, int[] cost, int point, int gasReqBefPath) {
		int count = 0;
		int gasRem = 0;
		while (count <= gas.length) {
			gasRem += gas[point];
			if (gasRem < cost[point])
				return false;
			gasRem -= cost[point];
			if (point == gas.length - 1) {
				if (gasRem >= gasReqBefPath)
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