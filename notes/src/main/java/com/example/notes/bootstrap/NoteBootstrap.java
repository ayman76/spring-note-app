package com.example.notes.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.notes.model.Notes;
import com.example.notes.repository.NotesRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NoteBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private NotesRepo notesRepo;

    public NoteBootstrap(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        notesRepo.saveAll(getNotes());
        log.debug("Loading Bootstrap Data");
    }

    private List<Notes> getNotes() {
        List<Notes> notes = new ArrayList<>();

        Notes note1 = new Notes();
        note1.setTitle("Note 1 Title");
        note1.setDescription("Note 1 Description");

        notes.add(note1);

        Notes note2 = new Notes();
        note2.setTitle("Note 2 Title");
        note2.setDescription("Note 2 Description");

        notes.add(note2);

        return notes;
    }

}
