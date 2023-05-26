package com.example.notes.service;

import java.util.Optional;
import java.util.Set;

import com.example.notes.model.Notes;

public interface NoteService{

    Set<Notes> getNotes();
    Optional<Notes> findById(Long id);
    void deleteById(Long id);

}
