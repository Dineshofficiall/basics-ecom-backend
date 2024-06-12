package com.springbootprojectdress.Basics.serviceImplementation;

import com.springbootprojectdress.Basics.entity.Kart;
import com.springbootprojectdress.Basics.entity.KartQuantity;
import com.springbootprojectdress.Basics.repositiory.KartQuantityRepository;
import com.springbootprojectdress.Basics.serviceInterface.KartQuantityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KartQuantityImplementation implements KartQuantityInterface {

    @Autowired
    KartQuantityRepository kartQuantityRepository;

    public String createKartData(KartQuantity kartQuantity) {
        KartQuantity isPresentKartQuantity = kartQuantityRepository.findByUserIdAndProductSizeId(kartQuantity.getUserId(), kartQuantity.getProductSizeId());
        if (isPresentKartQuantity == null) {
            kartQuantityRepository.save(kartQuantity);
            return "Created SuccessFully";
        } else {
            Long updatedQuantity = isPresentKartQuantity.getProductQuantity() + kartQuantity.getProductQuantity();
            isPresentKartQuantity.setProductQuantity(updatedQuantity);
            kartQuantityRepository.save(isPresentKartQuantity);
            return "Product Quantity Added SuccessFully";
        }
    }

    public KartQuantity getAllQuantity(Long userId, Long productSizeId) {
        return kartQuantityRepository.findByUserIdAndProductSizeId(userId, productSizeId);
    }

    public KartQuantity updateQuantity(KartQuantity kartQuantity) {
        KartQuantity kartQuantityDb = kartQuantityRepository.findByUserIdAndProductSizeId(kartQuantity.getUserId(), kartQuantity.getProductSizeId());

        if (kartQuantity.getProductQuantity() != null){
            if (kartQuantity.getProductQuantity() >= 0){
                Long updatedQuantity = kartQuantityDb.getProductQuantity() + kartQuantity.getProductQuantity();
                kartQuantityDb.setProductQuantity(updatedQuantity);
                kartQuantityRepository.save(kartQuantityDb);
            }else {
                Long updatedQuantity = kartQuantityDb.getProductQuantity() - kartQuantity.getProductQuantity();
                kartQuantityDb.setProductQuantity(updatedQuantity);
                kartQuantityRepository.save(kartQuantityDb);
            }
        }

        return kartQuantityDb;
    }


    public String deleteQuantity(Long userId, Long productSizeId) {
        kartQuantityRepository.deleteByUserIdAndProductSizeId(userId, productSizeId);
        return "Deleted SuccessFully";
    }
}
