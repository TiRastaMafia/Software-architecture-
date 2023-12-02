package ru.geekbrains.lesson6.notes.presentation.queries.views;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Scanner;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }
    }

    @Override
    public int getNoteId() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Укажите ID записи для удаления: ");
        int id = scan.nextInt();
        scan.close();
        return id;
    }


}
