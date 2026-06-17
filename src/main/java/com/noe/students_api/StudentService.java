package com.noe.students_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @brief Service de gestion des étudiants.
 * @author Noé Thierry Tchikpo
 * @version 1.0
 */
@Service
public class StudentService {

    /** @brief Repository pour l'accès à la base de données. */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * @brief Récupère tous les étudiants.
     * @return Liste de tous les étudiants.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * @brief Récupère un étudiant par son id.
     * @param id Identifiant de l'étudiant.
     * @return L'étudiant correspondant.
     * @throws RuntimeException si introuvable.
     */
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    /**
     * @brief Recherche des étudiants par nom.
     * @param nom Nom à rechercher.
     * @return Liste des étudiants correspondants.
     */
    public List<Student> searchByNom(String nom) {
        return studentRepository.findByNomContainingIgnoreCase(nom);
    }

    /**
     * @brief Ajoute un nouvel étudiant.
     * @param student L'étudiant à ajouter.
     * @return L'étudiant ajouté avec son id.
     */
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @brief Modifie un étudiant existant.
     * @param id Identifiant de l'étudiant.
     * @param newStudent Nouvelles données.
     * @return L'étudiant mis à jour.
     * @throws RuntimeException si introuvable.
     */
    public Student updateStudent(Long id, Student newStudent) {
        Student student = getStudentById(id);
        student.setNom(newStudent.getNom());
        student.setPrenom(newStudent.getPrenom());
        student.setEmail(newStudent.getEmail());
        student.setAge(newStudent.getAge());
        return studentRepository.save(student);
    }

    /**
     * @brief Supprime un étudiant par son id.
     * @param id Identifiant de l'étudiant.
     * @throws RuntimeException si introuvable.
     */
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Étudiant non trouvé");
        }
        studentRepository.deleteById(id);
    }
}