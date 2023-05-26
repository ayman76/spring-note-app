package com.example.notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.notes.model.Notes;
import com.example.notes.service.NoteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/note")
public class NoteController {

    public final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("note", new Notes());
        return "notes/noteForm";
    }

    @RequestMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("note", noteService.findById(Long.valueOf(id)));
        return "notes/show";
    }

    @RequestMapping("/{id}/update")
    public String updateNoteForm(@PathVariable String id, Model model) {
        model.addAttribute("note", noteService.findById(Long.valueOf(id)));
        return "/notes/noteForm";
    }

    @PostMapping
    @RequestMapping("")
    public String saveOrUpdateNote(@ModelAttribute Notes notes) {
        Notes note = noteService.saveNote(notes);

        return "redirect:/";
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public String deleteNoteById(@PathVariable String id) {
        noteService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

}
