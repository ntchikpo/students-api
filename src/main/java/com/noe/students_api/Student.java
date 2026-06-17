package com.noe.students_api;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * @brief Entité représentant un étudiant.
 * @author Noé Thierry Tchikpo
 * @version 1.0
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** @brief Nom de l'étudiant, obligatoire. */
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    /** @brief Prénom de l'étudiant, obligatoire. */
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    /** @brief Email valide et obligatoire. */
    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    /** @brief Age entre 1 et 100. */
    @Min(value = 1, message = "L'age doit être supérieur à 0")
    @Max(value = 100, message = "L'age doit être inférieur à 100")
    private Integer age;

    public Student() {}

    public Student(String nom, String prenom, String email, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}