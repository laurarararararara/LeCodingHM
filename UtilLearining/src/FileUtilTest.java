
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileUtilTest {
    public FileUtilTest() {
    }

    public static void main(String[] args) {
        long a = 104857600L;
//        System.out.println(104857600);
//        System.out.println(getCurrentDate());
//        System.out.println(getCurrentDay());
//        System.out.println(getCurrentTimestamp());

        String s="3,Jerry,\"羽毛球,爬山\",55.6,1980-5-26";
        String s1= " 1,Jane,\"下棋,\"\"飞\"\"\",56.2,1976-8-23";

        String[] split = s.split(",");
        for(int i=0;i<split.length;i++){
                System.out.println(split[i]);
//                String[] split1 = s.split(",");
//                for(int j=0;i<split1.length;j++) {
//                    System.out.println(split1[j]);
//                }
        }
        String[] split1 = s1.split(",");
        for(int i=0;i<split1.length;i++){
            System.out.println(split1[i]);
//                String[] split1 = s.split(",");
//                for(int j=0;i<split1.length;j++) {
//                    System.out.println(split1[j]);
//                }
        }
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static long getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        long createTime = calendar.getTimeInMillis();
        return createTime;
    }

    /**
     * 在n个文件中查找含有某字符串的文件有多少个
     * @return
     */
    public static int sum(String name,String keyword){
        int count=0;
        //新文件夹
        File file = new File(name);
        File[] files = file.listFiles();
        for (File f:files) {
            int times = keyWordsTimes(f.getName(), keyword);
            count=count+times;
        }
        return  count;
    }
    //检测一份文件中keyword出现了多少次
    public static int keyWordsTimes(String name,String keyword)  {
        int i=0;
        InputStreamReader inputReader = null;
        BufferedReader bf =null;
        try {
            //新文件夹
            File file = new File(name);
            inputReader = new InputStreamReader(new FileInputStream(file));
            bf = new BufferedReader(inputReader);
            // 按行读取字符串
            //记录每一行
            String str;
            while ((str = bf.readLine()) != null) {
                if(str.contains(keyword)){
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static long getCurrentTimestamp() {
        return (new Date()).getTime();
    }

    public static boolean checkFileExist(String fileNa, String keyWord) {
        boolean flag = false;
        File file = new File(fileNa);

        try {
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            String str;
            while((str = bf.readLine()) != null) {
                if (str.contains(keyWord)) {
                    flag = true;
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return flag;
    }
}

