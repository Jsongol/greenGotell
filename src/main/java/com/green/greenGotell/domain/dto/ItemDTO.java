package com.green.greenGotell.domain.dto;

import java.math.BigDecimal;

import com.green.greenGotell.domain.entity.CategoryEntity;
import com.green.greenGotell.domain.entity.ItemEntity;
import com.green.greenGotell.domain.enums.ProductCategory;
import com.green.greenGotell.domain.enums.ProductMiddleCategory;
import com.green.greenGotell.domain.enums.ProductSmallCategory;
import com.green.greenGotell.domain.enums.Standard;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class ItemDTO {
	 private Long id;
	//상품코드
	private String itemCode;	
	//상품명
	private String name;
	//규격
	private Standard standard;
	//공급자
	private String itemSource;
	//가격
	private BigDecimal  itemMoney;
    private Long parentCategory;
    private String middleCategory;
    private String subCategory;
	
	
	public ItemEntity toEntity() {
		return ItemEntity.builder()
				.itemCode(itemCode)
				.name(name)
				.itemSource(itemSource)
				.standard(standard)
				.itemMoney(itemMoney)
				.build();
	}

}
