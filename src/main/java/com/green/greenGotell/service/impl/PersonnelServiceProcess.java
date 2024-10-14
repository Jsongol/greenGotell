package com.green.greenGotell.service.impl;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.PageRequestDTO;
import com.green.greenGotell.domain.dto.PageResultDTO;
import com.green.greenGotell.domain.dto.employee.CreateEmployeeDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeListDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeSearchDTO;
import com.green.greenGotell.domain.entity.EmployeePhotoEntity;
import com.green.greenGotell.domain.entity.EmployeeScheduleEntity;
import com.green.greenGotell.domain.entity.EmployeesEntity;
import com.green.greenGotell.domain.repository.EmployeePhotoEntityRepository;
import com.green.greenGotell.domain.repository.EmployeeScheduleEntityRepository;
import com.green.greenGotell.domain.repository.EmployeesEntityRepository;
import com.green.greenGotell.service.PersonnelService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonnelServiceProcess implements PersonnelService {

	private final EmployeesEntityRepository rep;
	private final EmployeePhotoEntityRepository employeePhotoEntityRep;
	private final EmployeeScheduleEntityRepository employeeScheduleEntityRepository;
	private final PasswordEncoder pe;
	
	//직원가입
	@Override
	public void createEmployee(CreateEmployeeDTO dto) {
		
		 EmployeesEntity employee=rep.save(dto.toEntity(pe));
		 
	    // 프로필 엔티티 생성 및 저장
	     EmployeePhotoEntity photoEntity = EmployeePhotoEntity.builder()
	                .employee(employee) // 저장된 직원 엔티티 사용 자동으로 id값 매핑
	                .fileContent(null) // 초기에는 null할당
	                .build();

	        employeePhotoEntityRep.save(photoEntity);
	        
	        
	    //초기 직원 스케쥴 임의 할당
	        EmployeeScheduleEntity  scheduleEntity= EmployeeScheduleEntity.builder()
	        		.employee(employee)
	        		.scheduledStart(LocalTime.of(9, 0))
	        		.scheduledEnd(LocalTime.of(18, 0))
	        		.build();
	        
	        employeeScheduleEntityRepository.save(scheduleEntity);
	        
	    }
	

	 
    //통합 직원정보
	@Override
	public PageResultDTO<EmployeeListDTO, EmployeesEntity> showEmployeeList(PageRequestDTO pageDTO, EmployeeSearchDTO  searchDTO) {

		Pageable pageable =pageDTO.getPageable(Sort.by(Direction.DESC,"id").descending());
		
		
		List<EmployeesEntity> employeesAll = null;
		Page<EmployeesEntity> employees;
	
		
		//직원 검색이 없을경우
		if(searchDTO==null) {
			
			
			employeesAll= rep.findAll();
		    employees = rep.findAll(pageable);
			
		
			
		//검색 할 경우	
		}else {
			employeesAll=  rep.findBySearchEmployee(
					searchDTO.getDepartment(),
					searchDTO.getEmployeeStatus(),
					searchDTO.getName());
			
			employees = rep.findBySearchEmployee(
					searchDTO.getDepartment(),
					searchDTO.getEmployeeStatus(),
					searchDTO.getName(),
					pageable
	        );
			
		}
		
		return new PageResultDTO<>(employees,employeesAll, EmployeesEntity::toEmployeeDTO);
	}
	
	
		

   //수정버튼클릭시 보여줄 직원 정보 전송
	@Override
	public EmployeeListDTO updatefindById(Long id) {
		
		  EmployeeListDTO employee = rep.findById(id).orElseThrow().toEmployeeDTO();
		  
		  employee.setHighestRole(employee.getHighRole());
		
		return employee;
	}

	// 직원 정보 수정
	@Transactional
	@Override
	public void updateEmployee(Long id, CreateEmployeeDTO employeeUpdateDTO) {
		
		
		 EmployeesEntity employee=rep.findById(id).orElseThrow().update(employeeUpdateDTO);
				 
				  
		
	}








	


}
