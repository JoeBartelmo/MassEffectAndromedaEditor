package com.bartelmo.FBChunk;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 * Created by joeba on 3/25/2017.
 */
public class FBHeader {

    public FBHeader(DataInputStream dataStream)
            throws IOException {
        //Check FBHEADER header
        if (dataStream.readLong() != Constants.FBHEADER) {
            throw new IOException("Invalid magic for FBHeader");
        }
        //Check version
        if(dataStream.readShort() != 1) {
            throw new IOException("Incorrect Version of FBHeader descriptor");
        }

    }
}
