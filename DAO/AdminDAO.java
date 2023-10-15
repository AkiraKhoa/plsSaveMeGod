package DAO;

import entities.Admin;
import java.util.HashMap;


public class AdminDAO {
    private List<Admin> admins = new ArrayList<>();

    public AdminDAO() {
        this.admins = new HashMap<>();
    }

    public Admin getAdmin(String adminId) {
        return admins.get(adminId);
    }


    public void updateAdmin(String adminId, Admin updatedAdmin) {
        admins.put(adminId, updatedAdmin);
    }

    public void deleteAdmin(String adminId) {
        admins.remove(adminId);
    }
}
