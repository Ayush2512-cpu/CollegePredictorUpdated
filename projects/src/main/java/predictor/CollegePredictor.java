package predictor;

import app.Page1;
import database.CollegeDAO;
import database.CollegePopulatorAdvance;
import database.CollegePopulatorMains;
import database.CollegePredictorDAO;

import java.sql.SQLException;

public class CollegePredictor {

    public static void main(String args[]) throws Exception {
        CollegeDAO collegeDAO = new CollegeDAO();
        collegeDAO.readDataBase();
       // populateDatabase(collegeDAO);

        CollegePredictorDAO collegePredictorDAO = new CollegePredictorDAO();
        collegePredictorDAO.createTable("StudentDatabase");

        Page1 page1 = new Page1(collegePredictorDAO, collegeDAO);
        page1.runApplication();

//        TryMySQL dao = new TryMySQL();
//        try {
//            dao.readDataBase();
//        } catch (Exception e) {
//            e.printStackTrace();
//       }
    }

    private static void populateDatabase(CollegeDAO collegeDAO) throws Exception {

        collegeDAO.delete();
        try{
            CollegePopulatorAdvance.populate(collegeDAO);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            CollegePopulatorMains.populate(collegeDAO);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}