import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String questionText;
    ArrayList<String> options;
    int correctAnswerIndex;

    public Question(String questionText, ArrayList<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

class Quiz {
    String title;
    ArrayList<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.questionText);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println((i + 1) + ": " + question.options.get(i));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer - 1 == question.correctAnswerIndex) {
                score++;
            }
        }

        System.out.println("You scored " + score + " out of " + questions.size());
        System.out.print("Please provide your feedback: ");
        scanner.nextLine(); // Consume newline
        String feedback = scanner.nextLine();
        System.out.println("Thank you for your feedback: " + feedback);
    }
}

public class QuizGenerator{
    private static ArrayList<Quiz> quizzes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Create a new quiz");
            System.out.println("2. Add a question to a quiz");
            System.out.println("3. Take a quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter quiz title: ");
                    String title = scanner.nextLine();
                    if (isTitleUnique(title)) {
                        quizzes.add(new Quiz(title));
                    } else {
                        System.out.println("Quiz title already exists. Please choose a different title.");
                    }
                    break;
                case 2:
                    System.out.println("Available quizzes:");
                    for (int i = 0; i < quizzes.size(); i++) {
                        System.out.println((i + 1) + ": " + quizzes.get(i).title);
                    }
                    System.out.print("Choose a quiz to add a question to: ");
                    int quizIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (quizIndex >= 0 && quizIndex < quizzes.size()) {
                        System.out.print("Enter question text: ");
                        String questionText = scanner.nextLine();

                        ArrayList<String> options = new ArrayList<>();
                        int numOptions;
                        do {
                            System.out.print("Enter the number of options (minimum 2): ");
                            numOptions = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } while (numOptions < 2);

                        for (int i = 0; i < numOptions; i++) {
                            System.out.print("Enter option " + (i + 1) + ": ");
                            options.add(scanner.nextLine());
                        }

                        System.out.print("Enter the number of the correct answer: ");
                        int correctAnswerIndex = scanner.nextInt() - 1;

                        quizzes.get(quizIndex).addQuestion(new Question(questionText, options, correctAnswerIndex));
                    } else {
                        System.out.println("Invalid quiz selection.");
                    }
                    break;
                case 3:
                    System.out.println("Available quizzes:");
                    for (int i = 0; i < quizzes.size(); i++) {
                        System.out.println((i + 1) + ": " + quizzes.get(i).title);
                    }
                    System.out.print("Choose a quiz to take: ");
                    int takeQuizIndex = scanner.nextInt() - 1;

                    if (takeQuizIndex >= 0 && takeQuizIndex < quizzes.size()) {
                        quizzes.get(takeQuizIndex).takeQuiz();
                    } else {
                        System.out.println("Invalid quiz selection.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static boolean isTitleUnique(String title) {
        for (Quiz quiz : quizzes) {
            if (quiz.title.equalsIgnoreCase(title)) {
                return false;
            }
        }
        return true;
    }
}
