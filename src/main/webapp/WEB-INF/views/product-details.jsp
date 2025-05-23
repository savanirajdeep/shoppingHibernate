<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${product.name} - Product Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-image {
            max-height: 400px;
            object-fit: contain;
        }
        .product-description {
            white-space: pre-line;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/products">Shopping Store</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="${pageContext.request.contextPath}/cart">Cart</a>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-6">
                <img src="${product.imageUrl}" class="img-fluid product-image" alt="${product.name}">
            </div>
            <div class="col-md-6">
                <h1 class="mb-3">${product.name}</h1>
                <h3 class="text-primary mb-4">$${product.price}</h3>
                <div class="mb-4">
                    <h5>Description:</h5>
                    <p class="product-description">${product.description}</p>
                </div>
                <div class="mb-4">
                    <h5>Stock Status:</h5>
                    <p class="${product.stockQuantity > 0 ? 'text-success' : 'text-danger'}">
                        ${product.stockQuantity > 0 ? 'In Stock' : 'Out of Stock'}
                    </p>
                </div>
                <form action="${pageContext.request.contextPath}/cart/add" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <div class="mb-3">
                        <label for="quantity" class="form-label">Quantity:</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" 
                               value="1" min="1" max="${product.stockQuantity}" 
                               ${product.stockQuantity == 0 ? 'disabled' : ''}>
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg" 
                            ${product.stockQuantity == 0 ? 'disabled' : ''}>
                        Add to Cart
                    </button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 