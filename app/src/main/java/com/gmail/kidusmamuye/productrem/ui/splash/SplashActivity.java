package com.gmail.kidusmamuye.productrem.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.kidusmt.movieapp.R;
import com.example.kidusmt.movieapp.base.view.BaseActivity;
import com.example.kidusmt.movieapp.data.remote.genre.Genre;
import com.example.kidusmt.movieapp.data.remote.genre.GenreRemote;
import com.example.kidusmt.movieapp.data.remote.genre.GenreResponse;
import com.example.kidusmt.movieapp.ui.login.LoginActivity;
import com.example.kidusmt.movieapp.util.Constants;
import com.facebook.FacebookSdk;
import com.gmail.kidusmamuye.productrem.base.view.BaseActivity;
import com.gmail.kidusmamuye.productrem.ui.login.LoginActivity;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KidusMT on 12/25/2017.
 */

public class SplashActivity extends BaseActivity {

    private static final String KEY = "SEEN";

    public SharedPreferences pref;
    public SharedPreferences.Editor editor;

    public static HashMap<Integer,String> genreIds = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_splash);


        pref = getSharedPreferences("MovieApp",MODE_PRIVATE);

        //for fetching the genres from the API
//        getGenres();
        

        ImageView splashLogo = findViewById(R.id.iv_splash_img);
        //find out if the user has seen the splash screen - always false for now
        if (isSeen()){
            openTourActivity();
            return;
        }

        //Its possible to change the animation type anytime
        Animation alphaAnim = AnimationUtils.loadAnimation(this,R.anim.alpha);

        splashLogo.startAnimation(alphaAnim);

        alphaAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //SKIP THE CHECKING PART FOR NOW - WILL WORK OUT LATER
//                setSeen();//sets the seenVariable to true
                openTourActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    public void skipSplashScreen(View v){
        openTourActivity();
    }

    private boolean isSeen(){
        return false;//pref.getBoolean(KEY, false);
    }

    public void openTourActivity(){
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    private void setSeen(){
        editor = pref.edit();
        editor.putBoolean(KEY, true);
        editor.apply();
    }
}
