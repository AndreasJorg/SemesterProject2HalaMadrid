package model;

public class Booking {

    private int id;
    private int baneId;
    private String startTid;
    private String slutTid;
    private String pris;
    private String status;

    public Booking(int id, int baneId, String startTid, String slutTid, String pris, String status) {
        this.id = id;
        this.baneId = baneId;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getBaneId() {
        return baneId;
    }

    public String getStartTid() {
        return startTid;
    }

    public String getSlutTid() {
        return slutTid;
    }

    public String getPris() {
        return pris;
    }

    public String getStatus() {
        return status;
    }
}