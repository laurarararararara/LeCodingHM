/**
 * 找到最长的回文子串
 * 判断字符串是否为回文串
 */
public class LongestSubString {
    public static void main(String[] args) {
        String s="abcde";
        System.out.println(s.substring(0,1));
        String s1="abcbae";
      //  System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
        System.out.println(isPlalindrome("ababa"));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static  int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return (R-1) - (L+1) + 1;
    }

    //判断字符串是否为回文串
    public static boolean isPlalindrome(String str) {
        //将字符串转化为字符数组
        char[] array=str.toCharArray();
        int left=0,right=array.length-1;//记录数组的开始位置和结束位置
        while(left<right)//开始位置小于结束位置时，进行判断  两位置处于对称位置上
        {
            if(array[left++]!=array[right--])//如果两位值的字符不相同 则不对称
                return false;//返回false
        }
        //所有位除奇数位时的中间位均对应 返回true
        return true;
    }
}
