package com.ocento.demo.services.domain;

import com.ocento.demo.domain.MediaFranchise;
import com.ocento.demo.repository.MediaFranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MediaFranchiseService {

    @Autowired
    private MediaFranchiseRepository mediaFranchiseRepository;

    public List<MediaFranchise> list() {
        return StreamSupport.stream(mediaFranchiseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
