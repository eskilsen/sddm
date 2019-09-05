import java.util.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.CREATE;

public class readWriteProgram {

    private static final int BLOCKSIZE = 8192;
    private static final long NBLOCKS = 32 * 131072;
    
    Path file = Paths.get(System.getProperty("user.dir"), "myjavadata");
    SeekableByteChannel out = Files.newByteChannel(file, EnumSet.of(CREATE, APPEND));
    ByteBuffer buff = ByteBuffer.allocate(BLOCKSIZE);

    public readWriteProgram() throws IOException {
        out.write(buff);
    }
    
    public void writer() throws IOException{
        long start = System.currentTimeMillis();
        
        
        String randomSentence = "Hello motherfucker lets dance guns blazing\n";
        for (int i = 0; i<BLOCKSIZE; i++){
            Files.write(file,randomSentence.getBytes(), StandardOpenOption.APPEND);    
        }
        
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public Path getFile(){
        return file;
    }
    
    public static void main(String[] args) throws IOException {
     
        readWriteProgram r = new readWriteProgram();
        System.out.println(r.buff);
        System.out.println(r.out);
        
        r.writer();
        
        System.out.format("toString: %s%n", r.file.toString());
    }
    
}

