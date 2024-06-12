package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.KartQuantity;

import java.util.List;

public interface KartQuantityInterface {

    String createKartData(KartQuantity kartQuantity);

    KartQuantity getAllQuantity(Long userId, Long productSizeId);

    KartQuantity updateQuantity(KartQuantity kartQuantity);

    String deleteQuantity(Long userId, Long productSizeId);

}
