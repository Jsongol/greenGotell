package com.green.greenGotell.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.ProfileUpdateDTO;
import com.green.greenGotell.domain.entity.EmployeePhotoEntity;
import com.green.greenGotell.domain.repository.EmployeePhotoEntityRepository;
import com.green.greenGotell.domain.repository.EmployeesEntityRepository;
import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.MypageService;
import com.green.greenGotell.util.GotellFileUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;

@RequiredArgsConstructor
@Service
public class MypageServiceProcess implements MypageService {

	private final EmployeesEntityRepository  employeesEntityRep;
	private final EmployeePhotoEntityRepository employeePhotoEntityRep;
	private final PasswordEncoder pe;
	
	
	private final S3Client s3Client;
	private final GotellFileUtil fileUtil;
	
	
	@Value("${spring.cloud.aws.s3.bucket}")
	private String bucket;
	
	@Value("${spring.cloud.aws.s3.upload-src}")
	private String src;

	
	//직원정보확인
	@Override
	public void mypagelist(CustomUserDetails userDetails, Model model) {
		
		
		
		model.addAttribute("maypageList", employeesEntityRep.findById(userDetails.getId()).orElseThrow().toEmployeeDTO().splitAddress());
		model.addAttribute("mypagePhoto", employeePhotoEntityRep.findByEmployeeId(userDetails.getId()).orElseThrow().toEmployeeDTO());
	}

	
	// 직원 프로필 수정
	@Transactional
	@Override
	public void profileUpdate(CustomUserDetails userDetails, ProfileUpdateDTO dto) {
		
		if(dto.getFileContent() != null) {
			String key=src+fileUtil.newFilenameWithoutExtension();
			Map<String, String> result=fileUtil.awsS3fileUpload(dto.getFileContent(), s3Client, bucket, key);
			
			
			 EmployeePhotoEntity photoEntity = employeePhotoEntityRep.findByEmployeeId(userDetails.getId()).orElseThrow().update(result.get("url"),key);

			 employeePhotoEntityRep.save(photoEntity);
			
			
		}
		
	
		 employeesEntityRep.findById(userDetails.getId()).orElseThrow().update(dto);


	
	}

    //현재 비밀번호와 일치하는지 확인
	@Override
	public boolean checkPassword(Long userId, String pass) {
		
		return pe.matches(pass, employeesEntityRep.findById(userId).orElseThrow().getPass());
	}


	//새 비밀번호 업데이트  
	@Transactional
	@Override
	public void passUpdate(CustomUserDetails userDetails, String newpass) {
		
		
		employeesEntityRep.findById(userDetails.getId()).orElseThrow().update(newpass,pe);
		
		
	}

}
