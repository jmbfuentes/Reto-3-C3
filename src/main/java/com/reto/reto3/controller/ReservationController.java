package com.reto.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.reto3.model.Reservation;
import com.reto.reto3.model.DTOs.CountClient;
import com.reto.reto3.model.DTOs.CountStatus;
import com.reto.reto3.service.ReservationService;



@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> obtenerReservationall(){
        return reservationService.obtenerReservationall();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> obtenerReservationId(@PathVariable("id") Integer id){
        return reservationService.obtenerReservationaId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation salvarReservation (@RequestBody Reservation reservation){
        return reservationService.salvarReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation actualizarReservation(@RequestBody Reservation reservation){
        return reservationService.actualizarReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarReservation(@PathVariable("id") int reservationId){
        return reservationService.borrarReservation(reservationId);

    }

    //reto5

    @GetMapping("/report-clients")
    public List<CountClient> getReportTopClients(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationPeriod(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
        //public List<Reservation> getReportReservationsDate(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){    
        //return reservationService.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("report-status")
    public CountStatus getReportStatusReservations(){
        return reservationService.getReservationsStatus();
    }
    
        
    

        
    

    
}
