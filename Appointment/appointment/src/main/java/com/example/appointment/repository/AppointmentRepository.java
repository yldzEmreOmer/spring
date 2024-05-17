package com.example.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appointment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
