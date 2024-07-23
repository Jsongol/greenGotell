package com.green.greenGotell.domain.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.green.greenGotell.domain.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@Getter
public class CategoryDTO {

	private Long id;
    private String name;
    private int level;
    //private List<CategoryDTO> children;
    
    /*
    public static CategoryDTO fromEntity(CategoryEntity category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .level(category.getLevel())
                .build();
    }
    */

}