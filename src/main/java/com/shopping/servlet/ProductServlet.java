package com.shopping.servlet;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // List all products
            List<Product> products = productDAO.getAllProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/WEB-INF/views/product-list.jsp").forward(request, response);
        } else {
            // Get product details
            String[] splits = pathInfo.split("/");
            if (splits.length > 1) {
                try {
                    Long productId = Long.parseLong(splits[1]);
                    Product product = productDAO.getProductById(productId);
                    if (product != null) {
                        request.setAttribute("product", product);
                        request.getRequestDispatcher("/WEB-INF/views/product-details.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    }
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
            }
        }
    }
} 