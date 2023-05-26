package com.example.notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.notes.service.NoteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    private final NoteService noteService;

    public IndexController(NoteService noteService) {
        this.noteService = noteService;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Getting Index Page");
        model.addAttribute("notes", noteService.getNotes());
        return "index";
    }
    
    
}
