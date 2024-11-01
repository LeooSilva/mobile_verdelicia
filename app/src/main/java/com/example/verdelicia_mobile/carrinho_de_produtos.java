package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class carrinho_de_produtos extends AppCompatActivity { // Renomeie a classe para seguir a convenção de nomenclatura

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carrinho_de_produtos);

        // Ajusta os insets da janela
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.carrinho_produto), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrando o ImageView no layout para perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil); // Verifique se o ID está correto
        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carrinho_de_produtos.this, Tela_De_Perfil.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho); // Certifique-se de que o ID está correto
        imageViewCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carrinho_de_produtos.this, carrinho_de_produtos.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor); // Certifique-se de que o ID está correto
        imageViewFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carrinho_de_produtos.this, tela_fornecedor.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para home
        ImageView imageViewHome = findViewById(R.id.home); // Certifique-se de que o ID está correto
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carrinho_de_produtos.this, Tela_Home.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback); // Certifique-se de que o ID está correto
        imageViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carrinho_de_produtos.this, tela_feedback.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Inicialização do botão e configuração do OnClickListener
        Button buttonRedirect = findViewById(R.id.entrarButton); // Altere para o ID do seu botão
        buttonRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a Activity de forma de pagamento
                Intent intent = new Intent(carrinho_de_produtos.this, forma_de_pagamento.class); // Troque pela sua Activity de destino
                startActivity(intent); // Inicia a Activity de destino
            }
        });

        // Adicionando a lógica para exibir as quantidades e o total
        Intent intent = getIntent();
        ArrayList<Integer> quantidades = intent.getIntegerArrayListExtra("QUANTIDADES");
        double total = intent.getDoubleExtra("TOTAL", 0.0); // Padrão 0.0

        // Exibindo as quantidades nos TextViews
        if (quantidades != null) {
            ((TextView) findViewById(R.id.quanlimao)).setText(String.valueOf(quantidades.get(2))); // Limão
            ((TextView) findViewById(R.id.quanalface)).setText(String.valueOf(quantidades.get(3))); // Alface
            ((TextView) findViewById(R.id.quanpepino)).setText(String.valueOf(quantidades.get(1))); // Pepino
            ((TextView) findViewById(R.id.quankiwi)).setText(String.valueOf(quantidades.get(0))); // Kiwi
        }

        // Atualizando o total no TextView
        ((TextView) findViewById(R.id.total_textview)).setText(String.format("Total: R$ %.2f", total));
    }
}
