/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.BeforeClass;

/**
 *
 * @author linux
 */
public class DatabaseTest {

    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/aplikasi_inventory_dev";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void prepareDb() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
