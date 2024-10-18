package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Importando a classe Button
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class teladeprodutos extends AppCompatActivity { // Nome da classe deve começar com letra maiúscula

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_produtos);

        // Ajusta os insets da janela
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_de_produtos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referência ao ImageButton (ícone de ajuda)
        ImageButton imageButtonAjuda = findViewById(R.id.icon_help); // Altere para o ID correto do seu ImageButton
        imageButtonAjuda.setOnClickListener(this::openHelpPage);

        // Configurando os OnClickListeners para os outros ImageViews
        setClickListener(R.id.perfil, Tela_De_Perfil.class);
        setClickListener(R.id.carrinho, carrinho_de_produtos.class);
        setClickListener(R.id.fornecedor, tela_fornecedor.class);
        setClickListener(R.id.home, Tela_Home.class);
        setClickListener(R.id.feedback, tela_feedback.class);

        // Inicialização do botão e configuração do OnClickListener
        Button buttonRedirect = findViewById(R.id.entrarButton); // Altere para o ID do seu botão
        buttonRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a segunda Activity
                Intent intent = new Intent(teladeprodutos.this, carrinho_de_produtos.class); // Troque carrinho_de_produtos pela sua Activity de destino
                startActivity(intent); // Inicia a Activity de destino
            }
        });
    }

    // Método auxiliar para configurar o OnClickListener de um ImageView
    private void setClickListener(int imageViewId, Class<?> targetActivity) {
        ImageView imageView = findViewById(imageViewId);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(teladeprodutos.this, targetActivity);
            startActivity(intent);
        });
    }

    // Método para abrir a página de ajuda
    public void openHelpPage(View view) {
        Intent intent = new Intent(teladeprodutos.this, tela_de_ajuda.class);
        startActivity(intent);
    }
}
