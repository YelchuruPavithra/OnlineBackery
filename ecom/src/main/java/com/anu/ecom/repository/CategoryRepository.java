package com.anu.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.ecom.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{

}
