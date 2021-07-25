package com.ocento.demo.services.domain;

import com.ocento.demo.domain.Type;
import com.ocento.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> findAll() {
        return StreamSupport.stream(typeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    public Type  save(Type type){
        return typeRepository.save(type);
    }

    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }
}
