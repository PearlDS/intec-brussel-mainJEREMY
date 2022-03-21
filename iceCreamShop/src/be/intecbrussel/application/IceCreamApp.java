package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;


public class IceCreamApp {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(2,2,3);

        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Eatable[] orders = {iceCreamSalon.orderCone(new Flavor[]{Flavor.LEMON, Flavor.CHOCOLATE, Flavor.BANANA}), iceCreamSalon.orderMagnum(MagnumType.ALPINENUTS),
        iceCreamSalon.orderIceRocket()};

        for (Eatable order : orders) {
            order.eat();
        }

        System.out.println("Your profit is: €" + iceCreamSalon.getProfit());



    }
}
