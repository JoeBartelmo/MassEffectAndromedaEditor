package com.bartelmo.FBChunk;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Utils {
    /**
     * Returns a byte array representation of an integer
     * @param i
     * @return byte[]
     */
    public static List<Byte> getBytes(int i) {
        return Arrays.asList(new Byte[] {
                (byte)(i >>> 24),
                (byte)(i >>> 16),
                (byte)(i >>> 8),
                (byte)i});
    }

    public static  List<Byte> getBytes(short i) {
        return Arrays.asList(new Byte[] {
                (byte)(i >>> 8),
                (byte)i});
    }

    public static List<Byte> getByteObj(byte[] byteArr) {
        //I'd rather this one instance of bad code over important Guava
        List<Byte> bytes = new ArrayList<Byte>(byteArr.length);
        for(int index = 0; index < byteArr.length; index++) {
            bytes.add(byteArr[index]);
        }
        return bytes;
    }

    public static Date getDateTime(long biowareDateTime) {
        return new Date((biowareDateTime - Constants.BIOWARE_DT_OFFSET) * 1000);
    }
}
