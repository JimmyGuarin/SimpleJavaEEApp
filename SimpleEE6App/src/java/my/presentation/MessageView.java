/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sumset-Games
 */
@Named(value = "MessageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    
    private Message message;
    
    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
       
       this.message = new Message();
     
    }
    
     public Message getMessage() {
        return message;
    }
    
    public int getNumberOfMessages(){
        
        return messageFacade.findAll().size();
    }
    
    public String postMessage(){
        
        this.messageFacade.create(message);
        return "theend";
    }
    
    
    
}
