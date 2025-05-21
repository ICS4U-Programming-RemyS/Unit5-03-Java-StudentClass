// This class represents a student
public class Student {

    // Student's first name
    String firstName;

    // Student's middle initial (can be empty)
    String midInit;

    // Student's last name
    String lastName;

    // Student's grade
    int grade;

    // Whether the student has an IEP
    boolean iep;

    // Constructor with middle initial
    public Student(String u_firstName,
        String u_midInit, String u_lastName,
        int u_grade, boolean u_IEP) {
        this.firstName = u_firstName;
        this.midInit = u_midInit;
        this.lastName = u_lastName;
        this.grade = u_grade;
        this.iep = u_IEP;
    }

    // Constructor without middle initial
    public Student(String u_firstName,
        String u_lastName, int u_grade,
        boolean u_IEP) {
        this(u_firstName, "", u_lastName, u_grade, u_IEP);
    }

    // Method to return a string with the student's information
    public String print() {
        String fullName;

        // Build full name with or without middle initial
        if (midInit.isEmpty()) {
            fullName = firstName + " " + lastName;
        } else {
            fullName = firstName + " " + midInit + ". " + lastName;
        }

        // Add IEP information
        String iepStr;
        // Determine IEP status
        if (iep) {
            iepStr = "has an IEP.";
        } else {
            iepStr = "does not have an IEP.";
        }

        /*
         * Combine the full name, grade, and IEP status into a descriptive string.
         */
        return fullName + " is in grade " + grade +
            " and " + iepStr;
    }
}
