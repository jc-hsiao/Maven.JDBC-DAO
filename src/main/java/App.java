import daos.AttorneyDao;
import models.Attorney;

public class App {
    public static void main(String[] args) {
        AttorneyDao ad = new AttorneyDao();
        Attorney attorney = ad.findById(2);
        System.out.println(attorney);

        Attorney newAtt = new Attorney(6,"Diego","Armando", 33, "Prosecutor", "Light Brown", "White", "Coffee", "Prosecutor's office");
        ad.create(newAtt);

        System.out.println(ad.findAll());

        Attorney updateAtt = new Attorney(15,"Diego","Armando", 33, "Lawyer", "Light Brown", "White", "Coffee", "Prosecutor's office");
        ad.update(updateAtt);

        ad.delete(14);

    }

}
