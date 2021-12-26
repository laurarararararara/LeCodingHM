/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] a={4,3,2,1,4};
        System.out.println(convert(a));
//        int[] a1={1,2,1};
//        System.out.println(convert(a1));
        int[] a2={4,5,7,2,4,6};
        System.out.println(convert(a2));
        int[] a3={1,5,7,2,4,6};
        System.out.println(convert(a3));
    }
    public static int convert(int[] a){
        int max = 0;
        if(a.length==0 || a ==null){
            return max;
        }
        for(int i = 0,j = a.length - 1; i < j ; ){
            int minHeight = a[i] < a[j] ? a[i ++] : a[j --];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}
