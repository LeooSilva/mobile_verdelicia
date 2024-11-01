package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Import necessário para Button
import android.widget.EditText; // Import necessário para EditText
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cadastro_cartao extends AppCompatActivity {

    private EditText numCartao, nomeTitular, dataValidade, codSeguranca;
    private Button btnProximo;
    private DatabaseHelper dbHelper; // Instância do DatabaseHelper

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

        // Inicializa as variáveis
        numCartao = findViewById(R.id.numcartao);
        nomeTitular = findViewById(R.id.nometitular);
        dataValidade = findViewById(R.id.dt);
        codSeguranca = findViewById(R.id.codseg);
        btnProximo = findViewById(R.id.btn_proximo);
        dbHelper = new DatabaseHelper(this); // Inicializa o DatabaseHelper

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

        // Lógica de cadastro de cartão quando o botão "btn_proximo" for pressionado
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarCartao();
            }
        });
    }

    private void cadastrarCartao() {
        String numCartaoStr = numCartao.getText().toString().trim();
        String nomeTitularStr = nomeTitular.getText().toString().trim();
        String dataValidadeStr = dataValidade.getText().toString().trim();
        String codSegurancaStr = codSeguranca.getText().toString().trim();

        // Verifica se todos os campos estão preenchidos
        if (numCartaoStr.isEmpty() || nomeTitularStr.isEmpty() || dataValidadeStr.isEmpty() || codSegurancaStr.isEmpty()) {
            Toast.makeText(this, "Faltando dados", Toast.LENGTH_SHORT).show();
        } else {
            // Adiciona o cartão ao banco de dados
            dbHelper.addCartao(numCartaoStr, nomeTitularStr, dataValidadeStr, codSegurancaStr);
            Toast.makeText(this, "Cartão cadastrado", Toast.LENGTH_SHORT).show();

            // Redireciona para a próxima tela
            Intent intent = new Intent(cadastro_cartao.this, pagamento_efetivado.class);
            startActivity(intent);
            finish(); // Finaliza a Activity atual
        }
    }
}
