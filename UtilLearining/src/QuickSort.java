import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] a={2,4,1,6,7};
        sort(a);
        System.out.println(Arrays.toString(a));
        int[] b={2,1,0,-2};
        sort(b);
        System.out.println(Arrays.toString(b));
        int[] c={2};
        sort(c);
        System.out.println(Arrays.toString(c));
        int[] d=null;
        sort(d);
        System.out.println(Arrays.toString(d));
        int[] e={};
        sort(e);
        System.out.println(Arrays.toString(e));

    }
    public static void sort(int[] a){
        if(a==null || a.length==0){
            return;
        }
        sort(a,0,a.length-1);
    }
    private static void sort(int[] b,int l,int r){
        if(l>=r){
            return;
        }
        int p=b[(l+r)/2];
        int index=par(b,l,r,p);
        sort(b,l,index-1);
        sort(b,index,r);
    }
    private static int par(int[] a,int l,int r,int p){
        while (l<=r){
            while (a[l]<p){
                l++;
            }
            while (a[r]>p){
                r--;
            }
            if(l<=r){
                swap(a,l,r);
                l++;r--;
            }
        }
        return l;
    }
    private static void swap(int[] a,int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
}
