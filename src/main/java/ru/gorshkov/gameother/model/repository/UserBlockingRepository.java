package ru.gorshkov.gameother.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gorshkov.gameother.model.entity.UserBlocking;

@Repository
public interface UserBlockingRepository extends JpaRepository<UserBlocking, Long> {
}
