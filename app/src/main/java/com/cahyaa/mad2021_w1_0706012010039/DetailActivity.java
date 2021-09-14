package com.cahyaa.mad2021_w1_0706012010039;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import model.User;
import model.UserData;

public class DetailActivity extends AppCompatActivity {

    public User user;
    public int position;
    private ImageView add_imageView_back;
    public ArrayList<User> listUser = UserData.saveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        user = getIntent().getParcelableExtra("data");
        position = getIntent().getIntExtra("position", 0);
        TextView cardview_name_result = findViewById(R.id.cardview_name_result);
        TextView display_textView_age = findViewById(R.id.cardview_age_result);
        TextView display_textView_address = findViewById(R.id.cardview_address_result);
        Button detail_button_edit = findViewById(R.id.detail_button_edit);
        Button detail_button_delete = findViewById(R.id.detail_button_delete);

        cardview_name_result.setText(user.getNama());
        display_textView_age.setText(String.valueOf(user.getAge()));
        display_textView_address.setText(user.getAddress());

        detail_button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToEditPage();
            }
        });

        detail_button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage();
            }
        });

        add_imageView_back = findViewById(R.id.add_imageView_back);

        add_imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void navigateToEditPage() {
        Intent intent = new Intent(this, com.cahyaa.mad2021_w1_0706012010039.add_collection.class);
        intent.putExtra("data", user);
        intent.putExtra("position", position);
        startActivity(intent);
        finish();
    }

    public void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:

                        listUser.remove(position);
                        Log.d("test", String.valueOf(position));

                        Toast.makeText(DetailActivity.this, "Delete Success",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);

                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.dismiss();
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hapus Data");
        builder.setMessage("Yakin ingin hapus data?")
                .setPositiveButton("Hapus", dialogClickListener)
                .setNegativeButton("Batal", dialogClickListener).show();
    }
}