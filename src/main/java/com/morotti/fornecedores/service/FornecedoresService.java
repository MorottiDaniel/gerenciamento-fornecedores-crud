package com.morotti.fornecedores.service;

import com.morotti.fornecedores.entity.FornecedoresEntity;
import com.morotti.fornecedores.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {
    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    public FornecedoresEntity criarFornecedor(FornecedoresEntity entity){
        return fornecedoresRepository.save(entity);
    }

    public List<FornecedoresEntity> findAll(){
        return fornecedoresRepository.findAll();
    }

    public FornecedoresEntity buscarPorId(Long id){
        return fornecedoresRepository.findById(id).get();
    }

    public void deletar(Long id){
        fornecedoresRepository.deleteById(id);
    }

}
