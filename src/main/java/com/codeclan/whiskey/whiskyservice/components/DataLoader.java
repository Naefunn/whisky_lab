package com.codeclan.whiskey.whiskyservice.components;

import com.codeclan.whiskey.whiskyservice.models.Distillery;
import com.codeclan.whiskey.whiskyservice.models.Whisky;
import com.codeclan.whiskey.whiskyservice.respositories.DistilleryRepository;
import com.codeclan.whiskey.whiskyservice.respositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataLoader implements ApplicationRunner {

    public DataLoader(){}

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @Override
    public void run (ApplicationArguments args) throws Exception{

        Distillery talisker = new Distillery("Talisker", "Skye");
        Distillery laphroaig = new Distillery("Laphroaig", "Highlands");
        Distillery ardbeg = new Distillery("Ardbeg", "Lowlands");

        distilleryRepository.save(talisker);
        distilleryRepository.save(laphroaig);
        distilleryRepository.save(ardbeg);


        Whisky whisky1 = new Whisky("Talisker 10", talisker, 1990, 10);
        Whisky whisky2 = new Whisky("Talisker 12", talisker, 1980, 12);
        Whisky whisky3 = new Whisky("Laphroaig 10", laphroaig, 2005, 10);
        Whisky whisky4 = new Whisky("Ardbeg 15", ardbeg, 1973, 15);



        whiskyRepository.save(whisky1);
        whiskyRepository.save(whisky2);
        whiskyRepository.save(whisky3);
        whiskyRepository.save(whisky4);

        talisker.addWhisky(whisky1);
        talisker.addWhisky(whisky2);
        laphroaig.addWhisky(whisky3);
        ardbeg.addWhisky(whisky4);

        distilleryRepository.save(talisker);
        distilleryRepository.save(laphroaig);
        distilleryRepository.save(ardbeg);
    }
}
