package com.noe.students_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @brief Contrôleur REST pour la gestion des étudiants.
 *
 * Expose les endpoints HTTP pour les opérations CRUD
 * sur les étudiants.
 *
 * @author Noé Thierry Tchikpo
 * @version 1.0
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    /** @brief Service contenant la logique métier. */
    @Autowired
    private StudentService studentService;

    /**
     * @brief Récupère tous les étudiants.
     * @return Liste de tous les étudiants.
     * GET /api/students
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * @brief Récupère un étudiant par son id.
     * @param id Identifiant de l'étudiant.
     * @return L'étudiant correspondant.
     * GET /api/students/{id}
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    /**
     * @brief Ajoute un nouvel étudiant.
     * @param student L'étudiant à ajouter.
     * @return L'étudiant ajouté avec son id.
     * POST /api/students
     */
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    /**
     * @brief Modifie un étudiant existant.
     * @param id Identifiant de l'étudiant à modifier.
     * @param student Nouvelles données.
     * @return L'étudiant mis à jour.
     * PUT /api/students/{id}
     */
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    /**
     * @brief Supprime un étudiant par son id.
     * @param id Identifiant de l'étudiant à supprimer.
     * DELETE /api/students/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}