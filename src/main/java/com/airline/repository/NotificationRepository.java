package com.airline.repository;
import com.airline.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotificationRepository extends JpaRepository<Notification, String> {
    
}
