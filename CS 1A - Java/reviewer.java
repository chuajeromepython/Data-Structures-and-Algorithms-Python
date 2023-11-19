import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Reviewer{
    public static void main(String[] args){
        String regex = "-"; 
        String filename = "history_midterm.txt";
        List<String> questions;
        try {
            questions = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        questions.removeIf(q -> q.isEmpty() || q.trim().isEmpty());
        int score = 0, counter = 1;
        int totalQuestions = questions.size();
        Random random = new Random();
        while (!questions.isEmpty()) {
            int index = random.nextInt(questions.size());
            String picker = questions.remove(index);
            System.out.println("(" + counter + "/" + totalQuestions + ") " +picker.split(regex)[0]);            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Answer: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(picker.split("-")[1])) {
                System.out.println("CORRECT: Definition -> " + picker + "\n");
                score++;
            } else {
                System.out.println("WRONG: Definition -> " + picker + "\n");
            }
            counter += 1;
        }

        System.out.println("Score: " + score + "/" + totalQuestions);
    }
}
