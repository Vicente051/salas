package com.tweb.salas.chat;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage  implements Serializable {
	
	private static final long serialVersionUID = 8504771276343575995L;

		// Atributo de número entero único y autoincrementado automáticamente (identificador de la sala)
    	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    	
    	 private MessageType type;
    	    private String content;
    	    private String sender;
    

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
}
