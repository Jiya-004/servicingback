package com.AJS.vehicleservice.repository;
import com.AJS.vehicleservice.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUser_Id(Long userId);  // Use _Id if primary key is 'id'

    List<Bookings> findByWorker_Id(Long workerId); // Correct for 'worker'

}

