package com.julie.springdemo.domain.promotion;

import com.julie.springdemo.domain.product.ConsumerProduct;
import com.julie.springdemo.domain.product.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tradeFair")
public class TradeFair {
    @Autowired
    private IndustrialProduct industrialProduct;
    @Autowired
    private ConsumerProduct consumerProduct;

    public String specialPromotionPricing(){
        String priceInfo = " * Industrial Product is priced at $" + declareIndustrialProductPrice(industrialProduct) + " and "
                           + "Consumer Product is priced at $" + declareConsumerProductPrice(consumerProduct);
        return priceInfo;
    }

    public int declareIndustrialProductPrice(IndustrialProduct industrialProduct){
        return industrialProduct.calculatePrice();
    }

    public int declareConsumerProductPrice(ConsumerProduct consumerProduct){
        return consumerProduct.calculatePrice();
    }
}
