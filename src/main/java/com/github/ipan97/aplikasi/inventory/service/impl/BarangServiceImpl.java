/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.service.impl;

import com.github.ipan97.aplikasi.inventory.entity.Barang;
import com.github.ipan97.aplikasi.inventory.repository.BarangRepository;
import com.github.ipan97.aplikasi.inventory.service.BarangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author linux
 */
@Service("barangService")
@Transactional(readOnly = true)
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository repository;
    @Transactional(readOnly = false)
    public Barang saveOrUpdate(Barang barang) {
        repository.save(barang);
        return barang;
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public List<Barang> getBarangs(Integer indexStart, Integer numOfRows) {
        int page = indexStart / numOfRows;
        PageRequest pageRequest = new PageRequest(page, numOfRows);
        Page<Barang> barangs = repository.findAll(pageRequest);
        return barangs.getContent();
    }

    public Barang getBarangById(String id) {
        return repository.findOne(id);
    }

}
