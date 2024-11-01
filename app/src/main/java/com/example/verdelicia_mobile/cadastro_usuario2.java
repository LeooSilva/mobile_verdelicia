package com.example.verdelicia_mobile;

import android.content.ContentValues; // Para ContentValues
import android.content.Intent; // Para Intent
import android.net.Uri; // Para Uri
import android.os.Bundle; // Para Bundle
import android.view.View; // Para View
import android.widget.Button; // Para Button
import android.widget.EditText; // Para EditText
import android.widget.Toast; // Para Toast
import android.database.sqlite.SQLiteDatabase; // Para SQLiteDatabase
import androidx.annotation.Nullable; // Para Nullable
import androidx.appcompat.app.AppCompatActivity; // Para AppCompatActivity

public class cadastro_usuario2 extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1; // Código para identificar a solicitação de imagem

    // Declara os campos de entrada
    EditText endereco, complemento, cep, cpfCnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario2); // Define o layout da atividade

        // Referencia cada campo pelo seu ID
        endereco = findViewById(R.id.endereco); // Altere para o ID correto
        complemento = findViewById(R.id.complemento); // Altere para o ID correto
        cep = findViewById(R.id.cep); // Altere para o ID correto
        cpfCnpj = findViewById(R.id.cpfCnpj); // Altere para o ID correto

        // Recebe os dados da primeira Activity
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String email = intent.getStringExtra("email");
        String senha = intent.getStringExtra("senha");
        String telefone = intent.getStringExtra("telefone");

        // Botão "Salvar" para inserir dados no banco
        Button buttonSalvar = findViewById(R.id.btn_proximo); // Altere para o ID do seu botão de salvar
        buttonSalvar.setOnClickListener(new View.OnClickListener() { // Define o ouvinte de clique
            @Override
            public void onClick(View v) {
                // Valida as informações antes de salvar
                if (validarInformacoes()) {
                    // Coleta os dados do formulário
                    String enderecoText = endereco.getText().toString();
                    String complementoText = complemento.getText().toString();
                    String cepText = cep.getText().toString();
                    String cpfCnpjText = cpfCnpj.getText().toString();

                    // Chama o método para inserir os dados no banco
                    boolean resultado = inserirDados(nome, email, senha, telefone, enderecoText, complementoText, cepText, cpfCnpjText);

                    // Mostra mensagem de sucesso ou erro
                    if (resultado) {
                        Toast.makeText(cadastro_usuario2.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(cadastro_usuario2.this, termos_autorizacao_usuario.class); // Altere para o nome da sua nova atividade
                        startActivity(intent); // Inicia a nova atividade
                    } else {
                        Toast.makeText(cadastro_usuario2.this, "Erro ao cadastrar. Tente novamente.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Exibe mensagem de erro se faltarem informações
                    Toast.makeText(cadastro_usuario2.this, "Faltando informações.", Toast.LENGTH_SHORT).show();
                }
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

    private boolean inserirDados(String nome, String email, String senha, String telefone,
                                 String endereco, String complemento, String cep, String cpfCnpj) {
        DatabaseHelper dbHelper = new DatabaseHelper(this); // Cria a instância do DatabaseHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Abre o banco de dados em modo de escrita

        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("senha", senha);
        values.put("telefone", telefone);
        values.put("endereco", endereco);
        values.put("complemento", complemento);
        values.put("cep", cep);
        values.put("cpf_cnpj", cpfCnpj);

        long id = db.insert("usuarios", null, values); // Insere os dados na tabela "usuarios"
        db.close(); // Fecha o banco de dados

        return id != -1; // Retorna verdadeiro se a inserção foi bem-sucedida
    }

    // Método para validar se todos os campos estão preenchidos
    private boolean validarInformacoes() {
        return !endereco.getText().toString().trim().isEmpty() &&
                !complemento.getText().toString().trim().isEmpty() &&
                !cep.getText().toString().trim().isEmpty() &&
                !cpfCnpj.getText().toString().trim().isEmpty();
    }
}
