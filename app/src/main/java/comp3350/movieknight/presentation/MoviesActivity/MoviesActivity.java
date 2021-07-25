package comp3350.movieknight.presentation.MoviesActivity;

import comp3350.movieknight.R;
import comp3350.movieknight.presentation.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MoviesActivity extends AppCompatActivity {
    private int loggedInUser;
    private BottomNavigationView bottomNav;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loggedInUser = MainActivity.getLoggedInUserID();

        setContentView(R.layout.activity_movies);

        bottomNav = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);

        setUpBottomNavigation();
        setUpViewPager();
    }

    private void setUpBottomNavigation() {
        bottomNav.setOnNavigationItemSelectedListener((item) -> {
            switch(item.getItemId()) {
                case R.id.nav_movie_list:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.nav_tickets:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return true;
        });
    }

    private void setUpViewPager() {
        MoviesActivityViewPagerAdapter viewPagerAdapter = new MoviesActivityViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), loggedInUser);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.getMenu().findItem(R.id.nav_movie_list).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.nav_tickets).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                viewPagerAdapter.updateTicketFragment();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(MoviesActivity.this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
