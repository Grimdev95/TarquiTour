package com.grimjowd.tarquitour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private Button buttonOnboardingAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);


        setupOnboardingItems();
        final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager2);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardingIndicators(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });



        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1) ;
                }else{
                    startActivity(new Intent(getApplicationContext(), MainActivityLogin.class));
                    finish();
                }

            }
        });
    }
    private void setupOnboardingItems(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem itemPayOnline = new OnboardingItem();
        itemPayOnline.setTitle("¡Bienvenido a Tarqui!");
        itemPayOnline.setDescription("Descubre lugares únicos, experimenta la cultura local y encuentra tu próximo destino turístico con la aplicación oficial de Tarqui.");
        itemPayOnline.setImage(R.drawable.welcometarqui);

        OnboardingItem itemOnTheWay = new OnboardingItem();
        itemOnTheWay.setTitle("Atractivos Turísticos");
        itemOnTheWay.setDescription("Explora los impresionantes miradores que ofrecen vistas panorámicas, sumérgete en la belleza natural a orillas del majestuoso río Magdalena y descubre monumentos que cuentan la rica historia de nuestro querido Tarqui.");
        itemOnTheWay.setImage(R.drawable.atractivotarqui);

        OnboardingItem itemEatTogether = new OnboardingItem();
        itemEatTogether.setTitle("Funcionalidades de la Aplicación");
        itemEatTogether.setDescription("Nuestra aplicación te permite explorar Tarqui de manera fácil. Encuentra direcciones, descubre eventos locales, conoce restaurantes populares y sumérgete en la riqueza cultural de nuestro municipio.");
        itemEatTogether.setImage(R.drawable.fondo);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOnTheWay);
        onboardingItems.add(itemEatTogether);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }
    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
                    ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }
    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicators(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0; i< childCount; i++){
            ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
            if (i == index){
                    imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                    );
            }else {
                imageView.setImageDrawable(
                            ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if(index == onboardingAdapter.getItemCount() -1){
            buttonOnboardingAction.setText("Iniciar");
        }else{
            buttonOnboardingAction.setText(" Siguiente ");
        }
    }
}