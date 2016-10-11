package moviereviewapp;

public class Review {

    private int ID, rating;
    private int movieID;
    private int userID;
    private String dateOfSubmission;

    public Review(int ID, int movieID, int userID, String dateOfSubmission, int rating) {
        this.ID = ID;
        this.rating = rating;
        this.movieID = movieID;
        this.userID = userID;
        this.dateOfSubmission = dateOfSubmission;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getUserID() {
        return userID;
    }

    public int getID() {
        return ID;
    }

    public String getDateOfSubmission() {
        return dateOfSubmission;
    }

    public int getRating() {
        return rating;
    }

}
