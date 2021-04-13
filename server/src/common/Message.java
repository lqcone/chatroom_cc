package common;


import java.io.Serializable;

public class Message implements Serializable {
    private String MessageType;
    private String Content;
    private String time;

    public Message(){}
    public Message(String messageType, String content, String time) {
        MessageType = messageType;
        Content = content;
        this.time = time;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
