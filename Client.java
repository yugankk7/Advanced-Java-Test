
import java.io.*;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.nio.*;


public class Client {

    public static void main( String[] args ) throws Throwable {
        File f = new File( "text.txt" );
        FileChannel channel = FileChannel.open( f.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE );

        MappedByteBuffer b = channel.map( MapMode.READ_WRITE, 0, 4096 );
        CharBuffer charBuf = b.asCharBuffer();

        // Prints 'Hello server'
        char c;
        while( ( c = charBuf.get() ) != 0 ) {
            System.out.print( c );
        }
        System.out.println();
    }

}