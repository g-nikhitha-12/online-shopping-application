package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.ProductException;

public interface IProductService {
	public List<ProductDTO> viewAllProducts();
	public ProductDTO addProduct(ProductDTO product)throws ProductException;;
	public ProductDTO updateProduct(ProductDTO product)throws ProductException;
	public ProductDTO viewProductbyid(int id)throws ProductException;
	public ProductDTO removeProduct(int id)throws ProductException;
	List<ProductDTO> viewProductsByCatname(String cname)throws ProductException;

}
