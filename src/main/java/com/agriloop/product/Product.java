package com.agriloop.product;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="products")
public class Product {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false) private String name;
  @Column(nullable=false) private String category;
  @Column(name="price_per_kg", nullable=false) private BigDecimal pricePerKg;
  @Column(name="quantity_kg", nullable=false) private BigDecimal quantityKg;
  @Column(name="farmer_name", nullable=false) private String farmerName;
  @Column(nullable=false) private String location;
  @Column(name="harvest_date") private LocalDate harvestDate;
  public Product() {}
  public Long getId(){return id;} public void setId(Long v){id=v;}
  public String getName(){return name;} public void setName(String v){name=v;}
  public String getCategory(){return category;} public void setCategory(String v){category=v;}
  public BigDecimal getPricePerKg(){return pricePerKg;} public void setPricePerKg(BigDecimal v){pricePerKg=v;}
  public BigDecimal getQuantityKg(){return quantityKg;} public void setQuantityKg(BigDecimal v){quantityKg=v;}
  public String getFarmerName(){return farmerName;} public void setFarmerName(String v){farmerName=v;}
  public String getLocation(){return location;} public void setLocation(String v){location=v;}
  public LocalDate getHarvestDate(){return harvestDate;} public void setHarvestDate(LocalDate v){harvestDate=v;}
}
