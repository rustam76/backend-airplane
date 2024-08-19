package com.airline.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discount {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String code;
   private Double discount_percent;
   private String description;
   private LocalDateTime valid_from;
   private LocalDateTime valid_to;

   public Long getId() {
       return id;
   }    

   public void setId(Long id) {
       this.id = id;
   }

   public String getCode() {   
       return code;
   }


   public void setCode(String code) {
       this.code = code;
   }

 public Double getDiscount_percent() {
       return discount_percent;
   }

   public void setDiscount_percent(Double discount_percent) {
        this.discount_percent = discount_percent;
   }


   public String getDescription() {
       return description;
   }


   public void setDescription(String description) {
       this.description = description;
   }    


   public LocalDateTime getValid_from() {
       return valid_from;
   }

   public void setValid_from(LocalDateTime valid_from) {
       this.valid_from = valid_from;
   }


   public LocalDateTime getValid_to() {
       return valid_to;
   }

   public void setValid_to(LocalDateTime valid_to) {
       this.valid_to = valid_to;
   }

}
