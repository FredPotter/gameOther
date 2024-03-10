package ru.gorshkov.gameother.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gorshkov.gameother.model.entity.Category;
import ru.gorshkov.gameother.model.entity.Game;
import ru.gorshkov.gameother.model.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
    List<Offer> findOffersByGameAndCategoryOrderByPricePerLot(Game game, Category category);
    List<Offer> findOffersByGame(Game game);
    //Наверное не пригодиться TODO: Потом возможно убрать
    int countAllByGameAndCategory(Game game, Category category);
}
