package TwitterT;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String nation;
    private int age;
    private List<Tweet> tweet;

    public User(String firstName, String lastName, String nation, int age) {
        this.firstName= firstName;
        this.lastName=lastName;
        this.nation=nation;
        this.age=age;
        tweet = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNation() {
        return nation;
    }

    public int getAge() {
        return age;
    }

    public List<Tweet> getTweet() {
        return tweet;
    }

    public void addTweet(List<Tweet> tweetList){
        this.tweet=tweetList;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nation='" + nation + '\'' +
                ", age=" + age +
                '}';
    }
}
