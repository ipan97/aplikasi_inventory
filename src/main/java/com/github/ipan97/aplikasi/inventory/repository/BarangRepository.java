/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.repository;

import com.github.ipan97.aplikasi.inventory.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author linux
 */
public interface BarangRepository extends JpaRepository<Barang,String>{
    
}
