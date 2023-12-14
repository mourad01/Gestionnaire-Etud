import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int id = 0;
        String nom = "";
        String prenom = "";
        double note = 0;
        int menuChoice = 0;
        StudentDatabase studentDatabase = new StudentDatabase();

        while (true) {
            System.out.println("---------------------------");
            System.out.println("1. Add new student");
            System.out.println("2. Search By Id");
            System.out.println("3 . Delete By Id ");
            System.out.println("4 . Display all Students ");
            System.out.println("-----------------------------");
            try {
                menuChoice = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice, Please put a valid number");
                menuChoice = in.nextInt();
            }
            switch (menuChoice) {
                case 1:
                    System.out.println("id:");
                    //add conditons
                    id = in.nextInt();

                    System.out.println("Add student's last name : ");
                    nom = in.next();
                    while (!StudentDatabase.isValid(nom)) {
                        System.out.println("Invalid name, please retry ");
                        nom = in.next();

                    }
                    System.out.println("Add student's first name:");
                    prenom = in.next();
                    while (!StudentDatabase.isValid(prenom)) {
                        System.out.println("Invalid name, please retry ");
                        prenom = in.next();
                    }
                    System.out.println("note:");
                    note = in.nextDouble();
                    while (note > 100 && note < 0) {
                        System.out.println("Invalid note, please retry ");
                        note = in.nextDouble();
                    }
                    studentDatabase.ajouterStudent(new Etudiant(id, nom, prenom, note));
                    break;

                case 2:
                    System.out.println("Enter the id:");
                    int idsearch = in.nextInt();
                    System.out.println(studentDatabase.recherche(idsearch));
                    break;
                case 3:
                    System.out.println("Enter the name:");
                    String deleteName = in.next();
                    studentDatabase.delete(deleteName);
                    break;
                case 4:
                    studentDatabase.affichEtdiant();
                    break;

            }

        }


    }
}