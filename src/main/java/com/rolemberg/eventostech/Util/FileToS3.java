package com.rolemberg.eventostech.Util;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import static java.util.UUID.randomUUID;

@Component
public class FileToS3 {

    @Value("${aws.bucket.name}")
    private String bucket_name;
    @Autowired
    private AmazonS3 client;

    public String uploadToS3(MultipartFile image) {
        String img_name = randomUUID() + "-" + image.getOriginalFilename();
        try {
            File file = convertMultipartToFile(image);
            client.putObject(bucket_name, img_name, file);
            file.delete();
            return client.getUrl(bucket_name, img_name).toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }
}
