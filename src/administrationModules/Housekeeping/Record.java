package administrationModules.Housekeeping;

import javafx.beans.property.SimpleStringProperty;

public class Record {

        private SimpleStringProperty RoomNo, RoomType,Status , Guest , Attendant, Request;

        public Record(String RoomNo,String RoomType,String Status,String Guest,String Attendant,String Request)
        {
            this.RoomNo=new SimpleStringProperty(RoomNo);
            this.RoomType=new SimpleStringProperty(RoomType);
            this.Status=new SimpleStringProperty(Status);
            this.Guest=new SimpleStringProperty(Guest);
            this.Attendant=new SimpleStringProperty(Attendant);
            //this.Guest=new SimpleStringProperty(Guest);
            this.Request=new SimpleStringProperty(Request);
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

    public String getRoomType() {
        return RoomType.get();
    }

    public SimpleStringProperty roomTypeProperty() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        this.RoomType.set(roomType);
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }



    public String getAttendant() {
        return Attendant.get();
    }

    public SimpleStringProperty attendantProperty() {
        return Attendant;
    }

    public void setAttendant(String attendant) {
        this.Attendant.set(attendant);
    }

    public String getGuest() {
        return Guest.get();
    }

    public SimpleStringProperty guestProperty() {
        return Guest;
    }

    public void setGuest(String guest) {
        this.Guest.set(guest);
    }

    public String getRequest() {
        return Request.get();
    }

    public SimpleStringProperty requestProperty() {
        return Request;
    }

    public void setRequest(String request) {
        this.Request.set(request);
    }
}


