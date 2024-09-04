package com.rolemberg.eventostech.Config.Aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.s3.access.key}")
    private String access_key;
    @Value("${aws.s3.secret.key}")
    private String secret_key;

    @Bean
    public AmazonS3 client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        return AmazonS3ClientBuilder
            .standard()
            .withRegion(region)
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .build();
    }
}
