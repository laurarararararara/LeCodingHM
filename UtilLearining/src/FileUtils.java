import java.io.*;
import java.nio.charset.Charset;

/**
 * # 打印出文本文件的最后 n行文本
 * 给定一个 CSV 文件，其内容的展现规则如下：
 * - 每一行数据包含多个字段，字段间以[,]分割。
 * - 如果字段值不含有 [,] 和 ["] ，直接解析输出。
 * - 如果字段值内部含有逗号[,]，在在字段值两边加上双引号["]将字段值括起来。
 * - 如果字段值内部含有双引号["]，则字段值两边加上双引号["]括起来，同时，将字段值内的一个双引号["]替换为两个双引号 [""]，例如: [下棋,"飞"] 在 CSV 文件中被表现为 ["下棋,""飞"""]。
 *
 * ## 处理要求：
 * 读入文件 cvs.txt，根据上述 csv 文件的规则进行解析，重新格式化字段生成输出文件 output.txt
 *
 * 将
 * 第一列转为整形(int)
 * 第二列为字符串型
 * 第三列为字符串型
 * 第四列转为浮点数（float）
 * 第五列转为日期类型（DateTime）
 *
 * 输出文件的字段以制表符 [TAB] 来分割字段，
 * 字符串字段输出时用单引号[']括起来
 * 日期字段显示成 YYYY/MM/DD 的格式
 *
 * "
 * 1,Jane,"下棋,""飞""",56.2,1976-8-23
 * 2,Kate,购物,49.6,1979-12-5
 * 3,Jerry,"羽毛球,爬山",55.6,1980-5-26
 * "
 * 输出后：
 * 1,Jane,"""下棋,""飞""""",56.2,1976/8/23
 * 2,Kate,购物,49.6,1979/12/5
 * 3,Jerry,""羽毛球,爬山"",55.6,1980/5/26
 *
 * 请写出打印一个文本文件的最后n行的程序。
 *
 * ## 要求
 * 请正确处理 test-files 目录中的测试文件
 *
 *
 */
public class FileUtils {
    public static void main(String[] args) {

    }
    public static File operate(String name) throws IOException {
        int i=0;
        InputStreamReader inputReader = null;
        BufferedReader bf =null;
        File toFile = new File("output.txt");
        //如果File不存在，则创建它
        if(!toFile.exists()){
            toFile.createNewFile();
        }
        FileWriter filewriter = new FileWriter(toFile.getAbsoluteFile());
        BufferedWriter outputStream = new BufferedWriter(filewriter);
        try {
            File file = new File(name);
            inputReader = new InputStreamReader(new FileInputStream(file));
            bf = new BufferedReader(inputReader);
           
            String str;
            while ((str = bf.readLine()) != null) {
                String[] split = str.split("\"\"");
                StringBuilder builder = new StringBuilder();
                if(split[i].startsWith("\"")){
                    builder.append("'");
                    builder.append("\"");
                    builder.append(split[i]);
                    builder.append(",");
                    outputStream.write(builder.toString());
                }else if(split[i].endsWith("\"")){
                    builder.append(split[i]);
                    builder.append("\"");
                    outputStream.write(builder.toString());
                    builder.append("'");
                    outputStream.write("  ");
                }  else if(split[i].contains("-")){
                    builder.append("'");
                    outputStream.write(split[i].replaceAll("-","/"));
                    builder.append("'");
                }else {
                    builder.append("'");
                    outputStream.write(split[i]);
                    outputStream.write("  ");
                    builder.append("'");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toFile;
    }
    public static String read(String file,int n) throws Exception {
        Charset charset = Charset.defaultCharset();
        try (RandomAccessFile rf = new RandomAccessFile(file, "r")) {
            byte[] c = new byte[1];
            // 在获取到指定行数和读完文档之前,从文档末尾向前移动指针,遍历文档每一个字节
            for (long pointer = rf.length(), lineSeparatorNum = 0; pointer >= 0 && lineSeparatorNum < n;) {
                // 移动指针
                rf.seek(pointer--);
                // 读取数据
                int readLength = rf.read(c);
                if (readLength != -1 && c[0] == 10) {
                    lineSeparatorNum++;
                }
                if (pointer == -1 && lineSeparatorNum < n) {
                    rf.seek(0);
                }
            }
            byte[] tempbytes = new byte[(int) (rf.length() - rf.getFilePointer())];
            rf.readFully(tempbytes);
            return new String(tempbytes, charset);
        }
    }
}
