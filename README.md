## Lancer le projet en local

### Prérequis
- Java 17 ou supérieur
- Maven
- PostgreSQL 17
- Postman (optionnel, pour tester l'API)

### Étapes

**1. Cloner le repository**

```bash
git clone https://github.com/ntchikpo/students-api.git
cd students-api
```

**2. Créer la base de données**

Ouvrez pgAdmin, connectez-vous à votre serveur PostgreSQL et exécutez :

```sql
CREATE DATABASE students_db;
```

**3. Configurer la connexion à la base de données**

Ouvrez le fichier `src/main/resources/application.properties` et modifiez les lignes suivantes avec vos identifiants PostgreSQL :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/students_db
spring.datasource.username=postgres
spring.datasource.password=2005
```

**4. Lancer le backend**

```bash
mvn spring-boot:run
```

Le serveur démarre sur `http://localhost:8080`. La table students est créée automatiquement dans la base de données au démarrage.

**5. Tester l'API (optionnel)**

Avec Postman ou votre navigateur, vous pouvez tester les endpoints suivants :
GET    http://localhost:8080/api/students

GET    http://localhost:8080/api/students/{id}

GET    http://localhost:8080/api/students/search?nom=

POST   http://localhost:8080/api/students

PUT    http://localhost:8080/api/students/{id}

DELETE http://localhost:8080/api/students/{id}

**6. Lancer le frontend**

Le backend doit rester en cours d'exécution. Ouvrez un nouveau terminal et suivez les instructions du repository frontend pour lancer l'interface web :

👉 https://github.com/ntchikpo/students-frontend
# Students API - Spring Boot

API REST de gestion d'étudiants développée avec Spring Boot et PostgreSQL.

## Technologies
- Java 17
- Spring Boot 4.1
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Endpoints
| Méthode | Route | Description |
|---------|-------|-------------|
| GET | /api/students | Récupérer tous les étudiants |
| GET | /api/students/{id} | Récupérer un étudiant par id |
| POST | /api/students | Ajouter un étudiant |
| PUT | /api/students/{id} | Modifier un étudiant |
| DELETE | /api/students/{id} | Supprimer un étudiant |

## Auteur
Noé Thierry Tchikpo - Étudiant ingénieur ESEO Angers
