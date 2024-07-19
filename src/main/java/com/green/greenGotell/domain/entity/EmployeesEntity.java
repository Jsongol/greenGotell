package com.green.greenGotell.domain.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.enums.Department;
import com.green.greenGotell.domain.enums.EmployeeStatus;
import com.green.greenGotell.domain.enums.Role;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "employees")
@Entity
public class EmployeesEntity extends BaseEntity {
	
	//사번
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//이름
	@Column(nullable = false,columnDefinition = "varchar(20)")
	private String name;
	
	//이메일
	@Column(unique = true, nullable = false,columnDefinition = "varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String email;
	
	//비밀번호
	@Column(nullable = false,columnDefinition = "varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String pass;
	
	//전화번호
	@Column(columnDefinition = "varchar(11)")
	private String phone;
	
	//주소
	@Column(columnDefinition = "varchar(255)")
	private String address;
	
	//입사일
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate hireDate;
	
	//부서
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Department department ;
	
	//상태
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EmployeeStatus employeeStatus ;
	
	//롤
	@Enumerated(EnumType.STRING) 
	@CollectionTable(name = "role"
					,joinColumns = @JoinColumn(name="employees_id"))
	@ElementCollection(fetch = FetchType.EAGER) 
	@Builder.Default 
	@Column(name = "role_name") 
	private Set<Role> roles=new HashSet<>();
	
	//Role 등록하기 위한 편의 메서드 
	public EmployeesEntity addRole(Role role) {
		roles.add(role);
		
		return this;
	}	
	
		//0:EMP(사원), 1:DIR(부장), 2:CEO(총지배인)//엔티티에서 보낼때 반복문으로 돌려서 원하는 권한만큼 배열에 저장시켜서 보내는 메소드
	public EmployeesEntity addRole(String role) {
		
		Role target=Role.valueOf(role);
		
		for(int i=0; i<=target.ordinal(); i++) {
			addRole(Role.values()[i]);
		}
		return this;
	}

	public void setResetToken(String token) {
		// TODO Auto-generated method stub
		
	}

}
