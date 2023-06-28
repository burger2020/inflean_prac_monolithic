package com.prac.monolithic.awsmsamonolithicprac.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest

@Service
class S3Service(
    @Value("\${cloud.aws.region.static}") private val region: String,
    @Value("\${cloud.aws.s3.bucket}") private val bucket: String
) {

    private val s3: S3Client = S3Client.builder()
        .region(Region.of(region)) // Set your region
        .build()

    fun uploadFile(key: String, bytes: ByteArray): String {
        s3.putObject(
            PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build(),
            RequestBody.fromBytes(bytes)
        )
        return "https://s3.${region}.amazonaws.com/${bucket}/${key}"
    }
}