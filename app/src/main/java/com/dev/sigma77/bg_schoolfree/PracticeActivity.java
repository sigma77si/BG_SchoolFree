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


public class PracticeActivity extends AppCompatActivity {
    ImageView v;

    private Toolbar toolbar;
    RecyclerView reciclerView;
    private VizAdapter adapter;

    public PracticeActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.preparation);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        v = (ImageView) findViewById(R.id.imageView9);
        reciclerView = (RecyclerView) findViewById(R.id.drowerList);
        adapter = new VizAdapter(this, getData(), "Practice");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public List<DataInformation> getData() {
        List<DataInformation> data = new ArrayList<>();
        int[] icons = {
                R.drawable.count_on_fingers_04_small
                , R.drawable.mushroom1_small
                , R.drawable.a2_small
                , R.drawable.button6_small
                , R.drawable.pear_main_small
                , R.drawable.count_on_fingers_04_small
                , R.drawable.zapomni1
                , R.drawable.clock1
                , R.drawable.similar21
                , R.drawable.digit3
                , R.drawable.squares5
                , R.drawable.next_digit3
                , R.drawable.similarity_animal_1
                , R.drawable.similarity_things_1
//              ,R.drawable.letters_1
//              ,R.drawable.lines_1
//              ,R.drawable.half_figure_1
//              ,R.drawable.arrow_2
//              ,R.drawable.similarity_cubes_4
//              ,R.drawable.similarity_dice_1
//              ,R.drawable.cube_bloks_1
//              ,R.drawable.cubes_count_1
//              ,R.drawable.cubes_count_1
        };

        String a = getResources().getString(R.string.a_viz_adapter_title);
        String b = getResources().getString( R.string.b_viz_adapter_title);
        String c = getResources().getString( R.string.c_viz_adapter_title);
        String d= getResources().getString(R.string.d_viz_adapter_title);
        String e = getResources().getString(R.string.e_viz_adapter_title);
        String f = getResources().getString( R.string.f_viz_adapter_title);
        String g = getResources().getString( R.string.g_viz_adapter_title);
        String h = getResources().getString( R.string.h_viz_adapter_title);
        String i = getResources().getString( R.string.i_viz_adapter_title);
        String j = getResources().getString( R.string.j_viz_adapter_title);
        String k= getResources().getString(R.string.k_viz_adapter_title);
        String l = getResources().getString(R.string.l_viz_adapter_title);
        String m= getResources().getString(R.string.m_viz_adapter_title);
        String n = getResources().getString(R.string.n_viz_adapter_title);
        String[]titles={a,b,c,d,e,f,g,h,i,j,k,l,m,n


        };

//        String[] titles = {
//                "Преброй пръстите"
//                , "Открий силуета"
//                , "Намери излишната картинка"
//                , "Открий еднаквите"
//                , "Сглоби картината"
//                , "Преброй сгънатите пръсти"
//                , "Запомни картинките"
//                , "Колко е часът?"
//                , "Намери подобните"
//                , "Коя е цифрата?"
//                , "Колко са квадратите?"
//                , "Коя е следващата цифра?"
//                , "Кои си приличат? Животни"
//                , "Кои си приличат? Предмети"
////              ,"Кои си приличат? Букви"
////              ,"Кои си приличат? Линий"
////              ,"Кои си приличат? Фигури"
////              ,"Кои си приличат? Стрелки"
////              ,"Кои си приличат? Кубчета"
////              ,"Кои си приличат? Зарчета"
////              ,"Колко тухли трябват?"
////              ,"Преброй кубчетата"
////              ,"По малката цифра"
//        };
        for (int ii = 0; ii < titles.length && ii < icons.length; ii++) {
            DataInformation current = new DataInformation();

            current.iconId = icons[ii];
            current.title = titles[ii];
            data.add(current);
        }
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
//            case R.id.bg:
//                item.setChecked(true);
//                selLocale("bg");
//                break;
//            case R.id.en:
//                item.setChecked(true);
//                selLocale("en");
//
//                break;
//            case R.id.ru:
//                item.setChecked(true);
//                selLocale("ru");
//                break;
//            case R.id.de:
//                item.setChecked(true);
//                selLocale("de");
//                break;
            case R.id.action_settings:
                startActivity(new Intent(this, HelpActivity.class));


            default:
        //        selLocale("en");


        }


        return super.onOptionsItemSelected(item);
    }
    private void selLocale(String language) {
     Locale   myLocale =new Locale(language);
        Resources res=getResources();
        DisplayMetrics dm =res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale= myLocale;
        res.updateConfiguration(conf,dm);
        //     Intent intent=new Intent(this,PracticeActivity.class);
//        finish();
//        startActivity(intent);
        onConfigurationChanged(conf);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        adapter = new VizAdapter(this, getData(), "Practice");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(R.string.app_name);

        super.onConfigurationChanged(newConfig);

    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        adapter = new VizAdapter(this, getData(), "Practice");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(R.string.app_name);
    }


}
