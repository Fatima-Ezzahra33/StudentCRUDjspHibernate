# StudentCrudHibernate

Application web Java EE de gestion des étudiants (CRUD) développée avec **Hibernate**, **JSP/Servlet** et déployée sur **WildFly**.

---

## 🛠️ Technologies utilisées

- **Java 21**
- **Hibernate ORM ** (fourni par WildFly)
- **Jakarta Persistence (JPA)**
- **Jakarta Servlet**
- **JSP** (JavaServer Pages)
- **MySQL 8**
- **WildFly 39**
- **Maven**

---

## 📁 Structure du projet

```
StudentCrudHibernate/
├── src/
│   └── main/
│       ├── java/com/ensa/studentcrudhibernate/
│       │   ├── model/
│       │   │   └── Student.java          # Entité JPA
│       │   ├── dao/
│       │   │   └── StudentDAO.java       # Accès aux données (Hibernate Session)
│       │   ├── servlet/
│       │   │   └── StudentServlet.java   # Contrôleur HTTP
│       │   └── util/
│       │       └── HibernateUtil.java    # Factory SessionFactory
│       ├── resources/
│       │   └── META-INF/
│       │       └── persistence.xml       # Configuration JPA
│       └── webapp/
│           ├── WEB-INF/
│           │   ├── jboss-web.xml
│           │   └── jboss-deployment-structure.xml
│           └── *.jsp                     # Vues JSP
└── pom.xml
```

---

## ⚙️ Prérequis

- **JDK 11** ou supérieur
- **Maven 3.8+**
- **WildFly 39.x** installé et configuré
- **MySQL 8** en cours d'exécution
- **MySQL Connector/J** installé comme module WildFly

---

## 🗄️ Configuration de la base de données

### Créer la base de données MySQL

```sql
CREATE DATABASE studentdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
``

## 🚀 Lancement de l'application

### 1. Compiler et packager

```bash
mvn clean package
```

### 2. Déployer sur WildFly

Depuis IntelliJ IDEA avec la configuration WildFly

### 3. Accéder à l'application

```
http://localhost:8080/StudentCrudHibernate-1.0-SNAPSHOT/students
```

---


## 🔧 Dépendances Maven

Toutes les dépendances Jakarta et Hibernate sont en scope `provided` car fournies par WildFly :

| Dépendance | Version | Scope |
|---|---|---|
| jakarta.persistence-api | 3.1.0 | provided |
| jakarta.servlet-api | 6.0.0 | provided |
| hibernate-core | 6.6.x | provided |
| mysql-connector-j | 8.3.0 | — (module WildFly) |

---
## 👨‍💻 Auteur

Projet réalisé dans le cadre d'un TP Java EE — ENSA
