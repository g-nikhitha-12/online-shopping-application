package com.cg.osa.service;

import java.util.List;

import com.cg.osa.dto.CartDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.CartException;

public interface ICartService {
    public CartDTO addProductToCart(int cid,ProductDTO p)throws CartException;
    public CartDTO updatequantity(int cid,int pid , int qnt)throws CartException;
    public CartDTO removeProductFromCart(int cid,int pid)throws CartException;
    public CartDTO  viewAllProducts(int cid)throws CartException;
    public CartDTO  removeAllProducts(int cid)throws CartException;
    
	

}
