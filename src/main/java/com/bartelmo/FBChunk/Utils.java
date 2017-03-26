package com.bartelmo.FBChunk;

import java.io.UnsupportedEncodingException;
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
        return Arrays.asList(
                (byte)(i >>> 24),
                (byte)(i >>> 16),
                (byte)(i >>> 8),
                (byte)i);
    }

    public static  List<Byte> getBytes(short i) {
        return Arrays.asList(
                (byte)(i >>> 8),
                (byte)i);
    }

    public static List<Byte> getByteObj(byte[] byteArr) {
        //I'd rather this one instance of bad code over important Guava
        List<Byte> bytes = new ArrayList<Byte>(byteArr.length);
        for(byte b : byteArr) {
            bytes.add(b);
        }
        return bytes;
    }

    /**
     * Puts a list into a delimitor seperated block of bytes
     * @param list
     * @param delim
     * @return
     * @throws UnsupportedEncodingException
     */
    public static List<Byte> getBytes(List<Integer> list, byte delim) throws UnsupportedEncodingException{
        List<Byte> data = new ArrayList<Byte>(list.size() * 4 + (list.size()));
        for(Integer integer : list) {
            data.addAll(Utils.getByteObj(Integer.toString(integer)
                    .getBytes("US-ASCII")));
            data.add(delim); //character code for space
        }
        data.remove(data.size() - 1);
        return data;
    }

    public static Date getDateTime(long biowareDateTime) {
        return new Date((biowareDateTime - Constants.BIOWARE_DT_OFFSET) * 1000);
    }
}
