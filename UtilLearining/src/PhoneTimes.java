import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/comments/
 * "23" 2:abc 3:def
 */
public class PhoneTimes {
    public static void main(String[] args) {
        PhoneTimes phoneTimes = new PhoneTimes();
        System.out.println(phoneTimes.letterCombinations("23"));
        System.out.println(phoneTimes.letterCombinations("a"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            if(digits.charAt(i)<='z'&& digits.charAt(i)>='a'){
                return list;
            }
        }
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(list,digits, numString, 0);
        return list;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(List<String> list,String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(list,digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
