package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class tela_fornecedor extends AppCompatActivity {

    // Declaração dos campos de entrada
    private EditText nomeEmpresa, nomeContato, telefone, cpfCnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_fornecedor);

        // Inicialização dos campos de entrada
        nomeEmpresa = findViewById(R.id.nomeEmpresa);
        nomeContato = findViewById(R.id.nomeContato);
        telefone = findViewById(R.id.telefoneEmpresa);
        cpfCnpj = findViewById(R.id.cpfCnpjEmpresa);

        // Configuração dos botões de navegação para outras telas (perfil, carrinho, fornecedor, home, feedback)
        ImageView imageViewPerfil = findViewById(R.id.perfil);
        imageViewPerfil.setOnClickListener(v -> startActivity(new Intent(tela_fornecedor.this, Tela_De_Perfil.class)));

        ImageView imageViewCarrinho = findViewById(R.id.carrinho);
        imageViewCarrinho.setOnClickListener(v -> startActivity(new Intent(tela_fornecedor.this, carrinho_de_produtos.class)));

        ImageView imageViewFornecedor = findViewById(R.id.fornecedor);
        imageViewFornecedor.setOnClickListener(v -> startActivity(new Intent(tela_fornecedor.this, tela_fornecedor.class)));

        ImageView imageViewHome = findViewById(R.id.home);
        imageViewHome.setOnClickListener(v -> startActivity(new Intent(tela_fornecedor.this, Tela_Home.class)));

        ImageView imageViewFeedback = findViewById(R.id.feedback);
        imageViewFeedback.setOnClickListener(v -> startActivity(new Intent(tela_fornecedor.this, tela_feedback.class)));

        // Redirecionamento ao pressionar o botão "btn_proximo"
        Button btnProximo = findViewById(R.id.btn_proximo);
        btnProximo.setOnClickListener(v -> {
            // Verificação de preenchimento dos campos
            if (TextUtils.isEmpty(nomeEmpresa.getText()) || TextUtils.isEmpty(nomeContato.getText()) ||
                    TextUtils.isEmpty(telefone.getText()) || TextUtils.isEmpty(cpfCnpj.getText())) {
                Toast.makeText(tela_fornecedor.this, "Informação em branco", Toast.LENGTH_SHORT).show();
            } else {
                // Se todos os campos estiverem preenchidos, redireciona para a segunda tela de cadastro do fornecedor
                Intent intent = new Intent(tela_fornecedor.this, tela_cadastro_fornecedor_2.class);
                startActivity(intent);
            }
        });
    }
}
