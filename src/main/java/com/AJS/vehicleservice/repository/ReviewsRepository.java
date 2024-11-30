package com.AJS.vehicleservice.repository;
import com.AJS.vehicleservice.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    // Correct query based on Mechanics entity's primary key
    List<Reviews> findByWorker_Id(Long workerId);

    List<Reviews> findByUser_Id(Long userId);

}
