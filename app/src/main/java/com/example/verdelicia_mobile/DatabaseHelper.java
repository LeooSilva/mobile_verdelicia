package com.example.verdelicia_mobile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nome do banco de dados e versão
    private static final String DATABASE_NAME = "meu_banco.db";
    private static final int DATABASE_VERSION = 2; // Aumente a versão do banco de dados

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Comando SQL para criar a tabela de usuários
        String CREATE_USUARIOS_TABLE = "CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "email TEXT," +
                "senha TEXT," +
                "telefone TEXT," +
                "endereco TEXT," +
                "complemento TEXT," +
                "cep TEXT," +
                "cpf_cnpj TEXT" +
                ")";
        db.execSQL(CREATE_USUARIOS_TABLE);

        // Comando SQL para criar a tabela de fornecedores
        String CREATE_FORNECEDORES_TABLE = "CREATE TABLE fornecedores (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome_empresa TEXT," +
                "nome_contato TEXT," +
                "telefone TEXT," +
                "cnpj TEXT," +
                "cpf TEXT," +
                "endereco TEXT," +
                "numero TEXT," +
                "complemento TEXT," +
                "cep TEXT," +
                "senhafor TEXT," +
                "telefone_empresa TEXT" +
                ")";
        db.execSQL(CREATE_FORNECEDORES_TABLE);

        // Comando SQL para criar a tabela de cartões
        String CREATE_CARTOES_TABLE = "CREATE TABLE cartoes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "num_cartao TEXT," +
                "nome_titular TEXT," +
                "data_validade TEXT," +
                "cod_seguranca TEXT" +
                ")";
        db.execSQL(CREATE_CARTOES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Exclui as tabelas antigas se houver atualização de versão e cria novamente
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS fornecedores");
        db.execSQL("DROP TABLE IF EXISTS cartoes"); // Adiciona a tabela de cartões
        onCreate(db);
    }

    // Método para adicionar um usuário na tabela
    public void addUsuario(String nome, String email, String senha, String telefone, String endereco, String complemento, String cep, String cpfCnpj) {
        SQLiteDatabase db = this.getWritableDatabase();

        String insertUsuario = "INSERT INTO usuarios (nome, email, senha, telefone, endereco, complemento, cep, cpf_cnpj) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        db.execSQL(insertUsuario, new String[] {nome, email, senha, telefone, endereco, complemento, cep, cpfCnpj});

        db.close();
    }

    // Método para adicionar um fornecedor na tabela
    public void addFornecedor(String nomeEmpresa, String nomeContato, String telefone, String cnpj, String cpf,
                              String endereco, String numero, String complemento, String cep, String telefoneEmpresa) {
        SQLiteDatabase db = this.getWritableDatabase();

        String insertFornecedor = "INSERT INTO fornecedores (nome_empresa, nome_contato, telefone, cnpj, cpf, endereco, numero, complemento, cep, telefone_empresa, senhafor) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        db.execSQL(insertFornecedor, new String[] {nomeEmpresa, nomeContato, telefone, cnpj, cpf, endereco, numero, complemento, cep, telefoneEmpresa});

        db.close();
    }

    // Método para adicionar um cartão na tabela
    public void addCartao(String numCartao, String nomeTitular, String dataValidade, String codSeguranca) {
        SQLiteDatabase db = this.getWritableDatabase();

        String insertCartao = "INSERT INTO cartoes (num_cartao, nome_titular, data_validade, cod_seguranca) " +
                "VALUES (?, ?, ?, ?)";

        db.execSQL(insertCartao, new String[] {numCartao, nomeTitular, dataValidade, codSeguranca});

        db.close();
    }

    // Método para verificar se o usuário existe
    public boolean verificarUsuario(String nome, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("usuarios", null,
                "nome=? AND senha=?", new String[]{nome, senha}, null, null, null);

        boolean exists = (cursor.getCount() > 0); // Verifica se o usuário existe
        cursor.close(); // Fecha o cursor
        return exists; // Retorna verdadeiro se o usuário foi encontrado
    }

    // Método para verificar se o fornecedor existe
    public boolean verificarFornecedor(String nomeContato, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("fornecedores", null,
                "nome_contato=? AND senhafor=?", new String[]{nomeContato, senha}, null, null, null);

        boolean exists = (cursor.getCount() > 0); // Verifica se o fornecedor existe
        cursor.close(); // Fecha o cursor
        return exists; // Retorna verdadeiro se o fornecedor foi encontrado
    }
}
