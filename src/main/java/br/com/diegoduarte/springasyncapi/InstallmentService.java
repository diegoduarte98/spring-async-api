package br.com.diegoduarte.springasyncapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    @Async
    public void saveAll(List<Sale> sales) {
        List<Installment> installments = sales.stream().flatMap(sale -> sale.getInstallments().stream().peek(installment -> installment.setSale(sale))).collect(Collectors.toList());
        installmentRepository.saveAll(installments);
    }
}
