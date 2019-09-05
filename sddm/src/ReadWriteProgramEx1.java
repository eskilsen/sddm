import jdk.nashorn.internal.ir.Block;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;

public class ReadWriteProgramEx1 {
    
    private static final int BLOCKSIZE = 8192;
    private static final long NBLOCKS = 32 * 131072;

    Path file; 
    SeekableByteChannel out;
    ByteBuffer buff;
    
    public ReadWriteProgramEx1() throws IOException{
        this.file = Paths.get(System.getProperty("user.dir"), "myjavadata");
        this.out = Files.newByteChannel(file, EnumSet.of(CREATE, APPEND));
        this.buff = ByteBuffer.allocate(BLOCKSIZE);
    }
    
    public int writer() throws IOException{
        return out.write(buff);
    }
    
    
    
    public static void main(String[] args) throws IOException {
        ReadWriteProgramEx1 e = new ReadWriteProgramEx1();
        System.out.println(e.writer());
    }
    
}
