package com.advanced.cafe;

import com.advanced.cafe.entity.Beverage;
import com.advanced.cafe.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Loader {
    BeverageRepository beverageRepository;

    @Autowired
    public Loader(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Bean
    public void init() {
        Beverage americano = new Beverage(1L, "Coffee", "Americano", 4500, 5000, 5500);
        Beverage latte = new Beverage(2L, "Coffee", "Latte", 5000, 5500, 6000);
        Beverage mangoBanana = new Beverage(3L, "Blended", "MangoBanana", 0, 6300, 0);
        Beverage chamomile = new Beverage(4L, "Teavana", "Chamomile", 4500, 0, 5500);
        Beverage coldBrew = new Beverage(5L, "Reserve", "ColdBrew", 6500, 7000, 0);

        beverageRepository.save(americano);
        beverageRepository.save(latte);
        beverageRepository.save(mangoBanana);
        beverageRepository.save(chamomile);
        beverageRepository.save(coldBrew);
    }
}
