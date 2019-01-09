package com.bdp.app.Activity;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bdp.app.Adapter.FondosAdapter;
import com.bdp.app.Clases.Data;
import com.bdp.app.ProgressDialog;
import com.bdp.app.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private ArrayList<Data> mListData;
    private DatosRecycleAdapter mDataAdapter;
    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static LinearLayout seleccion,seleccion2;
    private RadioGroup radioFondos;
    private static TextView txtSelect1,txtSelect2;
    private ImageView imgEdit1,imgEdit2;
    private static Boolean flat1 = false;
    private static Boolean flat2 = false;
    private static Button next;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* toolbar*/
        toolbar = (Toolbar) findViewById(R.id.toolbaruser);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_arrow));
        } else {
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow));
        }


        /* lista*/
        mListData = new ArrayList<Data>();

        mDataAdapter = new DatosRecycleAdapter();

        /* recicler */
        mRecyclerView = (RecyclerView) findViewById(R.id.datos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mDataAdapter);



        //tab
        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);




        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Creating our pager adapter
        FondosAdapter adapter = new FondosAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);


        seleccion = (LinearLayout) findViewById(R.id.seleccion);
        seleccion2 = (LinearLayout) findViewById(R.id.seleccion2);

        radioFondos = (RadioGroup) findViewById(R.id.radioFondos);


        txtSelect1 = (TextView) findViewById(R.id.txtSelect1);
        txtSelect2 = (TextView) findViewById(R.id.txtSelect2);

        imgEdit1 =(ImageView) findViewById(R.id.imgEdit1);
        imgEdit2 =(ImageView) findViewById(R.id.imgEdit2);


        radioFondos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.debito) {

                    txtSelect1.setText(getString(R.string.debito));

                }else if(checkedId == R.id.ahorro){
                    txtSelect1.setText(getString(R.string.ahorro));

                }else if(checkedId == R.id.venta) {
                    txtSelect1.setText(getString(R.string.venta));
                }
                else{
                    txtSelect1.setText(getString(R.string.otros));
                }


                seleccion.setVisibility(View.VISIBLE);
                radioFondos.setVisibility(View.GONE);
                flat1 = true;
                if (flat1 ==true && flat2==true)
                {
                    next.setEnabled(true);
                    next.setBackground(getResources().getDrawable(R.drawable.button1));
                }

            }
            });

        imgEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccion.setVisibility(View.GONE);
                radioFondos.setVisibility(View.VISIBLE);
            }
        });


        imgEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccion2.setVisibility(View.GONE);
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
            }
        });

        progressDialog = new ProgressDialog(this);


        next = (Button) findViewById(R.id.next);
        next.setEnabled(false);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressDialog.showDialog();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hideDialog();

                        Intent intent = new Intent(MainActivity.this,ValidacionActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }, 3000);



            }
        });




    }

    public static void renovar(Context context)
    {
        seleccion2.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);
        txtSelect2.setText(context.getString(R.string.revocacion));
        flat2 = true;
        if (flat1 ==true && flat2==true)
        {
            next.setEnabled(true);
            next.setBackground(context.getResources().getDrawable(R.drawable.button1));
        }
    }

    public static void inversion(Context context, int select)
    {

        txtSelect2.setText(context.getString(R.string.cancelacion));
        seleccion2.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);
        flat2 = true;
        if (flat1 ==true && flat2==true)
        {
            next.setEnabled(true);
            next.setBackground(context.getResources().getDrawable(R.drawable.button1));
        }


    }


    private void carga()
    {

        mListData.add(new Data("CAPITAL","$200","USD",false));
        mListData.add(new Data("PLAZO","30","DIAS", false));
        mListData.add(new Data("RENDIMIENTO","$0.55","USD",false));
        mListData.add(new Data("RETENCIÓN","$","USD",false));
        mListData.add(new Data("RENDIMIENTO NETO","$0.55","USD",false));
        mListData.add(new Data("TOTAL A RECIBIR","$200.55","USD",true));

        mDataAdapter.notifyDataSetChanged();



    }


    @Override
    protected void onResume() {
        super.onResume();

        carga();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                //------------
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }



    /* adapter*/

    public class DatosRecycleAdapter extends RecyclerView.Adapter<DatosRecycleHolder> {
        private int lastPosition = -1;

        @Override
        public DatosRecycleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data, viewGroup, false);
            return new DatosRecycleHolder(v);
        }


        @Override
        public void onBindViewHolder(final DatosRecycleHolder productHolder, final int i) {


            productHolder.mTitle.setText(mListData.get(i).getText());
            productHolder.mCost.setText(mListData.get(i).getCost());
            productHolder.mMon.setText(mListData.get(i).getMoney());
            if(mListData.get(i).getBlack())
            {
                productHolder.mCost.setTextColor(getResources().getColor(R.color.total));
                productHolder.mTitle.setTextColor(getResources().getColor(R.color.total2));
                productHolder.mMon.setTextColor(getResources().getColor(R.color.total));
            }
            setAnimation(productHolder.itemView, i);

        }


        @Override
        public int getItemCount() {
            return mListData.size();
        }


        private void setAnimation(View viewToAnimate, int position) {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition) {
                Animation animation;
                if (position % 2 == 0) {
                    animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_in);
                } else {
                    animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_in);
                }

                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }


    }

    public class DatosRecycleHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mCost;
        public TextView mMon;


        public DatosRecycleHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            mCost = (TextView) itemView.findViewById(R.id.txtCost);
            mMon = (TextView) itemView.findViewById(R.id.txtMon);

        }
    }



}
