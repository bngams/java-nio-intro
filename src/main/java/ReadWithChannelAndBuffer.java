import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadWithChannelAndBuffer {
    public static void main(String[] args) {
        readWithChannelAndBuffer();
    }

    /**
     * To explore buffer API
     * http://tutorials.jenkov.com/java-nio/buffers.html
     */
    private static void readWithChannelAndBuffer() {
        try {
            FileInputStream  fi = new FileInputStream("days.txt");
            FileChannel inChannel = fi.getChannel();
            // create a buffer
            ByteBuffer buffer = ByteBuffer.allocate((int) 1024);
            // Write data from Channel into a Buffer
            inChannel.read(buffer);
            // prepare buffer to read it
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get());
            }
            inChannel.close();
            fi.close();
        } catch (IOException exc) {
            System.out.println(exc);
            System.exit(1);
        }
    }
}
