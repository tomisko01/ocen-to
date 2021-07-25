package com.ocento.demo.controller;

import com.ocento.demo.domain.Type;
import com.ocento.demo.services.domain.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/types")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public List<Type> getTypes() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public Type getType(@PathVariable Long id) {
        return typeService.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createType(@RequestBody Type Type) throws URISyntaxException {
        Type savedType = typeService.save(Type);
        return ResponseEntity.created(new URI("/types/" + savedType.getId())).body(savedType);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateType(@PathVariable Long id, @RequestBody Type Type) {
        Type currentType = typeService.findById(id).orElseThrow(RuntimeException::new);
        currentType.setName(Type.getName());
        typeService.save(Type);

        return ResponseEntity.ok(currentType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteType(@PathVariable Long id) {
        typeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
