/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.service;

import com.github.ipan97.aplikasi.inventory.entity.Barang;
import java.util.List;

/**
 *
 * @author linux
 */

public interface BarangService {
    Barang saveOrUpdate(Barang barang);
    void delete(String id);
    List<Barang> getBarangs(Integer indexStart, Integer numOfRows);
    Barang getBarangById(String id);
}
