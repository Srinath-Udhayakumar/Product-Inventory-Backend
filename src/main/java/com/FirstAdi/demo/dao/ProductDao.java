package com.FirstAdi.demo.dao;

import com.FirstAdi.demo.table.ProductTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductTable, Integer> {
}
