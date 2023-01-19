package entitiesSetMap;

import java.util.Date;

public class LogEntry {

    private String username;
    private final Date moment;

    //------------------------------------------ Construtores ------------------------------------------
    public LogEntry(String username, Date moment) {
        this.username = username;
        this.moment = moment;
    }

    //------------------------------------------ Getters e Setters ------------------------------------------
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getDate() {
        return moment;
    }

    //------------------------------------------ toString ------------------------------------------
    @Override
    public String toString() {
        return "LogEntry { " +
                "username ='" + username  +
                ", instante ='" + moment +
                '}';
    }

    //------------------------------------------ hashCode e equals ------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry logEntry)) return false;

        if (getUsername() != null ? !getUsername().equals(logEntry.getUsername()) : logEntry.getUsername() != null)
            return false;
        return getDate() != null ? getDate().equals(logEntry.getDate()) : logEntry.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }
}
