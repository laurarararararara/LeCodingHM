/**
 *找出数组的最大连续和:暴力法+动态规划
 */
public class Array {
    public static void main(String[] args) {
        int[] a={-1,2,3,5};
        System.out.println(sum(a));
        System.out.println(sum2(a));
    }
    //暴力
    public static int sum(int[] a){
        int max=a[0];
        int temp=0;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                for (int k=i;k<=j;k++){
                    temp+=a[k];
                }
                if(temp>max){
                    max=temp;
                }
                temp=0;
            }
        }
        return max;
    }
    //动态规划
    public static int sum2(int[] a){
        int max=a[0];
        int temp=0;
        for(int i=0;i<a.length;i++){
            if(temp>=0){
                temp+=a[i];
            }else {
                temp=a[i];
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }
}
