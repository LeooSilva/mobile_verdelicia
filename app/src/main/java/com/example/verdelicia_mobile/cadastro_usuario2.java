package com.example.verdelicia_mobile;

import android.content.Intent; // Importa a classe Intent
import android.net.Uri; // Importa a classe Uri
import android.os.Bundle; // Importa a classe Bundle
import android.view.View; // Importa a classe View
import android.widget.Button; // Importa a classe Button
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity; // Importa AppCompatActivity

public class cadastro_usuario2 extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1; // Código para identificar a solicitação de imagem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario2); // Define o layout da atividade

        // Botão "Próximo" que leva para outra tela
        Button buttonNovoNome = findViewById(R.id.btn_proximo); // Altere para o ID do seu botão
        buttonNovoNome.setOnClickListener(new View.OnClickListener() { // Define o ouvinte de clique
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro_usuario2.this, termos_autorizacao_usuario.class); // Altere para o nome da sua nova atividade
                startActivity(intent); // Inicia a nova atividade
            }
        });

        // Botão "Adicionar Foto" que abre a galeria
        Button botaoFoto = findViewById(R.id.botaoFoto); // Certifique-se de que este é o ID do seu botão
        botaoFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(); // Chama o método para abrir a galeria
            }
        });
    }

    // Método para abrir a galeria
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST); // Inicia a atividade para selecionar a imagem
    }

    // Método para lidar com o resultado da seleção da imagem
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            // Aqui você pode manipular a imagem selecionada, como exibi-la em um ImageView.
        }
    }
}
