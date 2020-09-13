package app.itemInventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Item {
    @Id@NonNull
    @ApiModelProperty(notes = "The unique id of the item")
    private Integer itemNumber;
    @ApiModelProperty(notes = "The name of the item")
    private String name;
    @ApiModelProperty(notes = "The quantity of item in stock")
    private Integer amount;
    @ApiModelProperty(notes = "The inventory code of the item")
    private String inventoryCode;

}
