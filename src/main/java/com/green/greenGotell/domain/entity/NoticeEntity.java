package com.green.greenGotell.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.dto.NoticeDetailDTO;
import com.green.greenGotell.domain.dto.NoticeListDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@SequenceGenerator(name = "gen_notice",
					sequenceName = "seq+notice", initialValue = 1, allocationSize = 1)

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "notice")
@Getter
@Entity
public class NoticeEntity extends BaseEntity { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_notice")
	private long no;
	
	@Column(nullable = false)
	private String title;
	@Column(columnDefinition = "text" ,nullable = false)
	private String content;
	
	private String division;	//구분-"전체","영화관"
	private boolean fixed;		//고정여부
	 
//	@Column(nullable = false)
//	private long id;     // 사원번호 필드 추가
	
	//편의메소드 매핑하기위한 메소드
	public NoticeListDTO toNoticeListDTO() {
		return NoticeListDTO.builder()
				.no(no)
				.title(title)
				.division(division)
				.fixed(fixed)
				.updatedAt(getUpdatedAt())
				.build();
	}

	public NoticeDetailDTO toNoticeDetailDTO() {
		return NoticeDetailDTO.builder()
				.no(no)
				.title(title)
				.content(content)
				.division(division)
				.createdAt(createdAt)
				.updatedAt(updatedAt)
				.build();
	}
	
	
	//제목 or 내용 수정
//	public NoticeEntity update(NoticeUpdateDTO dto) {
//		this.title=dto.getTitle();
//		this.content=dto.getContent();
//		return this;
//		
//	}
	
	
}
