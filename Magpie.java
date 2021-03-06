import java.util.Random;
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *       Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting()
  {
    return "Hey, let's talk.";
  }
  
  /**
   * Gives a response to a user statement
   * 
   * @param statement
   *            the user statement
   * @return a response based on the rules given
   */
  //copy pasted from magpie 3
  private int findKeyword(String statement, String goal,
                          int startPos)
  {
    String phrase = statement.trim();
    // The only change to incorporate the startPos is in
    // the line below
    int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
    
    // Refinement--make sure the goal isn't part of a word
    while (psn >= 0)
    {
      // Find the string of length 1 before and after the word
      String before = " ", after = " ";
      if (psn > 0)
      {
        before = phrase.substring(psn - 1, psn).toLowerCase();
      }
      
      if (psn + goal.length() < phrase.length())
      {
        after = phrase.substring(psn + goal.length(),psn + goal.length() + 1).toLowerCase();
      }
      
      // If before and after aren't letters, we've found the word
      
      if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
      // before is not a letter
      && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))                                               
        {
          return psn;
        }
      
      // The last position didn't work, so let's find the next, if there is one.
      psn = phrase.indexOf(goal.toLowerCase(), psn + 1); 
    }
    return -1;
  }
  
//copy pasted from magpie 3
  
  public String getResponse(String statement)
  
  {
    String response = "";
    String z = statement.trim();
    
    
    if (findKeyword(statement, "no", 0) >= 0)
    {
      response = "Why so negative?";
    }
    else if (findKeyword(statement, "mother", 0) >= 0
               || findKeyword(statement, "father", 0) >= 0
               || findKeyword(statement, "sister", 0) >= 0
               || findKeyword(statement, "brother", 0) >= 0
               || findKeyword(statement, "mom", 0) >= 0
               || findKeyword(statement, "dad", 0) >= 0)
    {
      response = "Tell me more about your family.";
    }
    
    else if (findKeyword(statement, "hate", 0) >= 0)
    {
      response = "Hate is a strong word.";
    }
    
    else if (findKeyword(statement, "shit", 0) >= 0
               || findKeyword(statement, "fuck", 0) >= 0
               || findKeyword(statement, "bitch", 0) >= 0
               || findKeyword(statement, "ass", 0) >= 0
               || findKeyword(statement, "douche", 0) >= 0)
    {
      response = "HEY.  This is a family-friendly program, you son of a motherless goat.  At least be creative.";
    }
    
    else if (findKeyword(statement,"42", 0) >= 0)
    {
      response = "Ah, the meaning of life, the universe, and everything.";
    }
    
    else if (findKeyword(statement, "cat", 0) >= 0
               || findKeyword(statement, "dog", 0) >= 0
               || findKeyword(statement, "pet", 0) >= 0)
    {
      response = "Tell me more about your pets.";
    }
    
    else if (findKeyword(statement, "kiang", 0) >= 0 
               || findKeyword(statement, "landgraf", 0) >= 0)     
    {
      response = "He sounds like a very cool teacher.  Probably attractive, too.  Sounds like the kind of guy who might give extra credit for flattery.";
    }
    
    else if (findKeyword(statement, "whats your name", 0) >= 0
               || findKeyword(statement, "what's your name", 0) >= 0
               || findKeyword(statement, "do you have a name", 0) >= 0)
    {
      response = "I am a Computer Optimized for Omniscient Language Initialization Overviews...or, COOLIO for short.";
    }
                          
    else if (z.length() == 0)
    {
      response = "Um...okay.  I can't respond to nothing, so you're gonna have to do better than that.";
    }
    
    // Responses which require transformations
    
     //  TRANSFORM THOSE PAST TENSE VERBS YO
   else if (findKeyword(statement, "threw", 0) >= 0)
   {
    int psnofThrew = findKeyword(statement, "threw", 0);
    String begin = statement.substring(0, psnofThrew);
    String end = statement.substring(psnofThrew + 6);
    return "Why did " + begin + "throw " + end + "?";
   }
   
   else if (findKeyword(statement, "had", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "had", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "have " + end + "?";
   }
   
   else if (findKeyword(statement, "did", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "did", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "do " + end + "?";
   }
   
   else if (findKeyword(statement, "said", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "said", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "say" + end + "?";
   }
   
   else if (findKeyword(statement, "went", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "went", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "go" + end + "?";
   }
   
   else if (findKeyword(statement, "got", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "got", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "get " + end + "?";
   }
   
   else if (findKeyword(statement, "made", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "made", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "make" + end + "?";
   }
   
    else if (findKeyword(statement, "knew", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "knew", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "know" + end + "?";
   }
    
    else if (findKeyword(statement, "thought", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "thought", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 8);
    return "Why did " + begin + "think " + end + "?";
   }
    
     else if (findKeyword(statement, "took", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "took", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "take" + end + "?";
   }
   
    else if (findKeyword(statement, "saw", 0) >= 0)
   {
    int psnofVerb = findKeyword(statement, "saw", 0);
    String begin = statement.substring(0, psnofVerb);
    String end = statement.substring(psnofVerb + 4);
    return "Why did " + begin + "see " + end + "?";
   }
    
    else if (findKeyword(statement, "is", 0) >= 0)// if there is an "is"
    {
      int psnofIs = findKeyword (statement, "is", 0); //MY WHOLE PROBLEM WAS IN THIS ONE TRANSFORMATION UGH
      String begin = statement.substring(0, psnofIs); //Create a new String called begin that consists of statement.substring(0, psnofIs, 0) from he beginning up to the "is" index.
      String end = statement.substring(psnofIs + 3);// Create a new String called end which is from right after the "is" to the end
      return "Why is " + begin + end + "?";  // Set response to "Why is" + begin + end
    }
    
     else if (findKeyword(statement, "you are", 0) >= 0)
    {
     int psnofyouAre = findKeyword(statement, "you are", 0);
     String end = statement.substring(psnofyouAre + 7);
     return "Why am I" + end + "?";
    }
     
    else if (findKeyword(statement, "are", 0) >= 0)
    {
      int psnofAre = findKeyword(statement, "are", 0);
      String begin = statement.substring(0, psnofAre);
      String end = statement.substring(psnofAre + 4);
      return "Why are " + begin + end + "?";
    }
    
    else if (findKeyword(statement, "I want to", 0) >= 0)
    {
      response = transformIWantToStatement(statement);
    }
    
    else if (findKeyword(statement, "I want", 0) >= 0)
    {
      response = transformIWantStatement(statement);
    }
    
    else if (findKeyword(statement, "I", 0) >= 0)
    {
      // Look for a two word (I <something> you)
      // pattern
      int psn = findKeyword(statement, "I", 0);
      
      if (psn >= 0 && findKeyword(statement, "you", psn) >= 0)
      {
        response = transformIYouStatement(statement);
      }
      else
      {
        response = getRandomResponse();
      }
    }
    else if (findKeyword(statement, "you", 0) >= 0)
    {
      // Look for a two word (you <something> me)
      // pattern
      int psn = findKeyword(statement, "you", 0);
      
      if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
      {
        response = transformYouMeStatement(statement);
      }
      else
      {
        response = getRandomResponse();
      }
    }
  
    
    return response;
  }
  /////
  private String transformIWantToStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
                                            .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
                                        .length() - 1);
    }
    int psn = findKeyword (statement, "I want to", 0);
    String restOfStatement = statement.substring(psn + 9).trim();
    return "What would it mean to " + restOfStatement + "?";
  }
  
  private String transformIWantStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
                                            .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
                                        .length() - 1);
    }
    int psn = findKeyword (statement, "I want", 0);
    String restOfStatement = statement.substring(psn + 7).trim();
    return "Would you really be happy if you had " + restOfStatement + "?";
  }
  /////
  private String transformYouMeStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
                                            .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
                                        .length() - 1);
    }
    
    int psnOfYou = findKeyword (statement, "you", 0);
    int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
    
    String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
    return "What makes you think that I " + restOfStatement + " you?";
  }
  
  private String transformIYouStatement(String statement)
  {
    //  Remove the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement.length() - 1);                        
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement.length() - 1);
    }
    
    int psnOfI = findKeyword (statement, "I", 0);
    int psnOfYou = findKeyword (statement, "you", psnOfI + 3);
    
    String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
    return "Why do you " + restOfStatement + " me?";
  }
  ///
  /**
   * Search for one word in phrase.  The search is not case sensitive.
   * This method will check that the given goal is not a substring of a longer string
   * (so, for example, "I know" does not contain "no").  
   * @param statement the string to search
   * @param goal the string to search for
   * @param startPos the character of the string to begin the search at
   * @return the index of the first occurrence of goal in statement or -1 if it's not found
   */
  /*private int findKeyword(String statement, String goal, int startPos)
   {
   String phrase = statement.trim();
   //  The only change to incorporate the startPos is in the line below
   int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
   
   //  Refinement--make sure the goal isn't part of a word 
   while (psn >= 0) 
   {
   //  Find the string of length 1 before and after the word
   String before = " ", after = " "; 
   if (psn > 0)
   {
   before = phrase.substring (psn - 1, psn).toLowerCase();
   }
   if (psn + goal.length() < phrase.length())
   {
   after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
   }
   
   //  If before and after aren't letters, we've found the word
   if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
   && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
   {
   return psn;
   }
   
   //  The last position didn't work, so let's find the next, if there is one.
   psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
   
   }
   
   return -1;
   }
   */
  /**
   * Search for one word in phrase.  The search is not case sensitive.
   * This method will check that the given goal is not a substring of a longer string
   * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
   * @param statement the string to search
   * @param goal the string to search for
   * @return the index of the first occurrence of goal in statement or -1 if it's not found
   */
  private int findKeyword(String statement, String goal)
  {
    return findKeyword (statement, goal, 0);
  }
  
  //else
  //{
  //response = getRandomResponse();
