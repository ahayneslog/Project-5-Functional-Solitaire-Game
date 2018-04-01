package lewisproject1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Card class contains will take in one number that will determine
 * what card it will be. The number must be between 0 - 51. Based on that
 * number, the card's face value and suit is given. Functions include
 * getValue(), getSuit(), compareTo() and toString(). 
 * @author Andrew C. Haynes
 * Project 2, COP 4331
 */
public class Card {
    
    private int number;
    Image cardImage;
    boolean faceDown = true;
    
    /**
     * Default Constructor. 
     * It does nothing. 
     */
    public Card() {
        //do nothing
    }
    /**
     * Card Constructor that determines the number of the Card. 
     * The number is between 0-51. This number determines the face value 
     * and suit.
     * @param x: the number assigned to this Card. 
     */
    public Card(int x) {
        if(x >= 0 && x < 52)
            number = x;
        else 
            number = -1;
    }
    /**
     * Returns the number assigned to this Card. 
     * @return number: the number assigned to this Card. 
     */
    public int getNumber() {
        if(number == -1)
            System.out.println("This card is given a wrong number. Please do a number between 0 - 51");
        return number;
    }
    /**
     * Looks at the number assigned to the Card and determines
     * if the Card is red or not. 
     * The suits that are red are Hearts and Spades. The numbers 0-25 are Clubs
     * and Diamonds. The numbers 26 - 51 are Spades and Hearts. 
     * @return a boolean that is True if Card is red, False if not.
     */ 
    public boolean isRedCard() {
        if(((number < 26) && (number > 12)) || ((number > 38) && (number <= 51))) 
            return true;
        else 
            return false;
    }
    /**
     * The order of suits in this class is Hearts, Spades, 
     * Diamonds and Clubs (from highest to lowest). 
     * The numbers 0 - 12 are Clubs. The numbers 13 - 25 are Diamonds. 
     * The numbers 26 - 38 are Spades. The numbers 39 -  51 are Hearts. 
     * @return suit: The name of the suit of the Card.
     */
    public String getSuit() {
        String suit;
        if(number >= 0 && number <= 12) {
            suit = "Clubs";
        }
        else if(number >= 13 && number <= 25) {
            suit = "Diamonds";
        }
        else if(number >= 26 && number <= 38) {
            suit = "Spades";
        }
        else if(number >= 39 && number <= 51) {
            suit = "Hearts";
        }
        else {
            suit = "This card was given an incorrect number.";
        }
        return suit;
    }
    /**
     * Returns a String that states the face value of the Card. 
     * If the Card is between 2 - 10, the function will return that. 
     * If the Card is a J, Q, K or A, the function will return that. 
     * @return value: The face value of the Card. It's either 2-10 or J, Q, K, A.
     */
    public String getValue() {
        String value = "";
        int x = (number % 13) + 2;
        if(x >= 2 && x <= 10) {
            value = "" + x;
        }
        else if ((number%13) == 9) {
            value = "Jack";
        }
        else if ((number%13) == 10) {
            value = "Queen";
        }
        else if ((number%13) == 11) {
            value = "King";
        }
        else if ((number%13) == 12) {
            value = "Ace" ;
        }
        return value;        
    }
    
    public int getValue(int test) {
        int x = 0;
        if(test == 1)
            x = (number % 13) + 2;
        return x;        
    }
    /**
     * Compares the Card that is calling this method to the 
     * Card passed in the parameter. An integer is returned for the result. 
     * -1 if the Card is lower than the Card in the parameter. 
     * 0 if the Cards are equal. 
     * 1 if the Card is higher than the Card in the parameter. 
     * @param card: A Card that will be compared to with the Card that calls this method. 
     * @return x: an integer that determines the result of the comparison
     */
    public int compareTo(Card card) {    
        int x = 0;
        if((number % 13) > (card.getNumber() % 13) ) {
            x = 1;
        }    
        else if((number % 13) < (card.getNumber() % 13)) {
            x = -1;
        }
        //Tests situation for if they are the same face value
        else if((number % 13) == (card.getNumber() % 13)) {
            if(number > card.getNumber())
                x = 1;
            else if(number < card.getNumber())
                x = -1;
            else if(number == card.getNumber())
                x = 0;
        }    
        return x;
    }
    /**
     * Returns a String that describes the Card. 
     * The format is "[FaceValue] of [Suit] [Color]".
     * @return card: describes the Card with its face value, suit and color.
     */
    @Override
    public String toString() {
        String card = getValue() + " " + getSuit() + " ";
        if(isRedCard() == true)
            card += "Red";
        else
            card += "Black";
        return card;
    }
    
    /**
     * To forget to do exception handling here. 
     * This function needs IOException thrown
     * @return 
     */
    
    //FIXED
    Image getCardImage() throws IOException {
        Image temp = null;
        if(!faceDown)
            try {
                String idea = System.getProperty("user.dir");
                idea = idea.replace("\\", "/");
                String fileName = idea + "/src/lewisproject1/Cards/" + Integer.toString(this.number) + ".gif";
                temp = ImageIO.read(new File(fileName));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
                temp = null;
            }
        else {
            try {
                String idea = System.getProperty("user.dir");
                idea = idea.replace("\\", "/");
                String fileName = idea + "/src/lewisproject1/Cards/52.gif";
                temp = ImageIO.read(new File(fileName));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
                temp = null;
            }
        }
        return temp;
    }
    
    /**
     * If the card is currently face down. 
     * @return
     * @throws IOException 
     */
    Image faceDown() throws IOException {
        Image temp;
        try {
            String idea = System.getProperty("user.dir");
            idea = idea.replace("\\", "/");
            String fileName = idea + "/src/lewisproject1/Cards/52.gif";
            temp = ImageIO.read(new File(fileName));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            temp = null;
        }
        return temp;
    }
    
    /**
     * If 0, the card is not facing down.
     * @param i 
     */
    void isFaceDown(int i) {
        if(i == 0) {
            faceDown = false;
        }
    }
    
}