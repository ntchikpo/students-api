package com.noe.students_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @brief Repository JPA pour l'accès aux données des étudiants.
 * @author Noé Thierry Tchikpo
 * @version 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * @brief Recherche des étudiants dont le nom contient la chaîne donnée.
     * @param nom Chaîne à rechercher dans le nom.
     * @return Liste des étudiants correspondants.
     */
    List<Student> findByNomContainingIgnoreCase(String nom);
}