package com.green.greenGotell.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.enums.ProductCategory;
import com.green.greenGotell.domain.enums.ProductMiddleCategory;
import com.green.greenGotell.domain.enums.ProductSmallCategory;
import com.green.greenGotell.domain.enums.Standard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "items")
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String codename;
    @Column(nullable = false)
    private String source;
    @Column(nullable = false)
    private String money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
