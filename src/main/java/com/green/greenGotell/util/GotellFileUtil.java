package com.green.greenGotell.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Slf4j
@Component
public class GotellFileUtil {
	
	
	public Map<String, String> awsS3fileUpload(MultipartFile multipartFile,S3Client s3Client,String bucket,String bucketKey) {
		
		PutObjectRequest putObjectRequest=PutObjectRequest.builder()
				.bucket(bucket)
				.key(bucketKey)
				.contentType(multipartFile.getContentType())
				.acl(ObjectCannedACL.PUBLIC_READ)
				.build();
		RequestBody requestBody;
		try {
			requestBody = RequestBody.fromInputStream(multipartFile.getInputStream(), multipartFile.getSize());
			//S3 버킷에 이미지 파일 업로드 기능 지원
			s3Client.putObject(putObjectRequest, requestBody);
			log.debug("--->파일업로드 완료!");
		} catch (IOException e) {
			log.debug("error - s3 파일 업로드 처리 오류 : com.green.aws_s3_test.utils.DomovieFileUtil");
		}
		
		
		String url=getS3BucketObjectUrl(s3Client, bucket, bucketKey);
		
		Map<String, String> result=new HashMap<>();
		result.put("url", url);
		result.put("bucketKey", bucketKey);
		
		return result;
	}
	
	
	private String getS3BucketObjectUrl(S3Client s3Client,String bucket,String bucketKey) {
		return s3Client.utilities()
				.getUrl(obj->obj.bucket(bucket).key(bucketKey))
				.toString()
				.substring(6);
	}
	
	
	//파일이름확장자 제거 UUID를 이용하여 변경
	public String newFilenameWithoutExtension() {
		return UUID.randomUUID().toString(); //새로운이름을 UUID로 생성
	}
	


}
