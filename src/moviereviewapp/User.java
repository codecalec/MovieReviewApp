package moviereviewapp;

public class User {
    private int ID, numberOfReviews;
    private String username, dateOfCreation;
    private boolean Premium;

    public User(int ID, String username, String dateOfCreation, boolean Premium, int numberOfReviews) {
        this.ID = ID;
        this.username = username;
        this.dateOfCreation = dateOfCreation;
        this.Premium = Premium;
        this.numberOfReviews = numberOfReviews;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public boolean isPremium() {
        return Premium;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }
    
    
    
}
