//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class SignalFileChecker {
    protected static final String PATH = "";
    protected static final String desDirectoryPath = "";

    public SignalFileChecker() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toArrayByInputStreamReader1("/Users/huiman/Downloads/templog 9/2021-11-03/1.main.log"));
//        System.out.println(toArrayByInputStreamReader1("/Users/huiman/Downloads/templog 9/2021-11-03/2.main.log"));
//        System.out.println(toArrayByInputStreamReader1("/Users/huiman/Downloads/templog 9/2021-11-03/3.main.log"));
//        System.out.println(toArrayByInputStreamReader1("/Users/huiman/Downloads/templog 9/2021-11-03/4.main.log"));
//        System.out.println(toArrayByInputStreamReader1("/Users/huiman/Downloads/templog 9/2021-11-03/1.main.encrypt.log"));
    }

    public static List toArray(File dir) {
        List<File> list = new ArrayList();
        File[] listFiles = dir.listFiles();
        File[] var3 = listFiles;
        int var4 = listFiles.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File file = var3[var5];
            if (file.isDirectory()) {
                toArray(file);
            } else {
                list.add(file);
            }
        }

        return list;
    }

    public static boolean checkFile(File file) throws Exception {
        boolean flag = true;
        if (file.getName().endsWith(".zip")) {
            String unFile = unzip(file);
            flag = toArrayByInputStreamReader1(unFile);
        } else {
            flag = toArrayByInputStreamReader1("" + File.separator + file.getName());
        }

        return flag;
    }

    public static String unzip(File zipFilePath) throws Exception {
        String desDirectory = "" + File.separator + "";
        File desDir = new File(desDirectory);
        if (!desDir.exists()) {
            boolean mkdirSuccess = desDir.mkdir();
            if (!mkdirSuccess) {
                throw new Exception("创建解压目标文件夹失败");
            }

            System.out.println("解压目录存在");
        }

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry zipEntry = zipInputStream.getNextEntry();

        String unzipFilePath;
        for(unzipFilePath = null; zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
            if (zipEntry.isDirectory()) {
                unzipFilePath = desDirectory + File.separator + zipEntry.getName();
                mkdir(new File(unzipFilePath));
            } else {
                unzipFilePath = desDirectory + File.separator + zipEntry.getName();
                File file = new File(unzipFilePath);
                mkdir(file.getParentFile());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(unzipFilePath));
                byte[] bytes = new byte[1024];

                int readLen;
                while((readLen = zipInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, readLen);
                }

                bufferedOutputStream.close();
            }

            zipInputStream.closeEntry();
        }

        zipInputStream.close();
        return unzipFilePath;
    }

    private static void mkdir(File file) {
        if (null != file && !file.exists()) {
            mkdir(file.getParentFile());
            file.mkdir();
        }
    }

    public static boolean toArrayByInputStreamReader1(String name) {
        ArrayList arrayList = new ArrayList();
        InputStreamReader inputReader = null;
        int index = 0;
        ArrayList errorList = new ArrayList();

        try {
            File file = new File(name);
            inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            String str;
            while((str = bf.readLine()) != null) {
                arrayList.add(str);
                ++index;
                if (hasWrongCode(str)) {
                    errorList.add(str);
                    System.out.println("行数:" + index + "  乱码字符串为 ： " + str);
                }
            }

            System.out.println(file.getName() + "共有" + errorList.size() + "行字符串乱码");
            bf.close();
            inputReader.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }
        return errorList.size() != 0;
    }

    public static boolean hasWrongCode(String line) {
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(line);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        String temp2 = temp.replaceAll("\\|", "a");
        String temper = filterEmoji(temp2);
        char[] ch = temper.trim().toCharArray();
        int count = 0;

        for(int i = 0; i < ch.length; ++i) {
            char c = ch[i];
            if ((c >= 127 && c < 19968 || c > '龥') && !isSpecialChar(c)) {
                System.out.print("乱码字符：" + c + "  ");
                ++count;
            }
        }

        if (count != 0) {
            System.out.println();
            System.out.println(count);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSpecialChar(char c) {
        return c == '+' || c == '<' || c == '>' || c == '=' || c == '{' || c == '}' || c == '[' || c == ']'
                || c == '%' || c == '&' || c == '|' || c == '@' || c == '$' || c == 8594 || c == ':' || c == '#'
                || c == '~' || c == 9584 || c == 9581 || c == '^' || c == '?' || c == 9752 || c == 10084 || c == 8593
                || c == 8595 || c == 0 || c == '*' || c == '-' || c == 'x' || c == '_' || c == 160 || c == 154 || c == 9819 || c == 9989;
    }

    public static boolean containsEmoji(String source) {
        int len = source.length();
        boolean isEmoji = false;

        for(int i = 0; i < len; ++i) {
            char hs = source.charAt(i);
            char ls;
            if ('\ud800' <= hs && hs <= '\udbff') {
                if (source.length() > 1) {
                    ls = source.charAt(i + 1);
                    int uc = (hs - '\ud800') * 1024 + (ls - '\udc00') + 65536;
                    if (118784 <= uc && uc <= 128895) {
                        return true;
                    }
                }
            } else {
                if (8448 <= hs && hs <= 10239 && hs != 9787) {
                    return true;
                }

                if (11013 <= hs && hs <= 11015) {
                    return true;
                }

                if (10548 <= hs && hs <= 10549) {
                    return true;
                }

                if (12951 <= hs && hs <= 12953) {
                    return true;
                }

                if (hs == 169 || hs == 174 || hs == 12349 || hs == 12336 || hs == 11093 || hs == 11036 || hs == 11035 || hs == 11088 || hs == 8986) {
                    return true;
                }

                if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
                    ls = source.charAt(i + 1);
                    if (ls == 8419) {
                        return true;
                    }
                }
            }
        }

        return isEmoji;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return codePoint == 0 || codePoint == '\t' || codePoint == '\n' || codePoint == '\r' || codePoint >= ' ' && codePoint <= '\ud7ff' || codePoint >= '\ue000' && codePoint <= '�' || codePoint >= 65536 && codePoint <= 1114111;
    }

    public static String filterEmoji(String source) {
        if (!containsEmoji(source)) {
            return source;
        } else {
            StringBuilder buf = null;
            int len = source.length();

            for(int i = 0; i < len; ++i) {
                char codePoint = source.charAt(i);
                if (isEmojiCharacter(codePoint)) {
                    if (buf == null) {
                        buf = new StringBuilder(source.length());
                    }

                    buf.append(codePoint);
                }
            }

            if (buf == null) {
                return source;
            } else if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }
}

