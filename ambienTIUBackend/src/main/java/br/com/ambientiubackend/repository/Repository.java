package br.com.ambientiubackend.repository;

import br.com.ambientiubackend.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface Repository extends JpaRepository <Model, Long> {

    List<Model> findByTemperatura(String temperatura);
    List<Model> findByUmidade(String umidade);
    List<Model> findByIluminacao(String iluminacao);
    List<Model> findByTime(LocalDateTime time);
}
