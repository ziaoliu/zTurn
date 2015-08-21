package leetcode;

/*
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class Q071_SimplifyPath {
	public static void main(String[] args) {
		Q071_SimplifyPath test = new Q071_SimplifyPath();
		Solution s = test.new Solution();
		System.out.println(s.simplifyPath("/a/./b/../../c/"));
	}

	public class Solution {
		public String simplifyPath(String path) {
			if (path == null || path.length() == 0)
				return path;
			String[] array = path.split("/");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				String dir = array[i];
				if (dir.equals("."))
					array[i] = "";
				else if (dir.equals("..")) {
					array[i] = "";
					for (int j = i - 1; j >= 0; j--) {
						if (array[j].equals(""))
							continue;
						array[j] = "";
						break;
					}
				}
			}
			for (int i = 0; i < array.length; i++) {
				if (!array[i].equals(""))
					sb.append("/").append(array[i]);
			}
			if (sb.length() == 0)
				sb.append("/");

			return sb.toString();
		}
	}
}
