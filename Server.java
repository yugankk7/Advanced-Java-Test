
import java.io.*;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.nio.*;

// Main class
public class Server {

	static void sendMessage(CharBuffer cb) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the message...");
		String msg = sc.nextLine();
		cb.clear();
        cb.append(msg);

	}

    public static void main( String[] args ) throws Throwable {
		
        File f = new File("text.txt");

        FileChannel channel = FileChannel.open( f.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE );

        MappedByteBuffer b = channel.map( MapMode.READ_WRITE, 0, 4096 );
        CharBuffer charBuf = b.asCharBuffer();

        sendMessage(charBuf);

        System.out.println( "Waiting for client." );
        while( charBuf.get( 0 ) != '\0' ) {
			sendMessage(charBuf);
		}
        System.out.println( "Finished waiting." );
    }
}