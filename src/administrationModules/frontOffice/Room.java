package administrationModules.frontOffice;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class Room {

    private final SimpleIntegerProperty roomNum;
    private final SimpleStringProperty roomType;
    private final SimpleStringProperty roomStatus;
    private final SimpleStringProperty roomGuest;
    private final SimpleStringProperty roomAttendant;
    private final SimpleStringProperty roomRequest;

    public Room(int roomNum, String roomType, String roomStatus, String roomGuest, String roomAttendant, String roomRequest) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.roomType = new SimpleStringProperty(roomType);
        this.roomStatus = new SimpleStringProperty(roomStatus);
        this.roomGuest = new SimpleStringProperty(roomGuest);
        this.roomAttendant = new SimpleStringProperty(roomAttendant);
        this.roomRequest = new SimpleStringProperty(roomRequest);


    }
    @FXML
    public int getRoomNum() {
        return roomNum.get();
    }

    public SimpleIntegerProperty roomNumProperty() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum.set(roomNum);
    }

    public String getRoomType() {
        return roomType.get();
    }

    public SimpleStringProperty roomTypeProperty() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType.set(roomType);
    }

    public String getRoomStatus() {
        return roomStatus.get();
    }

    public SimpleStringProperty roomStatusProperty() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus.set(roomStatus);
    }

    public String getRoomGuest() {
        return roomGuest.get();
    }

    public SimpleStringProperty roomGuestProperty() {
        return roomGuest;
    }

    public void setRoomGuest(String roomGuest) {
        this.roomGuest.set(roomGuest);
    }

    public String getRoomAttendant() {
        return roomAttendant.get();
    }

    public SimpleStringProperty roomAttendantProperty() {
        return roomAttendant;
    }

    public void setRoomAttendant(String roomAttendant) {
        this.roomAttendant.set(roomAttendant);
    }

    public String getRoomRequest() {
        return roomRequest.get();
    }

    public SimpleStringProperty roomRequestProperty() {
        return roomRequest;
    }

    public void setRoomRequest(String roomRequest) {
        this.roomRequest.set(roomRequest);
    }


}
