package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela_cadastro_fornecedor_2 extends AppCompatActivity {

    private EditText editEndereco, editNumero, editComplemento, editCep, editTelefoneEmpresa;
    private Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro_fornecedor2);

        // Ajuste de WindowInsets para tratamento de bordas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_cadastro_fornecedor_2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando os campos de input
        editEndereco = findViewById(R.id.editEndereco);
        editNumero = findViewById(R.id.editNumero);
        editComplemento = findViewById(R.id.editComplemento);
        editCep = findViewById(R.id.editCep);
        editTelefoneEmpresa = findViewById(R.id.editTelefoneEmpresa);

        // Botão para ir à próxima tela após validação
        btnProximo = findViewById(R.id.btn_proximo);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    Intent intent = new Intent(tela_cadastro_fornecedor_2.this, termos_finais_fornecedor.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(tela_cadastro_fornecedor_2.this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Configuração dos ícones de navegação
        ImageView imageViewPerfil = findViewById(R.id.perfil);
        imageViewPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(tela_cadastro_fornecedor_2.this, Tela_De_Perfil.class);
            startActivity(intent);
        });

        ImageView imageViewCarrinho = findViewById(R.id.carrinho);
        imageViewCarrinho.setOnClickListener(v -> {
            Intent intent = new Intent(tela_cadastro_fornecedor_2.this, carrinho_de_produtos.class);
            startActivity(intent);
        });

        ImageView imageViewFornecedor = findViewById(R.id.fornecedor);
        imageViewFornecedor.setOnClickListener(v -> {
            Intent intent = new Intent(tela_cadastro_fornecedor_2.this, tela_fornecedor.class);
            startActivity(intent);
        });

        ImageView imageViewHome = findViewById(R.id.home);
        imageViewHome.setOnClickListener(v -> {
            Intent intent = new Intent(tela_cadastro_fornecedor_2.this, Tela_Home.class);
            startActivity(intent);
        });

        ImageView imageViewFeedback = findViewById(R.id.feedback);
        imageViewFeedback.setOnClickListener(v -> {
            Intent intent = new Intent(tela_cadastro_fornecedor_2.this, tela_feedback.class);
            startActivity(intent);
        });
    }

    // Método para verificar se todos os campos foram preenchidos
    private boolean validarCampos() {
        return !editEndereco.getText().toString().isEmpty()
                && !editNumero.getText().toString().isEmpty()
                && !editComplemento.getText().toString().isEmpty()
                && !editCep.getText().toString().isEmpty()
                && !editTelefoneEmpresa.getText().toString().isEmpty();
    }
}
