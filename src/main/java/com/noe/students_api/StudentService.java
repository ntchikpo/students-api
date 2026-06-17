package com.noe.students_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @brief Service de gestion des étudiants.
 *
 * Contient la logique métier pour les opérations
 * CRUD sur les étudiants.
 *
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
     * @return Liste de tous les étudiants en base.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * @brief Récupère un étudiant par son identifiant.
     * @param id Identifiant unique de l'étudiant.
     * @return L'étudiant correspondant à l'id.
     * @throws RuntimeException si l'étudiant est introuvable.
     */
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    /**
     * @brief Ajoute un nouvel étudiant en base.
     * @param student L'étudiant à ajouter.
     * @return L'étudiant ajouté avec son id généré.
     */
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @brief Modifie un étudiant existant.
     * @param id Identifiant de l'étudiant à modifier.
     * @param newStudent Nouvelles données de l'étudiant.
     * @return L'étudiant mis à jour.
     * @throws RuntimeException si l'étudiant est introuvable.
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
     * @brief Supprime un étudiant par son identifiant.
     * @param id Identifiant de l'étudiant à supprimer.
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}