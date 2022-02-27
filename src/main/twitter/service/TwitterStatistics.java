package twitter.service;

import java.util.ArrayList;
import java.util.List;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.Twitter.User;

/**
 * Twitter Statistic provides a statistical service of a Twitter profile.
 * If you have a Twitter account, you can call any method with the Twitter credentials.
 * 
 * @author Carmine Dodaro {carminedodaro@gmail.com}, Simone Spaccarotella {spa.simone@gmail.com}
 */
public class TwitterStatistics {

    /**
     * Gets the list of your followers.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String listFollowers(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            List<User> listUser = twitter.getFollowers();
            for (User user : listUser) {
                response += "<user>";
                response += "<id>" + user.getId() + "</id>";
                response += "<name>" + user.getName() + "</name>";
                response += "<location>" + user.getLocation() + "</location>";
                response += "<screenname>" + user.getScreenName() + "</screenname>";
                response += "<imageurl>" + user.getProfileImageUrl().toString() + "</imageurl>";
                response += "<followerscount>" + user.getFollowersCount() + "</followerscount>";
                Twitter.Status status = user.getStatus();
                response += "<status>";
                if (status != null) {
                    response += status.getText();
                } else {
                    response += "";
                }
                response += "</status>";
                response += "</user>";
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Gets the list of your followings.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String listFollowings(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            List<User> listUser = twitter.getFriends();
            for (User user : listUser) {
                response += "<user>";
                response += "<id>" + user.getId() + "</id>";
                response += "<name>" + user.getName() + "</name>";
                response += "<location>" + user.getLocation() + "</location>";
                response += "<screenname>" + user.getScreenName() + "</screenname>";
                response += "<imageurl>" + user.getProfileImageUrl().toString() + "</imageurl>";
                response += "<followerscount>" + user.getFollowersCount() + "</followerscount>";
                Twitter.Status status = user.getStatus();
                response += "<status>";
                if (status != null) {
                    response += status.getText();
                } else {
                    response += "";
                }
                response += "</status>";
                response += "</user>";
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Gets one or more of your followings that have the highest number of followers.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String getTheMostPopularFollowings(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            List<User> listUser = twitter.getFriends();
            int followingsNumber = 0;
            for (User user : listUser) {
                int number = user.getFollowersCount();
                if (followingsNumber < number) {
                    followingsNumber = number;
                }
            }
            for (User user : listUser) {
                if (followingsNumber == user.getFollowersCount()) {
                    response += "<user>";
                    response += "<id>" + user.getId() + "</id>";
                    response += "<name>" + user.getName() + "</name>";
                    response += "<location>" + user.getLocation() + "</location>";
                    response += "<screenname>" + user.getScreenName() + "</screenname>";
                    response += "<imageurl>" + user.getProfileImageUrl().toString() + "</imageurl>";
                    response += "<followerscount>" + user.getFollowersCount() + "</followerscount>";
                    Twitter.Status status = user.getStatus();
                    response += "<status>";
                    if (status != null) {
                        response += status.getText();
                    } else {
                        response += "";
                    }
                    response += "</status>";
                    response += "</user>";
                }
            }
        } else {
            response += "<invalidlogin />";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Gets one or more of your followers that have the highest number of followers.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String getTheMostPopularFollowers(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            List<User> listUser = twitter.getFollowers();
            int followingsNumber = 0;
            for (User user : listUser) {
                int number = user.getFollowersCount();
                if (followingsNumber < number) {
                    followingsNumber = number;
                }
            }
            for (User user : listUser) {
                if (followingsNumber == user.getFollowersCount()) {
                    response += "<user>";
                    response += "<id>" + user.getId() + "</id>";
                    response += "<name>" + user.getName() + "</name>";
                    response += "<location>" + user.getLocation() + "</location>";
                    response += "<screenname>" + user.getScreenName() + "</screenname>";
                    response += "<imageurl>" + user.getProfileImageUrl().toString() + "</imageurl>";
                    response += "<followerscount>" + user.getFollowersCount() + "</followerscount>";
                    Twitter.Status status = user.getStatus();
                    response += "<status>";
                    if (status != null) {
                        response += status.getText();
                    } else {
                        response += "";
                    }
                    response += "</status>";
                    response += "</user>";
                }
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Gets one or more cities where the largest number of your followers/followings come from.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String getTheMostPopularCities(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        List<String> listCities = new ArrayList<String>();
        if (twitter.isValidLogin()) {
            List<User> listUser = twitter.getFollowers();
            for (User user : listUser) {
                listCities.add(user.getLocation());
            }
            String[] citiesArray = new String[listCities.size()];
            int counter = 0;
            for (String city : listCities) {
                citiesArray[counter] = city;
                counter++;
            }
            int[] countCitiesArray = new int[citiesArray.length];
            for (String city : listCities) {
                for (int i = 0; i < citiesArray.length; i++) {
                    if (city.equals(citiesArray[i])) {
                        countCitiesArray[i]++;
                    }
                }
            }
            listCities.clear();
            int max = 0;
            for (int i = 0; i < countCitiesArray.length; i++) {
                if (max < countCitiesArray[i] && !citiesArray[i].isEmpty()) {
                    max = countCitiesArray[i];
                }
            }
            for (int i = 0; i < countCitiesArray.length; i++) {
                if (countCitiesArray[i] == max && !citiesArray[i].isEmpty()) {
                    if (!listCities.contains(citiesArray[i])) {
                        listCities.add(citiesArray[i]);
                        response += "<city>" + citiesArray[i] + "</city>";
                    }
                }
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Search the given <code>keyword</code> into the status of your followers.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @param keyword the text you want to search
     * @return an XML file containing the result
     */
    public String searchContents(String username, String password, String keyword) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            if (keyword == null) {
                keyword = "";
            }
            List<User> listUser = twitter.getFollowers();
            for (User user : listUser) {
                Twitter.Status userStatus = user.getStatus();
                if (userStatus != null) {
                    String status = userStatus.getText();
                    status = status.toLowerCase();
                    keyword = keyword.toLowerCase();
                    if (status.contains(keyword)) {
                        response += "<user>";
                        response += "<id>" + user.getId() + "</id>";
                        response += "<name>" + user.getName() + "</name>";
                        response += "<location>" + user.getLocation() + "</location>";
                        response += "<screenname>" + user.getScreenName() + "</screenname>";
                        response += "<imageurl>" + user.getProfileImageUrl().toString() + "</imageurl>";
                        response += "<followerscount>" + user.getFollowersCount() + "</followerscount>";
                        response += "<status>" + userStatus.getText() + "</status>";
                        response += "</user>";
                    }
                }
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Gets a list of both your followers/followings.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return an XML file containing the result
     */
    public String getFollowersAndFollowing(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        String response = "<twitter>";
        if (twitter.isValidLogin()) {
            List<User> listFollowers = twitter.getFollowers();
            List<User> listFollowing = twitter.getFriends();
            for (User follower : listFollowers) {
                for (User following : listFollowing) {
                    if (follower.getId() == following.getId()) {
                        response += "<user>";
                        response += "<id>" + follower.getId() + "</id>";
                        response += "<name>" + follower.getName() + "</name>";
                        response += "<location>" + follower.getLocation() + "</location>";
                        response += "<screenname>" + follower.getScreenName() + "</screenname>";
                        response += "<imageurl>" + follower.getProfileImageUrl().toString() + "</imageurl>";
                        response += "<followerscount>" + follower.getFollowersCount() + "</followerscount>";
                        Twitter.Status status = follower.getStatus();
                        response += "<status>";
                        if (status != null) {
                            response += status.getText();
                        } else {
                            response += "";
                        }
                        response += "</status>";
                        response += "</user>";
                    }
                }
            }
        } else {
            response += "<invalidlogin></invalidlogin>";
        }
        response += "</twitter>";
        return response;
    }

    /**
     * Says whether or not these credentials are valid.
     * 
     * @param username the username of a Twitter account
     * @param password the password of a Twitter account
     * @return true if the username and password correspond to an existing Twitter account
     */
    public boolean isValidLogin(String username, String password) {
        Twitter twitter = new Twitter(username, password);
        return twitter.isValidLogin();
    }
}
