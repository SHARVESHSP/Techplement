# Techplement
This Java application allows users to create, manage, and take quizzes through a text-based interface. Users can interact with the system to create quizzes, add questions, and take quizzes, with scores and feedback provided at the end.
Here's the README file in markdown format without using code blocks:

---
# Quiz Generator

This program allows you to create, manage, and take quizzes through a command-line interface.

## Features

- Create new quizzes
- Add questions to existing quizzes
- Take quizzes and receive a score
- Provide feedback after taking a quiz

## How to Use

### Creating a New Quiz

1. Run the program.
2. Choose the option to create a new quiz.
3. Enter a unique title for the quiz.

### Adding Questions to a Quiz

1. Run the program.
2. Choose the option to add a question to a quiz.
3. Select the quiz you want to add a question to.
4. Enter the question text.
5. Enter the number of options (minimum 2).
6. Enter each option text.
7. Enter the number of the correct answer.

### Taking a Quiz

1. Run the program.
2. Choose the option to take a quiz.
3. Select the quiz you want to take.
4. Answer each question by entering the number of the correct option.
5. View your score at the end of the quiz.
6. Provide feedback when prompted.

## Implementation Details

### Question Class

- **Attributes:**
  - `questionText`: The text of the question.
  - `options`: A list of possible answers.
  - `correctAnswerIndex`: The index of the correct answer in the options list.

### Quiz Class

- **Attributes:**
  - `title`: The title of the quiz.
  - `questions`: A list of `Question` objects.

- **Methods:**
  - `addQuestion(Question question)`: Adds a question to the quiz.
  - `takeQuiz()`: Prompts the user to answer each question and calculates the score.

### QuizGenerator Class

- **Attributes:**
  - `quizzes`: A list of `Quiz` objects.

- **Methods:**
  - `main(String[] args)`: The main method that provides a command-line interface to interact with the quizzes.
  - `isTitleUnique(String title)`: Checks if the quiz title is unique.

### Program Flow

1. The user is prompted to choose an option: create a new quiz, add a question to a quiz, take a quiz, or exit.
2. Based on the user’s choice, the program executes the corresponding actions.
3. The user can create multiple quizzes, add multiple questions to each quiz, and take any quiz.
4. The program ensures that quiz titles are unique.
5. The program collects feedback from the user after they take a quiz.
