import java.util.Arrays;

/**
 * 排序算法及平均时间复杂度
 * 冒泡：n平方
 * 插入
 * 快排
 * 简单选择
 * 归并
 *
 */
public class Sort {
    public static void main(String[] args) {
        int[] a={3,1,6,2,9,0,7,4,5,8};
//        bubbleSort(a);
//        insertSort(a);
        quickSort(a);
 //       simpleSelect(a);
    }
    //冒泡
    public static void bubbleSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            //因为已经排好了i个了，所以只需要排length-i的数，-1是因为只需要排到倒数第二个，否则j+1会产生数组越界
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    //插入排序
    public static void insertSort(int[] a) {
        //j从后往前判断，如果前面的数比它小，则交换，继续向前判断；
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {  //如果后面的比前面的值大，则跳出内层for循环，进行下一个数的判断
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    //快排
    public static void quickSort(int[] a){
        quickSort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void quickSort(int[] a,int left,int right){
        if(left>=right){
          return;
        }
        int p=a[left+(right-left)/2];
        int index=partition(a,left,right,p);
        quickSort(a,left,index-1);
        quickSort(a,index,right);
    }

    private static int partition(int[] a, int left, int right, int p) {
        while (left<=right){
            while (a[left]<a[p]){
                left++;
            }
            while (a[right]>a[p]){
                right--;
            }
            if(left<=right){
                swap(a,left,right);
                left++;right--;
            }
        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;
    }
    //简单选择排序
    public static void simpleSelect(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    swap(a,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    //希尔排序
    public static void shellSort(int[] a){
        int count=0;
        for(int gap=a.length/2;gap>0;gap=gap/2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (a[j] > a[j + gap]) {
                        int temp = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = temp;
                    }
                }
            }
        }
    }
    //归并排序
    public static void sort(int[] a,int left,int right){
        if(left==right)return;
        int middle=(left+right)/2;
        sort(a,left,middle);
        sort(a,middle+1,right);
        merge(a,left,middle+1,right);
    }
    public static void merge(int[] a,int leftPtr,int rightPtr,int rightBound){
        int mid=rightPtr-1;
        int[] temp=new int[rightBound-leftPtr+1];
        int i=leftPtr;
        int j=rightPtr;
        int index=0;
        while (i<=mid&&j<=rightBound){
            temp[index++]=a[i]<=a[j] ? a[i++]:a[j++];
        }
        while (i<=mid){
            temp[index++]=a[i++];
            // i++;index++;
        }
        while (j<=rightBound){
            temp[index++]=a[j++];
            //j++;index++;
        }
        for(int k=0;k<temp.length;k++){
            a[k+leftPtr]=temp[k];
        }
    }

}
