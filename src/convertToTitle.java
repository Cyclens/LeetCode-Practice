class Solution {
    public String convertToTitle(int n) {
        String res = null;
        while (n >= 0){
            int temp = 0;
            temp = n % 26 - 1;
            res = res + "A" + temp;
            n -= temp;
            n /= 26;
        }
        return res;
    }
}