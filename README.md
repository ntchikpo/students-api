# Students API - Spring Boot

API REST de gestion d'étudiants développée avec Spring Boot et PostgreSQL.

## Technologies
- Java 17
- Spring Boot 4.1
- Spring Data JPA
- PostgreSQL
- Maven

## Fonctionnalités
- GET /api/students → Récupérer tous les étudiants
- GET /api/students/{id} → Récupérer un étudiant par id
- POST /api/students → Ajouter un étudiant
- PUT /api/students/{id} → Modifier un étudiant
- DELETE /api/students/{id} → Supprimer un étudiant

## Lancer le projet
1. Installer PostgreSQL et créer une base `students_db`
2. Configurer `application.properties` avec vos identifiants
3. Lancer avec IntelliJ ou `mvn spring-boot:run`

## Auteur
Noé Thierry Tchikpo - Étudiant ingénieur ESEO Angers
