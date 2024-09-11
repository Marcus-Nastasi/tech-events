package com.rolemberg.eventostech.Util;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static java.util.UUID.randomUUID;

@Component
public class FileToS3 {

    @Value("${aws.bucket.name}")
    private String bucket_name;
    @Autowired
    private AmazonS3 client;

    public String uploadToS3(MultipartFile image) {
        String img_name = "eventos-tech-" + randomUUID() + "-" + image.getOriginalFilename();
        try {
            File file = convertMultipartToFile(image);
            client.putObject(bucket_name, img_name, file);
            file.delete();
            return client.getUrl(bucket_name, img_name).toString();
        } catch (Exception e) {
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

    public boolean deleteFromS3(String fileUrl) {
        try {
            String fileKey = extractFileKeyFromUrl(fileUrl);
            client.deleteObject(bucket_name, fileKey);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String extractFileKeyFromUrl(String fileUrl) throws RuntimeException {
        try {
            URL url = new URL(fileUrl);
            return url.getPath().substring(1);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL inválida");
        }
    }
}
