package leetcode;

import java.util.ArrayList;

/* Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * 
 */
public class RestoreIPAddressesOJ {
	public static void main(String[] args) {
		RestoreIPAddressesOJ test = new RestoreIPAddressesOJ();
		SolutionMine solution = test.new SolutionMine();
		System.out.println(solution.restoreIpAddresses("1234"));
	}

	// my own solution: DFS
	public class SolutionMine {
		public ArrayList<String> restoreIpAddresses(String s) {
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<Integer> temp = new ArrayList<Integer>();

			if (s == null || s.length() <= 3 || s.equals(""))
				return result;

			dfs(result, s, 0, temp, -1);

			return result;
		}

		public void dfs(ArrayList<String> result, String s, int i,
				ArrayList<Integer> temp, int lastPosition) {
			if (i == 4) {
				StringBuilder sb = new StringBuilder();
				for (Integer sec : temp) {
					sb.append(sec).append(".");
				}
				sb.delete(sb.length() - 1, sb.length());
				if (!result.contains(sb.toString()))
					result.add(sb.toString());
				return;
			}

			// try 1 digit, and then 2, and 3
			for (int index = 0; index < 3; index++) {
				int section = 0;
				if (lastPosition + 1 > s.length()
						|| lastPosition + 2 + index > s.length())
					return;
				if (i != 3) {
					String number = s.substring(lastPosition + 1, lastPosition
							+ 2 + index);
					if (number.equals("") || number.length() > 3
							|| (number.startsWith("0") && number.length() > 1))
						return;
					section = Integer.parseInt(number);

				} else {
					String number = s.substring(lastPosition + 1);
					if (number.equals("") || number.length() > 3
							|| (number.startsWith("0") && number.length() > 1))
						return;
					section = Integer.parseInt(number);
				}
				if (section > 255)
					return;

				temp.add(section);
				dfs(result, s, i + 1, temp, lastPosition + 1 + index);
				temp.remove(temp.size() - 1);
			}

		}
	}
}
