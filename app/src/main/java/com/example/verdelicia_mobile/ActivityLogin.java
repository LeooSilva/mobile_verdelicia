package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText senhaEditText;
    private CheckBox lembrarSenhaCheckBox;
    private Button entrarButton;
    private TextView esqueceuSenhaTextView;
    private TextView cadastreSeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Verifique se este layout está correto

        nomeEditText = findViewById(R.id.nomeEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        lembrarSenhaCheckBox = findViewById(R.id.lembrarSenhaCheckBox);
        entrarButton = findViewById(R.id.entrarButton);
        esqueceuSenhaTextView = findViewById(R.id.esqueceuSenhaTextView);
        cadastreSeTextView = findViewById(R.id.cadastreSeTextView);

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de login aqui
                Intent intent = new Intent(ActivityLogin.this, Tela_Home.class); // Mude para a Activity desejada
                startActivity(intent);
            }
        });

        esqueceuSenhaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityEsqueciSenha.class); // Substitua por sua Activity de cadastro
                startActivity(intent);
            }
        });

        cadastreSeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a tela de cadastro
                Intent intent = new Intent(ActivityLogin.this, cadastro_usuario.class); // Substitua por sua Activity de cadastro
                startActivity(intent);
            }
        });

    }
}
