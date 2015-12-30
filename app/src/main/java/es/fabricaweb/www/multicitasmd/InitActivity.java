package es.fabricaweb.www.multicitasmd;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class InitActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private Button btnIniciar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainPageAdapter());

        btnIniciar = (Button) findViewById(R.id.btn_iniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClass(InitActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

    }

    class MainPageAdapter extends PagerAdapter{

        private LinearLayout page1;
        private LinearLayout page2;
        private LinearLayout page3;
        private LinearLayout page4;


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object instantiateItem(ViewGroup colletion, int position) {

            View page = null;

            switch (position){

                case 0:
                    if (page1 == null){
                        page1 = (LinearLayout) LayoutInflater.from (InitActivity.this).inflate(R.layout.init_present1,null);
                    }
                    page=page1;
                    break;

                case 1:
                    if (page2 == null){
                        page2 = (LinearLayout) LayoutInflater.from (InitActivity.this).inflate(R.layout.init_present2,null);
                    }
                    page=page2;
                    break;

                case 2:
                    if (page3 == null){
                        page3 = (LinearLayout) LayoutInflater.from (InitActivity.this).inflate(R.layout.init_main,null);
                    }
                    page=page3;
                    break;

                default:
                    if (page4 == null){
                        page4 = (LinearLayout) LayoutInflater.from (InitActivity.this).inflate(R.layout.init_login,null);
                    }
                    page=page4;
                    break;
            };

            ((ViewPager) colletion).addView(page,0);

            return page;

        }

        @Override
        public void destroyItem(View collection, int position, Object view) {

            ((ViewPager) collection).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }






}
