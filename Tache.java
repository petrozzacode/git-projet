package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Modèle (Model)
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

    // Autres getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

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

    // Service pour gérer les tâches
    public static class TacheService {
        private final List<Tache> taches = new ArrayList<>();

        // Ajouter une tâche
        public void addTache(Tache tache) {
            taches.add(tache);
        }

        // Obtenir toutes les tâches
        public List<Tache> getAllTaches() {
            return new ArrayList<>(taches);
        }

        // Obtenir une tâche par ID
        public Optional<Tache> getTacheById(int id) {
            return taches.stream().filter(t -> t.getId() == id).findFirst();
        }

        // Supprimer une tâche
        public void removeTache(int id) {
            taches.removeIf(t -> t.getId() == id);
        }
    }

    // Contrôleur pour les routes REST (Spring Boot)
    @org.springframework.web.bind.annotation.RestController
    @org.springframework.web.bind.annotation.RequestMapping("/taches")
    public static class TacheController {
        private final TacheService tacheService = new TacheService();

        @org.springframework.web.bind.annotation.GetMapping
        public List<Tache> getAllTaches() {
            return tacheService.getAllTaches();
        }

        @org.springframework.web.bind.annotation.PostMapping
        public void addTache(@org.springframework.web.bind.annotation.RequestBody Tache tache) {
            tacheService.addTache(tache);
        }

        @org.springframework.web.bind.annotation.GetMapping("/{id}")
        public Tache getTacheById(@org.springframework.web.bind.annotation.PathVariable int id) {
            return tacheService.getTacheById(id).orElse(null);
        }

        @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
        public void removeTache(@org.springframework.web.bind.annotation.PathVariable int id) {
            tacheService.removeTache(id);
        }
    }
}
