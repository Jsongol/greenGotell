package com.green.greenGotell.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.CreateEmployeeDTO;
import com.green.greenGotell.domain.entity.EmployeePhotoEntity;
import com.green.greenGotell.domain.entity.EmployeesEntity;
import com.green.greenGotell.domain.repository.EmployeePhotoEntityRepository;
import com.green.greenGotell.domain.repository.EmployeesEntityRepository;
import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.PersonnelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonnelServiceProcess implements PersonnelService {

	private final EmployeesEntityRepository rep;
	private final EmployeePhotoEntityRepository employeePhotoEntityRep;
	private final PasswordEncoder pe;
	
	//직원가입
	@Override
	public void createEmployee(CreateEmployeeDTO dto) {
		
		 EmployeesEntity employee=rep.save(dto.toEntity(pe));
		 
	    // 프로필 엔티티 생성 및 저장
	     EmployeePhotoEntity photoEntity = EmployeePhotoEntity.builder()
	                .employee(employee) // 저장된 직원 엔티티 사용 자동으로 id값 매핑
	                .fileContent(new byte[0]) // 초기에는 null할당
	                .build();

	        employeePhotoEntityRep.save(photoEntity);
	    }
	
	
    //페이지 로드시 전체 직원정보 
	@Override
	public void showEmployeeList(Model model) {
		
		Sort sort=Sort.by(Direction.DESC,"id");
		
		Pageable pageable=PageRequest.of(0, 15, sort);
		
		Page<EmployeesEntity> employees = rep.findAll(pageable);
		
		model.addAttribute("employees", employees.getContent().stream().map(EmployeesEntity :: toEmployeeDTO).collect(Collectors.toList()));
		
	}
		
	
	


}
