package comp3350.movieknight.presentation;

import comp3350.movieknight.R;
import comp3350.movieknight.application.Main;
import comp3350.movieknight.business.AccessUser;
import comp3350.movieknight.objects.User;
import comp3350.movieknight.presentation.MoviesActivity.MoviesActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int loggedInUserID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();

        Main.startUp();

        setContentView(R.layout.activity_main);
        setupDropDown();
        setupButton();
    }

    private void setupDropDown() {
        AccessUser accessUser = new AccessUser();
        ArrayList<User> users = new ArrayList<User>();
        accessUser.getAllUsers(users);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, R.layout.spinner_item, users);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void setupButton() {
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, MoviesActivity.class);
                intent.putExtra("LoggedInUserID",loggedInUserID);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        User loggedInUser = (User) arg0.getItemAtPosition(position);
        loggedInUserID = loggedInUser.getUserID();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Main.shutDown();
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.dbName);

        } catch (IOException ioe) {
            System.out.println("Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}