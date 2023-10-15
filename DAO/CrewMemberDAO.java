package DAO;

import entities.CrewMember;
import java.util.HashMap;


public class CrewMemberDAO {
    private HashMap<String, CrewMember> crewMembers;  

    public CrewMemberDAO() {
        this.crewMembers = new HashMap<>();
    }

    public CrewMember getCrewMember(String crewId) {
        return crewMembers.get(crewId);
    }

    public void addCrewMember(CrewMember crewMember) {
        crewMembers.put(crewMember.getCrewId(), crewMember);
    }

    public void updateCrewMember(String crewId, CrewMember updatedCrewMember) {
        crewMembers.put(crewId, updatedCrewMember);
    }

    public void deleteCrewMember(String crewId) {
        crewMembers.remove(crewId);
    }
}

