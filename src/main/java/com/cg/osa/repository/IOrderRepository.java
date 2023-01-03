package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.OrderDTO;
@Repository
public interface IOrderRepository extends JpaRepository<OrderDTO, Integer> {

}
