package app.inventoryItem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id private Integer itemNumber;
    private String name;
    private int amount;
    private String inventoryCode;



}
