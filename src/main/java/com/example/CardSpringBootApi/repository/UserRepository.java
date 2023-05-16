package com.example.CardSpringBootApi.repository;

import com.example.CardSpringBootApi.model.User;
import com.example.CardSpringBootApi.model.UserStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Modifying
    @Transactional
    @Query("update User user set user.status = :status where user.oib = :oib")
    void setStatusForUser(@Param("status") UserStatus status, @Param("oib") Long oib);

    @Modifying
    @Transactional
    @Query("update User user set user.latestCardPath = :latestCardPath where user.oib = :oib")
    void setCardRequestPathForUser(@Param("latestCardPath") String latestCardPath, @Param("oib") Long oib);

    @Modifying
    @Transactional
    @Query("update User user set user.status = :status, user.latestCardPath = :latestCardPath where user.oib = :oib")
    void setStatusAndCardRequestPathForUser(@Param("status") UserStatus status,
                                            @Param("latestCardPath") String latestCardPath,
                                            @Param("oib") Long oib);
}
