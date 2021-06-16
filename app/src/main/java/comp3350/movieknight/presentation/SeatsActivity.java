package comp3350.movieknight.presentation;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.movieknight.R;
import comp3350.movieknight.objects.Showing;
import comp3350.movieknight.presentation.adapters.SeatViewAdapter;
import comp3350.movieknight.presentation.common.ObjectWrapperForBinder;

public class SeatsActivity extends AppCompatActivity {

    private Showing showing;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SeatViewAdapter seatViewAdapter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Object showing = ((ObjectWrapperForBinder)getIntent().getExtras().getBinder("object_value")).getData();

        if(showing instanceof Showing) {

            setContentView(R.layout.activity_seats);

            recyclerView = findViewById(R.id.recyclerView);
            layoutManager = new GridLayoutManager(this, 5);
            recyclerView.setLayoutManager(layoutManager);
            seatViewAdapter = new SeatViewAdapter((Showing) showing);
        }
    }
}
