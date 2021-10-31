package com.usa.ciclo3reto.cicloreto.service;

import com.usa.ciclo3reto.cicloreto.model.Reservation;
import com.usa.ciclo3reto.cicloreto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getId()==null){
            return reservationRepository.save(reservation);
        }else {
            Optional<Reservation> tmpReservation=reservationRepository.getReservation((reservation.getId()));
            if (tmpReservation.isEmpty()){
                return reservationRepository.save(reservation);
            }else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if (reservation.getId()!=null){
            Optional<Reservation> tmpReservation=reservationRepository.getReservation((reservation.getId()));
            if (!tmpReservation.isEmpty()){
                return reservationRepository.save(reservation);
            }
        }
        return null;
    }

    public boolean deleteReservation(int id){
        Boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
