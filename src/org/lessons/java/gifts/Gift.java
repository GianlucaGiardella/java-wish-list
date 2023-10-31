package org.lessons.java.gifts;

public class Gift {
    private String description;
    private String recipient;

    public Gift(String description, String recipient) throws IllegalArgumentException {
        checkString(description, "descrizione");
        checkString(recipient, "destinatario");

        this.description = description;
        this.recipient = recipient;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        checkString(description, "Description");
        this.description = description;
    }

    public void setRecipient(String recipient) throws IllegalArgumentException {
        checkString(recipient, "Recipient");
        this.recipient = recipient;
    }

    private void checkString(String inputString, String inputName) throws IllegalArgumentException {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(inputName + " è null o vuoto");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "Descrizione: " + description + ", " +
                "Destinatario: " + recipient +
                "}";
    }
}
