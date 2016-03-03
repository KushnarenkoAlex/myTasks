package main.java.com.epam.preprod.kushnarenko.bucketCommands;

import main.java.com.epam.preprod.kushnarenko.entity.Bucket;

public class NoBucketCommand implements BucketCommand {

    @Override
    public Integer execute(Bucket bucket, Long product) {
        return 0;
    }

}
