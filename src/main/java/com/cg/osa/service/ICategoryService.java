package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.dto.CategoryDTO;
import com.cg.osa.exception.CategoryException;

public interface ICategoryService {
	public CategoryDTO addCategory(CategoryDTO category);
	public CategoryDTO updateCategory(CategoryDTO category)throws CategoryException;
	public CategoryDTO removeCategory(String id)throws CategoryException;
	public List<CategoryDTO> viewAllCategories();

}
