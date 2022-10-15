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

import com.reto.reto3.model.Message;
import com.reto.reto3.service.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> obtenerMessageCompleta(){
        return messageService.obtenerMessageCompleta();
    }
    @GetMapping("/{id}")
    public Optional<Message> obtenerMessageId(@PathVariable("id") Integer identificador){
        return messageService.obtenermessageid(identificador);

    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message salvarMessage(@RequestBody Message message){
        return messageService.salvarMessage(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message actualizarMessage(@RequestBody Message message){
        return messageService.actualizarMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarMessage(@PathVariable("id") int messageId){
        return messageService.borrarMessage(messageId);

    }





}
