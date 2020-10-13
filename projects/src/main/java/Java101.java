import database.CollegePredictorDAO;

public class Java101 {

    public static void main(String args[]) {

        CollegePredictorDAO collegePredictorDAO = new CollegePredictorDAO();
        collegePredictorDAO.createTable("StudentDatabase");

        Page1 page1 = new Page1(collegePredictorDAO);
        page1.runApplication();
    }
}




