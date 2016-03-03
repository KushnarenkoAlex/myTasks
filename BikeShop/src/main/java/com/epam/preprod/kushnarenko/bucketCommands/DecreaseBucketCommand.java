package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.entity.Bucket;

/**
 * Allows to decrease quantity of product with specified Id. If quantity is less
 * then 1 - method removes it from the Bucket.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class DecreaseBucketCommand implements BucketCommand {

    private final static Logger logger = Logger.getLogger(DecreaseBucketCommand.class);

    @Override
    public Integer execute(Bucket bucket, Long id) {
        logger.debug(String.format("Decreasing quantity of product with id %d", id));
        logger.debug(String.format("Id = %d", id));
        bucket.put(id, bucket.get(id) - 1);
        Integer quantity = bucket.get(id);
        if (quantity < 1) {
            bucket.remove(id);
            return 0;
        }
        return quantity;
    }

}
