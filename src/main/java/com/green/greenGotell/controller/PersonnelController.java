package com.green.greenGotell.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.green.greenGotell.domain.dto.PageRequestDTO;
import com.green.greenGotell.domain.dto.employee.CreateEmployeeDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeListDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeSearchDTO;
import com.green.greenGotell.service.PersonnelService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class PersonnelController {
	
	private final PersonnelService personnelService;
	

    //통합직원목록조회
	@GetMapping("/personnel/list")
	public String list(@ModelAttribute PageRequestDTO pageDTO, EmployeeSearchDTO  searchDTO , Model model) {
        System.out.println("작동");
        System.out.println(searchDTO);
		model.addAttribute("employees",personnelService.showEmployeeList(pageDTO,searchDTO));
	
		return "views/personnel/employee/list";
	}
	
	

	
	
	//직원추가
	@PostMapping("/personnel/create")
	public String create(CreateEmployeeDTO dto) {
		personnelService.createEmployee(dto);
		
		return "redirect:/personnel/list";
	}
	
	
	//직원 수정폼 로드시 직원 데이터 채우기
	@GetMapping("/personnel/employee/{employeeId}")
	@ResponseBody
	public EmployeeListDTO getEmployeeData(@PathVariable(name = "employeeId") Long id) {
		EmployeeListDTO employee = personnelService.updatefindById(id);
	    return employee;
	}
	
	//직원 수정
	 @PutMapping("/personnel/update/{id}")
	   public String updateEmployee(@PathVariable(name = "id")  Long id,CreateEmployeeDTO employeeUpdateDTO) {
	       personnelService.updateEmployee(id, employeeUpdateDTO);
	       return "redirect:/personnel/list"; // 수정 후 직원 목록 페이지로 리다이렉트
     }
	 
	
	
	

	
	
	
	
	
}
