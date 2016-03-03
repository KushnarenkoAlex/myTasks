package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * Container for keeping commands for working with bucket.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class BucketCommandContainer {

    private static Map<String, BucketCommand> commands = new HashMap<String, BucketCommand>();

    static {
        commands.put("addToBucket", new AddToBucketCommand());
        commands.put("increaseQuantity", new IncreaseBucketCommand());
        commands.put("decreaseQuantity", new DecreaseBucketCommand());
    }

    public static BucketCommand get(String key) {
        if (commands.get(key) != null) {
            return commands.get(key);
        }
        return new NoBucketCommand();
    }

}
