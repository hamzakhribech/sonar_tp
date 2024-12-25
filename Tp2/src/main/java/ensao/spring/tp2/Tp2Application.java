package ensao.spring.tp2;

import ensao.spring.tp2.Entities.Task;
import ensao.spring.tp2.Repos.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Tp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Bean
    CommandLineRunner run(TaskRepository taskRepository) {
        return args -> {
            // Ajouter des tâches dans la base de données
            Task task1 = new Task(null, "Complete the project", LocalDate.now(), LocalDate.of(2024, 11, 15));
            Task task2 = new Task(null, "Prepare for the exam", LocalDate.now(), LocalDate.of(2024, 12, 1));
            Task task3 = new Task(null, "Buy groceries", LocalDate.now(), LocalDate.of(2024, 11, 10));

            // Sauvegarder les tâches dans la base de données
            taskRepository.save(task1);
            taskRepository.save(task2);
            taskRepository.save(task3);

            // Afficher toutes les tâches dans la console
            System.out.println("Listing all tasks:");
            taskRepository.findAll().forEach(System.out::println);
        };
    }
}
