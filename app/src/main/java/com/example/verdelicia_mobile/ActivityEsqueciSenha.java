package com.example.verdelicia_mobile;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle; // Importa a classe Bundle
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import androidx.appcompat.app.AppCompatActivity; // Importa AppCompatActivity

public class ActivityEsqueciSenha extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha); // Define o layout da atividade

        // Configura o botão para redefinir senha
        Button buttonRedefinirSenha = findViewById(R.id.btnRedefinirSenha);
        buttonRedefinirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEsqueciSenha.this, ActivityLogin.class);
                startActivity(intent); // Inicia a nova atividade
            }
        });

        // Configura o botão para retornar à página inicial
        Button buttonRetornar = findViewById(R.id.txtRetornar);
        buttonRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEsqueciSenha.this, ActivityLogin.class);
                startActivity(intent); // Inicia a nova atividade
            }
        });
    }
}
