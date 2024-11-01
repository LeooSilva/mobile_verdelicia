package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class termos_finais_fornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_termos_finais_fornecedor);

        // Ajuste de WindowInsets para tratamento de bordas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.termos_fornecedor), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrando o ImageView no layout para perfil
        ImageView imageViewPerfil = findViewById(R.id.perfil); // Verifique se o ID está correto
        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(termos_finais_fornecedor.this, Tela_De_Perfil.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para carrinho
        ImageView imageViewCarrinho = findViewById(R.id.carrinho); // Certifique-se de que o ID está correto
        imageViewCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(termos_finais_fornecedor.this, carrinho_de_produtos.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para fornecedor
        ImageView imageViewFornecedor = findViewById(R.id.fornecedor); // Certifique-se de que o ID está correto
        imageViewFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(termos_finais_fornecedor.this, tela_fornecedor.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para home
        ImageView imageViewHome = findViewById(R.id.home); // Certifique-se de que o ID está correto
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(termos_finais_fornecedor.this, Tela_Home.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o ImageView no layout para feedback
        ImageView imageViewFeedback = findViewById(R.id.feedback); // Certifique-se de que o ID está correto
        imageViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(termos_finais_fornecedor.this, tela_feedback.class); // Verifique se o nome das Atividades está correto
                startActivity(intent);
            }
        });

        // Encontrando o CheckBox e o botão "btntermos"
        CheckBox fornecedorCheckBox = findViewById(R.id.fornecedorCheckBox);
        Button btnPagamento = findViewById(R.id.btntermos); // Certifique-se de que o ID está correto

        // Redirecionamento ao pressionar o botão "btntermos"
        btnPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fornecedorCheckBox.isChecked()) {
                    Toast.makeText(termos_finais_fornecedor.this, "Cadastro fornecedor finalizado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(termos_finais_fornecedor.this, ActivityLogin.class); // Redireciona para a página ActivityLogin
                    startActivity(intent);
                } else {
                    Toast.makeText(termos_finais_fornecedor.this, "Termos não aceito", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

