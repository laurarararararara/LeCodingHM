import java.util.ArrayList;

/**
 *质数
 * 100以内7的倍数和以7结尾的数
 */
public class Prime {
    public static void main(String[] args){
//        int i=0;
//        for(i=2;i<=100;i++){
//            if(getPrimary(i)){
//                System.out.print(i+" ");
//            }
//        }
//        System.out.println();
//        method();
        System.out.println(sum(100));
        find();
    }
    //100以内7的倍数和以7结尾的
    public static ArrayList<Integer> sum(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i%7==0 || (i%10)==7){
                list.add(i);
            }
        }
        return list;
    }
    public static void find(){
        for(int i=0;i<10;i++){
            if(i%2 ==0){
                break;
            }else {
                i++;
                System.out.println(i);
                continue;
            }
        }

    }
    public static boolean getPrimary(int i){
        int max=i/2+1;
        for(int n=2;n<max;n++){
            if(i%n==0){
                return false;
            }
        }
        return true;
    }
    public static void method() {
        for(int i=2;i<=100;i++) {
            int count=0;
            for(int j=1;j<i+1;j++){
                if(i%j==0){
                    count++;
                    if(count==3)break;;
                }
            }
            if(count==2){
                System.out.print(i+" ");
            }

        }
    }

}
