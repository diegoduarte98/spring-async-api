package br.com.diegoduarte.springasyncapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private InstallmentService installmentService;

    @GetMapping
    @Transactional
    public void save() throws Exception {
        long startTime = System.currentTimeMillis();

        List<SaleOutputDto> records = new ObjectMapper().readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("sales.json"), new TypeReference<>() {});

        saleRepository.saveAll(sales);

        installmentService.saveAll(sales);

        if(true) throw new RuntimeException();

        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime) / 1000);
    }
}
