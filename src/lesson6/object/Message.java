package lesson6.object;

import java.util.Objects;

public class Message implements Cloneable{
    private String messageText;
    private Autor autor;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", autor=" + autor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (getMessageText() != null ? !getMessageText().equals(message.getMessageText()) : message.getMessageText() != null)
            return false;
        return getAutor() != null ? getAutor().equals(message.getAutor()) : message.getAutor() == null;
    }

    @Override
    public int hashCode() {
        int result = getMessageText() != null ? getMessageText().hashCode() : 0;
        result = 31 * result + (getAutor() != null ? getAutor().hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Autor {
    private String name;

    public Autor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(name, autor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}