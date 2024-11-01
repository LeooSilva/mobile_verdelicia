package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela_feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_feedback);

        // Referência ao ImageButton (ícone de ajuda)
        ImageButton imageButtonAjuda = findViewById(R.id.icon_help); // Altere para o ID correto do seu ImageButton
        imageButtonAjuda.setOnClickListener(v -> openHelpPage(v)); // Chama o método para abrir a página de ajuda

        // Encontrando o ImageView no layout para perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil);
        imageViewPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(tela_feedback.this, Tela_De_Perfil.class);
            startActivity(intent);
        });

        // Referência ao ImageView para a página inicial (home)
        ImageView imageViewHome = findViewById(R.id.home);
        imageViewHome.setOnClickListener(v -> {
            Intent intent = new Intent(tela_feedback.this, Tela_Home.class);
            startActivity(intent);
        });

        // Encontrando o ImageView no layout para carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho);
        imageViewCarrinho.setOnClickListener(v -> {
            Intent intent = new Intent(tela_feedback.this, carrinho_de_produtos.class);
            startActivity(intent);
        });

        // Encontrando o ImageView no layout para fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor);
        imageViewFornecedor.setOnClickListener(v -> {
            Intent intent = new Intent(tela_feedback.this, tela_fornecedor.class);
            startActivity(intent);
        });

        // Encontrando o ImageView no layout para feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback);
        imageViewFeedback.setOnClickListener(v -> {
            Intent intent = new Intent(tela_feedback.this, tela_feedback.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_feedback), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openHelpPage(View v) {
        // Implementar lógica para abrir a página de ajuda
    }
}
