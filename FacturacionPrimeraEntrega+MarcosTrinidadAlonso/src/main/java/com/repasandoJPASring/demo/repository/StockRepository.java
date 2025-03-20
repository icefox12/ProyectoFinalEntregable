package com.repasandoJPASring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.repasandoJPASring.demo.model.Stock;
import com.repasandoJPASring.demo.model.Sucursal;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findBySucursal(Sucursal sucursal);
    void deleteAllByJuegoId(Long juegoId);
}
