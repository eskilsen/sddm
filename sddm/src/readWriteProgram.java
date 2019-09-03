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

}
