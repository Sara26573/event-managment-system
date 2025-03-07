package com.example.eventmanagment.Repository;

import com.example.eventmanagment.Model.AllEvents;
import com.example.eventmanagment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository <AllEvents, Long> {

}
