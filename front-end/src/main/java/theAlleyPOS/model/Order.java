package theAlleyPOS.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDateTime;

/**
 * @author Spencer Le, Sebastian Oberg
 */
public class Order {
    private SimpleIntegerProperty id;
    private SimpleStringProperty customerName;
    private SimpleObjectProperty<LocalDateTime> orderDate; // Change Date to LocalDateTime
    private SimpleDoubleProperty totalCost;

    /**
     * Default constructor
     */
    public Order() {
        this.id = new SimpleIntegerProperty();
        this.customerName = new SimpleStringProperty();
        this.orderDate = new SimpleObjectProperty<>();
        this.totalCost = new SimpleDoubleProperty();
    }

    /**
     * Parameterized constructor
     * @param id
     * @param customerName
     * @param orderDate
     * @param totalCost
     */
    public Order(int id, String customerName, LocalDateTime orderDate, double totalCost) {
        this.id = new SimpleIntegerProperty(id);
        this.customerName = new SimpleStringProperty(customerName);
        this.orderDate = new SimpleObjectProperty<>(orderDate);
        this.totalCost = new SimpleDoubleProperty(totalCost);
    }

    /**
     * The rest of the following are getters and setters for the Order class
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

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public LocalDateTime getOrderDate() {
        return orderDate.get();
    }

    public SimpleObjectProperty<LocalDateTime> orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate.set(orderDate);
    }

    public double getTotalCost() {
        return totalCost.get();
    }

    public SimpleDoubleProperty totalCostProperty() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost.set(totalCost);
    }
}
