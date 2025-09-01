package com.cfs.SimpleNotesApp.controller;

import com.cfs.SimpleNotesApp.entity.Notes;
import com.cfs.SimpleNotesApp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin

public class NotesController {

    @Autowired
    NotesService noteService;

    @GetMapping
    public List<Notes> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PostMapping
    public Notes createNote(@RequestBody Notes notes){
        return noteService.createNote(notes);
    }

    @GetMapping("/{id}")
    public Notes getNoteById(@PathVariable Long id){
        return noteService.findNotesById(id);
    }

    @GetMapping("/title/{title}")
    public List<Notes> getNotesByTitle(@PathVariable String title){
        return noteService.getNotesByTitle(title);
    }

    @GetMapping("/content/{content}")
    public List<Notes> getNotesByContent(@PathVariable String content){
        return noteService.findNotesByContent(content);
    }

    @GetMapping("/delete/{id}")
    public List<Notes> deleteById(@PathVariable Long id){
        return noteService.deleteNoteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllNotes(){
        noteService.deleteAllNotes();
    }

    @PutMapping("/{id}")
    public Notes updateNotes(@PathVariable Long id, @RequestBody Notes notes){
        return noteService.updateNoteById(id, notes);
    }

    @PatchMapping("/updateTitle/{id}")
    public Notes updateNoteTitle(@PathVariable Long id, @RequestBody String title){
        return noteService.updateNoteTitleById(id,title);
    }
    @PatchMapping("/updateContent/{id}")
    public Notes updateNoteContent(@PathVariable Long id, @RequestBody String content){
        return noteService.updateNoteContentById(id,content);
    }

    @PatchMapping("/updateContentByTitle/{title}")
    public Notes updateNoteContentByTitle(@PathVariable String title, @RequestBody String content){
        return noteService.updateNoteContentByTitle(title,content);
    }
}
