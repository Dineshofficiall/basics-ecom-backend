package com.springbootprojectdress.Basics.serviceInterface;

import com.springbootprojectdress.Basics.entity.Kart;
import com.springbootprojectdress.Basics.entity.KartDetails;

import java.util.List;

public interface KartInterface {
    String createKartData(Kart kart);

    List<KartDetails> getKartData(Long pId);

    String getDeleteById(Long id);
}
