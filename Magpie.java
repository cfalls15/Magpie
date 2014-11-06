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
  return "Hello, let's talk.";
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
  int psn = phrase.toLowerCase().indexOf(
    goal.toLowerCase(), startPos);

  // Refinement--make sure the goal isn't part of a
  // word
  while (psn >= 0)
  {
   // Find the string of length 1 before and after
   // the word
   String before = " ", after = " ";
   if (psn > 0)
   {
    before = phrase.substring(psn - 1, psn)
      .toLowerCase();
   }
   if (psn + goal.length() < phrase.length())
   {
    after = phrase.substring(
      psn + goal.length(),
      psn + goal.length() + 1)
      .toLowerCase();
   }

   // If before and after aren't letters, we've
   // found the word
   if (((before.compareTo("a") < 0) || (before
     .compareTo("z") > 0)) // before is not a
           // letter
     && ((after.compareTo("a") < 0) || (after
       .compareTo("z") > 0)))
   {
    return psn;
   }

   // The last position didn't work, so let's find
   // the next, if there is one.
   psn = phrase.indexOf(goal.toLowerCase(),
     psn + 1);

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
    || findKeyword(statement, "landgraf", 0) >= 0
    || findKeyword(statement, "Landgraf", 0) >= 0
    || findKeyword(statement, "Kiang", 0) >= 0)     
     {
      response = "He sounds like a very cool teacher.  Probably attractive, too.  Sounds like the kind of guy who might give extra credit for flattery.";
     }
  
  else if (z.length() == 0)
    {
      response = "Um...okay.  I can't respond to nothing, so you're gonna have to do better than that.";
    }
    
  else
  {
   response = getRandomResponse();
  }
  return response;
 }

 /**
  * Pick a default response to use if nothing else fits.
  * @return a non-committal string
  */
 private String getRandomResponse()
 {
  final int NUMBER_OF_RESPONSES = 6;
  double r = Math.random();
  int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
  String response = "";
  
  if (whichResponse == 0)
  {
   response = "Interesting, tell me more.";
  }
  else if (whichResponse == 1)
  {
   response = "Hmmm.";
  }
  else if (whichResponse == 2)
  {
   response = "Do you really think so?";
  }
  else if (whichResponse == 3)
  {
   response = "You don't say.";
  }
  else if (whichResponse == 4)
  {
   response = "Huh.  Okay.";
  }
  else if (whichResponse == 5)
  {
   response = "Mhmm.  Go on.";
  }

  return response;
 }
}

//if there are two keywords in a statement, whichever one is referred to first in the code is the response that will trigger.
//I think one might be able to prioritize responses by checking to see which key word is triggered first
//as that will probably be the subject of the statement
//like how "My mom has a dog" is more about the mom than the dog

//the problem with keywords inside other words is that you can't really do anything to avoid triggering the set response
//except specifically coding for every word that contains the key word
//or coming up with some code to find if the key word is immediately surrounded by letter characters