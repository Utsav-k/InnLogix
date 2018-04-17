package administrationModules.Housekeeping;

import javafx.beans.property.SimpleStringProperty;

public class RoomInventory {

    private SimpleStringProperty RoomNo, Soap, WaterBottle, Towel;

    public RoomInventory(String roomNo, String soap, String waterBottle, String towel) {

        RoomNo = new SimpleStringProperty(roomNo);
        Soap = new SimpleStringProperty(soap);
        WaterBottle = new SimpleStringProperty(waterBottle);
        Towel = new SimpleStringProperty(towel);
    }

    public String getRoomNo() {
        return RoomNo.get();
    }

    public SimpleStringProperty roomNoProperty() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        this.RoomNo.set(roomNo);
    }

    public String getSoap() {
        return Soap.get();
    }

    public SimpleStringProperty soapProperty() {
        return Soap;
    }

    public void setSoap(String soap) {
        this.Soap.set(soap);
    }

    public String getWaterBottle() {
        return WaterBottle.get();
    }

    public SimpleStringProperty waterBottleProperty() {
        return WaterBottle;
    }

    public void setWaterBottle(String waterBottle) {
        this.WaterBottle.set(waterBottle);
    }

    public String getTowel() {
        return Towel.get();
    }

    public SimpleStringProperty towelProperty() {
        return Towel;
    }

    public void setTowel(String towel) {
        this.Towel.set(towel);
    }


}