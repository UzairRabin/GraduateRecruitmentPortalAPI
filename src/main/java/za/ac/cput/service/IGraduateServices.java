package za.ac.cput.service;

import za.ac.cput.model.Graduate;

import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 24 November 2022
 */
public interface IGraduateServices extends IService<Graduate, String> {

    Set<Graduate> getAll();
}

