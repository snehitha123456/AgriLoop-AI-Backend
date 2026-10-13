package com.agriloop.order;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name="orders")
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="buyer_name",nullable=false) private String buyerName;
  @Column(name="product_id",nullable=false) private Long productId;
  @Column(name="quantity_kg",nullable=false) private BigDecimal quantityKg;
  @Column(name="total_price",nullable=false) private BigDecimal totalPrice;
  @Column(nullable=false) private String status="PLACED";
  @Column(name="created_at") private LocalDateTime createdAt=LocalDateTime.now();
  public Order() {}
  public Long getId(){return id;} public void setId(Long v){id=v;}
  public String getBuyerName(){return buyerName;} public void setBuyerName(String v){buyerName=v;}
  public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
  public BigDecimal getQuantityKg(){return quantityKg;} public void setQuantityKg(BigDecimal v){quantityKg=v;}
  public BigDecimal getTotalPrice(){return totalPrice;} public void setTotalPrice(BigDecimal v){totalPrice=v;}
  public String getStatus(){return status;} public void setStatus(String v){status=v;}
  public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
