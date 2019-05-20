package TwitterT;

public class Tweet {
    private String topic;
    private String text;
    private User user;

    public Tweet(String top, String tes) {
        this.topic = top;
        this.text = tes;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
