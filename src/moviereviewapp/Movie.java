package moviereviewapp;

public class Movie {
    private int ID;
    private String name, director, dateOfRelease;

    public Movie(int ID, String name, String director, String dateOfRelease) {
        this.ID = ID;
        this.name = name;
        this.director = director;
        this.dateOfRelease = dateOfRelease;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }
    
    
    
}
