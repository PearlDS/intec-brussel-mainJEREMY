package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;


public class IceCreamAppV2 {
    public static void main(String[] args) {
        try {

        PriceList priceList = new PriceList(1,2,3);

        Stock stock = new Stock(0,1,1,1);

        IceCreamCar iceCreamCar = new IceCreamCar(stock,priceList);

        Eatable[] orders = new Eatable[0];

            orders = new Eatable[]{iceCreamCar.orderCone(Flavor.values()), iceCreamCar.orderMagnum(MagnumType.BLACKCHOCOLATE),
                    iceCreamCar.orderIceRocket()};


        for (Eatable order : orders) {
            order.eat();
        }

        if (iceCreamCar.getConeStock() == 0 || iceCreamCar.getIcerocketStock() == 0 || iceCreamCar.getMagnumStock() == 0){
            System.out.println("Sorry we are out of stock!");
        }

        System.out.println("Your profit is: €" + iceCreamCar.getProfit());
        } catch (NoMoreIceCreamException e) {
            e.printStackTrace();
        }

    }
}
