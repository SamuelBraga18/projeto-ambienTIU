package br.com.ambientiubackend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String temperatura;
    private String umidade;
    private String iluminacao;

    @CreationTimestamp
    @Column(name = "time", updatable = false, nullable = false)
    private LocalDateTime time;

    public Model(){}

    public Model(String temperatura, String umidade, String iluminacao){
        setTemperatura(temperatura);
        setUmidade(umidade);
        setIluminacao(iluminacao);
        setTime(time);
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public void setIluminacao(String iluminacao){
        this.iluminacao = iluminacao;
    }

    public void setTime(LocalDateTime time){
        this.time = time;
    }

    public String getTemperatura(){
        return temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public String getIluminacao() {
        return iluminacao;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
