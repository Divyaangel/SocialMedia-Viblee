package com.example.product.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Notifications;


@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

}
