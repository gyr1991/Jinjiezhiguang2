package com.gyr.jinjiezhiguang.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gyr.jinjiezhiguang.R;


public class ToolBarActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    TextView tv_close;
    DrawerLayout mDrawLayout;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        initViews();
    }

    private void initViews(){
        tv_close=findViewById(R.id.tv_close);
        mToolBar=this.findViewById(R.id.toolbar);
        mToolBar.setTitle("ToolBar");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_settings:
                        Toast.makeText(ToolBarActivity.this,"action_settings",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(ToolBarActivity.this,"action_share",Toast.LENGTH_SHORT).show();
                        break;
                        default:
                            break;
                }
                return true;
            }
        });
        mDrawLayout=findViewById(R.id.id_drawerlayout);
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawLayout,mToolBar,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawLayout.setDrawerListener(mDrawerToggle);
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawLayout.closeDrawer(Gravity.LEFT);
            }
        });
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                Palette.Swatch swatch=palette.getVibrantSwatch();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));
            }
        });
    }

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }
}
