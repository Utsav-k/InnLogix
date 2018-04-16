package administrationModules.frontOffice;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

import java.time.LocalDate;

public class Guest {
    private final SimpleStringProperty guestName;
    private final SimpleStringProperty guestAddr;
    private final SimpleStringProperty guestCity;
    private final SimpleStringProperty guestContact;
    private final SimpleStringProperty guestRoom;
    private final SimpleStringProperty guestStartDate;
    private final SimpleStringProperty guestEndDate;
    private final SimpleStringProperty guestEmail;

    public Guest(String guestName, String guestAddr, String guestCity, String guestContact, String guestRoom, String guestStartDate, String guestEndDate, String guestEmail) {
        this.guestName = new SimpleStringProperty(guestName);
        this.guestAddr = new SimpleStringProperty(guestAddr);
        this.guestCity = new SimpleStringProperty(guestCity);
        this.guestContact = new SimpleStringProperty(guestContact);
        this.guestRoom = new SimpleStringProperty(guestRoom);
        this.guestStartDate = new SimpleStringProperty(guestStartDate);
        this.guestEndDate = new SimpleStringProperty(guestEndDate);
        this.guestEmail = new SimpleStringProperty(guestEmail);
    }

    public String getGuestName() {
        return guestName.get();
    }

    public SimpleStringProperty guestNameProperty() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName.set(guestName);
    }

    public String getGuestAddr() {
        return guestAddr.get();
    }

    public SimpleStringProperty guestAddrProperty() {
        return guestAddr;
    }

    public void setGuestAddr(String guestAddr) {
        this.guestAddr.set(guestAddr);
    }

    public String getGuestCity() {
        return guestCity.get();
    }

    public SimpleStringProperty guestCityProperty() {
        return guestCity;
    }

    public void setGuestCity(String guestCity) {
        this.guestCity.set(guestCity);
    }

    public String getGuestContact() {
        return guestContact.get();
    }

    public SimpleStringProperty guestContactProperty() {
        return guestContact;
    }

    public void setGuestContact(String guestContact) {
        this.guestContact.set(guestContact);
    }

    public String getGuestRoom() {
        return guestRoom.get();
    }

    public SimpleStringProperty guestRoomProperty() {
        return guestRoom;
    }

    public void setGuestRoom(String guestRoom) {
        this.guestRoom.set(guestRoom);
    }

    public String getGuestStartDate() {
        return guestStartDate.get();
    }

    public SimpleStringProperty guestStartDateProperty() {
        return guestStartDate;
    }

    public void setGuestStartDate(String guestStartDate) {
        this.guestStartDate.set(guestStartDate);
    }

    public String getGuestEndDate() {
        return guestEndDate.get();
    }

    public SimpleStringProperty guestEndDateProperty() {
        return guestEndDate;
    }

    public void setGuestEndDate(String guestEndDate) {
        this.guestEndDate.set(guestEndDate);
    }

    public String getGuestEmail() {
        return guestEmail.get();
    }

    public SimpleStringProperty guestEmailProperty() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail.set(guestEmail);
    }
}
