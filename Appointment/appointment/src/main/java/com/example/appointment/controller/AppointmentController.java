package com.example.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.appointment.model.Appointment;
import com.example.appointment.service.AppointmentService;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("appointmentForm");
        mav.addObject("appointment", new Appointment());
        return mav;
    }

    @PostMapping("/")
    public ModelAndView submitForm(@Valid @ModelAttribute Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("appointmentForm");
        }
        appointmentService.save(appointment);
        ModelAndView mav = new ModelAndView("resultPage");
        mav.addObject("appointment", appointment);
        return mav;
    }

    @GetMapping("/appointments")
    public ModelAndView listAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        ModelAndView mav = new ModelAndView("appointmentList");
        mav.addObject("appointments", appointments);
        return mav;
    }

    @GetMapping("/appointments/edit/{id}")
    public ModelAndView editAppointment(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("appointmentForm");
        Appointment appointment = appointmentService.findById(id);
        mav.addObject("appointment", appointment);
        return mav;
    }

    @PostMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return "redirect:/appointments";
    }
}
