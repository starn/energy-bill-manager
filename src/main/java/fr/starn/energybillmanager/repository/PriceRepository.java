package fr.starn.energybillmanager.repository;

import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("""
        SELECT price FROM Price price
        WHERE (
              price.isPRO = true
              AND :#{#client.isPRO()} = true
              AND :#{#client.getChiffreAffaire()} >= price.caMin
              AND :#{#client.getChiffreAffaire()} < price.caMin
              ) 
              OR (price.isPRO = false AND :#{#client.isPRO()} = false)
        """)
    Price findFirstBy(@Param("client") Client client);

    //@Query(value="select * from author a where a.first_name= :firstName", nativeQuery=true)
    //List<Author> getAuthorsByFirstName(String firstName);
}
