
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileUtilTest {
    public FileUtilTest() {
    }

    public static void main(String[] args) {
        long a = 104857600L;
        System.out.println(104857600);
        System.out.println(getCurrentDate());
        System.out.println(getCurrentDay());
        System.out.println(getCurrentTimestamp());
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

