package leetcode;

/*
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.

 http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html
 https://leetcodenotes.wordpress.com/2013/11/21/leetcode-gas-station-%E8%BD%AC%E5%9C%88%E7%9A%84%E5%8A%A0%E6%B2%B9%E7%AB%99%E7%9C%8B%E8%83%BD%E4%B8%8D%E8%83%BD%E8%B5%B0%E4%B8%80%E5%9C%88/
 */
public class Q134_GasStation {
	public class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			if (gas == null || cost == null || gas.length == 0
					|| cost.length == 0 || gas.length != cost.length)
				return -1;
			int total = 0;
			int sum = 0;
			int index = 0;
			int i = 0;
			for (; i < gas.length; i++) {
				int diff = gas[i] - cost[i];
				sum = sum + diff;
				if (sum < 0) {
					index = i + 1;
					sum = 0;
				}
				total = total + diff;
			}
			return total < 0 ? -1 : index;
		}
	}

	public class SolutionOn {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			if (gas == null || cost == null || gas.length == 0
					|| cost.length == 0 || gas.length != cost.length)
				return -1;

			int start = 0;
			int count = 0;
			int tank = 0;
			while (start < gas.length && count < gas.length) {
				int index = (start + count) % gas.length;
				if (count == 0 && gas[start] - cost[start] < 0) {
					start++;
					continue;
				}
				tank = tank + gas[index] - cost[index];
				if (tank < 0) {
					tank = 0;
					start++;
					count = 0;
					continue;
				}
				count++;
				if (count == gas.length)
					return start;
			}

			return -1;
		}
	}

	public class SolutionOnsquare {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			if (gas == null || cost == null || gas.length == 0
					|| cost.length == 0 || gas.length != cost.length)
				return -1;
			for (int i = 0; i < gas.length; i++) {
				int distance = 0;
				int tank = 0;
				if (gas[i] - cost[i] >= 0)
					for (int j = 0; j < gas.length; j++) {
						int stop = (i + j) % gas.length;
						tank = tank + gas[stop] - cost[stop];
						if (tank < 0)
							break;
						distance++;
						if (distance == gas.length)
							return i;
					}
			}
			return -1;
		}
	}
}
