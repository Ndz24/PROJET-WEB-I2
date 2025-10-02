package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AuthController {
    @GetMapping("/")
    public String home() {
        return "accueil";
    }

    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    @GetMapping("/candidatures")
    public String candidatures() {
        return "candidatures";
    }

    @GetMapping("/CVs")
    public String cvs() {
        return "CVs";
    }

    @GetMapping("/auth")
    public String authenticate(Model model) {

        try {
            ProcessBuilder pb = new ProcessBuilder("python", "src/main/python/scriptMail.py");
            Process p = pb.start();
            //p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("message", "Script exécuté !");
        return "candidatures";
    }
}
