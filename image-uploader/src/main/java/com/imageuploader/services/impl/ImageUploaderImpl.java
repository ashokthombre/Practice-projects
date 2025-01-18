package com.imageuploader.services.impl;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;      
import com.amazonaws.services.s3.model.*;
import com.imageuploader.exceptions.ImageUpoadException;
import com.imageuploader.models.ImageDetails;
import com.imageuploader.repositories.ImageRepository;
import com.imageuploader.services.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ImageUploaderImpl implements ImageUploader {


    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AmazonS3 client;


    @Value("${app.s3.bucket}")
    private String bucketName;

    @Override
    public String uploadImage(MultipartFile image) {

        String originalFilename = image.getOriginalFilename();

        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        ObjectMetadata metadata=new ObjectMetadata();
        metadata.setContentLength(image.getSize());

        try {
            PutObjectResult putObjectResult = client.putObject(new PutObjectRequest(bucketName, fileName, image.getInputStream(), metadata));

            String url = preSignedUrl(fileName);

            ImageDetails imageDetails=new ImageDetails();
            imageDetails.setImageUrl(url);
            imageDetails.setImageName(fileName);

            this.imageRepository.save(imageDetails);

            return url;


        } catch (IOException e) {

            throw new ImageUpoadException(e.getMessage());
        }




    }

    @Override
    public List<String> allFiles() {

        ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request().withBucketName(bucketName);

        ListObjectsV2Result listObjectsV2Result = client.listObjectsV2(listObjectsRequest);

        List<S3ObjectSummary> objectSummaries = listObjectsV2Result.getObjectSummaries();
        List<String> listOfFileUrl = objectSummaries.stream().map(item -> this.preSignedUrl(item.getKey())).collect(Collectors.toList());

        return listOfFileUrl;
    }

    @Override
    public String preSignedUrl(String fileName) {

        Date expirationDate =new Date();

        long time = expirationDate.getTime();
        int hour=2;
        time=time+hour*60*60*1000;

        expirationDate.setTime(time);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileName)
                .withMethod(HttpMethod.GET)
                .withExpiration(expirationDate);

        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);


        return url.toString();
    }

    @Override
    public String getImageUrlNyName(String fileName) {

        S3Object object = client.getObject(bucketName, fileName);
        String key = object.getKey();
        String fileUrl = preSignedUrl(key);
        return fileUrl;
    }
}
