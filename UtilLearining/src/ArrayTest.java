import java.util.*;

/**
 * 返回两数组元素是否一致，一直返回null，不一致返回不一致的元素
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] a={-1,1,0,2,4,56,6};
//       // System.out.println(sum(a));
//        Integer[] b={-1,-2,2,6,7,9};
//        System.out.println(compare2(a,b));
//        System.out.println(twoSearch(a,2,0,a.length-1));
//        System.out.println(twoSearch(a,8,0,a.length-1));

        //打印昨天的当前时刻
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
    }

    // 0、1、1、2、3、5、8、13、21、34、……
    public static List<Integer> feibo(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int a=1;int b=0;int c=0;
        if(n==0){
            list.add(n);
        }else if(n==1) {
           list.add(0);
           list.add(1);
        }else if(n>=2){
          for(int i=0;i<n-2;i++){
              c=a+b;
              a=b;
              b=c;
          }
          list.add(c);
        }
        return list;
    }
    //二分查找
    public static int twoSearch(int[] a,int target,int l,int r){
        if(target<a[l] ||target>a[r] ||l>r){
            return -1;
        }
        int middle =(l+r)/2;   //l+(r-l)/2
        if(a[middle]>target){
            return twoSearch(a,target,l,middle-1);
        }else if(a[middle]<target){
            return twoSearch(a,target,middle,r);
        }else {
            return middle;
        }
    }
    /**
     * 返回两数组元素是否一致，一直返回null，不一致返回不一致的元素
     */
    public static Set<Integer> compare2(Integer[] arr1, Integer[] arr2) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
        Set<Integer> set3 = new HashSet<>(set2);
        set3.addAll(set1);//set3  set集合有去重特性
        set1.retainAll(set2);//retainAll():保留包含在指定 collection 中的元素；s1：[-1,1,2]
        set3.removeAll(set1);//	removeAll(); 移除 set 中那些包含在指定 collection 中的元素 ; s3 [3,4,100,5,7,-12,12]
        if(set3.size()==0){
            return null;
        }else {
            return set3;
        }
    }

    public static void is(int[] a,int[] b){
     for(int i=0;i<a.length;i++){
            int result =0;
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                    result=1;
                }
            }
            if(result==0){
                System.out.println("不包含的数："+a[i]) ;
            }
        }
    }


    public static List<Integer> isSameArray(int[] arr1,int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0;i<arr1.length;i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr1[i] != arr2[j]) {
                        arrayList.add(arr1[i]);
                    }
                }
            }
            return arrayList;
        }


    public static List<Integer> same(int[] a,int[] b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean flag=true;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]!=b[j]){
                    flag=false;
                    arrayList.add(a[i]);
                    arrayList.add(b[j]);
                }
            }
        }
        if(flag){
            return null;
        }else {
            return arrayList;
        }
    }
    public static List<List<Integer>> sum(int[] a){
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(i>0 && a[i] ==a[i-1]){
                continue;
            }
            int tar=0-a[i];
            //双指针
            int r=a.length-1;
            int l=i+1;
            while (l<r){
                if(a[l]+a[r]==tar){
                  List<Integer>  temp=new ArrayList<>();
                  temp.add(a[i]);
                  temp.add(a[l]);
                  temp.add(a[r]);
                  list.add(temp);
                  while (l<r && a[r]==a[r-1]){
                      r--;
                  }
                  r--;
                  continue;
                }
                if(a[l]+a[r]>tar){
                    while (l<r && a[r]==a[r-1]){
                        r--;
                    }
                    r--;
                    continue;
                }
                if(a[l]+a[r]<tar){
                    while (l<r && a[l]==a[l+1]){
                        l++;
                    }
                    l++;
                    continue;
                }
            }
        }
        return list;
    }
}
