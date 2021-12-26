import java.util.HashMap;

public class MapUtils {
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();
              map.put("DEMO", 1);
               /*Value的类型*///得到map中key相对应的value的值
                 System.out.println(map.get("1"));//null
              System.out.println(map.get("DEMO"));//1

        /*boolean*///判断map是否为空
                 System.out.println(map.isEmpty());//true
                 map.put("DEMO", 1);
                 System.out.println(map.isEmpty());//false
        /*boolean*///判断map中是否存在这个key
        System.out.println(map.containsKey("DEMO"));//false
        map.put("DEMO", 1);
        System.out.println(map.containsKey("DEMO"));//true

        /*boolean*///判断map中是否存在这个value
        System.out.println(map.containsValue(1));//false
        map.put("DEMO", 1);
        System.out.println(map.containsValue(1));//true

        /*Integer*///删除key值下的value
        System.out.println(map.remove("1"));//null
        map.put("DEMO", 2);
        System.out.println(map.remove("DEMO"));//2(删除的值)

        map.put("DEMO1", 1);
                map.put("DEMO2", 2);
                 System.out.println(map.values());//[1, 2]

        System.out.println(map.keySet());
        System.out.println(map.entrySet());//[DEMO1=1, DEMO2=2]
    }
}
