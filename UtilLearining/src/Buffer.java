import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class Buffer {
    public static void main(String[] args) {
        File file = new File("/Users/huiman/Downloads/templog 12/2021-11-05/1.mini0.log");
        RandomAccessFile accessFile = null;
        try {
            accessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = null;
            channel = accessFile.getChannel();
            ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 160L);
            System.out.println("--------Test reset----------");
            buffer.position(5);
            buffer.mark();
            buffer.position(10);
            System.out.println("before reset:" + buffer);
            buffer.reset();
            System.out.println("after reset:" + buffer);
            System.out.println("--------Test rewind--------");
            buffer.clear();
            buffer.position(10);
            buffer.limit(15);
            System.out.println("before rewind:" + buffer);
            buffer.rewind();
            System.out.println("before rewind:" + buffer);
            System.out.println("--------Test compact--------");
            buffer.clear();
            buffer.put("abcd".getBytes());
            System.out.println("before compact:" + buffer);
            buffer.flip();
            System.out.println("after flip:" + buffer);
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println("after three gets:" + buffer);
            buffer.compact();
            System.out.println("after compact:" + buffer);
            System.out.println("------Test get-------------");
            ByteBuffer buffer2 = ByteBuffer.allocate(32);
            buffer.put((byte)97).put((byte)98).put((byte)99).put((byte)100).put((byte)101).put((byte)102);
            System.out.println("before flip()" + buffer);
            buffer2.flip();
            System.out.println("before get():" + buffer2);
           // System.out.println((char)buffer2.get());
            System.out.println("after get():" + buffer2);
            System.out.println("after get(index):" + buffer2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