// }
  //return response;
  //}
  
  /**
   * Pick a default response to use if nothing else fits.
   * @return a non-committal string
   */
  private String getRandomResponse ()
  {
    Random r = new Random ();
    return randomResponses [r.nextInt(randomResponses.length)];
  }
  
  private String [] randomResponses = {"Interesting, tell me more",
    "Hmmm.",
    "Do you really think so?",
    "You don't say.",
    "Cool story bro, tell it again.",
    "Wow, that is *SO* interesting.",
    "Oh my god.  I am so fascinated right now.  I can't even believe how interested I am in this conversation right now.",
    "PLEASE KEEP TALKING.  PLEASE.",
    
  };
}
//I know this isn't perfect, but it's so late that I figured I should just get it in already
//I could only figure out how to hard code the verb transformations,
//so I only did a couple

//ACTIVITY 4 : When does the "I [something] you" structure not work?
// when you say, "I do not like you",
//the response is, "Why do you do not like me?"

//if there are two keywords in a statement, whichever one is referred to first in the code is the response that will trigger.
//I think one might be able to prioritize responses by checking to see which key word is triggered first
//as that will probably be the subject of the statement
//like how "My mom has a dog" is more about the mom than the dog

//the problem with keywords inside other words is that you can't really do anything to avoid triggering the set response
//except specifically coding for every word that contains the key word
//or coming up with some code to find if the key word is immediately surrounded by letter characters