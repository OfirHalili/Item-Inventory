package app.inventoryItem.repository;

import app.inventoryItem.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
