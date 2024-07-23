package com.green.greenGotell.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.domain.dto.NoticeUpdateDTO;
import com.green.greenGotell.domain.entity.NoticeEntity;
import com.green.greenGotell.domain.repository.NoticeEntityRepository;
import com.green.greenGotell.service.NoticeService;


import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Service
public class NoticeServiceProcess implements NoticeService{
	
	private final NoticeEntityRepository repository;

	@Override
	public void listProcess(int _division, Model model) {//부서번호(int _division), 정보를 저장할 모델객체(Model model)
		
		int page=1;
		int pageSize = 10;
		
		Sort sort=Sort.by(Direction.DESC, "fixed","no");
		Pageable pageable=PageRequest.of(page-1, pageSize, sort);
		
		String division;
	    switch (_division) {
	        case 1:
	        	division = "전체";
	            break;
	        case 2:
	        	division = "프론트오피스부";
	            break;
	        case 3:
	        	division = "식음료부";
	            break;
	        case 4:
	        	division = "시설관리부";
	            break;
	        case 5:
	        	division = "보안부";
	            break;
	        case 6:
	        	division = "인사부";
	            break;
	        case 7:
	        	division = "지원부";
	            break;
	        case 8:
	        	division = "마케팅부";
	            break;
	        default:
	        	division = "전체";
	    }
		
		//JPA 쿼리메서드 : findAll() 사용자가 만들수 있는 쿼리메서드 문법-키워드
		Page<NoticeEntity> result=repository.findAllByDivision(division, pageable);
		
		//_division가 0이면 모든 항목 페이지에 출력
		if (_division==0) {
            result = repository.findAll(pageable);
        } else {//_division가 0이 아니면 해당 부서별 페이지 출력
            result = repository.findAllByDivision(division, pageable);
        }
		
		model.addAttribute("list", result.getContent().stream()
										.map(NoticeEntity::toNoticeListDTO)//메서드 참조를 사용할 수 있다
										.collect(Collectors.toList()));	
		
	}	

	//공지사항 저장 처리
	@Override
	public void saveProcess(NoticeSaveDTO dto) {		
		repository.save(dto.toEntity());
	}

	//공지사항 상세 페이지 출력
	@Override
	public void detailProcess(long no, Model model) { // 상세정보 조회해서 model에 담아라
		//Null Pointer Exception 방지:
		NoticeEntity result=repository.findById(no).orElseThrow();
		model.addAttribute("detail", result.toNoticeDetailDTO());
		repository.save(result);
		//JPA를 사용시 SqlSession이유지되는 동안 Entity가 수정되면 -> update쿼리가 처리됨
		
	}

	//no(pk)해당하는 공지사항 상세페이지에서 수정 기능
	@Override
	@Transactional
	public void updateProcess(long no, NoticeUpdateDTO dto) {
		// 1. 수정할 대상을 조회 2. 변경사항을 적용 -> 변경된entity 저장
		repository.findById(no).orElseThrow().update(dto);
				
	}


	//no(pk)해당하는 공지사항 DB에서 삭제
	@Override
	public void deleteProcess(long no) {
		repository.delete(repository.findById(no).orElseThrow());
		
	}

}
