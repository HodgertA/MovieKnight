package comp3350.movieknight.presentation.ticketPage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import comp3350.movieknight.R;
import comp3350.movieknight.business.AccessTickets;
import comp3350.movieknight.objects.Ticket;

public class TicketFragment extends Fragment {

    private RecyclerView ticketRecyclerView;
    private TicketRecyclerViewAdapter adapter;
    private ArrayList<Ticket> tickets;
    private AccessTickets accessTickets;
    private int userID;

    public TicketFragment(int userID){
        this.userID = userID;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ticket, container, false);
        accessTickets=new AccessTickets();

        tickets= accessTickets.getUserTickets(userID);

        ticketRecyclerView=view.findViewById(R.id.tickets_recycler_view);
        ticketRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter=new TicketRecyclerViewAdapter(tickets);
        ticketRecyclerView.setAdapter(adapter);


        return view;
    }

    public void updateTickets(){
        adapter.notifyDataSetChanged();
    }

}