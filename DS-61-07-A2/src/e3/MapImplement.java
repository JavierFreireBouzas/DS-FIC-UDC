package e3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapImplement implements NetworkManager{

    Map<String, List<TopicOfInterest>> map = new LinkedHashMap<>();

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(!map.containsKey(user)){
            map.put(user, topicsOfInterest);
        }
        else
            throw new IllegalArgumentException();
    }

    public void removeUser(String user) {
        if(map.containsKey(user)){
            map.remove(user);
        }
        else
            throw new IllegalArgumentException();
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if(map.containsKey(user) && !map.get(user).contains(topicOfInterest)){
            map.get(user).add(topicOfInterest);
        }
        else
            throw new IllegalArgumentException();
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if(map.containsKey(user) && map.get(user).contains(topicOfInterest)){
            map.get(user).remove(topicOfInterest);
        }
        else
            throw new IllegalArgumentException();
    }

    public List<String> getUsers() {
        if(!map.isEmpty()){
            List<String> usersMap = new ArrayList<>(map.keySet());
            usersMap.sort(null);
            return usersMap;
        }
        else
            throw new IllegalArgumentException();
    }

    public List<TopicOfInterest> getInterests() {
        if(!map.isEmpty()){
            List<TopicOfInterest> interests = new ArrayList<>();

            for (List<TopicOfInterest> l : map.values()){
                for (TopicOfInterest topicOfInterest : l) {
                    if (!interests.contains(topicOfInterest))
                        interests.add(topicOfInterest);
                }
            }
            return interests;
        }
        else
            throw new IllegalArgumentException();
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
        if(!map.isEmpty() && map.containsKey(user)){
            return map.get(user);
        }
        else
            throw new IllegalArgumentException();
    }

}
