package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pagamento_efetivado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagamento_efetivado);

        // Ajuste de WindowInsets para tratamento de bordas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pagamento_efetivado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referência ao ImageButton (ícone de ajuda)
        ImageButton imageButtonAjuda = findViewById(R.id.icon_help); // Altere para o ID correto do seu ImageButton
        imageButtonAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelpPage(v); // Chama o método para abrir a página de ajuda
            }
        });

        // Encontrando o ImageView no layout para perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil); // Verifique se o ID está correto
        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pagamento_efetivado.this, Tela_De_Perfil.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho); // Certifique-se de que o ID está correto
        imageViewCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pagamento_efetivado.this, carrinho_de_produtos.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor); // Certifique-se de que o ID está correto
        imageViewFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pagamento_efetivado.this, tela_fornecedor.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para home
        ImageView imageViewHome = findViewById(R.id.home); // Certifique-se de que o ID está correto
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pagamento_efetivado.this, Tela_Home.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback); // Certifique-se de que o ID está correto
        imageViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pagamento_efetivado.this, tela_feedback.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });
    }

    // Método para abrir a página de ajuda
    public void openHelpPage(View view) {
        Intent intent = new Intent(pagamento_efetivado.this, tela_de_ajuda.class); // Abre a página de ajuda
        startActivity(intent);
    }
}
