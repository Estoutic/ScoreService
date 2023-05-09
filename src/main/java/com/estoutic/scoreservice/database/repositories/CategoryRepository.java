package com.estoutic.scoreservice.database.repositories;

import com.estoutic.scoreservice.database.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,String > {
}
