# File Loader – USSD Call Detail Record Processor

This project is a Spring Boot application that loads and parses USSD Call Detail Record (CDR) files from a configured folder, processes them, and stores the data into a PostgreSQL database. After processing, files are moved to a separate "processed" folder to avoid reprocessing.

---

## Features
- Automatically scans input folder for USSD log files.
- Parses `|` (pipe) separated CDR records.
- Validates and maps records into structured JPA entities.
- Persists parsed data into PostgreSQL.
- Handles malformed records with proper logging.
- Supports scheduled execution for continuous monitoring.
- Moves processed files to a designated folder.

---

## Tech Stack
- Java 17+
- Spring Boot 3 (Data JPA, Scheduling)
- PostgreSQL
- Hibernate
- Maven
- IntelliJ IDEA (Recommended IDE)

---

## Configuration
Set your database, input folder, and processed folder inside `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ussd
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

fileloader.input-folder=D:/ussd_input_files
fileloader.processed-folder=D:/ussd_processed_files
spring.main.banner-mode=off
spring.jpa.properties.hibernate.format_sql=true

# Enable scheduling
spring.task.scheduling.pool.size=2
src/main/java/com/example/fileloader




## Project Structure
src
├─ main
│ ├─ java
│ │ └─ com.example.fileloader
│ │ ├─ controller
│ │ ├─ entity
│ │ ├─ repository
│ │ ├─ service
│ │ └─ FileLoaderApplication.java
│ └─ resources
│ ├─ application.properties
│ └─ data
├─ test
│ └─ java
│ └─ com.example.fileloader


---

## Configuration

Set your database, input folder, and processed folder inside `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ussd
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

fileloader.input-folder=D:/ussd_input_files
fileloader.processed-folder=D:/ussd_processed_files
spring.main.banner-mode=off
spring.jpa.properties.hibernate.format_sql=true

# Enable scheduling
spring.task.scheduling.pool.size=2

## **Setup Instructions**

### **1. Clone the Repository**

**Clone the repository and navigate into the project folder:**

```bash
git clone https://github.com/akram3855/file-loader-service.git
cd File-loader



2. Set Up PostgreSQL

Create a PostgreSQL database (default: ussd).

Ensure the cdr_records table exists or allow Spring Boot to auto-create it.

Insert sample CDR files in the input folder for testing.

3. Run the Application
mvn clean install
mvn spring-boot:run

