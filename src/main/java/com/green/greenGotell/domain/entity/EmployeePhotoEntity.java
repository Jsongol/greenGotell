package com.green.greenGotell.domain.entity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.dto.EmployeeListDTO;
import com.green.greenGotell.domain.dto.ProfileImageDTO;
import com.green.greenGotell.domain.dto.ProfileUpdateDTO;
import com.green.greenGotell.domain.enums.Department;
import com.green.greenGotell.domain.enums.EmployeeStatus;
import com.green.greenGotell.domain.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "employeePhoto")
@Entity
public class EmployeePhotoEntity {
	
    //프로필아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //프로필을 설정한 직원
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id", unique = true, nullable = false)
    private EmployeesEntity employee;
    
    private String profileImageUrl;
  	private String profileImagekey;


    //프로필의 소스코드 
    @Lob
    @Column(nullable = false, columnDefinition = "MEDIUMBLOB")
    private byte[] fileContent; //최대 16mb


    
    public EmployeePhotoEntity update(String profileImageUrl,String key) {
    	
    	this.profileImagekey=key;
    	this.profileImageUrl=profileImageUrl;
    	
    
        return this; // 업데이트 후 현재 객체를 반환
    }

    //직원 정보 얻어올때 dto
	public EmployeeListDTO toEmployeeDTO() {
		
		return EmployeeListDTO.builder().profileImageUrl(profileImageUrl).build();
		
	}

 

 
	
	
	

}
