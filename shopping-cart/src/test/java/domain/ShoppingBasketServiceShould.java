package domain;

import domain.basket.IBasketRepository;
import domain.exceptions.ProductDoesNotExistException;
import domain.product.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.timeserver.ITimeServer;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import domain.product.Product;

import static org.mockito.Mockito.*;

public class ShoppingBasketServiceShould {
    @Mock IProductRepository productRepository;
    @Mock IBasketRepository basketRepository;
    @Mock ITimeServer timeServer;

    @Test
        public void send_new_shopping_basket_to_repo_when_basket_does_not_exist() {

        MockitoAnnotations.initMocks(this);
        UserId userId = new UserId(1);
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(productRepository, basketRepository, timeServer);
        when(timeServer.getDate()).thenReturn("10/02/1990");
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());
        when(basketRepository.get(userId)).thenReturn(null);
        when(productRepository.get(productId)).thenReturn(product);
        shoppingBasket.add(product,2);

        shoppingBasketService.addItem(userId, productId, 2);

        verify(basketRepository).save(shoppingBasket);
    }
    @Test
    public void not_allow_to_add_a_non_existent_product(){

        MockitoAnnotations.initMocks(this);
        UserId userId = new UserId(1);
        ProductId productId = new ProductId(10002);
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(productRepository, basketRepository, timeServer);
        when(productRepository.get(productId)).thenReturn(null);


        Assertions.assertThrows(ProductDoesNotExistException.class, ()-> shoppingBasketService.addItem(userId, productId,2));
    }
}