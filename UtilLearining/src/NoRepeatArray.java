import java.util.*;

/**
 * 很多很多数在列表中，找到重复数，和重复次数最高的数
 */
public class NoRepeatArray {
    public static void main(String[] args) {
//        int[] a={1,1,2};
//        System.out.println(noRepeat(a));
        int[] a2={1,1,2,1,7,8,9,4,2};
        System.out.println(noRepeat(a2));
        int[] a3={1};
        System.out.println(noRepeat(a3));
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(3);

        HashMap<Integer, Integer> map= number(list);
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        //找出最大的value
        int temp =0;
        while (iterator.hasNext()){
            Integer next = iterator.next();
            Integer integer = map.get(next);
            System.out.println("key:"+next+" value:"+integer);
            if(integer>temp) {
                temp = integer;
            }
        }
         System.out.println(temp);

    }
    //很多很多数在列表中，找到重复数，和重复次数最高的数
    public static HashMap<Integer,Integer> number(List<Integer> list){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:list) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i,1);
            }
        }
        return map;
    }


    public static int noRepeat(int[] a){
        if(a==null || a.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(set.add(a[i])){
                list.add(a[i]);
            }
        }
        //return set.size();
        return list.size();
    }

}
