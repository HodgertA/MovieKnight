package comp3350.movieknight.objects;


import java.util.Objects;

public class Ticket {

    private String ticketID;
    private int seatNum;
    private String userID;
    private String showingID;
    private String theatreID;



    public Ticket(String ticketID,String userID,String showingID,String theatreID,int seatNum){
        this.ticketID=ticketID;
        this.userID=userID;
        this.showingID=showingID;
        this.theatreID=theatreID;
        this.seatNum=seatNum;
    }

    public Ticket(String ticketID,String showingID,String theatreID,int seatNum){
        this.ticketID=ticketID;
        this.userID=null;
        this.showingID=showingID;
        this.theatreID=theatreID;
        this.seatNum=seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setShowingID(String showingID) {
        this.showingID = showingID;
    }

    public void setTheatreID(String theatreID) {
        this.theatreID = theatreID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getShowingID() {
        return showingID;
    }

    public String getTheatreID() {
        return theatreID;
    }

    public String getUserID() {
        return userID;
    }

    public String getTicketID() {
        return ticketID;
    }

//    @Override
//    public String toString() {
//        return "Ticket{" +
//                "ticketID='" + ticketID + '\'' +
//                ", seatNum=" + seatNum +
//                ", userID='" + userID + '\'' +
//                ", showingID='" + showingID + '\'' +
//                ", theatreID='" + theatreID + '\'' +
//                '}';
//    }



    @Override
    //------------------------------------------
    //this equals function compare ticketID
    //------------------------------------------
    public boolean equals(Object o) {
        boolean result=false;
        Ticket ticket;

        if(o instanceof Ticket)
        {
            ticket=(Ticket) o;
            if(((ticket.ticketID==null)&&(ticketID==null))||(ticket.ticketID.equals(ticketID)))
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
