package e3;

import java.util.ArrayList;
import java.util.List;

public class TableImplement implements NetworkManager{

    List<String> names = new ArrayList<>();
    List<List<TopicOfInterest>> table = new ArrayList<>();

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(!names.contains(user)){
            names.add(user);
            table.add(topicsOfInterest);
        }
        else
            throw new IllegalArgumentException();
    }

    public void removeUser(String user) {
        if(names.contains(user)){
            int index;
            index = names.indexOf(user);
            table.remove(index);
            names.remove(user);
        }
        else
            throw new IllegalArgumentException();
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if(names.contains(user)){
            int index;
            index = names.indexOf(user);
            if(!table.get(index).contains(topicOfInterest)){
                table.get(index).add(topicOfInterest);
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if(names.contains(user)){
            int index;
            index = names.indexOf(user);
            if(table.get(index).contains(topicOfInterest)){
                table.get(index).remove(topicOfInterest);
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }

    public List<String> getUsers() {
        if(!names.isEmpty()) {
            List<String> nameReturn = new ArrayList<>(names);
            nameReturn.sort(null);
            return nameReturn;
        }else
            throw new IllegalArgumentException();
    }

    public List<TopicOfInterest> getInterests() {
        if(!names.isEmpty()) {
            List<TopicOfInterest> topics = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < table.get(i).size(); j++) {
                    if (!topics.contains(table.get(i).get(j))) {
                        topics.add(table.get(i).get(j));
                    }
                }
            }
            return topics;
        }else
            throw new IllegalArgumentException();
    }
    public List<TopicOfInterest> getInterestsUser(String user) {
        if(names.contains(user)){
            int index;
            index = names.indexOf(user);
            return table.get(index);
        }
        else
            throw new IllegalArgumentException();
    }

}