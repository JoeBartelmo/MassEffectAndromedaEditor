package com.bartelmo.FBChunk;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 * Created by joe on 3/23/17.
 */
public class Descriptor {
    int fbHeaderLength;
    int dataLength;

    public Descriptor(DataInputStream dataStream)
            throws IOException {
        //Check FBCHUCNKS header
        if (dataStream.readLong() != Constants.FBCHUNKS) {
            throw new IOException("Invalid File magic for FBChunks file");
        }
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
    }
}
