package com.test.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class NoteController {

    private final Logger log = LoggerFactory.getLogger(NoteController.class);

    @GetMapping("/notes")
    Collection<Note> notes(Principal principal) {
        return null;
    }

    @GetMapping("/note/{id}")
    ResponseEntity<?> getNote(@PathVariable Long id) {
        Note note =  new Note(id, "this is random text");
        return ResponseEntity.ok().body(note);
    }

    @PostMapping("/note")
    ResponseEntity<Note> createNote(@Valid @RequestBody Note note) throws URISyntaxException {
        log.info("Request to create note: {}", note);

        return ResponseEntity.created(new URI("/api/note/" + note.getId()))
                .body(note);
    }


    @PutMapping("/note/{id}")
    ResponseEntity<Note> updateNote(@Valid @RequestBody Note note) {
        log.info("Request to update group: {}", note);
        return ResponseEntity.ok().body(note);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}