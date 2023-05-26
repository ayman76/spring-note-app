package com.example.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notes.model.Notes;

public interface NotesRepo extends JpaRepository<Notes, Long> {

}
