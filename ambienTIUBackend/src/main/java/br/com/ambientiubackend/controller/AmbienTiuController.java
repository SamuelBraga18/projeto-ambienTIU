package br.com.ambientiubackend.controller;

import br.com.ambientiubackend.model.Model;
import br.com.ambientiubackend.dto.Dto;
import br.com.ambientiubackend.service.AmbienTiuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/data")
public class AmbienTiuController {

    @Autowired
    AmbienTiuService ambienTiuService;

    @PostMapping
    public ResponseEntity<Dto> saveDataController(@RequestBody @Valid Dto dto){

        Dto newData = ambienTiuService.saveData(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newData);
    }

    @GetMapping
    public ResponseEntity<List<Dto>> viewDataController(){
        List<Dto> allData = ambienTiuService.viewData();
        return ResponseEntity.ok(allData);

    }
}
