package demo.service;

import demo.model.Email;
import demo.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository EmailRepository;

    public void saveEmail(Email email) {
        EmailRepository.save(email);
    }

    public List<Email> getAllEmails() {
        return EmailRepository.findAll();
    }
}
