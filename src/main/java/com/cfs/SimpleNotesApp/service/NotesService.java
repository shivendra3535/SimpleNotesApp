package com.cfs.SimpleNotesApp.service;

import com.cfs.SimpleNotesApp.entity.Notes;
import com.cfs.SimpleNotesApp.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    NotesRepo notesRepo;

    public Notes createNote(Notes notes){
        return notesRepo.save(notes);
    }

    public List<Notes> getAllNotes(){
        return notesRepo.findAll();
    }

    public Notes findNotesById(Long id){
        return notesRepo.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public List<Notes> getNotesByTitle(String title){
        return notesRepo.findAll().stream().filter(notes -> notes.getTitle().equalsIgnoreCase(title) ).toList();
    }

    public List<Notes> deleteNoteById(Long id){
        notesRepo.deleteById(id);
        return notesRepo.findAll();
    }

    public Notes updateNoteById(Long id, Notes notes){
        Notes existingNote= notesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notes Not Found"));
        existingNote.setTitle(notes.getTitle());
        existingNote.setContent((notes.getContent()));
        notesRepo.save(existingNote);
        return existingNote;
    }

    public  void deleteAllNotes(){
        notesRepo.deleteAll();
    }

    public List<Notes> findNotesByContent(String content){
        return notesRepo.findAll().stream().filter(notes -> notes.getContent().equalsIgnoreCase(content)).toList();
    }

    public Notes updateNoteTitleById(Long id, String title){
        Notes existingNote= notesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notes Not Found"));
        existingNote.setTitle(title);
        notesRepo.save(existingNote);
        return existingNote;
    }

    public Notes updateNoteContentById(Long id, String content){
        Notes existingNote= notesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notes Not Found"));
        existingNote.setContent(content);
        notesRepo.save(existingNote);
        return existingNote;
    }

    public Notes updateNoteContentByTitle(String title, String content){
        Notes existingNote= (Notes) notesRepo.findAll().stream().filter(notes -> notes.getTitle().equalsIgnoreCase(title));
        existingNote.setContent(content);
        notesRepo.save(existingNote);
        return existingNote;
    }
}
