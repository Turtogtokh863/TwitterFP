package TwitterT;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TweetsAgainstHumanity {
    public static void main(String[] args){
        Random rand = new Random();
        List<String> head = new ArrayList<String>(Arrays.asList("I drink to forget, ","What ended my last relationship? ","I'm sorry Professor I couldn't complete my homework because of ","This is the prime of my life. I'm young, hot, and full of ","What gives me unconrollable gas? ","Before I run for President I must destroy all evidence of my envolvement with ","Instead of coal, Santa now gives the bad children ","What did the US airdrop to the children of poor countries? ","What gets better with age? "," What do you hear? "));
        List<String> bottom = new ArrayList<String>(Arrays.asList("My relationship status.","Unfathomable stupidity."," Barack Obama.","a windmill full of corpses.","Crippling debt.","Alcoholism","Auschwitz.","Multiple stab wounds","Amputees.","Explosions.","Drinking alone.","a lifetime of saddness."));

        List<String> celeb = new ArrayList<String>(Arrays.asList("Donald Trump ","Kim Jong Un ","Xi Jinping ","Vladimir Putin ","Angela Merkel ","Jeff Bezos ","Pope Francis ","Bill Gates ","Mark Zuckerberg ","Theresa May ","Warren Buffet ","Jack Ma ","Tim Cook ","Elon Musk", "Shinzo Abe "));
        List<String> choice = new ArrayList<String>(Arrays.asList("agrees to ", "states ","acknowledges ","quotes ","hate to say ","love to say ","just dont know what it means "));
        List<String> randomFacts = new ArrayList<String>(Arrays.asList("My opponent is conspiring with greedy insurance companies, pot smokers and overpaid CEOs.","I refuse to support an America where tree-huggers and overseas manufacturers can sabotage our young entrepreneurs.","I will work for an America where government bureaucrats and street gangs can't undermine our right to accrue foreign debt.", "Unlike my opponent, I will protect our cherished national parks, our brave firefighters and our precious environment.","When I'm elected, I'll make sure MSNBC cronies and North Korean dictators cannot destroy our Christian values.","My opponent is palling around with drug addicts, backroom dealmakers and Fox News cronies.","The reinforcement of deviousness is asinine in its isomorphism.","The hypocrisy of ecology is quite philisophical in its morphology.","The reciprocity of tenacity is very nearly conservative in its lugubriousness.","The mobility of interdependence is almost open-minded in its pride.","The codependency of fluidity is independent in its fragmentation.","The smart investor this season will never redistribute sequential-pay stocks.", "Why doth sinful promiscuity scorch the courtier's loyalty? Yea!","O lewd indiscretion! Forsooth! Thou art th' oppressor's strict garters.","O womanly felicity! Wherefore doth ancient commerce scour the sun's persecution?","O evil history! O bitter wealth! Thou art th' angels' debased troubles.","15 Facts Your Spouse Thinks About In The Bathroom","5 Unbelievable Things That Make Supervisors Go To The Gym More","8 Embarassing Secrets Psychiatrists Write In Their Journals","For the everlasting God hath not given us the spirit of evil, but of goodness and kindness.","Thus saith God unto Canaan: rearrange ye not piles of oil, but barns full of gold.","Praise the Lord thy God and thou shalt cast out carnality; thou shalt be spared the flatulence.","They that pray to the Holy One shalt preserve their joy; they shalt banish frailty and adultery."));

        List<String> nat = new ArrayList<String>(Arrays.asList("Mongolia","India","USA","Japan","Ethiopia","Nepal"));
        List<String> slogan = new ArrayList<>(Arrays.asList(" are continually evolving, helping to procure worldwide knowledge portals for today's Pakistanian information workers.", " are dedicated to helping resell knowledge based solutions for today's capital-based virtual eBusinesses."," will constantly strive to deliver integrated eSolutions for today's market-driven virtual companies."," will help to implement advanced database solutions for today's Fortune 500 eCompanies."," will continue to research data-driven business metrics for today's web economy eBusinesses."," will steadfastly and unceasingly provide virtual eBusiness solutions for today's bottom-line focused market leaders."," will constantly strive to enable wireless knowledge products for today's data-driven dot-com virtual corporations."," are dedicated to helping leverage international data implementations for today's Scandinavian virtual businesses."," will constantly strive to deploy scalable eProducts for today's leading corporations."," will continue to manage portable workflow enhancements for today's new economy virtual eMonopolies."," are continually evolving, helping to resell XML-compliant ePortal solutions for today's profit-driven market leaders."," will constantly strive to deliver highly effective ePortals for today's knowledge-driven virtual eBusinesses."," will not stand for an America where corrupt labor unions and Muslim extremists can sabotage our innocent children."," will work for an America where porn stars and greedy insurance companies can't corrupt our brave police force.","want an America where Taliban militants and shifty Canadians cannot take away our founding fathers' dreams."," faith in our precious oil supply, our hard-working teachers and our beloved family pets."," refuse to support an America where racists and unstable nuclear regimes can destroy our right to free speech."));
        List<String> topic = new ArrayList<>(Arrays.asList("randomFacts","slogan","cardsAgainstHumanity"));


        Function<List<String>,String> randomString = (list)->
                list.get(rand.nextInt(list.size()));

        Function<Boolean,String> getCardsAgainstHumanity=x->
                randomString.apply(head)+" " +randomString.apply(bottom);

        Function<Boolean,String> getSlogan=x->
                randomString.apply(nat)+" " +randomString.apply(slogan);

        Function<Boolean,String> getRandomFact=x->
                randomString.apply(celeb)+" " +randomString.apply(choice)+" " +randomString.apply(randomFacts);


        Function<Topic,String> getTweet=(t)->{
            if(t==Topic.Card){
               return  getCardsAgainstHumanity.apply(true);
            }else if (t==Topic.Nat){
               return  getSlogan.apply(true);
            }
            else{
                return getRandomFact.apply(true);
            }
        } ;











        List<Topic> topics = new ArrayList<>();
        topics.add(Topic.Nat);
        topics.add(Topic.Card);
        topics.add(Topic.Celeb);

        BiFunction<List<Topic>,Long,List<String>> genTweets=(topicList,n)->
                new Random().ints(n, 0, topics.size())
                        .mapToObj(i->topicList.get(i))
                        .map(t->getTweet.apply(t)).collect(Collectors.toList());



        genTweets.apply(topics,10l).forEach(e->System.out.println(e));
    }
}
