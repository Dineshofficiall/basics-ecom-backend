package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Kart;
import com.springbootprojectdress.Basics.repositiory.KartRepository;
import com.springbootprojectdress.Basics.serviceInterface.KartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KartImplementation implements KartInterface {

    @Autowired
    KartRepository kartRepository;

//  create
    public String createKartData(Kart kart) {
        kartRepository.save(kart);
        return "Created Successfully";
    }

//  getAll kart
//    public List<Kart> getKartData(Long pId) {
//        return kartRepository.findByProduct_Id(pId);
//    }


}
