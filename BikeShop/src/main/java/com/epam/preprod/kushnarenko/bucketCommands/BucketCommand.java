package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import main.java.com.epam.preprod.kushnarenko.entity.Bucket;

/**
 * Interface for working with bucket. Need of this interface is in realization
 * of pattern Command. To use it correctly, you have to get a needed command
 * from BucketCommandContainer and execute Command on Bucket.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public interface BucketCommand {

    /**
     * This is the method that performs action that specified in the name of the class.
     * 
     * @param bucket
     *            - bucket witch we have to change
     * @param id
     * @return
     */
    public Integer execute(Bucket bucket, Long id);

}
