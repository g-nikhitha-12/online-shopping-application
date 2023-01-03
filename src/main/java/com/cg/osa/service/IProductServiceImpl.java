package com.cg.osa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.ProductException;
import com.cg.osa.repository.IProductRepository;
@Service

public class IProductServiceImpl implements IProductService{
	@Autowired
	IProductRepository productrepository;;
	public List<ProductDTO> viewAllProducts(){
		List<ProductDTO> list=productrepository.findAll();
		return list;
	}
	public ProductDTO addProduct(ProductDTO product)throws ProductException {
		if(productrepository.existsById(product.getProductId())) {
			throw new ProductException("product already exist");
		}
		else {
		productrepository.save(product);
		return product;
		}
	}
	
	public ProductDTO updateProduct(ProductDTO product)throws ProductException {
		if(productrepository.existsById(product.getProductId())) {
		productrepository.save(product);
		return product;
		}else {
			throw new ProductException("Id not found");
		}
	}
	public  ProductDTO viewProductbyid(int id) throws ProductException {
		if(productrepository.existsById(id))
			return productrepository.findById(id).get();
		else {
			throw new ProductException("Id not found");
		}
	}

	public ProductDTO removeProduct(int id)throws ProductException{
		if(productrepository.existsById(id)) {
			ProductDTO product=productrepository.findById(id).get();
			productrepository.deleteById(id);
			return product;
		}
		else {
			throw new ProductException("Id not found");
		}
	}

public List<ProductDTO> viewProductsByCatname(String cname)throws ProductException {
	List<ProductDTO> list= productrepository.findAll();
 	 
 	 List<ProductDTO> cat =list.stream().filter(productDTO->productDTO.getCategory().getCatName().equals(cname)).collect(Collectors.toList());
 	  if(cat.size()!=0) {
 		  return cat;
 	  }
 		  else {
 			  throw new ProductException("no products of the category "+cname);
 		  }
 		  
}	

}
