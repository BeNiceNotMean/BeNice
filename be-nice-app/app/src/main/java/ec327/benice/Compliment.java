package ec327.benice;

import java.util.ArrayList;

/**
 * Created by ericmooney on 12/1/15.
 */

public class Compliment {
    private String _id, _message;

    public Compliment(String id, String message) {
        _id = id;
        _message = message;
    }

    public String get_id() {
        return _id;
    }

    public String get_message() {
        return _message;
    }


    static public ArrayList<Compliment> loadCompliments(ArrayList<Compliment> compliments_list)
    {

        compliments_list.add(new Compliment("1", "You're pretty high on my list of people with whom I would want to be stranded on an island."));
        compliments_list.add(new Compliment("2", "You are a good friend."));
        compliments_list.add(new Compliment("3", "You are beautiful."));
        compliments_list.add(new Compliment("4", "You are brave."));
        compliments_list.add(new Compliment("5", "You are capable."));
        compliments_list.add(new Compliment("6", "You are creative."));
        compliments_list.add(new Compliment("7", "You are full of youth."));
        compliments_list.add(new Compliment("8", "You are important."));
        compliments_list.add(new Compliment("9", "You are interesting."));
        compliments_list.add(new Compliment("10", "You are kind."));
        compliments_list.add(new Compliment("11", "You are loved."));
        compliments_list.add(new Compliment("12", "You are making a difference."));
        compliments_list.add(new Compliment("13", "You are so charming."));
        compliments_list.add(new Compliment("14", "You are the person I most rely on when I need help. Thank you for being there."));
        compliments_list.add(new Compliment("15", "You are valuable."));
        compliments_list.add(new Compliment("16", "You bring out the best in other people."));
        compliments_list.add(new Compliment("17", "You can always make me laugh."));
        compliments_list.add(new Compliment("18", "You can do it."));
        compliments_list.add(new Compliment("19", "You can do this."));
        compliments_list.add(new Compliment("20", "You have a great sense of humor."));
        compliments_list.add(new Compliment("21", "You have good taste."));
        compliments_list.add(new Compliment("22", "You have the best laugh ever."));
        compliments_list.add(new Compliment("23", "You light up the room."));
        compliments_list.add(new Compliment("24", "You make a difference in my life."));
        compliments_list.add(new Compliment("25", "You make a difference."));
        compliments_list.add(new Compliment("26", "You make me smile."));
        compliments_list.add(new Compliment("27", "You make me want to be a better person."));
        compliments_list.add(new Compliment("28", "You make me want to be the person I am capable of being."));
        compliments_list.add(new Compliment("29", "You make the gloomy days a little less gloomy."));
        compliments_list.add(new Compliment("30", "You really impress me."));
        compliments_list.add(new Compliment("31", "You seem to really know who you are."));
        compliments_list.add(new Compliment("32", "You should be proud of yourself."));
        compliments_list.add(new Compliment("33", "You should be thanked more often. So thank you!!"));
        compliments_list.add(new Compliment("34", "You're a gift to those around you."));
        compliments_list.add(new Compliment("35", "You're a great example to others."));
        compliments_list.add(new Compliment("36", "You're always learning new things and trying to better yourself, which is awesome."));
        compliments_list.add(new Compliment("37", "You're an awesome friend."));
        compliments_list.add(new Compliment("38", "You're gorgeous -- and that's the least interesting thing about you, too."));
        compliments_list.add(new Compliment("39", "You're inspiring."));
        compliments_list.add(new Compliment("40", "You're like a breath of fresh air."));
        compliments_list.add(new Compliment("41", "You're like sunshine on a rainy day."));
        compliments_list.add(new Compliment("42", "You're more helpful than you realize."));
        compliments_list.add(new Compliment("43", "You're one of a kind!"));
        compliments_list.add(new Compliment("44", "You're pretty groovy, dude."));
        compliments_list.add(new Compliment("45", "You're really something special."));
        compliments_list.add(new Compliment("46", "You're so smart!"));
        compliments_list.add(new Compliment("47", "You're so strong."));
        compliments_list.add(new Compliment("48", "You're wonderful."));
        compliments_list.add(new Compliment("49", "You’ve made me think of things in a completely new way."));
        compliments_list.add(new Compliment("50", "Your actions are powerful."));
        compliments_list.add(new Compliment("51", "Your creative potential seems limitless."));
        compliments_list.add(new Compliment("52", "Your glass is the fullest."));
        compliments_list.add(new Compliment("53", "Your ideas are interesting."));
        compliments_list.add(new Compliment("54", "Your life is so interesting!"));
        compliments_list.add(new Compliment("55", "Your perspective is refreshing."));
        compliments_list.add(new Compliment("56", "Your smile brightens the room."));
        compliments_list.add(new Compliment("57", "Your smile is contagious."));
        compliments_list.add(new Compliment("58", "All of your ideas are brilliant."));
        compliments_list.add(new Compliment("59", "Any team would be lucky to have you on it."));
        compliments_list.add(new Compliment("60", "Being around you is like being on a happy little vacation."));
        compliments_list.add(new Compliment("61", "Being around you makes everything better!"));
        compliments_list.add(new Compliment("62", "Being awesome is hard, but you make it look easy."));
        compliments_list.add(new Compliment("63", "Can you teach me how to be as awesome as you?"));
        compliments_list.add(new Compliment("64", "Colors seem brighter when you're around."));
        compliments_list.add(new Compliment("65", "Don't worry. You'll do great."));
        compliments_list.add(new Compliment("66", "Even when you make mistakes you are still wonderful."));
        compliments_list.add(new Compliment("67", "Everything would be better if more people were like you!"));
        compliments_list.add(new Compliment("68", "Hanging out with you is always a blast."));
        compliments_list.add(new Compliment("69", "I am having trouble coming up with a compliment worthy enough for you."));
        compliments_list.add(new Compliment("70", "I appreciate you."));
        compliments_list.add(new Compliment("71", "I believe in you."));
        compliments_list.add(new Compliment("72", "I enjoy spending time with you."));
        compliments_list.add(new Compliment("73", "I enjoy your company."));
        compliments_list.add(new Compliment("74", "I have faith in you."));
        compliments_list.add(new Compliment("75", "I like the way you are."));
        compliments_list.add(new Compliment("76", "I love spending time with you."));
        compliments_list.add(new Compliment("77", "I love the way you and I just seem to click."));
        compliments_list.add(new Compliment("78", "I sure love you."));
        compliments_list.add(new Compliment("79", "I think about you when we’re apart."));
        compliments_list.add(new Compliment("80", "I'd like to be more like you."));
        compliments_list.add(new Compliment("81", "I'm always happy to see you."));
        compliments_list.add(new Compliment("82", "I'm glad we met."));
        compliments_list.add(new Compliment("83", "I'm so proud of you."));
        compliments_list.add(new Compliment("84", "I'm sorry."));
        compliments_list.add(new Compliment("85", "I’m excited to see what you do."));
        compliments_list.add(new Compliment("86", "I’m glad you’re here."));
        compliments_list.add(new Compliment("87", "I’m grateful you’re in my life."));
        compliments_list.add(new Compliment("88", "I’m happy to talk with you."));
        compliments_list.add(new Compliment("89", "I’m love listening to you talk."));
        compliments_list.add(new Compliment("90", "I’m proud of you."));
        compliments_list.add(new Compliment("91", "It’s fun to do things with you."));
        compliments_list.add(new Compliment("92", "Jokes are funnier when you tell them."));
        compliments_list.add(new Compliment("93", "Let's never stop hanging out."));
        compliments_list.add(new Compliment("94", "Look how far you've come!"));
        compliments_list.add(new Compliment("95", "My world is better with you in it."));
        compliments_list.add(new Compliment("96", "On a scale from 1 to 10, you're an 11."));
        compliments_list.add(new Compliment("97", "Take a break; you've earned it."));
        compliments_list.add(new Compliment("98", "Thank you."));
        compliments_list.add(new Compliment("99", "Thanks for being there for me."));
        compliments_list.add(new Compliment("100", "The people you love are lucky to have you in their lives."));
        compliments_list.add(new Compliment("101", "There isn't a thing about you that I don't like."));
        compliments_list.add(new Compliment("102", "There's ordinary, and then there's you."));
        compliments_list.add(new Compliment("103", "We have so many awesome memories together."));
        compliments_list.add(new Compliment("104", "When I grow up, I want to be just like you."));
        compliments_list.add(new Compliment("105", "You always know -- and say -- exactly what I need to hear when I need to hear it."));
        compliments_list.add(new Compliment("106", "You always know just what to say."));
        compliments_list.add(new Compliment("107", "You're a great listener."));
        compliments_list.add(new Compliment("108", "You have taught me so much."));
        compliments_list.add(new Compliment("109", "Actions speak louder than words, and yours tell an incredible story."));
        compliments_list.add(new Compliment("110", "Everyone gets knocked down sometimes, but you always get back up and keep going."));
        compliments_list.add(new Compliment("111", "I am enchanted to meet you."));
        compliments_list.add(new Compliment("112", "I am grateful to be blessed by your presence."));
        compliments_list.add(new Compliment("113", "I am utterly disarmed by your wit."));
        compliments_list.add(new Compliment("114", "I appreciate all of your opinions."));
        compliments_list.add(new Compliment("115", "I could hang out with you for a solid year straight and never get tired of you."));
        compliments_list.add(new Compliment("116", "I disagree with anyone who disagrees with you."));
        compliments_list.add(new Compliment("117", "I enjoy you more than a good sneeze. A GOOD one."));
        compliments_list.add(new Compliment("118", "I find you to be a fountain of inspiration."));
        compliments_list.add(new Compliment("119", "I like you more than the smell of Grandma's home-made apple pies."));
        compliments_list.add(new Compliment("120", "I like your aura."));
        compliments_list.add(new Compliment("121", "I support all of your decisions."));
        compliments_list.add(new Compliment("122", "I wish I could choose your handwriting as a font."));
        compliments_list.add(new Compliment("123", "I would enjoy a roadtrip with you."));
        compliments_list.add(new Compliment("124", "I would hold the elevator doors open for you if they were closing."));
        compliments_list.add(new Compliment("125", "I've had the time of my life, and I owe it all to you!"));
        compliments_list.add(new Compliment("126", "If I had to choose between you or Mr. Rogers, it would be you."));
        compliments_list.add(new Compliment("127", "If there is anyone who can handle it, I know you can handle it."));
        compliments_list.add(new Compliment("128", "If we were playing kickball, I'd pick you first."));
        compliments_list.add(new Compliment("129", "If you broke your arm, I would carry your books for you."));
        compliments_list.add(new Compliment("130", "In high school I bet you were voted 'most likely to keep being awesome.'"));
        compliments_list.add(new Compliment("131", "Is that your picture next to 'charming' in the dictionary?"));
        compliments_list.add(new Compliment("132", "Just knowing someone as cool as you will read this makes me smile."));
        compliments_list.add(new Compliment("133", "Me without you is like a shoe with out laces."));
        compliments_list.add(new Compliment("134", "My mom always asks me why I can't be more like you."));
        compliments_list.add(new Compliment("135", "Our awkward silences aren't even awkward."));
        compliments_list.add(new Compliment("136", "Somehow you make time stop and fly at the same time."));
        compliments_list.add(new Compliment("137", "Someone is getting through something hard right now because you've got their back."));
        compliments_list.add(new Compliment("138", "Thank you for contributing to our family."));
        compliments_list.add(new Compliment("139", "Thanks for helping me."));
        compliments_list.add(new Compliment("140", "That thing you don't like about yourself is what makes you so interesting."));
        compliments_list.add(new Compliment("141", "The way you treasure your loved ones is incredible."));
        compliments_list.add(new Compliment("142", "Way to go!"));
        compliments_list.add(new Compliment("143", "When you make up your mind about something, nothing stands in your way."));
        compliments_list.add(new Compliment("144", "When you're not afraid to be yourself is when you're most incredible."));
        compliments_list.add(new Compliment("145", "Who raised you? They deserve a medal for a job well done."));
        compliments_list.add(new Compliment("146", "With your creative wit, I'm sure you could come up with better compliments than me."));
        compliments_list.add(new Compliment("147", "You always know how to find that silver lining."));
        compliments_list.add(new Compliment("148", "You are a bucket of awesome."));
        compliments_list.add(new Compliment("149", "You are a champ!"));
        compliments_list.add(new Compliment("150", "You are able to do work that matters."));
        compliments_list.add(new Compliment("151", "You are deserving."));
        compliments_list.add(new Compliment("152", "You are enough."));
        compliments_list.add(new Compliment("153", "You are imperfect, and so am I."));
        compliments_list.add(new Compliment("154", "You are infatuating."));
        compliments_list.add(new Compliment("155", "You are the most perfect you there is."));
        compliments_list.add(new Compliment("156", "You are the world's greatest hugger."));
        compliments_list.add(new Compliment("157", "You deserve a hug right now."));
        compliments_list.add(new Compliment("158", "You deserve a promotion."));
        compliments_list.add(new Compliment("159", "You have such nice manners!"));
        compliments_list.add(new Compliment("160", "You have the best ideas."));
        compliments_list.add(new Compliment("161", "You have the courage of your convictions."));
        compliments_list.add(new Compliment("162", "You intrigue me."));
        compliments_list.add(new Compliment("163", "You just made my day."));
        compliments_list.add(new Compliment("164", "You look so perfect."));
        compliments_list.add(new Compliment("165", "You're spontaneous, and I love it!"));
        compliments_list.add(new Compliment("166", "You make me feel like I am on top of the world."));
        compliments_list.add(new Compliment("167", "You're #1 in my book!"));

        return compliments_list;
    }


}
