package com.bdp.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.legacy.app.ActionBarDrawerToggle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bdp.app.Adapter.MenuAdapter;
import com.bdp.app.R;

public class MenuActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView_main;
    private String[] TITLES = new String[5];
    private int[] ICONS = new int[5];
    private ActionBarDrawerToggle mDrawerToggle;
    private int PROFILE = R.drawable.ic_user;
    private MenuAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout Drawer;
    private String imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* toolbar*/
        toolbar = (Toolbar) findViewById(R.id.toolbaruser);

        TextView title = (TextView) findViewById(R.id.txtTitle);

        title.setText(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_list_white));
        } else {
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_list_white));
        }

        /*main menu*/
        mRecyclerView_main = (RecyclerView) findViewById(R.id.RecyclerView_main); // Assigning the RecyclerView Object to the xml View
        mRecyclerView_main.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size


        /* menu main*/
        TITLES[0] = getString(R.string.inicio);
        TITLES[1] = "";
        TITLES[2] = "";
        TITLES[3] = getString(R.string.ayuda);
        TITLES[4] = getString(R.string.cerrar);


        ICONS[0] = R.drawable.ic_home;
        ICONS[1] = R.drawable.ic_home;
        ICONS[2] = R.drawable.ic_home;
        ICONS[3] = R.drawable.ic_help;
        ICONS[4] = R.drawable.ic_exit;

        menu();

    }

    public void menu()
    {


        mAdapter = new MenuAdapter(TITLES, ICONS, "Luis Paterno", PROFILE, imagen, MenuActivity.this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)

        mRecyclerView_main.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView_main.setLayoutManager(mLayoutManager);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view



        mDrawerToggle = new androidx.legacy.app.ActionBarDrawerToggle(this, Drawer,R.drawable.ic_user, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        }; // Drawer Toggle Object Made*/

        Drawer.addDrawerListener(mDrawerToggle);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Drawer.openDrawer(Drawer);
                Drawer.openDrawer(Gravity.LEFT);
                //------------
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (Drawer.isDrawerOpen(GravityCompat.START)) {
            Drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


}
