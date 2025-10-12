package demo.service;

import demo.model.Cv;
import demo.repository.CvRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CvService {

    private final CvRepository cvRepository;

    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public Cv saveCv(MultipartFile file) throws IOException {
        Cv cv = new Cv();

        cv.setNomFichier(file.getOriginalFilename());
        cv.setType(file.getContentType());
        cv.setData(file.getBytes());
        return cvRepository.save(cv);
    }

    public List<Cv> getAllCvs() {
        return cvRepository.findAll();
    }

    public Optional<Cv> getCv(Long id) {
        return cvRepository.findById(id);
    }

    public void deleteCv(Long id) {
        cvRepository.deleteById(id);
    }
}
