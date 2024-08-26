package com.example.model;

import java.time.LocalDateTime;

public class Tache {
    private int id;
    private String description;
    private boolean completed;
    private LocalDateTime dueDate;
    private int priority; // Nouvelle propriété pour la priorité

    // Constructeur par défaut
    public Tache() {
    }

    // Constructeur avec paramètres
    public Tache(int id, String description, boolean completed, LocalDateTime dueDate, int priority) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Getters et Setters pour priority
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Autres getters et setters restent inchangés

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                '}';
    }
}
