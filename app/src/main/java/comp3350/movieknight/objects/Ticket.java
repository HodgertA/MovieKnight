package comp3350.movieknight.objects;

public class Ticket {

    private int ticketID;
    private int seatNum;
    private int userID;
    private int showingID;
    private int theatreID;

    public Ticket(int ticketID, int userID,int showingID,int theatreID,int seatNum){
        this.ticketID=ticketID;
        this.userID=userID;
        this.showingID=showingID;
        this.theatreID=theatreID;
        this.seatNum=seatNum;
    }

    public Ticket(int ticketID, int showingID, int theatreID, int seatNum){
        this.ticketID=ticketID;
        this.userID= -1;
        this.showingID=showingID;
        this.theatreID=theatreID;
        this.seatNum=seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setShowingID(int showingID) {
        this.showingID = showingID;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getShowingID() {
        return showingID;
    }

    public int getTheatreID() {
        return theatreID;
    }

    public int getUserID() {
        return userID;
    }

    public int getTicketID() {
        return ticketID;
    }

    @Override
    public String toString() {
        return "Ticket: " +
                "ticketID=" + ticketID +
                ", seatNum=" + seatNum +
                ", userID=" + userID +
                ", showingID=" + showingID +
                ", theatreID=" + theatreID ;
    }

    @Override
    //------------------------------------------
    //this equals function compare ticketID
    //------------------------------------------
    public boolean equals(Object o) {
        boolean result = false;
        Ticket ticket;

        if(o instanceof Ticket)
        {
            ticket=(Ticket) o;
            if((ticket.ticketID == ticketID))
            {
                result=true;
            }
        }

        return result;
    }


//    @Override
//    //------------------------------------------
//    //this equals function compare userID, showingID and seatNum
//    //------------------------------------------
//    public boolean equals(Object o) {
//
//        boolean result=false;
//        Ticket ticket;
//
//        if(o instanceof Ticket)
//        {
//            ticket=(Ticket) o;
//            if(((ticket.userID==null)&&(userID==null))||(ticket.userID.equals(userID))
//                    &&((ticket.showingID==null)&&(showingID==null))||(ticket.showingID.equals(showingID))
//                    &&(ticket.seatNum==seatNum))
//            {
//                result=true;
//            }
//        }
//
//
//        return result;
//    }

}
