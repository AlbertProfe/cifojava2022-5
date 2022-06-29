package io.company.library.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class TextMessage {

    private String content;

    public TextMessage() {}
    public TextMessage(String content) {
        super();
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage [content=" + content + "]";
    }



}