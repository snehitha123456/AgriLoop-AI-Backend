package com.agriloop.order;
import com.agriloop.product.Product;
import com.agriloop.product.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
  private final OrderRepository orders; private final ProductRepository products;
  public OrderController(OrderRepository orders, ProductRepository products){this.orders=orders;this.products=products;}
  @GetMapping public List<Order> all(){return orders.findAll();}
  @PostMapping @Transactional public Order create(@RequestBody Order request){
    if(request.getBuyerName()==null||request.getBuyerName().isBlank()||request.getProductId()==null||request.getQuantityKg()==null||request.getQuantityKg().signum()<=0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Buyer, product and positive quantity are required");
    Product product=products.findById(request.getProductId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
    if(product.getQuantityKg().compareTo(request.getQuantityKg())<0) throw new ResponseStatusException(HttpStatus.CONFLICT,"Not enough stock available");
    BigDecimal total=product.getPricePerKg().multiply(request.getQuantityKg());
    product.setQuantityKg(product.getQuantityKg().subtract(request.getQuantityKg()));
    products.save(product);
    request.setId(null); request.setTotalPrice(total); request.setStatus("PLACED");
    return orders.save(request);
  }
}
