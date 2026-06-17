package com.noe.students_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @brief Contrôleur REST pour la gestion des étudiants.
 * @author Noé Thierry Tchikpo
 * @version 1.0
 */
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    /**
     * @brief Récupère un étudiant par son id.
     * @param id Identifiant de l'étudiant.
     * @return L'étudiant ou 404 si introuvable.
     * GET /api/students/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getStudentById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @brief Recherche des étudiants par nom.
     * @param nom Nom à rechercher.
     * @return Liste des étudiants correspondants.
     * GET /api/students/search?nom=Tchikpo
     */
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchByNom(@RequestParam String nom) {
        return ResponseEntity.ok(studentService.searchByNom(nom));
    }

    /**
     * @brief Ajoute un nouvel étudiant.
     * @param student L'étudiant à ajouter (validé).
     * @return L'étudiant ajouté avec code 201.
     * POST /api/students
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(student));
    }

    /**
     * @brief Modifie un étudiant existant.
     * @param id Identifiant de l'étudiant.
     * @param student Nouvelles données (validées).
     * @return L'étudiant mis à jour ou 404.
     * PUT /api/students/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @Valid @RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, student));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @brief Supprime un étudiant par son id.
     * @param id Identifiant de l'étudiant.
     * @return 204 No Content ou 404.
     * DELETE /api/students/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}