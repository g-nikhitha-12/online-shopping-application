package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.CategoryDTO;
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryDTO,String> {

}
