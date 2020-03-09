package domain;

import domain.basket.IBasketRepository;
import domain.exceptions.ProductDoesNotExistException;
import domain.memento.ShoppingBasketMemento;
import domain.product.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;
import domain.timeserver.ITimeServer;
import domain.product.Product;

public class ShoppingBasketService {
    private final IProductRepository productRepository;
    private final IBasketRepository basketRepository;
    private final ITimeServer timeServer;

    public ShoppingBasketService(IProductRepository productRepository, IBasketRepository basketRepository, ITimeServer timeServer) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
        this.timeServer = timeServer;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {


        ShoppingBasket shoppingBasket = basketRepository.get(userId);
        if (shoppingBasket == null) shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());
        Product product = productRepository.get(productId);

        shoppingBasket.add(product, quantity);

        basketRepository.save(shoppingBasket);
    }

    public ShoppingBasketMemento basketFor(UserId userId) {

        return basketRepository.memento(userId);
    }

    @Override
    public String toString() {
        return "ShoppingBasketService{" +
                "productRepository=" + productRepository +
                ", basketRepository=" + basketRepository +
                ", timeServer=" + timeServer +
                '}';
    }
}
