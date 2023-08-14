package com.example.backproject.Repository;


import com.example.backproject.Domain.Reservation_film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation_film,Long> {
}
