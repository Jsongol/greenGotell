package com.green.greenGotell.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.dto.ItemDTO;
import com.green.greenGotell.domain.enums.ProductCategory;
import com.green.greenGotell.domain.enums.ProductMiddleCategory;
import com.green.greenGotell.domain.enums.ProductSmallCategory;
import com.green.greenGotell.domain.enums.Standard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicUpdate
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="item") 
public class ItemEntity { //품목리스트 추가 테이블
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//상품코드
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String itemCode;
	//상품명
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String name;
	//공급자
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String itemSource;
	//가격
	@Column(nullable = false, columnDefinition = "bigint")
	private long itemMoney;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	
	//수량단위
	@Enumerated(EnumType.STRING)
	private Standard standard;
	
	
	
}
