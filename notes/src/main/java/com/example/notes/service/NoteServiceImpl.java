package com.example.notes.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.notes.model.Notes;
import com.example.notes.repository.NotesRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    private final NotesRepo notesRepo;

    public NoteServiceImpl(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }

    @Override
    public Set<Notes> getNotes() {
        Set<Notes> notes = new HashSet<>();

        notesRepo.findAll().forEach(note -> notes.add(note));
        return notes;
    }

    @Override
    public Optional<Notes> findById(Long id) {
        Optional<Notes> noteOptional = notesRepo.findById(id);
        if (!noteOptional.isPresent())
            throw new RuntimeException("Note not Found!");

        return noteOptional;

    }

    @Override
    public void deleteById(Long id) {
        notesRepo.deleteById(id);
    }

}
