package com.agriloop.product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductController {
  private final ProductRepository repo;
  public ProductController(ProductRepository repo){this.repo=repo;}
  @GetMapping public List<Product> all(){return repo.findAll();}
  @GetMapping("/{id}") public Product one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
  @PostMapping public Product create(@RequestBody Product p){
    if(p.getName()==null||p.getName().isBlank()||p.getCategory()==null||p.getPricePerKg()==null||p.getQuantityKg()==null||p.getFarmerName()==null||p.getLocation()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing required product fields");
    if(p.getPricePerKg().signum()<0||p.getQuantityKg().signum()<0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Price and quantity must not be negative");
    p.setId(null); return repo.save(p);
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){if(!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"); repo.deleteById(id);}
}
