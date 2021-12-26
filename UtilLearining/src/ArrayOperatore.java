import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * 求数组组合起来的最大数：两种方式
 * 数组连续最大和
 * 数组排序并去重
 * 给定一个数组和目标值，找出等于目标值的所有组合
 * 合并找出两个数组，找出中位数
 * 找出不重复的数，即数组中只出现过一次的数
 */
public class ArrayOperatore {
    public static void main(String[] args) {
        int[] f={6,-7,2,-3,5,-6,5,5,5};
        ArrayOperatore operatore = new ArrayOperatore();
      //  System.out.println(operatore.combinationSum(a,8));
       // System.out.println(array(a));

       // System.out.println(mapUtil(a));
      // System.out.println(dynaticMethod(a));
        int[] e={6,7,2,3,5,6,0,1,45,5,5};
        System.out.println(getMaxSum(e));
        System.out.println(largestNumber(e));
        int[] a={1,2,1,1,4,6};
        sortGroup2(a);
        System.out.println(Arrays.toString(a));
        int[] b={2,4};
        sortGroup2(b);
        System.out.println(Arrays.toString(b));
        int[] c={2,1,7,9};
        sortGroup2(c);
        System.out.println(Arrays.toString(c));
        //1,2,2,4,7,9
        System.out.println(findMedianSortedArrays(b, c));
        System.out.println(findFirstNotRepeat(e));

    }
    /**
     *找出不重复的数，即数组中只出现过一次的数
     */
    public static List<Integer> findFirstNotRepeat(int[] arr) {
        //对每个元素进行计数
        Map<Integer, Integer> map = new LinkedHashMap<>();
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //如果map中存在该元素，则对应的数量加1
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], value + 1);
            } else {
                //每个元素初始次数为0
                map.put(arr[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        //值为1的便是不重复的数
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(1)) {
                list.add(key);
            }
        }
        return list;
    }


    //合并找出两个数组，找出中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //判断两个数组中若有一个数组为空
        if(nums1==null&&nums2==null) {
            return 0;
        }
        //创建一个新数组 长度为两个数组之和
        int[] nums = new int[nums1.length + nums2.length];
        //原数组元素遍历到新数组中
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[nums1.length + i] = nums2[i];
        }
        //对数组进行排序
        Arrays.sort(nums);
        //判断数组个数奇偶 找出中位数
        if (nums.length % 2 == 0) {
            return ((nums[nums.length / 2]) + (nums[nums.length / 2 - 1])) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }
    //所有奇数位于偶数前
    public static void sortGroup2(int[] array) {
        int temp = 0;
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] % 2 != 0) {
                left++;
            } else if (array[right] % 2 == 0) {
                right--;
            } else {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }
    /**
     * 数组中组合的最大数
     * 这个排序方法并不能按照题目要求正确排序。例如，数字8和883，如果按照字符串顺序排序，883大于8，就会把883放在前面，8放在后面，最后输出8838。
     * 而实际8883才是正确结果。正确的排序方法，是使用排序方法进行比较时，比较两个字符串（设为A和B），以先后顺序拼接而成的两个字符串A+B和B+A，如果A+B更大，则A在前B在后，否则A在后B在前。
     */
    public static String getMaxSum(int[] nums) {
        if (nums == null) {
            return "";
        }
        String[] numsStr = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            numsStr[i++] = num + "";
        }
        Arrays.sort(numsStr, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String temp1 = str1 + str2;
                String temp2 = str2 + str1;
                return (-temp1.compareTo(temp2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : numsStr)
            sb.append(s);
        return sb.toString();
    }

    /**
     * 数组中组合的最大数 方法2
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        int n=nums.length;
        String[] str=new String[n];
        for(int i=0;i<n;i++) {
            str[i]=String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String a = s1 + s2;
                String b = s2 + s1;

                return b.compareTo(a);
            }
        };

        Arrays.sort(str,comp);
        StringBuilder ans=new StringBuilder("");
        for(String s: str)
            ans.append(s);

        if(ans.charAt(0) == '0')
            return "0";

        return ans.toString();
    }

    /**
     * 数组中连续最大和
     */
    public static int dynaticMethod(int[] a){
        int maxResult = a[0];
        int maxTemp = 0;
        for(int i = 0;i < a.length;i++){
            if(maxTemp >= 0) {
                maxTemp += a[i];
            } else {
                maxTemp = a[i];
            }
            if(maxTemp > maxResult)
                maxResult = maxTemp;
        }
        return maxResult;
    }
    /**
     * 比如有这样一个数组，[1,3,3,4,5,5,1]，设计一个函数，将数组输入，返回一个map，key来存储重复的数字，value来存放重复数字的下标
     * @return
     */
    public static HashMap<Integer,Integer> mapUtil(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],i);
        }
        return map;
    }
    //数组排序并去重
    public static Set<Integer> array(int[] a){
        Arrays.sort(a);
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<a.length;i++){
            hashSet.add(a[i]);
        }
        return hashSet;
    }

    /**
     *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     *  https://leetcode-cn.com/problems/search-insert-position/
     */
    public static int location(int[] a,int target){
        if(a==null ||a.length==0){
            return 0;
        }
      for (int i=0;i<a.length;i++) {
          if(a[i]>=target) {
              return i;
          }
      }
      return a.length;
    }
    /**
     *给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
     *https://leetcode-cn.com/problems/combination-sum/
     */
    List<List<Integer>> res = new LinkedList<>();
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(track, 0, candidates, target,0);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int sum,
                           int[] candidates, int target,int index) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (sum + candidates[i] > target) break;
            //做选择
            track.add(candidates[i]);
            backtrack(track, sum + candidates[i],
                    candidates, target, i);
            //撤销选择
            track.removeLast();
        }
    }
}
