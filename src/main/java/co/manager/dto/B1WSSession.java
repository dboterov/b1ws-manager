package co.manager.dto;

public class B1WSSession implements Comparable<B1WSSession>{
    private String sessionId;
    private long created;
    private long lastBorrowed;

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastBorrowed() {
        return lastBorrowed;
    }

    public void setLastBorrowed(long lastBorrowed) {
        this.lastBorrowed = lastBorrowed;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int compareTo(B1WSSession o) {
        return Long.compare(o.lastBorrowed, lastBorrowed);
    }
}
