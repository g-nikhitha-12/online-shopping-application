package com.cg.osa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.CartDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.CartException;
import com.cg.osa.repository.ICartRepository;
@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cartRepository;

	@Override
	public CartDTO updatequantity(int cid,int pid , int qnt) throws CartException{
		if(cartRepository.existsById(cid)) {
		ProductDTO it = null;
		CartDTO cart1 = cartRepository.findById(cid).get();
		List<ProductDTO> products = cart1.getProducts();
		for(ProductDTO p : products) {
			if(p.getProductId()==(pid))
			 it = p;
		}
		int qty = it.getQuantity();
		it.setQuantity(qnt+qty);
		cartRepository.save(cart1);
		return cart1;	
		}
		else {
			throw new CartException("np cart id found");
		}
		
	}
	@Override
	public CartDTO removeProductFromCart(int cid,int pid) throws CartException {
		if(cartRepository.existsById(cid)){
			CartDTO cart1=cartRepository.findById(cid).get();
					List<ProductDTO> p1=cart1.getProducts();
					List<ProductDTO> l=new ArrayList<ProductDTO>();
					for(ProductDTO i:l) {
						ProductDTO p=i;
						if(p.getProductId()!=pid) {
							l.add(p);
					}
					}
					cart1.setProducts(l);

					cartRepository.save(cart1);
					
					return cart1;
		}
		else {
			throw new CartException("wrong cart id");
		}
	}

	@Override
	public CartDTO viewAllProducts(int cid)throws CartException{
		if(cartRepository.existsById(cid)) {
	
			CartDTO cart1=cartRepository.findById(cid).get();
			cartRepository.save(cart1);
			return cart1;
		}
		else {
			throw new CartException("no cart found");
		}
	}
		

	@Override
	public CartDTO removeAllProducts(int cid)throws CartException {
		if(cartRepository.existsById(cid)) {
			CartDTO cart=cartRepository.findById(cid).get();
			List<ProductDTO> l=cart.getProducts();
		    l.clear();
		    cartRepository.save(cart);
		return cart;
		}
		else {
			throw new CartException("cart id not found");
		}
	}



	@Override
	public CartDTO addProductToCart(int cid,ProductDTO p) throws CartException {
		if(cartRepository.existsById(cid)) {
			CartDTO cart1=cartRepository.findById(cid).get();
			List<ProductDTO> products=cart1.getProducts();
			products.add(p);
			cart1.setProducts(products);
			cartRepository.save(cart1);
			
			return cart1;
			}
		else {
			throw new CartException("cart not found");
			
		}
				
		
	}

}
