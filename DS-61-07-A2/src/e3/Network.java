package e3;

import java.util.ArrayList;
import java.util.List;

public class Network{

    NetworkManager implementation;

    /*
    * Adding and removing users from the network.
    */

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest, NetworkManager implementation) {
        implementation.addUser(user, topicsOfInterest);
    }

    public void removeUser(String user, NetworkManager implementation) {
        implementation.removeUser(user);
    }

    /*
    * Modifying the topics of interest for a given user.
    */

    public void addInterest(String user, TopicOfInterest topicOfInterest, NetworkManager implementation) {
        implementation.addInterest(user, topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest, NetworkManager implementation) {
        implementation.removeInterest(user, topicOfInterest);
    }

    /*
     * Obtaining a list of all the users in the network.
     */

    public List<String> getUsers(NetworkManager implementation) {
        return implementation.getUsers();
    }

    /*
    * Obtaining a list of all the topics that are of interest to the users in the network.
    */

    public List<TopicOfInterest> getInterests(NetworkManager implementation) {
        return implementation.getInterests();
    }

    /*
    * Obtaining the topics of interest for a given user.
    */

    public List<TopicOfInterest> getInterestsUser(String user, NetworkManager implementation) {
        return implementation.getInterestsUser(user);
    }

    public Network(NetworkManager implementation) {
        this.implementation = implementation;
    }

    public List<String> sortTopics(List<TopicOfInterest> topics){
        if(!topics.isEmpty()){
            List<String> sorted = new ArrayList<>();

            for(int i = 0; i < topics.size(); i++ ){
                sorted.add(i,topics.get(i).topic);
            }
            sorted.sort(null);
            return sorted;
        }
        else
            throw new IllegalArgumentException();
    }

    /*
    * Finding all the users that are interested in a given topic.
    */

    public List<String> findUsers(TopicOfInterest topic, NetworkManager implementation){
        List<String> allUsers = getUsers(implementation);
            List<String> users = new ArrayList<>();
            List<List<TopicOfInterest>> topics = new ArrayList<>();
            for (String allUser : allUsers) {
                topics.add(getInterestsUser(allUser, implementation));
            }
            for(int i = 0; i < allUsers.size(); i++){
                if(topics.get(i).contains(topic)){
                    users.add(allUsers.get(i));
                }
            }
            return users;
    }

    /*
    * Finding the topics of interest that are shared by two users
    */

    public List<TopicOfInterest> commonTopics(String user1, String user2, NetworkManager implementation){
        List<String> allUsers = getUsers(implementation);
        if(allUsers.contains(user1) && allUsers.contains(user2)){
            List<TopicOfInterest> topicsUser1 = getInterestsUser(user1, implementation);
            List<TopicOfInterest> topicsUser2 = getInterestsUser(user2, implementation);
            List<TopicOfInterest> common = new ArrayList<>();
            for (TopicOfInterest topicOfInterest : topicsUser1) {
                if (topicsUser2.contains(topicOfInterest))
                    common.add(topicOfInterest);
            }
            return common;
        }else
            throw new IllegalArgumentException();
    }

    /*
    * Viewing the information of all the users in the network, that is, their user
    * names together with the corresponding list of topics of interest.
    */

    public String infoUsers(NetworkManager implementation){
        List<String> allUsers = getUsers(implementation);
        StringBuilder strInfo = new StringBuilder();
            for (String allUser : allUsers) {
                strInfo.append(allUser).append(": ").append(getInterestsUser(allUser, implementation).toString()).append("\n");
            }
            return strInfo.toString();

    }
}