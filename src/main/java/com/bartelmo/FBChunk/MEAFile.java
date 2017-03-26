package com.bartelmo.FBChunk;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by joeba on 3/25/2017.
 */
public class MEAFile {
    String file;
    Descriptor descriptor;
    FBHeader fbHeader;
    public MEAFile(String file) throws FileNotFoundException, IOException {
        this.file = file;

        FileInputStream fs = new FileInputStream(file);
        DataInputStream stream = new DataInputStream(fs);

        this.descriptor = new Descriptor(stream);
        this.fbHeader = new FBHeader(stream);

        stream.close();
        fs.close();
    }
}
