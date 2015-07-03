package leetcode;

import static org.junit.Assert.*;
import leetcode.MinimumWindowSubStringOJ.Solution;

import org.junit.Test;

public class MinimumWindowSubStringOJTest {

	@Test
	public void test() {
		MinimumWindowSubStringOJ solution = new MinimumWindowSubStringOJ();
		Solution test = solution.new Solution();
		String S = "kgfidhktkjhlkbgjkylgdracfzjduycghkomrbrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyfbkoowqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvh";//"ADAOBECODEBANC";
		String T = "sgfet";//"ABC";
		long start = System.currentTimeMillis();
		System.out.println(test.minWindow(S, T));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
