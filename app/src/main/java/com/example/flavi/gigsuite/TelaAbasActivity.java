package com.example.flavi.gigsuite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.flavi.gigsuite.utils.AbasPagerAdapter;

/**
 * Created by lucasnascimento on 18/06/17.
 */

public class TelaAbasActivity extends AppCompatActivity {
    ViewPager mViewPager;
    TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_abas);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        Toolbar toolbarVerdadeiro = (Toolbar) findViewById(R.id.toolbarVerdadeiro);
        setSupportActionBar(toolbarVerdadeiro);

        toolbarVerdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAbasActivity.this, ListarUsuariosActivity.class);
                startActivity(intent);
            }
        });

        AbasPagerAdapter pagerAdapter = new AbasPagerAdapter(this,
                getSupportFragmentManager());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
