/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author linux
 */

@Entity
@Table(name="pegawai")
public class Pegawai {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="kode_pegawai")
    private String kodePegawai;
    @Column(name="nama_pegawai",nullable=false)
    private String namaPegawai;
    @Column(name="username",nullable=false)
    private String username;
    @Column(name="password",nullable=false)
    private String password;
    @Column(name="type",nullable=false)
    private String type;
}
