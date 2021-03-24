package com.example.foodcompanythelorry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsPage extends AppCompatActivity {

    private RecyclerView mCommentRecyclerView;
    private ArrayList<Comments> mCommentArrayList= new ArrayList<>();
    private CommentAdapter mCommentAdapter;
    private RecyclerView.LayoutManager mCommentLayoutManager;
    String title, rating, address, location;
    TextView titletv,commentTitle,addresstv,ratingtv;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ratingtv = findViewById(R.id.ratingtv);
        titletv = findViewById(R.id.titletv);
        commentTitle = findViewById(R.id.commentTitle);
        ratingBar = findViewById(R.id.ratingBar1);
        addresstv = findViewById(R.id.addresstv);
        title = getIntent().getStringExtra("resname");
        rating = getIntent().getStringExtra("rating");
        address = getIntent().getStringExtra("address");
        location = getIntent().getStringExtra("location");
        addresstv.setText(address);
        ratingtv.setText(rating +" / 5");
        ratingBar.setRating(Float.parseFloat(rating));
        if (!title.equals(null)){
            titletv.setText(title);
        }

        initializeComment();

        ImageView back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backhome = new Intent(DetailsPage.this, MainActivity.class);
                startActivity(backhome);
            }
        });

        Button copy = findViewById(R.id.copybutton);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Address", addresstv.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Adress Copied", Toast.LENGTH_SHORT).show();
            }
        });

        Button navbutton = findViewById(R.id.navbutton);
        navbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Uri gmmIntentUri = Uri.parse("geo:3.193374,101.629711");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }*/
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

    private void initializeComment() {
        mCommentArrayList.clear();
        mCommentArrayList.add(new Comments(R.drawable.profileimage,"TonyHawk","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        mCommentArrayList.add(new Comments(R.drawable.profileimage,"TonyHawk","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        mCommentArrayList.add(new Comments(R.drawable.profileimage,"TonyHawk","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        mCommentArrayList.add(new Comments(R.drawable.profileimage,"TonyHawk","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        mCommentArrayList.add(new Comments(R.drawable.profileimage,"TonyHawk","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mCommentRecyclerView = findViewById(R.id.commentrecyclerView);
        mCommentRecyclerView.setHasFixedSize(true);
        mCommentLayoutManager = new LinearLayoutManager(this);
        mCommentAdapter = new CommentAdapter(mCommentArrayList);
        mCommentRecyclerView.setLayoutManager(mCommentLayoutManager);
        mCommentRecyclerView.setAdapter(mCommentAdapter);

        commentTitle.setText("Comments (" + mCommentArrayList.size() + ")");
    }
}