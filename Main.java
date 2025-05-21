import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// This is the main class
final class Main {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) throws Exception {

        // Open the input file
        File inputFile = new File("input.txt");

        // Create a scanner to read the input file
        Scanner scanner = new Scanner(inputFile);

        // Create a file writer to write to output.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Create a list to hold all students
        List<Student> listOfStudents = new ArrayList<>();

        // Read each line in the input file
        while (scanner.hasNextLine()) {

            // Get the next line
            String line = scanner.nextLine();

            // Split the line into parts using spaces
            String[] parts = line.split(" ");

            // Set the first name
            String firstName = parts[0];

            // Check if the student has a middle initial
            if (parts.length == 5) {
                // Get the middle initial, last name, grade, and IEP
                String midInit = parts[1];
                String lastName = parts[2];
                int grade = Integer.parseInt(parts[3]);
                boolean iep = parts[4].equalsIgnoreCase("y");

                // Create student with middle initial and add to list
                listOfStudents.add(
                    new Student(firstName, midInit, lastName, grade, iep)
                );
            } else if (parts.length < 4) {

                // Check if it is a empty line
                continue;

            } else {
                // Get the last name, grade, and IEP
                String lastName = parts[1];
                int grade = Integer.parseInt(parts[2]);
                boolean iep = parts[3].equalsIgnoreCase("y");

                // Create student without middle initial and add to list
                listOfStudents.add(
                    new Student(firstName, lastName, grade, iep)
                );
            }
        }

        // Write how many students were read
        outputWriter.write(
            "There are " + listOfStudents.size()
            + " students in the student list.\n"
        );

        // Write all student info
        outputWriter.write("The students are:\n\n");

        // Go through the student list and print each student
        for (Student s : listOfStudents) {
            outputWriter.write(s.print() + "\n");
        }

        // Close the scanner and writer
        scanner.close();
        outputWriter.close();
    }
}
