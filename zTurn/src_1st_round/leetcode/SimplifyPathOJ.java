package leetcode;

/* Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * 
 */
public class SimplifyPathOJ {
	public class Solution {
		public String simplifyPath(String path) {
			if (null == path || path.equals("/"))
				return "/";
			String[] dirs = path.split("/");
			for (int i = 0; i < dirs.length; i++) {
				String dir = dirs[i];
				if (dir.equals("."))
					dirs[i] = "";
				else if (dir.equals("..")) {
					dirs[i] = "";
					for (int j = i - 1; j >= 0; j--) {
						if (dirs[j].equals(""))
							continue;
						else {
							dirs[j] = "";
							break;
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < dirs.length; i++) {
				if (dirs[i].equals(""))
					continue;
				else
					sb.append("/").append(dirs[i]);
			}
			if(sb.length()==0)
				sb.append("/");
			return sb.toString();
		}
	}
}
