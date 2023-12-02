package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    private Collection<Note> notesList;

    @Override
    public Collection<Note> getAll() {
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        notesList = new LinkedList<>();
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }


    @Override
    public void removeNote(int id){
        ((NotesDatabase)database).getNotesTable().removeRecord(id);
    }


    public NotesDbContext(Database database) {
        super(database);
        this.notesList = new ArrayList<>();
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
