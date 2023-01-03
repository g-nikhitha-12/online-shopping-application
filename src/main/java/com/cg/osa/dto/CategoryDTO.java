package com.cg.osa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="category_table")
public class CategoryDTO {
	@Id
	@NotNull(message="sorry id cannot be null")
	@Column(name = "catid",length=20)
	String catId;
	@NotBlank(message = " enter the category")
	@Column(name = "catname",length=20)
	String catName;

	public CategoryDTO() {
		super();
	} 

	public CategoryDTO(String catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "CategoryDto [catId=" + catId + ", catName=" + catName + "]";
	}

}
