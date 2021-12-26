import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//无序数组，输出三个数相加为0的集合
public class FileUtil {
    public static void main(String[] args) {
        int a[] ={3,-2,1,0,1,-1};
        System.out.println(sum(a));
    }
    public static List<List<Integer>> sum(int[] a){
        List<List<Integer>> lists =new ArrayList<>();
        Arrays.sort(a);
        for (int i=0;i<a.length;i++){
            if(a[i]>0){
                return lists;
            }
           if(i>0 &&a[i]==a[i-1]) continue;
           int cur=a[i];
            int l=i+1;int r=a.length-1;
            while (l<r) {
                int temp = cur + a[l] + a[r];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(a[l]);
                    list.add(a[r]);
                    lists.add(list);
                    while (l < r && a[l + 1] == a[l]) ++l;
                    while (l < r && a[r - 1] == a[r]) --r;
                    ++l;
                    --r;
                } else if (temp < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return lists;
    }
}
