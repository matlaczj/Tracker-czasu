package com.example.trackerczasu.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.trackerczasu.ActivityType;
import com.example.trackerczasu.MainActivity;
import com.example.trackerczasu.R;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddTypeActivity extends AppCompatActivity {
    private Context context;
    public Button saveAddType;
    public TextView addTypeNameEditText;
    public Button typeColorButton;
    public int color = Color.parseColor("#e9d92e");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type);
        Button saveAddType = (Button) findViewById(R.id.save_type_button);
        Button typeColorButton = (Button) findViewById(R.id.pick_color2);
        final EditText addTypeNameEditText = (EditText) findViewById(R.id.add_type_name_editText);
        saveAddType.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                {
                    MainActivity.typeList.addType(new ActivityType(addTypeNameEditText.getText().toString(), color ,R.drawable.types));
                    finish();
                }
            }
        });
    }

    public void pickColor(View view) {
        final Button button = (Button) findViewById(R.id.pick_color2);
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                button.setBackgroundColor(color);
                setColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }
        });

        dialog.show();
    }

    public void setColor(int color) {
        this.color = color;
    }


}
