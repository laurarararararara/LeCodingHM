import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/11/28 /11
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeNumberNum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists);
//        System.out.println(threeSumClosest(nums,5));
        System.out.println(twoSum(nums, 1));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序 {-4,-1,-1,0,1,2}
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];//curr:-4 l:-1 r:2
            int L = i+1, R = len-1;
            while (L < R) { //tmp:-2 <0;l++ 第二轮：l:-1 r:2  l++ 第三轮: l:0 r:2 第三轮：l:1 r:2 总结：以-4为基准，如果加起来>0,往小移动；否则往大移动
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
    public static int threeSumClosest(int[] nums, int target) {
        //排序 {-4,-1,-1,0,1,2}
        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2; ++i){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                if(Math.abs(sum-target) < diff){
                    diff = Math.abs(sum-target);
                    res = sum;
                }
                if(sum < target)
                    j++;
                else if(sum > target)
                    k--;
            }
        }
        return res;
    }
    //输入一个数组，输出里面两两相加等于target的数组对
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        //排序 {-4,-1,-1,0,1,2}
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int temp=nums[l]+nums[r];
            if(temp==target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                lists.add(list);
                while(l < r && nums[l+1] == nums[l]) ++l;
                while (l < r && nums[r-1] == nums[r]) --r;
                ++l;
                --r;
            }else if(temp<target){
                ++l;
            }else {
                --r;
            }
        }

        return lists;
    }
}
