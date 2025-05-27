<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .cart-item-image {
            width: 100px;
            height: 100px;
            object-fit: cover;
        }
        .quantity-input {
            width: 70px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/products">Shopping Store</a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link active" href="${pageContext.request.contextPath}/cart">Cart</a>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h1 class="mb-4">Shopping Cart</h1>
        
        <c:if test="${param.error == 'insufficientStock'}">
            <div class="alert alert-danger">
                Sorry, some items in your cart are no longer available in the requested quantity. Please update your cart and try again.
            </div>
        </c:if>
        
        <c:if test="${param.error == 'checkoutFailed'}">
            <div class="alert alert-danger">
                There was an error processing your order. Please try again later.
            </div>
        </c:if>
        
        <c:choose>
            <c:when test="${empty cart.items}">
                <div class="alert alert-info">
                    Your cart is empty. <a href="${pageContext.request.contextPath}/products">Continue shopping</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="cartTotal" value="0" />
                            <c:forEach items="${cart.items}" var="item">
                                <c:set var="itemTotal" value="${item.product.price * item.quantity}" />
                                <c:set var="cartTotal" value="${cartTotal + itemTotal}" />
                                <tr>
                                    <td>
                                        <div class="d-flex align-items-center">
                                            <img src="${item.product.imageUrl}" class="cart-item-image me-3" 
                                                 alt="${item.product.name}">
                                            <div>
                                                <h5 class="mb-0">${item.product.name}</h5>
                                                <small class="text-muted">Stock: ${item.product.stockQuantity}</small>
                                            </div>
                                        </div>
                                    </td>
                                    <td><fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol="$"/></td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cart/update" method="post" 
                                              class="d-flex align-items-center">
                                            <input type="hidden" name="productId" value="${item.product.id}">
                                            <input type="number" name="quantity" value="${item.quantity}" 
                                                   min="1" max="${item.product.stockQuantity}" 
                                                   class="form-control quantity-input me-2">
                                            <button type="submit" class="btn btn-sm btn-outline-primary">Update</button>
                                        </form>
                                    </td>
                                    <td><fmt:formatNumber value="${itemTotal}" type="currency" currencySymbol="$"/></td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cart/remove" method="post" 
                                              class="d-inline">
                                            <input type="hidden" name="productId" value="${item.product.id}">
                                            <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="3" class="text-end"><strong>Total:</strong></td>
                                <td><strong><fmt:formatNumber value="${cartTotal}" type="currency" currencySymbol="$"/></strong></td>
                                <td></td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                
                <div class="d-flex justify-content-between mt-4">
                    <a href="${pageContext.request.contextPath}/products" class="btn btn-outline-primary">
                        Continue Shopping
                    </a>
                    <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#checkoutModal">
                        Proceed to Checkout
                    </button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- Checkout Modal -->
    <div class="modal fade" id="checkoutModal" tabindex="-1" aria-labelledby="checkoutModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="checkoutModalLabel">Confirm Order</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to place this order?</p>
                    <p>Total Amount: <strong><fmt:formatNumber value="${cartTotal}" type="currency" currencySymbol="$"/></strong></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <form action="${pageContext.request.contextPath}/cart/checkout" method="post" id="checkoutForm">
                        <button type="submit" class="btn btn-success">Place Order</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Success Modal -->
    <div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Order Placed Successfully!</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Your order has been placed successfully. Thank you for shopping with us!</p>
                </div>
                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/products" class="btn btn-primary">Continue Shopping</a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Show success modal if order was placed
        if (window.location.search.includes('orderPlaced=true')) {
            var successModal = new bootstrap.Modal(document.getElementById('successModal'));
            successModal.show();
        }
    </script>
</body>
</html> 