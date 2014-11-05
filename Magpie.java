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
 public String getResponse(String statement)
 {
  String response = "";
  String z = statement.trim();
  
  if (statement.indexOf("no") >= 0)
  {
   response = "Why so negative?";
  }
  else if (statement.indexOf("mother") >= 0
    || statement.indexOf("father") >= 0
    || statement.indexOf("sister") >= 0
    || statement.indexOf("brother") >= 0
    || statement.indexOf("mom") >= 0
    || statement.indexOf("Mom") >= 0    
    || statement.indexOf("dad") >= 0
    || statement.indexOf("Dad") >= 0)
  {
   response = "Tell me more about your family.";
  }
  
  else if (statement.indexOf("hate") >= 0)
  {
    response = "Hate is a strong word.";
  }
           
  else if (statement.indexOf("shit") >= 0
    || statement.indexOf("fuck") >= 0
    || statement.indexOf("bitch") >= 0
    || statement.indexOf("ass") >= 0
    || statement.indexOf("douche") >= 0)
     {
       response = "HEY.  This is a family-friendly program, you son of a motherless goat.  At least be creative.";
     }
  
  else if (statement.indexOf("42") >= 0)
  {
    response = "Ah, the meaning of life, the universe, and everything.";
  }
  
  else if (statement.indexOf("cat") >= 0
    || statement.indexOf("dog") >= 0
    || statement.indexOf("pet") >= 0)
     {
       response = "Tell me more about your pets.";
     }
  
  else if (statement.indexOf("iang") >= 0
    || statement.indexOf("andgraf") >= 0) 
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