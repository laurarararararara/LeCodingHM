import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Stack;

/**
 *移除数组中的某元素 simple
 *整数反转 23>32 -123>-321 120>21
 *字符串的反转：StringBuffer原生的reverse方法、StringBuffer倒序拼接、利用栈的先进后出、递归的整数反转、二分法的整数反转
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] a={1,2,2,3};
      //  System.out.println(removeElement(a,2));
      //  System.out.println(reverse(1234));
//        System.out.println(reverse(-23));
//        System.out.println(length(a,2));
//        System.out.println(length(a,3));
//        System.out.println(length(a,6));
//        int[] b={2,2};
//        System.out.println(length(b,2));
        System.out.println(reverseTestOne("abcdef"));
        System.out.println(reverseTestThree("abcdef"));
        System.out.println(reverseTestFour("abcdef"));
        System.out.println(reverseTestSix("abcdef"));
        System.out.println(reverseTestSeven("abcdef"));

    }
    //字符串的反转,StringBuffer原生的reverse方法
    public static String reverseTestOne(String s) {
        return new StringBuffer(s).reverse().toString();
    }
    //stringBuffer倒序拼接
    public static String reverseTestThree(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    //利用栈的先进后出
    public static String reverseTestFour(String s) {
        StringBuffer sb = new StringBuffer();
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            //stack会返回栈顶值，并且会把该值删除
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    //递归的整数反转
    public static String reverseTestSix(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseTestSix(s.substring(1)) + s.substring(0, 1);
    }
    //二分法的递归反转
    public static String reverseTestSeven(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverseTestSeven(right) + reverseTestSeven(left);
    }
    //移除某元素，返回数组长度
        public static int removeElement(int[] nums, int val) {
            int i=0,j=0;
            while (j<nums.length){
                if (nums[j] == val){
                    j++;
                }else {
                    nums[i]=nums[j];
                    i++;
                    j++;
                }
            }
            return i;
        }
        //返回长度方法2
    public static int length(int[] nums,int val){
        if(nums==null){
            return 0;
        }
        int flag=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==val){
                    flag++;
                }
            }
         return nums.length-flag;
        }
        //翻转整数
        public static int reverse(int x) {
        int n=0;
            while (x != 0) {
                n = n * 10 + x % 10; //位数
                x = x / 10;//各位
            }
            return n > Integer.MAX_VALUE || n < Integer.MIN_VALUE ? 0 : n;
        }

}
