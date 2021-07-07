package comp3350.movieknight.objects;

public class Seat {
    private int seatId;
    private boolean selected;

    public Seat(int seatId, boolean selected) {
        this.seatId = seatId;
        this.selected = selected;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
