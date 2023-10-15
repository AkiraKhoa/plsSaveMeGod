package entities;


public class CrewMember {
    private String name;
    private String crewId;
    private CrewRole role; 

    public CrewMember(String name, CrewRole role) {
        this.name = name;
        this.role = role;
        this.crewId = crewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public CrewRole getRole() {
        return role;
    }

    public void setRole(CrewRole role) {
        this.role = role;
    }


    public enum CrewRole {
    PILOT,
    FLIGHT_ATTENDANT,
    GROUND_STAFF,
    // ... any other roles you want to include
}
     
}
