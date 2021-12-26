import java.util.ArrayList;

/**
 * int a[][] ={{1,2,3},
 *              {4,5,6}
 *             };
 */
public class TwoArray {
    public static void main(String[] args) {
       int[][] a={{1,2,3},{4,5,6}};
       //print(a);
        int[][] b={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        //print(b);
//        System.out.println(printMatrix(b));
//       print(a);
        int[][] matrix = generateMatrix(3);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println(findTarget(b,13));
        System.out.println(findTarget(b,11));
       // System.out.println(matrix.toString());
        //System.out.println(generateMatrix(4).toString());
    }
    /**
     *方法1 nlogn：找到顺序二维数组的目标值是否存在
     */
    public static boolean findTarget(int [][] array,int target) {
        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *方法2：找到顺序二维数组的目标值是否存在
     */
    public boolean findTagert2(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }



    /**
     *给你一个正整数n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n){
        int[][] arr = new int [n][n];  int num = 1;
        if (n % 2 != 0){
            arr[n/2][n/2] = n*n;
        }
        for (int i = 0; i < n/2; i++){
            // 顶横
            for (int j = i; j < n-i-1 ; j++){
                arr[i][j] = num++;
            }
            // 右纵
            for (int j = i; j < n-i-1; j++){
                arr[j][n-i-1] = num++;
            }
            // 底横
            for (int j = n-i-1; j > i ; j--){
                arr[n-i-1][j] = num++;
            }
            // 左纵
            for (int j = n-i-1; j > i; j--){
                arr[j][i] = num++;
            }
        }
        return arr;
    }
    //二维数组顺时针打印
        public static ArrayList<Integer> printMatrix(int [][] matrix) {
            int length = matrix.length;   //行长度：矩阵的长
            int width = matrix[0].length; //列长度：矩阵的宽
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            if(matrix == null || length==0 || width==0) return null;
            if(length==1){
                for(int a1 = 0;a1<width;a1++){
                    arrayList.add(matrix[0][a1]);
                }
                return arrayList;
            }
            if(width==1){
                for(int a2 = 0;a2<length;a2++){
                    arrayList.add(matrix[a2][0]);
                }
                return arrayList;
            }

            //一次循环是一圈
            for(int i =0;i<length-i;i++){
                int j=i;
                if(j<width-i) {
                    //一圈的上边
                    for (;j<width - i; j++) {
                        arrayList.add(matrix[i][j]);
                    }
                    //一圈的右边
                    for (int k = i + 1; k < length - i; k++) {
                        arrayList.add(matrix[k][width - 1 - i]);
                    }

                    int f = length - 1 - i; //下边所在的行数
                    if (f != i) {
                        //一圈的下边
                        for (int m = width - 1 - i - 1; m >= i; m--) {
                            arrayList.add(matrix[f][m]);
                        }
                        //一圈的左边
                        for (int n = f - 1; n > i; n--) {
                            arrayList.add(matrix[n][i]);
                        }
                    }
                }
            }
            return arrayList;
        }
        //二维数组顺时针的打印，3*3；2*3
    public static void print(int[][] a){
        int row=a.length;
        //列长度
        int c=a[0].length;
        //只有一个元素时
        if(row==1 && c==1){
            System.out.println(a[row-1][c-1]);
            return;
        }
        //第一行
        for(int i=0;i<c;i++){
            System.out.println(a[0][i]);
        }
        //最后一列
        for(int i=1;i<row;i++){
            System.out.println(a[i][c-1]);
        }
        //最后一行
        for(int i=c-2;i>=0;i--){
            System.out.println(a[row-1][i]);
        }
        //第一列
        for(int i=row-2;i>=1;i--){
            System.out.println(a[i][0]);
        }
        //未打印
        if(row-2>0 && c-2>0){
            int array[][] =new int[row-2][row-2];
            for(int i=1;i<=row-2;i++){
                for(int j=1;j<=c-2;j++){
                    array[i-1][j-1]=a[i][j];
                }
            }
            print(array);
        }
    }
}
