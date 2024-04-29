package com.springbootprojectdress.Basics.repositiory;

import com.springbootprojectdress.Basics.entity.Rating;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "select product_id from (select r.product_id, sum(r.ratings)/count(r.id) as product_rating from rating r group by r.product_id)  dt where product_rating >= :filtered_rating", nativeQuery = true)
    List<Long> findProductsByRating(@Param("filtered_rating") int filterRating);
}
