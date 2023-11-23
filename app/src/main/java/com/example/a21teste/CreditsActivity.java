package com.example.a21teste;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreditsActivity extends Activity {

    private Button btn_voltar_home;
    private LinearLayout link_mateus;
    private LinearLayout link_marcio;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        link_mateus = findViewById(R.id.link_mateus);
        link_mateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser executada quando o LinearLayout é clicado
                abrirLinkExterno("https://github.com/MateusS0ares");
            }
        });

        link_marcio = findViewById(R.id.link_marcio);
        link_marcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser executada quando o LinearLayout é clicado
                abrirLinkExterno("https://github.com/MarcioJRGodoi");
            }
        });


        btn_voltar_home = findViewById(R.id.btn_credits_voltar);
        btn_voltar_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void abrirLinkExterno(String url) {
        // Abra o link externo usando um Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }


}
