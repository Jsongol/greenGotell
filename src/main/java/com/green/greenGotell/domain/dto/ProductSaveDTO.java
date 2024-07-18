package com.green.greenGotell.domain.dto;

import com.green.greenGotell.domain.entity.InventoryEntity;
import com.green.greenGotell.domain.enums.ProductCategory;
import com.green.greenGotell.domain.enums.ProductMiddleCategory;
import com.green.greenGotell.domain.enums.ProductSmallCategory;
import com.green.greenGotell.domain.enums.Standard;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class ProductSaveDTO {
	//대분류
	private ProductCategory productCategory;
	//중분류
	private ProductMiddleCategory productMiddleCategory;
	//소분류
	private ProductSmallCategory productSmallCategory;
	//상품코드
	private String productCode;
	//상품명
	private String name;
	//규격
	private Standard standard;
	//공급자
	private String itemSource;
	//가격
	private long itemMoney;
	
	public InventoryEntity toEntity() {
		
		return InventoryEntity.builder()
				.productCategory(productCategory)
				.productMiddleCategory(productMiddleCategory)
				.productSmallCategory(productSmallCategory)
				.productCode(productCode)
				.name(name)
				.standard(standard)
				.itemSource(itemSource)
				.itemMoney(itemMoney)
				.build();
	}
	
	

}
