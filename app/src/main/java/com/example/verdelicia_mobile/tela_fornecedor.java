package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button; // Import para Button

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela_fornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_fornecedor);

        // Ajuste de WindowInsets para tratamento de bordas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_fornecedor), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrando o ImageView no layout para perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil); // Verifique se o ID está correto
        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, Tela_De_Perfil.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho); // Certifique-se de que o ID está correto
        imageViewCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, carrinho_de_produtos.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor); // Certifique-se de que o ID está correto
        imageViewFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, tela_fornecedor.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para home
        ImageView imageViewHome = findViewById(R.id.home); // Certifique-se de que o ID está correto
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, Tela_Home.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback); // Certifique-se de que o ID está correto
        imageViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, tela_feedback.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Redirecionamento ao pressionar o botão "btn_proximo"
        Button btnProximo = findViewById(R.id.btn_proximo); // Certifique-se de que o ID está correto
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_fornecedor.this, tela_cadastro_fornecedor_2.class); // Redireciona para a página tela_cadastro_fornecedor_2
                startActivity(intent);
            }
        });
    }
}
