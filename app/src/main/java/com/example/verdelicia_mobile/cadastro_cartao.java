package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button; // Import necessário para Button

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cadastro_cartao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cartao);

        // Ajuste de WindowInsets para tratamento de bordas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_cartao), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Redirecionamento para a tela de perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil);
        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, Tela_De_Perfil.class);
                startActivity(intent);
            }
        });

        // Redirecionamento para a tela de carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho);
        imageViewCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, carrinho_de_produtos.class);
                startActivity(intent);
            }
        });

        // Redirecionamento para a tela home (fornecedor)
        ImageView imageViewHome = findViewById(R.id.home);
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, tela_fornecedor.class);
                startActivity(intent);
            }
        });

        // Redirecionamento para a tela fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor);
        imageViewFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, tela_fornecedor.class);
                startActivity(intent);
            }
        });

        // Redirecionamento para a tela feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback);
        imageViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, tela_feedback.class);
                startActivity(intent);
            }
        });

        // Redirecionamento quando o botão "btn_proximo" for pressionado
        Button btnProximo = findViewById(R.id.btn_proximo);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_cartao.this, pagamento_efetivado.class);
                startActivity(intent);
            }
        });
    }
}
