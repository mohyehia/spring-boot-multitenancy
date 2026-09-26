package com.moh.yehia.multitenancy.repository;

import com.moh.yehia.multitenancy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
