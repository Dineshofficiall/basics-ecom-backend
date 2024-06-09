package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Kart;
import com.springbootprojectdress.Basics.entity.KartDetails;
import com.springbootprojectdress.Basics.repositiory.KartRepository;
import com.springbootprojectdress.Basics.repositiory.ProductRepository;
import com.springbootprojectdress.Basics.serviceInterface.KartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KartImplementation implements KartInterface {

    @Autowired
    KartRepository kartRepository;

    @Autowired
    ProductRepository productRepository;

//  create
    public String createKartData(Kart kart) {
        kartRepository.save(kart);
        return "Created Successfully";
    }

//  getAll kart
    public List<KartDetails> getKartData(Long pId) {

        List<Kart> karts = kartRepository.findByUserId(pId);
        List<KartDetails> kartDetailsList = new ArrayList<>();

        for (Kart kart : karts){
            KartDetails kartDetails = new KartDetails();
            kartDetails.setKartId(kart.getId());
            kartDetails.setUserId(kart.getUserId());
            kartDetails.setProducts(productRepository.findById(kart.getProductId()).get());
            kartDetailsList.add(kartDetails);
        }
        return kartDetailsList;
    }


    public String getDeleteById(Long id) {
        kartRepository.deleteByProductId(id);
        return null;
    }
}
