package com.github.ipan97.aplikasi.inventory;

import com.github.ipan97.aplikasi.inventory.configuration.SpringDataJpaConfiguration;
import com.github.ipan97.aplikasi.inventory.entity.Barang;
import com.github.ipan97.aplikasi.inventory.service.BarangService;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AplikasiInventoryApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringDataJpaConfiguration.class);
        BarangService barangService = applicationContext.getBean(BarangService.class);
        Barang b = new Barang();
        b.setTanggal(new Date());
        b.setMerk("samsung");
        b.setStatus("inventaris");
        b.setRuang("ruang");
        b.setHarga(new BigDecimal(5000));
        barangService.saveOrUpdate(b);
        for (Barang barang : barangService.getBarangs(0, 1)) {
            System.out.println(barang.getKodeBarang());
            System.out.println(barang.getMerk());
            System.out.println(barang.getStatus());
            System.out.println(barang.getTanggal());
        }
    }
}
