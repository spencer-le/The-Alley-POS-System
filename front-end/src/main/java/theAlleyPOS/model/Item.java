package theAlleyPOS.model;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Sebastian Oberg
 */
public class Item implements Orderable {
    private SimpleIntegerProperty id;
    private SimpleStringProperty itemName;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty inventoryCount;

    /**
     * Default constructor
     */
    public Item() {
        this.id = new SimpleIntegerProperty();
        this.itemName = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.inventoryCount = new SimpleIntegerProperty();
    }

    /**
     * Parameterized constructor
     * @param id
     * @param itemName
     * @param price
     * @param inventoryCount
     */
    public Item(int id, String itemName, double price, int inventoryCount) {
        this.id = new SimpleIntegerProperty(id);
        this.itemName = new SimpleStringProperty(itemName);
        this.price = new SimpleDoubleProperty(price);
        this.inventoryCount = new SimpleIntegerProperty(inventoryCount);
    }

    /**
     * The rest of the following are getters and setters for the Item class
     * @return
     */
    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getInventoryCount() {
        return inventoryCount.get();
    }

    public SimpleIntegerProperty inventoryCountProperty() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount.set(inventoryCount);
    }

    @Override
    public String getName() {
        return getItemName();
    }

    @Override
    public Double getPrice() {
        return price.get();
    }
}
