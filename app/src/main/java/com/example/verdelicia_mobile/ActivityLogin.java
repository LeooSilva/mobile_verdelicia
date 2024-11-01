package com.example.verdelicia_mobile;

import android.content.Intent;
import android.content.SharedPreferences; // Importa SharedPreferences
import android.database.Cursor; // Importa a classe Cursor
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText senhaEditText;
    private CheckBox lembrarSenhaCheckBox;
    private Button entrarButton;
    private TextView esqueceuSenhaTextView;
    private TextView cadastreSeTextView;

    private SharedPreferences sharedPreferences; // Declara o SharedPreferences
    private static final String PREFS_NAME = "LoginPrefs"; // Nome do arquivo de preferências
    private static final String KEY_NOME = "nome"; // Chave para o nome
    private static final String KEY_SENHA = "senha"; // Chave para a senha

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Verifique se este layout está correto

        nomeEditText = findViewById(R.id.nomeEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        lembrarSenhaCheckBox = findViewById(R.id.lembrarSenhaCheckBox);
        entrarButton = findViewById(R.id.entrarButton);
        esqueceuSenhaTextView = findViewById(R.id.esqueceuSenhaTextView);
        cadastreSeTextView = findViewById(R.id.cadastreSeTextView);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE); // Inicializa o SharedPreferences

        // Carrega os dados salvos
        String nomeSalvo = sharedPreferences.getString(KEY_NOME, "");
        String senhaSalva = sharedPreferences.getString(KEY_SENHA, "");
        nomeEditText.setText(nomeSalvo); // Preenche o campo de nome
        senhaEditText.setText(senhaSalva); // Preenche o campo de senha

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeEditText.getText().toString().trim();
                String senha = senhaEditText.getText().toString().trim();

                // Valida se os campos estão preenchidos
                if (nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "Efetue o Login", Toast.LENGTH_SHORT).show();
                    return; // Impede a execução da validação se os campos estiverem vazios
                }

                // Valida o login
                if (validarLogin(nome, senha)) {
                    // Salva a senha se o checkbox estiver marcado
                    if (lembrarSenhaCheckBox.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_NOME, nome);
                        editor.putString(KEY_SENHA, senha);
                        editor.apply(); // Salva as preferências
                    } else {
                        // Limpa as preferências se o checkbox não estiver marcado
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(KEY_NOME);
                        editor.remove(KEY_SENHA);
                        editor.apply();
                    }

                    Intent intent = new Intent(ActivityLogin.this, Tela_Home.class); // Mude para a Activity desejada
                    startActivity(intent);
                } else {
                    Toast.makeText(ActivityLogin.this, "Usuário não cadastrado.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        esqueceuSenhaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityEsqueciSenha.class); // Substitua por sua Activity de recuperação de senha
                startActivity(intent);
            }
        });

        cadastreSeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a tela de cadastro
                Intent intent = new Intent(ActivityLogin.this, cadastro_usuario.class); // Substitua por sua Activity de cadastro
                startActivity(intent);
            }
        });
    }

    private boolean validarLogin(String nome, String senha) {
        DatabaseHelper dbHelper = new DatabaseHelper(this); // Cria a instância do DatabaseHelper

        // Verifica na tabela de usuários
        Cursor cursorUsuario = dbHelper.getReadableDatabase().query("usuarios", null,
                "nome=? AND senha=?", new String[]{nome, senha}, null, null, null);

        if (cursorUsuario.getCount() > 0) {
            cursorUsuario.close();
            return true; // Usuário encontrado na tabela de usuários
        }
        cursorUsuario.close();

        // Verifica na tabela de fornecedores
        Cursor cursorFornecedor = dbHelper.getReadableDatabase().query("fornecedores", null,
                "nomeContato=? AND senhafor=?", new String[]{nome, senha}, null, null, null);

        boolean isFornecedorValid = cursorFornecedor.getCount() > 0; // Verifica se o fornecedor existe
        cursorFornecedor.close();

        return isFornecedorValid; // Retorna verdadeiro se o fornecedor foi encontrado
    }
}
