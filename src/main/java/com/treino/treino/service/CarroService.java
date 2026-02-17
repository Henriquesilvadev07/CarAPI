package com.treino.treino.service;

import com.treino.treino.entity.CarroModel;
import com.treino.treino.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public CarroModel salvarCarro(CarroModel carro) {//salvando o carro na "entity"
        return carroRepository.save(carro);
    }

    public List<CarroModel> listarCarros(CarroModel carro) { //listando todos os carros da entity
        return carroRepository.findAll();
    }

    public CarroModel acharPorId(Long id) { //procurando um carro na entity por id, caso nao exista, lança o erro
        return carroRepository.findById(id).orElseThrow();
    }

    public CarroModel atualizarPorId(CarroModel carroAtualizado, Long id) { //atualizando um carro da entity por id

        CarroModel carro = carroRepository.findById(id).orElseThrow(); //variavel carro recebendo os dados achados pelo id

        carro.setMarca(carroAtualizado.getMarca()); //salvando os novos dados do carro baseado no que receber no carroAtualizado
        carro.setModelo(carroAtualizado.getModelo());
        return carroRepository.save(carro); //salvando novamente o carro na entity so que atualizado
    }

    public void deletarPorId(Long id) { // deletando por id
        if (carroRepository.existsById(id)) { //verificando o id existe na entity, caso contrario nao vai deletar nada
            carroRepository.deleteById(id);
        }
    }





}
