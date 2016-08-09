package com.dev.sigma77.bg_schoolfree;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TestActivity extends AppCompatActivity {
    ImageView v;

    private Toolbar toolbar;
    RecyclerView reciclerView;
    private VizAdapter adapter;
    Locale  myLocale;

    public TestActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.test);

        if (!MainActivity.isTest) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        v=(ImageView)findViewById(R.id.imageView9);
        reciclerView = (RecyclerView) findViewById(R.id.drowerList);
        adapter = new VizAdapter(this, getData(),"Test");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<DataInformation> getData() {
        List<DataInformation> data = new ArrayList<>();
        int[] icons = {
                R.drawable.test_ikon,
              R.drawable.mushroom1_small
        };
        String[] titles = {
                getResources().getString(R.string.test1),
                getResources().getString(R.string.test2)
        };

        for (int i = 0; i < titles.length && i < icons.length; i++) {
            DataInformation current = new DataInformation();

            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.bg:
                item.setChecked(true);
                setLocale("bg");
                break;
            case R.id.en:
                item.setChecked(true);
                setLocale("en");

                break;
            case R.id.ru:
                item.setChecked(true);
                setLocale("ru");
                break;
            case R.id.de:
                item.setChecked(true);
                setLocale("de");
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, HelpActivity.class));


            default:
                //    setLocale("en");


        }
        return super.onOptionsItemSelected(item);
    }

    private void setLocale(String language) {
        myLocale =new Locale(language);
        Resources res=getResources();
        DisplayMetrics dm =res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale= myLocale;
        res.updateConfiguration(conf,dm);
        //     Intent intent=new Intent(this,MainActivity.class);
//        finish();
//        startActivity(intent);
        onConfigurationChanged(conf);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {

        adapter = new VizAdapter(this, getData(), "Test");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(R.string.test);

        super.onConfigurationChanged(newConfig);

    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        adapter = new VizAdapter(this, getData(), "Test");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(R.string.test);
    }
}
