package com.cg.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.osa.dto.ProductDTO;

public interface IProductRepository extends JpaRepository<ProductDTO,Integer>{

}
