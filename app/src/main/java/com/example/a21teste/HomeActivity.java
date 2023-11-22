package com.example.a21teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {

    private Button tutorial_button;
    private Button credits_button;
    private EditText url_servidor;
    private Button btn_conectar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tutorial_button = findViewById(R.id.tutorial_button);
        credits_button = findViewById(R.id.btn_credits);
        tutorial_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TutorialActivity.class));
            }
        });
        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CreditsActivity.class));
            }
        });

        url_servidor = findViewById(R.id.url_servidor);
        btn_conectar = findViewById(R.id.btn_conectar);

        btn_conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = url_servidor.getText().toString();
                Intent intent = new Intent(HomeActivity.this, ServerUrlActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                finish();
            }
        });

    }

}
