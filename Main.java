package TwitterT;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

        List<String> top = new ArrayList<String>(Arrays.asList("rel","pol","feel"));
        List<String> rel = new ArrayList<String>(Arrays.asList("humanity","Buddism","Atheist","Christian","faith","hope","Pope","Dalai Lam","Taosim","Allah","god","bless","pray","preacher","monk","Krishna"));
        List<String> pol = new ArrayList<String>(Arrays.asList("Donald","Trump","election","Predisent","Parliament","Barack Obama","Hussein","protest","law","Health"));
        List<String> feel = new ArrayList<String>(Arrays.asList("love","hate","feeling","crying","my heart","devistated","for a while","wherever","you","only","me"));

        List<String> nat = new ArrayList<String>(Arrays.asList("Mongolia","India","USA","Japan","Ethiopia","Nepal"));

        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18,25,37,49,57,22,31,19,54,76,88,103,24,26));
        List<String> name = new ArrayList<String>(Arrays.asList("Ashley","Tom","Enkhbold","Jav guru","Maharishi","Guthrie","Sickler","Terminator","Chris","Sandeep","Tumurtogoo","Chinggis","Ichiban","Jan Woo","John","Kim","Rajesh","Trevor","Noah"));

        List<String> acts= new ArrayList<String>(Arrays.asList("empowered", "sticky", "value-added", "oriented", "centric", "distributed","clustered", "branded", "outaide-the-box", "positioned","networked", " focused", "leveraged", "aligned", "targeted", "shared", "cooperative", "accelerated"));

        Random rand = new Random();
        Map<String,List<String>> by = new HashMap<String, List<String>>();
        by.put("pol",pol);
        by.put("rel",rel);
        by.put("feel",feel);
        by.put("name",name);
        by.put("feel",feel);



        Object randomSet = by.keySet().toArray()[rand.nextInt(by.keySet().toArray().length)];

        Function<List<String>,String> randomString = (list)->
                list.get(rand.nextInt(list.size()));


        Function<List<String>,String> textCreateRandom = (list)->
                list.get(rand.nextInt(list.size()))
                        .concat( " " +randomString.apply(feel)+ " "
                                +randomString.apply(rel)+ " in "
                                +randomString.apply(nat)+ ".");

        BiFunction<List<String>,String,String> textCreateByTopic = (text, topic)->
                text.stream().filter(e->e.matches(topic))
                        .map(m->((randomString.apply(nat) + " "
                                +randomString.apply(pol) + " "
                                +randomString.apply(acts) + " "
                                +randomString.apply(rel) + " "
                                +randomString.apply(nat))))
                        .collect(Collectors.joining(" "));

        Function<Map<String,List<String>>,Tweet> randomTweet = (tw)->{
            return new Tweet(randomSet.toString(),textCreateRandom.apply(by.get(randomSet)));
        };
        Function<List<String>,User> randomUser = (u)->{
            return new User(u.get(rand.nextInt(u.size())),randomString.apply(u),randomString.apply(nat),ages.get(rand.nextInt(ages.size())));
        };

        BiFunction<Map<String,List<String>>,String, Tweet> tweetByTopic = (tww,topic)->
                tww.keySet().stream().filter(m->m.matches(topic))
                        .map(m->{
                            return new Tweet(m,textCreateByTopic.apply(top,m));
                        }).findAny().get();

        Stream<List<String>> stream = Stream.of(pol,rel,feel,nat,pol,rel,nat,feel);
        stream.forEach(p-> System.out.println(new Tweet(p.toString(),textCreateRandom.apply(p)).getText()));

        Tweet test = tweetByTopic.apply(by,"pol");
        Tweet tweet = randomTweet.apply(by);
        System.out.println(tweet.getTopic() + "{}" + tweet.getText());
        System.out.println(test.getTopic() + "{}" + test.getText());
        User testu = randomUser.apply(name);
        List<Tweet> tweetList = new ArrayList<>();
        tweetList.add(test);
        tweetList.add(tweet);
        System.out.println(testu.toString());
        testu.addTweet(tweetList);








    }
}
