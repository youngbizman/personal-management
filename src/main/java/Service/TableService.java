package Service;

import DAO.TableDAO;

public class TableService {

    private final TableDAO tableDAO = new TableDAO();

    public void createTableVacation() {
        tableDAO.createTableVacation();
    }

    public void createTablePersonnel() {
        tableDAO.createTablePersonnel();
    }
}
