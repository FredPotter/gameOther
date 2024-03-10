package ru.gorshkov.gameother.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gorshkov.gameother.model.DTO.SellerDto;
import ru.gorshkov.gameother.model.entity.Review;
import ru.gorshkov.gameother.model.entity.User;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT u.id AS seller_id, " +
            "u.username, " +
            "u.lastLoginDate, " +
            "u.pathToAvatar, " +
            "AVG(r.rating) AS averageRating " +
            "FROM User u JOIN Review r " + // Предполагая, что у вас есть соответствующая связь в сущности User
            "ON u.id = r.Seller.id " +
            "WHERE u.accountStatus = 1 " +
            "GROUP BY u.id")
    public List<SellerDto> getSellers();
}
