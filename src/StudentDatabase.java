import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

public class StudentDatabase {

    ArrayList<Etudiant> etudiantsList;

    public StudentDatabase() {
        this.etudiantsList = new ArrayList<Etudiant>();
    }

    public static  boolean isValid(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        return  !name.isEmpty() && pattern.matcher(name).matches();

    }

    public void ajouterStudent(Etudiant etudiant) {
            this.etudiantsList.add(etudiant);
            System.out.println( "The Student added successfully");
    }

    public void affichEtdiant() {
        System.out.println("Student List");
        System.out.println(this.etudiantsList);
    }

    public Etudiant recherche(int id) {

        Etudiant target = null;
        for (Etudiant etd : this.etudiantsList) {
            if (etd.id() == id) {
                target = etd;
            } else {
                System.out.println("not found");
            }
        }
        return target;
    }

    public void delete(String name) {
        for (Etudiant etudiant : this.etudiantsList) {
            if (etudiant.nom().equals(name)) {
                this.etudiantsList.remove(name);
                System.out.println(" "+name+"was deleted");
            } else {
                System.out.println("not found");
            }
        }


    }

}
