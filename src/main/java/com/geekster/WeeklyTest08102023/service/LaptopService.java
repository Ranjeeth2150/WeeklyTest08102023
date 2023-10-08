package com.geekster.WeeklyTest08102023.service;

import com.geekster.WeeklyTest08102023.model.Laptop;
import com.geekster.WeeklyTest08102023.repo.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    private ILaptopRepository laptopRepository;
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(String id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(String id, Laptop updatedLaptop) {
        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
        if (existingLaptop != null) {
            existingLaptop.setName(updatedLaptop.getName());
            existingLaptop.setBrand(updatedLaptop.getBrand());

            return laptopRepository.save(existingLaptop);
        }
        return null;
    }

    public void deleteLaptop(String id) {
        laptopRepository.deleteById(id);
    }
}
