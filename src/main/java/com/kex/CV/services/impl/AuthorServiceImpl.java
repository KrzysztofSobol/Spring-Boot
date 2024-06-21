package com.kex.CV.services.impl;

import com.kex.CV.domain.dto.AuthorDto;
import com.kex.CV.domain.entities.AuthorEntity;
import com.kex.CV.repositories.AuthorRepository;
import com.kex.CV.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
         return StreamSupport.stream(authorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorEntity> find(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean exists(Long id) {
        return authorRepository.existsById(id);
    }
}
