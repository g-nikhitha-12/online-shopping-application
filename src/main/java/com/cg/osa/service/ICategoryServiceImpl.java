package com.cg.osa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.dto.CategoryDTO;
import com.cg.osa.exception.CategoryException;
import com.cg.osa.repository.ICategoryRepository;
@Service
public class ICategoryServiceImpl implements ICategoryService{
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public CategoryDTO addCategory( CategoryDTO category) {
		categoryRepository.save(category);
		return category;
	}

	@Override
	public CategoryDTO updateCategory( CategoryDTO category)throws CategoryException{
		if(categoryRepository.existsById(category.getCatId())) {
		categoryRepository.save(category);
		return category;
		}
		else {
			throw new CategoryException("Category id not found");
		}
		
	}

	@Override
	public CategoryDTO removeCategory( String id) throws CategoryException {
		if(categoryRepository.existsById(id)) {
			CategoryDTO cat= categoryRepository.findById(id).get();
			categoryRepository.delete(cat);
			return cat;
		}
		else {
			throw new CategoryException("Category id not found");
		}
		
	}

	@Override
	public List<CategoryDTO> viewAllCategories() {
		return categoryRepository.findAll();
	}

}
