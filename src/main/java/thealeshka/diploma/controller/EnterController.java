package thealeshka.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import thealeshka.diploma.entity.Person;
import thealeshka.diploma.repository.MessageRepository;
import thealeshka.diploma.repository.PersonRepository;

import java.util.List;

@Controller
public class EnterController {
    private PersonRepository usersRepository;
    private MessageRepository messageRepository;

    public EnterController() {
    }

    @Autowired
    public EnterController(PersonRepository personRepository, MessageRepository messageRepository) {
        this.usersRepository = usersRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String enter(Model model, @ModelAttribute("Login") String login,
                        @ModelAttribute("Password") String password) {
        List<Person> list = usersRepository.findAll();
        for (Person i : list) {
            if ((i.getUserName().equals(login)) && (i.getPassword().equals(password))) {
                model.addAttribute("login", login);
                return "chat/mainChatFile";
            }
        }
        return "connect/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "connect/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerTwo(@ModelAttribute("Login") String login, @ModelAttribute("Password") String password,
                              @ModelAttribute("PasswordRepite") String passwordRepite) {
        if (password.equals(passwordRepite)) {
            Person user = new Person(login, password);
            if (usersRepository.findAll().contains(user)) {
                return "register";
            } else {
                usersRepository.save(user);
                return "connect/login";
            }
        } else {
            return "register";
        }
    }


}
