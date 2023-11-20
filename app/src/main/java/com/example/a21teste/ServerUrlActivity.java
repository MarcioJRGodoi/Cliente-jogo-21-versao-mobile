package com.example.a21teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ServerUrlActivity extends Activity {
    private TextView status;
    private Button button1;
    private Button button2;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (TextView) findViewById(R.id.status);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        String url = getIntent().getStringExtra("url");
        final Animation clickAnimation = AnimationUtils.loadAnimation(this, R.anim.click_animation);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(url, 9000);
                    out = new PrintWriter(socket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            status.setText("Conexão bem sucedida!");
                        }
                    });

                    // Loop para ler as mensagens do servidor
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        final String message = serverMessage;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(message.equals("NOVO JOGO")){
                                    status.setText("");
                                }else{
                                    status.append("\n" + message);
                                }

                                button1.setEnabled(true);
                                button2.setEnabled(true);
                            }
                        });

                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            status.setText("Erro: " + e.getMessage());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            status.setText("Erro: " + e.getMessage());
                        }
                    });
                }
            }
        }).start();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (socket != null && socket.isConnected()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            out.println("1");
                            v.startAnimation(clickAnimation);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    button1.setEnabled(false);
                                    button2.setEnabled(false);
                                }
                            });
                        }
                    }).start();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (socket != null && socket.isConnected()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            out.println("2");
                            v.startAnimation(clickAnimation);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    button1.setEnabled(false);
                                    button2.setEnabled(false);
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }
}
