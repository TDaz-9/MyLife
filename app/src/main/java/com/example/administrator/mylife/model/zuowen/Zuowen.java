package com.example.administrator.mylife.model.zuowen;

import java.util.List;

/**
 * 作文
 */

public class Zuowen {
    private int code;
    private String reason;
    private List<Message> messages;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
