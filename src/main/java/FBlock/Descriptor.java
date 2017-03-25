package FBlock;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 * Created by joe on 3/23/17.
 */
public class Descriptor {
    int fbHeaderLength;
    int dataLength;
    byte[] unknown11Bytes = new byte[11];
    public Descriptor(DataInputStream dataStream)
            throws IOException, DataFormatException {
        //Check FBCHUCNKS header
        //Check version
        if(dataStream.readShort() != 1) {
            throw new IOException("Incorrect Version of FBCHUNKS descriptor");
        }

        fbHeaderLength = dataStream.readInt();
        dataLength = dataStream.readInt(); //total length after header is done
        dataStream.readInt();//CRC32 of whole Header (preceeded with 0x12345678)
        if(dataStream.readShort() != 1) {
            throw new IOException("Invalid FBHeader chunk");
        }
        //we're gonna hold onto this
        dataStream.read(unknown11Bytes, 0, 11);

    }
}
