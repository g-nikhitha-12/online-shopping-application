package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.CartDTO;
@Repository
public interface ICartRepository extends JpaRepository<CartDTO,Integer> {

}
