package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.entity.Bucket;

/**
 * Allows to increase quantity of product with specified Id.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class IncreaseBucketCommand implements BucketCommand {

    private final static Logger logger = Logger.getLogger(IncreaseBucketCommand.class);

    @Override
    public Integer execute(Bucket bucket, Long id) {
        logger.debug(String.format("Increasing quantity of product with id %d", id));
        logger.debug(String.format("Id = %d", id));
        Integer quantity = bucket.get(id);
        bucket.put(id, ++quantity);
        return quantity;
    }

}
