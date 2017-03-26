package com.bartelmo.FBChunk;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

/**
 * Created by joeba on 3/25/2017.
 */
public class FBHeader {
    Map<METype, Object> fbHeaderValues;

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

        int fbHeaderLength = dataStream.readInt();
        fbHeaderValues = new HashMap<METype, Object>(fbHeaderLength);

        for(int meTypeIndex = 0; meTypeIndex < fbHeaderLength; meTypeIndex++) {
            int keyId = dataStream.readInt();
            METype key = Constants.HEADER_TYPES.get(keyId);
            if(key == null) {
                key = new METype()
                        .withId(keyId)
                        .withName("Unknown -- unknown ID: " +
                                Integer.toHexString(keyId).toLowerCase())
                        .withTypeDef(METype.Data.String);//default
            }
            byte[] data = new byte[dataStream.readShort()];
            if (data.length > 0) {
                dataStream.readFully(data);
            }
            else {
                data = null;
            }

            fbHeaderValues.put(key, METype.getTypeDefData(key.getTypeDef(), data));
        }

        dataStream.readInt();//checksum for next block
    }
}
