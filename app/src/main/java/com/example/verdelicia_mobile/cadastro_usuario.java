package com.example.verdelicia_mobile;

import android.content.Intent; // Importa a classe Intent
import android.os.Bundle; // Importa a classe Bundle
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import android.widget.EditText; // Importa a classe EditText
import android.widget.Toast; // Importa a classe Toast
import androidx.appcompat.app.AppCompatActivity; // Importa AppCompatActivity

public class cadastro_usuario extends AppCompatActivity {

    // Declara os campos de entrada
    EditText nome, email, senha, confirmar_senha, telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario); // Define o layout da atividade

        // Referencia cada campo pelo seu ID
        nome = findViewById(R.id.nome); // ID do campo nome
        email = findViewById(R.id.email); // ID do campo email
        senha = findViewById(R.id.senha); // ID do campo senha
        confirmar_senha = findViewById(R.id.confirmar_senha); // ID do campo confirmar senha
        telefone = findViewById(R.id.telefone); // ID do campo telefone

        Button buttonProximo = findViewById(R.id.btn_proximo); // ID do botão "Próximo"
        buttonProximo.setOnClickListener(new View.OnClickListener() { // Define o ouvinte de clique
            @Override
            public void onClick(View v) {
                // Valida as informações antes de avançar
                if (validarInformacoes()) {
                    // Coleta os valores dos campos de entrada
                    String nomeValue = nome.getText().toString(); // Renomeado para evitar confusão
                    String emailValue = email.getText().toString(); // Renomeado para evitar confusão
                    String senhaValue = senha.getText().toString(); // Renomeado para evitar confusão
                    String telefoneValue = telefone.getText().toString(); // Renomeado para evitar confusão

                    // Envia esses dados para a segunda Activity
                    Intent intent = new Intent(cadastro_usuario.this, cadastro_usuario2.class);
                    intent.putExtra("nome", nomeValue);
                    intent.putExtra("email", emailValue);
                    intent.putExtra("senha", senhaValue);
                    intent.putExtra("telefone", telefoneValue);

                    startActivity(intent); // Inicia a nova atividade
                } else {
                    // Exibe mensagem de erro se faltarem informações
                    Toast.makeText(cadastro_usuario.this, "Faltando informações.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para validar se todos os campos estão preenchidos
    private boolean validarInformacoes() {
        return !nome.getText().toString().trim().isEmpty() &&
                !email.getText().toString().trim().isEmpty() &&
                !senha.getText().toString().trim().isEmpty() &&
                !confirmar_senha.getText().toString().trim().isEmpty() &&
                !telefone.getText().toString().trim().isEmpty();
    }
}
