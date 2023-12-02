package ru.geekbrains.lesson6.notes.presentation.queries.controllers;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Optional;
import java.util.Scanner;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note){
        this.notesEditor.add(note);
    }

    public void routeRemoveNote(){
        this.notesEditor.remove(notesEditor.requestId());
    }

    public Optional<Note> routeGetNote(int id){
        return this.notesEditor.getById(id);
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

}
