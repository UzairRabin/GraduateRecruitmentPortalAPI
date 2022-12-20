/*
Author: Tiffany Kiwiets
Cv interface for CV
 */
package za.ac.cput.service;

import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.model.Cv;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.util.List;

public interface ICvService extends IService<Cv,String> {
    Cv save(MultipartFile cv, Long username);
    List<Cv> findAll();
    List<Cv> findAllByUserId();

}
