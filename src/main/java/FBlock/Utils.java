package FBlock;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    /**
     * Returns a byte array representation of an integer
     * @param i
     * @return byte[]
     */
    public static Byte[] IntToBytes(int i) {
        return new Byte[] {
                (byte)(i >>> 24),
                (byte)(i >>> 16),
                (byte)(i >>> 8),
                (byte)i };
    }

    public static Byte[] toByteArr(byte[] byteArr) {
        return Arrays.asList(byteArr)
                .stream()
                .map(b -> (Byte)b)
                .collect(Collectors.toList());
    }
}
