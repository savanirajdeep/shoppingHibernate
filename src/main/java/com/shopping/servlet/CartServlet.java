package com.shopping.servlet;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Cart;
import com.shopping.model.CartItem;
import com.shopping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getPathInfo();
        
        if ("/add".equals(action)) {
            addToCart(request, response);
        } else if ("/remove".equals(action)) {
            removeFromCart(request, response);
        } else if ("/update".equals(action)) {
            updateCartItem(request, response);
        } else if ("/checkout".equals(action)) {
            checkout(request, response);
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        try {
            Long productId = Long.parseLong(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            Product product = productDAO.getProductById(productId);
            if (product != null && product.getStockQuantity() >= quantity) {
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
                cart.addItem(cartItem);
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
        
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void removeFromCart(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart != null) {
            try {
                Long productId = Long.parseLong(request.getParameter("productId"));
                cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
            } catch (NumberFormatException e) {
                // Handle invalid input
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/cart");
    }

    private void updateCartItem(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart != null) {
            try {
                Long productId = Long.parseLong(request.getParameter("productId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                
                for (CartItem item : cart.getItems()) {
                    if (item.getProduct().getId().equals(productId)) {
                        if (quantity > 0 && item.getProduct().getStockQuantity() >= quantity) {
                            item.setQuantity(quantity);
                        }
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // Handle invalid input
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/cart");
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart != null && !cart.getItems().isEmpty()) {
            try {
                // Update stock quantities for each item in the cart
                for (CartItem item : cart.getItems()) {
                    Product product = item.getProduct();
                    int newStock = product.getStockQuantity() - item.getQuantity();
                    
                    // Ensure we don't go below 0 stock
                    if (newStock >= 0) {
                        product.setStockQuantity(newStock);
                        productDAO.updateProduct(product);
                    } else {
                        // Handle insufficient stock error
                        response.sendRedirect(request.getContextPath() + "/cart?error=insufficientStock");
                        return;
                    }
                }
                
                // Clear the cart after successful stock update
                cart.getItems().clear();
                session.setAttribute("cart", cart);
                
                // Redirect back to cart page with success parameter
                response.sendRedirect(request.getContextPath() + "/cart?orderPlaced=true");
            } catch (Exception e) {
                // Handle any errors during the checkout process
                response.sendRedirect(request.getContextPath() + "/cart?error=checkoutFailed");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/cart");
        }
    }
} 