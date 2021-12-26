import java.util.HashMap;
import java.util.HashSet;

/**
 * 2021/11/25/3
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 * 输入: s = "pwwkew"
 * 输出: 3
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 查找字符串数组中的最长公共前缀
 */
public class NoRepeatSubString {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(strStr(s,"ew"));
//        System.out.println(lengthOfLongestSubstring(s));
//        String s1="";
//        System.out.println(lengthOfLongestSubstring(s1));
//        String s2="abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s2));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=0 || s==null ||s==""){
            return 0;
        }
        int count=1;
        //添加进hashset，返回长度
        HashSet<Character> objects = new HashSet<Character>();
        StringBuilder sbd = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(objects.add(s.charAt(i))){
                sbd.append(s.charAt(i));
            }
        }
        return sbd.length();
    }
    /**
     *  https://leetcode-cn.com/problems/longest-common-prefix/comments/
     *  编写一个函数来查找字符串数组中的最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
    /**
     *  https://leetcode-cn.com/problems/implement-strstr/
     *  实现 strStr() 函数。
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     */
    public static int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
