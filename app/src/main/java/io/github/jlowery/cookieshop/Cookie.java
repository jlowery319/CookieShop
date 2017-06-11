package io.github.jlowery.cookieshop;

public class Cookie {

    private String cookieName;
    private String description;
    private int imageId;

    // array of Cookies
    public static final Cookie[] cookies = {
        new Cookie("Chocolate Chip", "A Cookie Monster favorite", R.drawable.choc_chip),
        new Cookie("Snickerdoodle", "Not your Granny's cinnamon sugar cookies", R.drawable.snickerdoodle),
        new Cookie("Peanut Butter", "Peanut butter - chocolate's evil sidekick", R.drawable.peanut),
        new Cookie("Sugar", "These look innocent but trust me, they're not", R.drawable.sugar),
        new Cookie("Lemon", "These qualify as fruit! Muahahaha", R.drawable.lemon)
    };

    // constructor
    private Cookie(String name, String description, int imageId) {
        this.cookieName = name;
        this.description = description;
        this.imageId = imageId;
    }


    // Getters for instance variables
    public String getCookieName() {
        return cookieName;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(long id) { imageId = (int)id; }

    public String toString() {
        return cookieName;
    }

}
