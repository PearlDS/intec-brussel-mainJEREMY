package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar  implements IceCreamSeller {
    private PriceList priceList;
    private Stock stock;
    private double profit;
    private int icerocketStock;
    private int coneStock;
    private int magnumStock;

    public IceCreamCar(Stock stock, PriceList priceList) {
        this.stock = stock;
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Flavor[] flavors) {
        for (Flavor f : flavors) {
            profit = profit + priceList.getBallPrice();
        }

        coneStock = stock.getCones() - 1;

        return new Cone(new Flavor[]{Flavor.PISTACHE, Flavor.STRACIATELLA, Flavor.BANANA});
    }

    private Cone prepareCone(Flavor[] flavors){
        return null;
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {

        IceRocket iceRocket = prepareIceRocket();

        if (iceRocket!= null)
        profit = profit + priceList.getRocketPrice();

        return iceRocket;

    }

    private IceRocket prepareIceRocket() throws NoMoreIceCreamException {
        if(stock.getIceRockets()<=0){
            throw new NoMoreIceCreamException("No mre IceRockets");

        }
        else {
            icerocketStock = stock.getIceRockets() - 1;
            stock.setIceRockets(icerocketStock);
            return new IceRocket();
        }
    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
        switch (type){
            case MILKCHOCOLATE, WHITECHOCOLATE, BLACKCHOCOLATE -> profit = profit + priceList.getMagnumStandardPrice(type);
            case ROMANTICSTRAWBERRIES -> profit = profit + (priceList.getMagnumStandardPrice(type) * 1.2);
            case ALPINENUTS -> profit = profit + (priceList.getMagnumStandardPrice(type) * 1.5);
        }

        magnumStock = stock.getMagni() - 1;

        return new Magnum(MagnumType.BLACKCHOCOLATE);
    }

    private Magnum prepareMagnum(MagnumType type){
        return null;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    public int getIcerocketStock(){
        return icerocketStock;
    }

    public int getConeStock() {
        return coneStock;
    }

    public int getMagnumStock(){
        return magnumStock;
    }
}
