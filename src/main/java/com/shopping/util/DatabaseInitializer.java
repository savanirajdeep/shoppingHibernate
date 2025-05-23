package com.shopping.util;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;

import java.math.BigDecimal;

public class DatabaseInitializer {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // Sample products
        Product product1 = new Product();
        product1.setName("Smartphone X");
        product1.setDescription("Latest smartphone with advanced features and high-resolution camera.");
        product1.setPrice(new BigDecimal("699.99"));
        product1.setImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=500");
        product1.setStockQuantity(50);
        productDAO.saveProduct(product1);

        Product product2 = new Product();
        product2.setName("Laptop Pro");
        product2.setDescription("Powerful laptop for professionals with high-performance processor.");
        product2.setPrice(new BigDecimal("1299.99"));
        product2.setImageUrl("https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=500");
        product2.setStockQuantity(30);
        productDAO.saveProduct(product2);

        Product product3 = new Product();
        product3.setName("Wireless Headphones");
        product3.setDescription("Premium noise-cancelling wireless headphones with long battery life.");
        product3.setPrice(new BigDecimal("199.99"));
        product3.setImageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500");
        product3.setStockQuantity(100);
        productDAO.saveProduct(product3);

        Product product4 = new Product();
        product4.setName("Smart Watch");
        product4.setDescription("Feature-rich smartwatch with health monitoring and notifications.");
        product4.setPrice(new BigDecimal("249.99"));
        product4.setImageUrl("https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=500");
        product4.setStockQuantity(75);
        productDAO.saveProduct(product4);

        Product product5 = new Product();
        product5.setName("Digital Camera");
        product5.setDescription("Professional-grade digital camera with 4K video recording.");
        product5.setPrice(new BigDecimal("899.99"));
        product5.setImageUrl("https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=500");
        product5.setStockQuantity(25);
        productDAO.saveProduct(product5);

        System.out.println("Sample products have been added to the database!");
    }
} 