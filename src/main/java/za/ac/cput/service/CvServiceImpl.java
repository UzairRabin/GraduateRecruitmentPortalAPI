/*
Author: Tiffany Kiwiets
Service class for CV
 */
package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.GraduateRecruitmentPortalAPI;
import za.ac.cput.model.Cv;
import za.ac.cput.repository.ICvRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CvServiceImpl implements ICvService {

    private ICvRepository repository;

    @Autowired
    public CvServiceImpl(ICvRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cv save(Cv cv) {
        return this.repository.save(cv);
    }

    @Override
    public Optional<Cv> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Cv cv) {
        this.repository.delete(cv);
    }

    @Override
    public Cv
    save(MultipartFile cv, String username)
    {
        String userCvDirectory = GraduateRecruitmentPortalAPI
                                 .getUserDocumentsDirectory(username)
                                 .concat("cv").concat("//");

        Cv cvInstance = Cv.builder().documentLocation(userCvDirectory)
                                    .documentName(cv.getOriginalFilename())
                                    .isAcknowledged(false)
                                    .dateAdded(LocalDate.now()).build();
        try {
            cv.transferTo(new File(userCvDirectory));
        }catch (IOException | IllegalStateException exception)
        {
            log.error("Save request:{}", cv);
        }
        return cvInstance;
    }

    @Override
    public List<Cv> findAll() {
        return this.repository.findAll();
    }

}
