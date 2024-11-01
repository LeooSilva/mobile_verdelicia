package com.example.verdelicia_mobile;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle; // Importa a classe Bundle
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.CheckBox; // Importa a classe CheckBox
import android.widget.Toast; // Importa a classe Toast
import androidx.appcompat.app.AppCompatActivity; // Importa AppCompatActivity

public class termos_autorizacao_usuario extends AppCompatActivity {
    private CheckBox checkboxTermos; // Declara o CheckBox
    private Button buttonNovoNome; // Declara o Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos_autorizacao_usuario); // Define o layout da atividade

        checkboxTermos = findViewById(R.id.checkbox_termos); // Altere para o ID do seu CheckBox
        buttonNovoNome = findViewById(R.id.btn_proximo); // Altere para o ID do seu botão

        buttonNovoNome.setOnClickListener(new View.OnClickListener() { // Define o ouvinte de clique
            @Override
            public void onClick(View v) {
                // Verifica se o checkbox está marcado
                if (checkboxTermos.isChecked()) {
                    Intent intent = new Intent(termos_autorizacao_usuario.this, ActivityLogin.class); // Altere para o nome da sua nova atividade
                    startActivity(intent); // Inicia a nova atividade
                } else {
                    // Exibe uma mensagem de erro se o checkbox não estiver marcado
                    Toast.makeText(termos_autorizacao_usuario.this, "Termos de autorização não aceitos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
