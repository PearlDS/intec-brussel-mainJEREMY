package be.intecbrussel.sellers;
import be.intecbrussel.eatables.*;

public interface IceCreamSeller extends Profitable{

    Cone orderCone(Flavor[]flavors);

    IceRocket orderIceRocket() throws NoMoreIceCreamException;

    Magnum orderMagnum(MagnumType type);

}
