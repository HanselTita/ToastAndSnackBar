package com.softhans.toastandsnackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button longToast, shortToast, snackBtn;

    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        longToast = findViewById(R.id.longBtn);
        shortToast = findViewById(R.id.shortBtn);
        snackBtn = findViewById(R.id.snackbarBtn);

        mCoordinatorLayout = findViewById(R.id.coordinatorLayout);


        longToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Toast.makeText(MainActivity.this, "Long Toast", Toast.LENGTH_LONG).show();

            }
        });

        shortToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Short Toast", Toast.LENGTH_SHORT).show();

            }
        });


        /**
         * To create a snackBar, add the following dependency to app's build gradle (Module:app) --> implementation 'com.google.android.material:material:1.0.0'
         * ...since you are working on an androidx.
         * In your onclick listener, create a showSnackbar method.
         * Change your layout to CoordinatorLayout.
         * Add a relativeLayout to contain your button(s).
         * give an id to your coordinatorLayout.
         */

        snackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               showSnackbar();

            }
        });

    }

    public void showSnackbar() {
        Snackbar snackbar = Snackbar.make(mCoordinatorLayout, "This is a Snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1 = Snackbar.make(mCoordinatorLayout, "Undo successful", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                })
                .setActionTextColor(Color.RED);

        View snackView = snackbar.getView();
        TextView textView = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);

        snackbar.show();
    }

}
