import java.math.BigInteger;

/**
 * n的阶乘
 */
public class Number {
    public static void main(String[] args) {
//        System.out.println(circulation(4));
//        System.out.println(recursion(4));
//        System.out.println(bigState(4));
        System.out.println(rand10());
    }
    private static int rand6(){
        return (int)(Math.random()*6)+1;
    }
    //
    private static int rand10() {
        while(true){
            //0,1,2,3,4,5 + 1,2,3,4,5,6,
            int num = (rand6()-1)*6+rand6();
            if(num<=36) {
                return num % 5 + 1;
            }
        }
    }
    // n的阶乘循环方法
    public static int circulation(int n) {
        int result = 1;
        for(int i=1;i<=n;i++) {
            result*=i;
        }
        return result;
    }
    // 递归方法
    public static int recursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return recursion(n - 1) * n;
        }
    }
    //当n很大时，会超过max_int 2的32次方-1
    public static BigInteger bigState(int n) {
        BigInteger result = new BigInteger("1");//超过30！应该使用BigInteger
        for (int i = 1; i <= n; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            result = result.multiply(num);// 调用自乘方法
        }
        return result;
    }

}
