package ru.gorshkov.gameother.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gorshkov.gameother.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
