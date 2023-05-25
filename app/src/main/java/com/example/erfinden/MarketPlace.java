package com.example.erfinden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class MarketPlace extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        bottomNavigation=findViewById(R.id.bottomnavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.baseline_settings_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.baseline_add_shopping_cart_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_home_24));
//        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.baseline_home_24));

//        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//            @Override
//            public Unit invoke(MeowBottomNavigation.Model model) {
//                // YOUR CODES
//                switch (model.getId()){
//                    case 1:
//                        break;
//                }
//                return null;
//            }
//        });
//
//        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//            @Override
//            public Unit invoke(MeowBottomNavigation.Model model) {
//                // YOUR CODES
//                switch (model.getId()){
//                    case 1:
//                        break;
//                }
//                return null;
//            }
//        });




    }
}