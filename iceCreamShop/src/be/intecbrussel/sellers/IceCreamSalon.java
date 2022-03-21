package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{

    private PriceList priceList;
   private double totalProfit;


    public IceCreamSalon(PriceList priceList){
        this.priceList = priceList;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Flavor[] flavors) {
        for (int i = 0; i< flavors.length; i++) {
            totalProfit = totalProfit + priceList.getBallPrice();
        }

        return new Cone(flavors);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit = totalProfit + priceList.getRocketPrice();
        return  new IceRocket();

    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
       totalProfit+= priceList.getMagnumStandardPrice(type);
        return new Magnum(type);
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
