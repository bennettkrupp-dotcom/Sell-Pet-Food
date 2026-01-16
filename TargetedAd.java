/*
 * Problem 2.3.1 Sell My Pet Food
 */
import java.util.ArrayList;
public class TargetedAd {

  public static void main(String[] args)
  {
   

    DataCollector dogCollector = new DataCollector();
    DataCollector catCollector = new DataCollector();

    dogCollector.setData("socialMediaPosts.txt", "DogTargetWords.txt");
    catCollector.setData("socialMediaPosts.txt", "CatTargetWords.txt");

    ArrayList<String> catLovers = new ArrayList<>();

    ArrayList<String> dogLovers = new ArrayList<>();


    //Loops through cat and dog collector creating a list of users who love cats or dogs

    while(true) {
      String post = dogCollector.getNextPost();
      if(post.equals("NONE")) {
        break;
      }
      String username = post.split(" ")[0];

      while(true) {
        String word = dogCollector.getNextTargetWord();
        if(word.equals("NONE")) {
        break;
        }
        if(post.contains(word) && !dogLovers.contains(username)) {
          dogLovers.add(username);
        }  
      }
    }

    while(true) {
      String post = catCollector.getNextPost();
      if(post.equals("NONE")) {
        break;
      }
      String username = post.split(" ")[0];

      while(true) {
        String word = catCollector.getNextTargetWord();
        if(word.equals("NONE")) {
        break;
        }
        if(post.contains(word)) {
          catLovers.add(username);
        }  
      }
    }

    catCollector.prepareAdvertisement("CatAdvertisement.txt", catLovers, "Your furry friend will love our cat food!");
    dogCollector.prepareAdvertisement("dogAdvertisement.txt", dogLovers, "Your furry friend will love our dog food!");

     
  }

}
