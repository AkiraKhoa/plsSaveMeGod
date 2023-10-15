package services;

import DAO.CrewMemberDAO;
import entities.CrewMember;

public class CrewService {
    private CrewMemberDAO crewMemberDAO;

    public CrewService(CrewMemberDAO crewMemberDAO) {
        this.crewMemberDAO = crewMemberDAO;
    }

    public void addCrewMember(CrewMember crewMember) {
        crewMemberDAO.addCrewMember(crewMember);
    }

    public CrewMember getCrewMember(String crewId) {
        return crewMemberDAO.getCrewMember(crewId);
    }

    // Other methods related to crew member assignments and management
}
