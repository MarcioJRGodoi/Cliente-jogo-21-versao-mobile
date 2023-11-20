package com.example.a21teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText editTextUrl;
    private Button buttonConnect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_conect);

        editTextUrl = (EditText) findViewById(R.id.editTextUrl);
        buttonConnect = (Button) findViewById(R.id.buttonConnect);

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                Intent intent = new Intent(MainActivity.this, ServerUrlActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
