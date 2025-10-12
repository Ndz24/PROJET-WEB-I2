package demo.controller;

import demo.model.Cv;
import demo.model.Email;
import demo.service.CvService;
import demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import org.json.JSONObject;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CvService cvService;

    @GetMapping("/")
    public String home() { return "accueil"; }

    @GetMapping("/accueil")
    public String accueil() { return "accueil"; }

    @GetMapping("/candidatures")
    public String candidatures(Model model) {
        model.addAttribute("data", emailService.getAllEmails());
        return "candidatures";
    }

    // ✅ Affichage des CV
    @GetMapping("/CVs")
    public String cvs(Model model) {
        List<Cv> cvs = cvService.getAllCvs();
        model.addAttribute("cvs", cvs);
        return "CVs";
    }

    // ✅ Upload CV
    @PostMapping("/uploadCv")
    public String uploadCv(@RequestParam("file") MultipartFile file, Model model) {
        try {
            if (!file.isEmpty()) {
                cvService.saveCv(file);
                model.addAttribute("message", "CV importé avec succès !");
            } else {
                model.addAttribute("message", "Aucun fichier sélectionné !");
            }
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de l'upload du CV : " + e.getMessage());
        }
        return "redirect:/CVs";
    }

    // ✅ Téléchargement CV
    @GetMapping("/downloadCv/{id}")
    public void downloadCv(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Cv cv = cvService.getCv(id).orElseThrow(() -> new RuntimeException("CV non trouvé"));
        response.setContentType(cv.getType());
        response.setHeader("Content-Disposition", "inline; filename=\"" + cv.getNomFichier() + "\"");
        response.getOutputStream().write(cv.getData());
        response.getOutputStream().flush();
    }

    // ✅ Suppression CV
    @GetMapping("/deleteCv/{id}")
    public String deleteCv(@PathVariable Long id) {
        cvService.deleteCv(id);
        return "redirect:/CVs";
    }

    // 🔄 Auth (inchangé)
    @GetMapping("/login")
    public String login() { return "accueil"; }

    @GetMapping("/auth")
    public String authenticate(Model model) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "src/main/python/scriptMail.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) output.append(line);
            process.waitFor();

            JSONObject json = new JSONObject(output.toString());
            Email email = new Email();
            email.setJob(json.getString("job"));
            email.setCompany(json.getString("company"));
            email.setDate(json.getString("date"));
            email.setEtat(json.getString("etat"));
            emailService.saveEmail(email);

            model.addAttribute("data", emailService.getAllEmails());
            model.addAttribute("message", "Mail récupéré et enregistré !");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de l'authentification : " + e.getMessage());
        }
        return "candidatures";
    }

    @GetMapping("/logout")
    public String logout() {
        File tokenFile = new File("src/main/python/token.json");
        if (tokenFile.exists()) tokenFile.delete();
        return "redirect:/accueil";
    }
}
