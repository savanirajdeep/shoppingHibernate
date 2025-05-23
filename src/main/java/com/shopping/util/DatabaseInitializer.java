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
        product4.setDescription("Fitness tracker with heart rate monitor, GPS, and 7-day battery life.");
        product4.setPrice(new BigDecimal("249.99"));
        product4.setImageUrl("https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=500");
        product4.setStockQuantity(75);
        productDAO.saveProduct(product4);

        Product product5 = new Product();
        product5.setName("Mechanical Keyboard");
        product5.setDescription("RGB mechanical gaming keyboard with customizable keys and wrist rest.");
        product5.setPrice(new BigDecimal("129.99"));
        product5.setImageUrl("https://images.unsplash.com/photo-1511467687858-23d96c32e4ae?w=500");
        product5.setStockQuantity(50);
        productDAO.saveProduct(product5);

        Product product6 = new Product();
        product6.setName("Gaming Mouse");
        product6.setDescription("High-precision gaming mouse with adjustable DPI and programmable buttons.");
        product6.setPrice(new BigDecimal("79.99"));
        product6.setImageUrl("https://images.unsplash.com/photo-1527814050087-3793815479db?w=500");
        product6.setStockQuantity(120);
        productDAO.saveProduct(product6);

        Product product7 = new Product();
        product7.setName("Portable SSD");
        product7.setDescription("1TB portable solid-state drive with USB 3.2 Gen 2 interface.");
        product7.setPrice(new BigDecimal("149.99"));
        product7.setImageUrl("https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=500");
        product7.setStockQuantity(60);
        productDAO.saveProduct(product7);

        Product product8 = new Product();
        product8.setName("Wireless Earbuds");
        product8.setDescription("True wireless earbuds with active noise cancellation and water resistance.");
        product8.setPrice(new BigDecimal("159.99"));
        product8.setImageUrl("https://images.unsplash.com/photo-1606220588913-b3aacb4d2f46?w=500");
        product8.setStockQuantity(200);
        productDAO.saveProduct(product8);

        Product product9 = new Product();
        product9.setName("4K Webcam");
        product9.setDescription("Ultra HD webcam with built-in microphone and privacy cover.");
        product9.setPrice(new BigDecimal("129.99"));
        product9.setImageUrl("https://images.unsplash.com/photo-1556656793-08538906a9f8?w=500");
        product9.setStockQuantity(45);
        productDAO.saveProduct(product9);

        Product product10 = new Product();
        product10.setName("Gaming Chair");
        product10.setDescription("Ergonomic gaming chair with adjustable lumbar support and headrest.");
        product10.setPrice(new BigDecimal("299.99"));
        product10.setImageUrl("https://images.unsplash.com/photo-1580480055273-228ff5388ef8?w=500");
        product10.setStockQuantity(30);
        productDAO.saveProduct(product10);

        Product product11 = new Product();
        product11.setName("Wireless Charger");
        product11.setDescription("Fast wireless charging pad with multiple device support and LED indicator.");
        product11.setPrice(new BigDecimal("49.99"));
        product11.setImageUrl("https://images.unsplash.com/photo-1586953208448-b95a79798f07?w=500");
        product11.setStockQuantity(150);
        productDAO.saveProduct(product11);

        Product product12 = new Product();
        product12.setName("Bluetooth Speaker");
        product12.setDescription("Portable waterproof Bluetooth speaker with 20-hour battery life.");
        product12.setPrice(new BigDecimal("89.99"));
        product12.setImageUrl("https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=500");
        product12.setStockQuantity(80);
        productDAO.saveProduct(product12);

        Product product13 = new Product();
        product13.setName("Tablet Pro");
        product13.setDescription("10-inch tablet with high-resolution display and stylus support.");
        product13.setPrice(new BigDecimal("399.99"));
        product13.setImageUrl("https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=500");
        product13.setStockQuantity(40);
        productDAO.saveProduct(product13);

        Product product14 = new Product();
        product14.setName("Smart Home Hub");
        product14.setDescription("Central control hub for smart home devices with voice assistant.");
        product14.setPrice(new BigDecimal("129.99"));
        product14.setImageUrl("https://images.unsplash.com/photo-1558002038-1055907df827?w=500");
        product14.setStockQuantity(60);
        productDAO.saveProduct(product14);

        Product product15 = new Product();
        product15.setName("Gaming Monitor");
        product15.setDescription("27-inch 4K gaming monitor with 144Hz refresh rate and HDR.");
        product15.setPrice(new BigDecimal("449.99"));
        product15.setImageUrl("https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=500");
        product15.setStockQuantity(25);
        productDAO.saveProduct(product15);

        Product product16 = new Product();
        product16.setName("External Hard Drive");
        product16.setDescription("2TB external hard drive with USB 3.0 and backup software.");
        product16.setPrice(new BigDecimal("79.99"));
        product16.setImageUrl("https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=500");
        product16.setStockQuantity(100);
        productDAO.saveProduct(product16);

        Product product17 = new Product();
        product17.setName("Wireless Keyboard & Mouse Set");
        product17.setDescription("Ergonomic wireless keyboard and mouse combo with long battery life.");
        product17.setPrice(new BigDecimal("69.99"));
        product17.setImageUrl("https://images.unsplash.com/photo-1527814050087-3793815479db?w=500");
        product17.setStockQuantity(75);
        productDAO.saveProduct(product17);

        Product product18 = new Product();
        product18.setName("Smart Light Bulbs");
        product18.setDescription("Set of 4 smart LED bulbs with color control and scheduling.");
        product18.setPrice(new BigDecimal("59.99"));
        product18.setImageUrl("https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=500");
        product18.setStockQuantity(200);
        productDAO.saveProduct(product18);

        Product product19 = new Product();
        product19.setName("USB-C Hub");
        product19.setDescription("7-in-1 USB-C hub with HDMI, SD card reader, and power delivery.");
        product19.setPrice(new BigDecimal("39.99"));
        product19.setImageUrl("https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=500");
        product19.setStockQuantity(120);
        productDAO.saveProduct(product19);

        Product product20 = new Product();
        product20.setName("Wireless Gaming Headset");
        product20.setDescription("7.1 surround sound gaming headset with noise-cancelling microphone.");
        product20.setPrice(new BigDecimal("149.99"));
        product20.setImageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500");
        product20.setStockQuantity(50);
        productDAO.saveProduct(product20);

        System.out.println("Sample products have been added to the database!");
    }
} 