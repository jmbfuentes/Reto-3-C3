package com.reto.reto3.repository.CRUD;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto.reto3.model.Reservation;

public interface ReservationCrudRepoInterfaz extends CrudRepository<Reservation, Integer>{
    
//reto 5
//query methos
    @Query ("SELECT c.partyroom, COUNT(c.partyroom) FROM Reservation AS c GROUP BY c.partyroom ORDER BY COUNT(c.partyroom) DESC")
    public List<Object[]> countTotalReservationByPartyroom();

    @Query ("SELECT c.client, COUNT(c.client)FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC") 
    public List<Object[]> countTotalReservationByClients();

    //SELECT * FROM Resercation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo;
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
    
    //SELECT * FROM Reservation WHERE status = "canceled"
    public List<Reservation> findAllByStatus(String status);

}   

