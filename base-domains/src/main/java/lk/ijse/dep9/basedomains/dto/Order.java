package lk.ijse.dep9.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order implements Serializable {
    private String orderId;
    private String name;
    private int qty;
    private double price;
}
