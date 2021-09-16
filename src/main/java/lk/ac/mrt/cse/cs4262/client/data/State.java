package lk.ac.mrt.cse.cs4262.client.data;

public class State {
    private String identity;
    private String roomId;

    public State(String identity, String roomId) {
        this.identity = identity;
        this.roomId = roomId;
    }

    public synchronized String getRoomId() {
        return roomId;
    }

    public synchronized void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getIdentity() {
        return identity;
    }


}
