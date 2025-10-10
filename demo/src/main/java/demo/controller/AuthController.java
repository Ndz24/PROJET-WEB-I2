package demo.controller;

import java.io.File;
import demo.model.Email;
import demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.*;
import org.json.JSONObject;

@Controller
public class AuthController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "accueil";
    }

    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    @GetMapping("/candidatures")
    public String candidatures(Model model) {
        // Récupère tous les mails depuis la base
        model.addAttribute("emails", emailService.getAllEmails());
        return "candidatures";
    }

    @GetMapping("/CVs")
    public String cvs() {
        return "CVs";
    }

    @GetMapping("/auth")
    public String authenticate(Model model) {
        try {
            // Lance le script Python
            ProcessBuilder pb = new ProcessBuilder("python", "src/main/python/scriptMail.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Récupère la sortie du script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            process.waitFor();

            // Parse le JSON renvoyé par le script
            JSONObject json = new JSONObject(output.toString());
            String job = json.getString("job");
            String company = json.getString("company");
            String date = json.getString("date");
            String etat = json.getString("etat");

            // Enregistre dans la base via le service
            Email email = new Email();
            email.setJob(job);
            email.setCompany(company);
            email.setDate(date);
            email.setEtat(etat);
            emailService.saveEmail(email);

            // Recharge les données pour la vue
            model.addAttribute("emails", emailService.getAllEmails());
            model.addAttribute("message", "Mail récupéré et enregistré !");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de l'authentification : " + e.getMessage());
        }

        return "candidatures";
    }

    @GetMapping("/logout")
    public String logout() {
        String tokenPath = "src/main/python/token.json";
        try {
            File tokenFile = new File(tokenPath);
            if (tokenFile.exists()) tokenFile.delete();
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du token : " + e.getMessage());
        }
        return "redirect:/accueil";
    }
}
