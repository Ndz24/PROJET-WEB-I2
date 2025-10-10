package main.java.demo.service;

import demo.dao.EmailDao;
import demo.data.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailDao emailDao;

    public void saveEmail(Email email) {
        emailDao.save(email);
    }

    public List<Email> getAllEmails() {
        return emailDao.findAll();
    }
}