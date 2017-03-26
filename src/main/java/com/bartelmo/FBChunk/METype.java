package com.bartelmo.FBChunk;

import java.util.List;
import java.util.ArrayList;

import java.io.UnsupportedEncodingException;

/**
 * Created by joe on 3/23/17.
 */
public class METype {
    public enum Data {
        String,
        Int32,
        Int64,
        Float,
        ListInteger,
        ListIntegerSemicolon,//i love when 2 developers want to use a different delimiter >.>
        Boolean
    }
    private Data typeDef;
    private String name;
    private int id;

    public METype() {

    }
    public METype(Data typeDef, String name, int id) {
        this.typeDef = typeDef;
        this.name = name;
        this.id = id;
    }

    public Data getTypeDef() {
        return typeDef;
    }
    public METype withTypeDef(Data def) {
            typeDef = def;
            return this;
    }
    public String getName() {
        return name;
    }
    public METype withName(String n) {
        name = n;
        return this;
    }
    public int getId() {
        return id;
    }
    public METype withId(int n) {
        id = n;
        return this;
    }

    public static String getStringFromData(byte[] data)
            throws UnsupportedEncodingException {
        return new String(data, "US-ASCII");
    }

    public static Object getTypeDefData(Data typeDef, byte[] data)
            throws UnsupportedEncodingException {
        switch(typeDef) {
            case String:
                return getStringFromData(data);
            case Int32:
                return Integer.getInteger(getStringFromData(data));
            case Int64:
                return Long.getLong(getStringFromData(data));
            case Float:
                return Float.valueOf(getStringFromData(data));
            case Boolean:
                return getStringFromData(data).toLowerCase().equals("true");
            case ListInteger:
            case ListIntegerSemicolon:
                //we convert them all to one type so i don't have to rewrite code
                String[] integers = getStringFromData(data)
                        .replace(" ", ";").split(";");
                List<Integer> toReturn = new ArrayList<Integer>();
                for(String str : integers) {
                    toReturn.add(Integer.getInteger(str));
                }

                return toReturn;
        }
        throw new UnsupportedEncodingException("Data type supplied is not of types listed in Data Enum");
    }

    public static int getIntFromData(byte[] data)
            throws UnsupportedEncodingException {
        return (Integer)getTypeDefData(Data.Int32, data);
    }
    public static long getLongFromData(byte[] data)
            throws UnsupportedEncodingException {
        return (Long)getTypeDefData(Data.Int64, data);
    }
    public static float getFloatFromData(byte[] data)
            throws UnsupportedEncodingException {
        return (Integer)getTypeDefData(Data.Float, data);
    }
    public static boolean getBooleanFromData(byte[] data)
            throws UnsupportedEncodingException {
        return (Boolean)getTypeDefData(Data.Boolean, data);
    }
    public static List<Integer> getIntListFromData(byte[] data)
            throws UnsupportedEncodingException {
        return (List<Integer>)getTypeDefData(Data.ListInteger, data);
    }

    public static Byte[] getBytes(METype metype, Object val) throws UnsupportedEncodingException {
        List<Byte> data = null;

        switch(metype.getTypeDef()) {
            case String:
                data = Utils.getByteObj(((String)val)
                        .getBytes("US-ASCII"));
                break;
            case Int32:
                data = Utils.getByteObj(Integer.toString((Integer)val)
                        .getBytes("US-ASCII"));
                break;
            case Int64:
                data = Utils.getByteObj(Long.toString((Long)val)
                        .getBytes("US-ASCII"));
                break;
            case Float:
                data = Utils.getByteObj(Float.toString((Float)val)
                        .getBytes("US-ASCII"));
                break;
            case Boolean:
                data = Utils.getByteObj(Boolean.toString((Boolean)val)
                        .toLowerCase().getBytes("US-ASCII"));
                break;
            case ListInteger:
                data = Utils.getBytes((List<Integer>)val, (byte)0x2e);
                break;
            case ListIntegerSemicolon:
                data = Utils.getBytes((List<Integer>)val, (byte)0x3b);
                break;
        }
        List<Byte> buffer = new ArrayList<Byte>();
        //ID for ME Type
        buffer.addAll(Utils.getBytes(metype.getId()));
        //Length of data
        buffer.addAll(Utils.getBytes((short)data.size()));
        //data
        buffer.addAll(data);

        return buffer.toArray(new Byte[buffer.size()]);
    }
}