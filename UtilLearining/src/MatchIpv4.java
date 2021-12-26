/**
 * 判断字符串是否符合ipv4
 */
public class MatchIpv4 {
    public static void main(String[] args) {
        String s="123.4.5.1";
        System.out.println(match(s));
        String s2="0.4.5.1";
        System.out.println(match(s2));
        String s3="123";
        System.out.println(match(s3));

    }
    public static boolean match(String ipv4){
        if(ipv4==null || ipv4.length()==0){
            return false;//字符串为空或者空串
        }
        String[] parts=ipv4.split("\\.");//因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"
        if(parts.length!=4){
            return false;//分割开的数组根本就不是4个数字
        }
        for(int i=0;i<parts.length;i++){
            try{
                int n=Integer.parseInt(parts[i]);
                if(n<0 || n>255){
                    return false;//数字不在正确范围内
                }
            }catch (NumberFormatException e) {
                return false;//转换数字不正确
            }
        }
        return true;
    }
}
