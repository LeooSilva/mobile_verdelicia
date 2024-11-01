package com.example.verdelicia_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Importando a classe Button
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView; // Importando a classe TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class teladeprodutos extends AppCompatActivity { // Nome da classe deve começar com letra maiúscula

    private List<Produto> produtosCarrinho = new ArrayList<>(); // Lista para armazenar os produtos

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

        // Inicialização dos produtos
        initializeProduto(R.id.kiwiIncrementButton, R.id.kiwiDecrementButton, R.id.kiwiQuantityTextView, "Kiwi", 6.00, R.drawable.kiwi);
        initializeProduto(R.id.pepinoIncrementButton, R.id.pepinoDecrementButton, R.id.pepinoQuantityTextView, "Pepino", 4.00, R.drawable.pepino);
        initializeProduto(R.id.limaoIncrementButton, R.id.limaoDecrementButton, R.id.limaoQuantityTextView, "Limão", 3.00, R.drawable.limao);
        initializeProduto(R.id.alfaceIncrementButton, R.id.alfaceDecrementButton, R.id.alfaceQuantityTextView, "Alface", 5.00, R.drawable.alface);

        // Botão para redirecionar para o carrinho
        Button proximoButton = findViewById(R.id.entrarButton); // Altere para o ID do seu botão
        proximoButton.setOnClickListener(v -> {
            // Armazenar produtos no carrinho e redirecionar para a página do carrinho
            armazenarProdutosCarrinho();
        });
    }

    private void initializeProduto(int incrementButtonId, int decrementButtonId, int quantityTextViewId, String nomeProduto, double precoProduto, int imagemProduto) {
        TextView quantityTextView = findViewById(quantityTextViewId);
        Button incrementButton = findViewById(incrementButtonId);
        Button decrementButton = findViewById(decrementButtonId);

        incrementButton.setOnClickListener(v -> {
            int quantidade = Integer.parseInt(quantityTextView.getText().toString());
            quantidade++;
            quantityTextView.setText(String.valueOf(quantidade));
        });

        decrementButton.setOnClickListener(v -> {
            int quantidade = Integer.parseInt(quantityTextView.getText().toString());
            if (quantidade > 0) {
                quantidade--;
                quantityTextView.setText(String.valueOf(quantidade));
            }
        });
    }

    private void armazenarProdutosCarrinho() {
        produtosCarrinho.clear(); // Limpa a lista antes de armazenar novos produtos
        double total = 0.0; // Inicializa a variável total

        // Capturando o produto Kiwi
        total += adicionarProdutoCarrinho("Kiwi", 6.00, R.id.kiwiQuantityTextView, R.drawable.kiwi);
        // Capturando o produto Pepino
        total += adicionarProdutoCarrinho("Pepino", 4.00, R.id.pepinoQuantityTextView, R.drawable.pepino);
        // Capturando o produto Limão
        total += adicionarProdutoCarrinho("Limão", 3.00, R.id.limaoQuantityTextView, R.drawable.limao);
        // Capturando o produto Alface
        total += adicionarProdutoCarrinho("Alface", 5.00, R.id.alfaceQuantityTextView, R.drawable.alface);

        // Passando as quantidades e o total para a tela do carrinho
        Intent intent = new Intent(teladeprodutos.this, carrinho_de_produtos.class);
        intent.putExtra("TOTAL", total); // Passa o total
        intent.putIntegerArrayListExtra("QUANTIDADES", getQuantidades()); // Passa a lista de quantidades
        startActivity(intent); // Inicia a Activity de destino



    }

    private double adicionarProdutoCarrinho(String nomeProduto, double precoProduto, int quantityTextViewId, int imagemProduto) {
        TextView quantityTextView = findViewById(quantityTextViewId);
        int quantidade = Integer.parseInt(quantityTextView.getText().toString());

        if (quantidade > 0) {
            produtosCarrinho.add(new Produto(nomeProduto, precoProduto, quantidade, String.valueOf(imagemProduto))); // Adiciona ao carrinho se a quantidade for maior que 0
            return quantidade * precoProduto; // Retorna o valor do produto adicionado
        }
        return 0.0; // Retorna 0 se não foi adicionado
    }

    // Método auxiliar para obter a lista de quantidades
    private ArrayList<Integer> getQuantidades() {
        ArrayList<Integer> quantidades = new ArrayList<>();
        quantidades.add(Integer.parseInt(((TextView) findViewById(R.id.kiwiQuantityTextView)).getText().toString()));
        quantidades.add(Integer.parseInt(((TextView) findViewById(R.id.pepinoQuantityTextView)).getText().toString()));
        quantidades.add(Integer.parseInt(((TextView) findViewById(R.id.limaoQuantityTextView)).getText().toString()));
        quantidades.add(Integer.parseInt(((TextView) findViewById(R.id.alfaceQuantityTextView)).getText().toString()));
        return quantidades; // Retorna a lista de quantidades
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

// Classe Produto para armazenar informações do produto
class Produto {
    String nome;
    double preco;
    int quantidade;
    String imagem;

    Produto(String nome, double preco, int quantidade, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }
}
