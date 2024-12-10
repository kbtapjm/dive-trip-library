package io.divetrip.domain.repository;

import io.divetrip.domain.entity.Payment;
import io.divetrip.domain.entity.TripReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    List<Payment> findByTripReservation(final TripReservation tripReservation);

}
