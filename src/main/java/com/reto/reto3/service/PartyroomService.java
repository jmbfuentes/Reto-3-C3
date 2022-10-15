package com.reto.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.model.Partyroom;
import com.reto.reto3.repository.PartyroomRepository;

@Service
public class PartyroomService {

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> obtenerPartyroomall() {
        return partyroomRepository.obtenerPartyroomall();
    }

    public Optional<Partyroom> obtenerPartyroomId(Integer id) {
        return partyroomRepository.obtenerPartyroomId(id);
    }

    public Partyroom salvarPartyroom(Partyroom partyroom) {
        if (partyroom.getId() == null) {
            return partyroomRepository.salvarPartyroom(partyroom);

        } else {
            Optional<Partyroom> partyroomAuxiliar = partyroomRepository.obtenerPartyroomId(partyroom.getId());
            if (partyroomAuxiliar.isEmpty()) {
                return partyroomRepository.salvarPartyroom(partyroom);

            } else {
                return partyroom;
            }
        }
    }
   

    public Partyroom actualizarPartyroom(Partyroom partyroom) {
        if (partyroom.getId() != null) {
            Optional<Partyroom> e = partyroomRepository.obtenerPartyroomId(partyroom.getId());
            if (!e.isEmpty()) {
                if (partyroom.getName() != null) {
                    e.get().setName(partyroom.getName());
                }
                if (partyroom.getOwner() != null) {
                    e.get().setOwner(partyroom.getOwner());
                }
                if (partyroom.getCapacity() != null) {
                    e.get().setCapacity(partyroom.getCapacity());
                }
                if (partyroom.getDescription() != null) {
                    e.get().setDescription(partyroom.getDescription());
                }

                partyroomRepository.salvarPartyroom(e.get());
                return e.get();

            } else {
                return partyroom;
            }
        } else {
            return partyroom;
        }
    }

    public boolean borrarPartyroom(int partyroomId) {
        boolean flag=false;
        Optional<Partyroom> c= partyroomRepository.obtenerPartyroomId(partyroomId);
        if(c.isPresent()){
            partyroomRepository.delete(c.get());
            flag=true;
        }
        return flag;

    } 


}
