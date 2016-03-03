package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import org.apache.log4j.Logger;

import main.java.com.epam.preprod.kushnarenko.entity.Bucket;

/**
 * Command that allows to add new Product with Id to the Bucket.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class AddToBucketCommand implements BucketCommand {

    private final static Logger logger = Logger.getLogger(AddToBucketCommand.class);

    @Override
    public Integer execute(Bucket bucket, Long id) {
        logger.debug(String.format("Adding product with id %d to bucket", id));
        logger.debug(String.format("Id = %d", id));
        Integer quantity = bucket.get(id);
        logger.debug(String.format("quantity = %d", quantity));
        if (quantity == null) {
            bucket.put(id, 1);
            return 1;
        } else {
            bucket.put(id, ++quantity);
            return quantity;
        }
    }

}
