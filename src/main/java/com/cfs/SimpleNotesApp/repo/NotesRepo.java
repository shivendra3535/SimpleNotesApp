package com.cfs.SimpleNotesApp.repo;

import com.cfs.SimpleNotesApp.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Notes, Long> {
}
