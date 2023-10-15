package services;

import DAO.AdminDAO;
import entities.Admin;

public class AdminService {
    private AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin getAdmin(String adminId) {
        return adminDAO.getAdmin(adminId);
    }

    // Other methods related to admin functionalities, like managing system settings
}
