package FBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

/**
 * Created by joe on 3/23/17.
 */
public class Constants {
    private static final Map<Integer, METype> knownTypes;
    static {
        HashMap<Integer, METype> types = new HashMap<Integer, METype>();

        //explicitly define all so there's no confusion
        types.put(0x18090fed, new METype()
                .withId(0x18090fed)
                .withName("Unknown")
                .withTypeDef(METype.Data.Int32)); //appears to represent letter 0
        types.put(0x18090fed, new METype()
                .withId(0xb73ffe0c)
                .withName("Location")
                .withTypeDef(METype.Data.String));
        types.put(0x346eaf1, new METype()
                .withId(0x346eaf1)
                .withName("Unknown")
                .withTypeDef(METype.Data.String));//appears to represent letters "101"
        types.put(0x4d86fb47, new METype()
                .withId(0x4d86fb47)
                .withName("Unknown <Nullable>")
                .withTypeDef(METype.Data.String));//appears to be nullin my files
        types.put(0xc8e7f2d2, new METype()
                .withId(0xc8e7f2d2)
                .withName("Game Install Grouping")
                .withTypeDef(METype.Data.String));//don't change this
        types.put(0x6340d6a9, new METype()
                .withId(0x6340d6a9)
                .withName("Pathfinder Save Name")
                .withTypeDef(METype.Data.String));
        types.put(0x5261103a, new METype()
                .withId(0x5261103a)
                .withName("Pathfinder In-game Name")
                .withTypeDef(METype.Data.String));
        types.put(0x12a98e23, new METype()
                .withId(0x12a98e23)
                .withName("Profile ID")
                .withTypeDef(METype.Data.String));
        types.put(0x574d2d1e, new METype()
                .withId(0x574d2d1e)
                .withName("Game Level")
                .withTypeDef(METype.Data.String));
        types.put(0xf5339720, new METype()
                .withId(0xf5339720)
                .withName("Pathfinder Level")
                .withTypeDef(METype.Data.String));
        types.put(0x3e8c1126, new METype()
                .withId(0x3e8c1126)
                .withName("Unknown <Boolean>")
                .withTypeDef(METype.Data.String));
        types.put(0xcae59484, new METype()
                .withId(0xcae59484)
                .withName("Unknown <Boolean>")
                .withTypeDef(METype.Data.String));
        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));
        types.put(0xc163a5e4, new METype()
            .withId(0xc163a5e4)
            .withName("Bioware Timestamp")// val - 210866831999 = unix timestamp
            .withTypeDef(METype.Data.String));
        types.put(0x31b2a7de, new METype()
                .withId(0x31b2a7de)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));
        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));

        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));

        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));

        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));

        types.put(0x53de4f39, new METype()
                .withId(0x53de4f39)
                .withName("Unknown <Series of numbers seperated by space>")
                .withTypeDef(METype.Data.String));


        0x8587ff46
        0x17d7b226
        0x30e1a056
        0xa07dc1ee

                eof, next is checksum
        0xaaeaff15


        knownTypes = Collections.unmodifiableMap(types);
    }
}
