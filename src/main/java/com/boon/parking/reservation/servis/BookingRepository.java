package com.boon.parking.reservation.servis;

import com.boon.parking.reservation.servis.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID>, JpaSpecificationExecutor<BookingEntity> {

    @Query(value = "INSERT INTO booking(id, parking_space_id, start_time, end_time, user_name) SELECT "
            + ":id as id, :parkingSpaceId as parking_space_id, :startTime as start_time, :endTime as end_time, "
            + ":userName as user_name WHERE NOT EXISTS (SELECT id FROM booking WHERE parking_space_id = :parkingSpaceId AND "
            + "(:startTime, :endTime) OVERLAPS (start_time, end_time))", nativeQuery = true)
    @Modifying
    @Transactional
    int insertBookingIfNotExists(@Param("id" ) UUID id, @Param("parkingSpaceId" ) UUID parkingSpaceId,
                                 @Param("startTime" ) LocalDateTime startTime, @Param("endTime" ) LocalDateTime endTime,
                                 @Param("userName" ) String userName);

}
