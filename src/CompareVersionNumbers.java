
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        int n = Math.max(vers1.length, vers2.length);
        for (int i = 0; i < n; i++) {
        	int k = i < vers1.length? Integer.parseInt(vers1[i]) : 0;
        	int l = i < vers1.length? Integer.parseInt(vers1[i]) : 0;
        	if (k > l) {
        		return 1;
        	}
        	else if (k < l) {
        		return -1;
        	}
        }
        return 0;
    }
}
