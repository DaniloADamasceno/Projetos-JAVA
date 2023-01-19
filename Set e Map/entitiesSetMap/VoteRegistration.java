package entitiesSetMap;

public class VoteRegistration {

    private String userName;
    private int votes;

    //-------------------------------------  CONSTRUCTOR  ---------------------------------------------------------
    public VoteRegistration(String userName, int votes) {
        this.userName = userName;
        this.votes = votes;
    }

    //-------------------------------------  GETTERS AND SETTERS  --------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    //-------------------------------------  TOSTRING  -------------------------------------------------------------
    @Override
    public String toString() {
        return "VoteRegistration{" +
                "Name / Nome='" + userName + '\'' +
                ", votes / Votos =" + votes +
                '}';
    }

    //-------------------------------------  EQUALS AND HASHCODE  --------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VoteRegistration that)) return false;

        if (getVotes() != that.getVotes()) return false;
        return getUserName().equals(that.getUserName());
    }

    @Override
    public int hashCode() {
        int result = getUserName().hashCode();
        result = 31 * result + getVotes();
        return result;
    }
}
