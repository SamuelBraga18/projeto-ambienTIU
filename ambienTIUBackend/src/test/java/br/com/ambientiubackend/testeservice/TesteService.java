package br.com.ambientiubackend.testeservice;

import br.com.ambientiubackend.dto.Dto;
import br.com.ambientiubackend.model.Model;
import br.com.ambientiubackend.repository.Repository;
import br.com.ambientiubackend.service.AmbienTiuService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TesteService {

    @Mock
    private Repository repository;

    @InjectMocks
    private AmbienTiuService ambienTiuService;

    private Model model;

    @Test
    public void salvarDadosSucesso(){

        LocalDateTime dataTeste = LocalDateTime.of(2026, 5, 16, 14, 30);
        Dto inputDto = new Dto("21", "29", "60", dataTeste);
        ArgumentCaptor<Model> modelCaptor = ArgumentCaptor.forClass(Model.class);

        ambienTiuService.saveData(inputDto);

        verify(repository, times(1)).save(modelCaptor.capture());

        Model modelSalvo = modelCaptor.getValue();
        assertEquals("21", modelSalvo.getTemperatura());
        assertEquals("29", modelSalvo.getUmidade());
        assertEquals("60", modelSalvo.getIluminacao());
    }

    @Test
    public void dadosAoVivoSucesso(){

        LocalDateTime horaAtual = LocalDateTime.now();

        Model model = new Model();
        model.setTemperatura("25.5");
        model.setUmidade("60.0");
        model.setIluminacao("80.0");
        model.setTime(horaAtual);

        List<Model> listaSimulada = List.of(model);
        when(repository.findAll()).thenReturn(listaSimulada);

        List<Dto> resultado = ambienTiuService.viewData();

        assertNotNull(resultado);
        assertEquals(1, resultado.size(), "A lista deve conter exatamente 1 elemento");

        Dto dtoResultado = resultado.get(0);
        assertEquals(model.getTemperatura(), dtoResultado.temperatura());
        assertEquals(model.getUmidade(), dtoResultado.umidade());
        assertEquals(model.getIluminacao(), dtoResultado.iluminacao());
        assertEquals(model.getTime(), dtoResultado.time());
    }
}
