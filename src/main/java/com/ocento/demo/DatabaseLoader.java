package com.ocento.demo;

import com.ocento.demo.domain.Type;
import com.ocento.demo.services.domain.ItemService;
import com.ocento.demo.services.domain.MediaFranchiseService;
import com.ocento.demo.services.domain.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseLoader implements CommandLineRunner {

    private final ItemService itemService;
    private final MediaFranchiseService mediaFranchiseService;
    private final TypeService typeService;

    @Override
    public void run(String... strings) throws Exception {
        this.typeService.save(Type.builder()
                .name("BOOK")
                .build());
    }
}
