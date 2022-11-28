/*
Author: Tiffany Kiwiets
Cv interface for CV
 */
package za.ac.cput.service;

import za.ac.cput.model.Cv;

import java.util.List;

public interface ICvService extends IService<Cv,String> {

    List<Cv> findAll();

}
