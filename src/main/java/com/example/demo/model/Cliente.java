package com.example.demo.model;

public class Cliente {

    private long id;
    private String nome;
    private String Email;
    private int Idade;
    public Cliente(){
    
    }

    public Cliente(String nome,int Idade, Long id, String Email){
        this.setId(id);
        this.setNome(nome);
        this.setEmail(Email);
        this.setIdade(Idade);
    }
    public Cliente(String nome,int Idade, String Email){
        this.setNome(nome);
        this.setEmail(Email);
        this.setIdade(Idade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
