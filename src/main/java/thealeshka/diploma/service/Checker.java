package thealeshka.diploma.service;

import thealeshka.diploma.repository.MessageRepository;
import thealeshka.diploma.repository.PersonRepository;

public class Checker {
    private PersonRepository personRepository;
    private MessageRepository messageRepository;

    public Checker(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public Checker() {
    }

    public boolean check(String a){
        return true;
    }
}
