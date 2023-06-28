package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    MapImplement mapImplement = new MapImplement();
    TableImplement tableImplement = new TableImplement();
    Network testNetwork = new Network(mapImplement);
    Network testNetwork2 = new Network(tableImplement);
    List<TopicOfInterest> topics1 = new ArrayList<>();
    List<TopicOfInterest> topics2 = new ArrayList<>();
    List<TopicOfInterest> topics3 = new ArrayList<>();

    TopicOfInterest football = new TopicOfInterest("Football");
    TopicOfInterest films = new TopicOfInterest("Films");
    TopicOfInterest fashion = new TopicOfInterest("Fashion");
    TopicOfInterest music = new TopicOfInterest("Music");
    TopicOfInterest basket = new TopicOfInterest("Basket");
    TopicOfInterest tennis = new TopicOfInterest("Tennis");
    TopicOfInterest opera = new TopicOfInterest("Opera");
    TopicOfInterest theatre = new TopicOfInterest("Theatre");

    @BeforeEach
    void setUp() {
        topics1.add(0, football);
        topics1.add(1, films);
        topics1.add(2, fashion);
        topics1.add(3, music);
        topics2.add(0, basket);
        topics2.add(1, football);
        topics2.add(2, tennis);
        topics3.add(0, films);
        topics3.add(1, music);
        topics3.add(2, opera);
        topics3.add(3, fashion);
        topics3.add(4, theatre);
    }
    @Test
    void MapTest() {
        testNetwork.addUser("Pedro", topics1, mapImplement);
        testNetwork.addUser("Ana", topics2, mapImplement);
        testNetwork.addUser("Antonio", topics3, mapImplement);

        testNetwork.removeUser("Ana", mapImplement);

        TopicOfInterest chess = new TopicOfInterest("Chess");
        TopicOfInterest waterpolo = new TopicOfInterest("Waterpolo");
        testNetwork.addInterest("Antonio", chess, mapImplement);
        testNetwork.addInterest("Antonio", waterpolo, mapImplement);

        testNetwork.removeInterest("Pedro", football, mapImplement);
        testNetwork.removeInterest("Antonio", opera, mapImplement);

        List<String> usersTest = new ArrayList<>();
        usersTest.add("Antonio");
        usersTest.add("Pedro");
        usersTest.sort(null);
        assertEquals(usersTest, testNetwork.getUsers(mapImplement));

        List<TopicOfInterest> topicsTest = new ArrayList<>();
        topicsTest.add(films);
        topicsTest.add(fashion);
        topicsTest.add(music);
        topicsTest.add(waterpolo);
        topicsTest.add(theatre);
        topicsTest.add(chess);
        assertEquals(testNetwork.sortTopics(topicsTest), testNetwork.sortTopics(testNetwork.getInterests(mapImplement)));

        List<TopicOfInterest> topicsTest2 = new ArrayList<>();
        topicsTest2.add(films);
        topicsTest2.add(fashion);
        topicsTest2.add(music);
        assertEquals(testNetwork.sortTopics(topicsTest2), testNetwork.sortTopics(testNetwork.getInterestsUser("Pedro", mapImplement)));

        String testInfoUsers = """
                Antonio: [Films, Music, Fashion, Theatre, Chess, Waterpolo]
                Pedro: [Films, Fashion, Music]
                """;
        assertEquals(testInfoUsers,testNetwork.infoUsers(mapImplement));

        List<String> commonUsers = new ArrayList<>();
        commonUsers.add("Antonio");
        commonUsers.add("Pedro");
        assertEquals(commonUsers, testNetwork.findUsers(films, mapImplement));
        assertNotEquals(commonUsers, testNetwork.findUsers(chess, mapImplement));

        List<TopicOfInterest> commonTopics = new ArrayList<>();
        commonTopics.add(films);
        commonTopics.add(fashion);
        commonTopics.add(music);
        testNetwork.addUser("Paco", topics2, mapImplement);
        assertEquals(commonTopics, testNetwork.commonTopics("Pedro", "Antonio", mapImplement));
        assertNotEquals(commonTopics, testNetwork.commonTopics("Pedro", "Paco", mapImplement));

    }
    @Test
    void exceptionsMapTest() {
        MapImplement mapImplementExceptions = new MapImplement();
        Network n = new Network(mapImplementExceptions);
        MapImplement mapImplementEmpty = new MapImplement();
        Network emptyNetwork = new Network(mapImplementExceptions);
        n.addUser("Juan", topics1, mapImplementExceptions);
        List<TopicOfInterest> topicsEmpty = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> n.addUser("Juan", topics2, mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeUser("Maria", mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.addInterest("Carlos", films, mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.addInterest("Juan", football, mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeInterest("Carlos", films, mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeInterest("Juan", opera, mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getUsers(mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getInterests(mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> n.getInterestsUser("John", mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getInterestsUser("John", mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.infoUsers(mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.findUsers(opera, mapImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> n.commonTopics("Carlos", "Maria", mapImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.sortTopics(topicsEmpty));

    }
    @Test
    void TableTest(){
        testNetwork2.addUser("Pedro", topics1, tableImplement);
        testNetwork2.addUser("Ana", topics2, tableImplement);
        testNetwork2.addUser("Antonio", topics3, tableImplement);

        testNetwork2.removeUser("Ana", tableImplement);

        TopicOfInterest chess = new TopicOfInterest("Chess");
        TopicOfInterest waterpolo = new TopicOfInterest("Waterpolo");
        testNetwork2.addInterest("Antonio", chess, tableImplement);
        testNetwork2.addInterest("Antonio", waterpolo, tableImplement);

        testNetwork2.removeInterest("Pedro", football, tableImplement);
        testNetwork2.removeInterest("Antonio", opera, tableImplement);

        List<String> usersTest = new ArrayList<>();
        usersTest.add("Antonio");
        usersTest.add("Pedro");
        usersTest.sort(null);
        assertEquals(usersTest, testNetwork2.getUsers(tableImplement));

        List<TopicOfInterest> topicsTest = new ArrayList<>();
        topicsTest.add(films);
        topicsTest.add(fashion);
        topicsTest.add(music);
        topicsTest.add(waterpolo);
        topicsTest.add(theatre);
        topicsTest.add(chess);
        assertEquals(testNetwork2.sortTopics(topicsTest), testNetwork2.sortTopics(testNetwork2.getInterests(tableImplement)));

        List<TopicOfInterest> topicsTest2 = new ArrayList<>();
        topicsTest2.add(films);
        topicsTest2.add(fashion);
        topicsTest2.add(music);
        assertEquals(testNetwork2.sortTopics(topicsTest2), testNetwork2.sortTopics(testNetwork2.getInterestsUser("Pedro", tableImplement)));

        String testInfoUsers = """
                Antonio: [Films, Music, Fashion, Theatre, Chess, Waterpolo]
                Pedro: [Films, Fashion, Music]
                """;
        assertEquals(testInfoUsers,testNetwork2.infoUsers(tableImplement));

        List<String> commonUsers = new ArrayList<>();
        commonUsers.add("Antonio");
        commonUsers.add("Pedro");
        assertEquals(commonUsers, testNetwork2.findUsers(films, tableImplement));
        assertNotEquals(commonUsers, testNetwork2.findUsers(chess, tableImplement));

        List<TopicOfInterest> commonTopics = new ArrayList<>();
        commonTopics.add(films);
        commonTopics.add(fashion);
        commonTopics.add(music);
        testNetwork2.addUser("Paco", topics2, tableImplement);
        assertEquals(commonTopics, testNetwork2.commonTopics("Pedro", "Antonio", tableImplement));
        assertNotEquals(commonTopics, testNetwork2.commonTopics("Pedro", "Paco", tableImplement));
    }

    @Test
    void exceptionsTableTest() {
        TableImplement tableImplementExceptions = new TableImplement();
        Network n = new Network(tableImplementExceptions);
        TableImplement tableImplementEmpty = new TableImplement();
        Network emptyNetwork = new Network(tableImplementExceptions);
        n.addUser("Juan", topics1, tableImplementExceptions);
        List<TopicOfInterest> topicsEmpty = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> n.addUser("Juan", topics2, tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeUser("Maria", tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.addInterest("Carlos", films, tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.addInterest("Juan", football, tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeInterest("Carlos", films, tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> n.removeInterest("Juan", opera, tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getUsers(tableImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getInterests(tableImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> n.getInterestsUser("John", tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.getInterestsUser("John", tableImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.infoUsers(tableImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.findUsers(opera, tableImplementEmpty));
        assertThrows(IllegalArgumentException.class, () -> n.commonTopics("Carlos", "Maria", tableImplementExceptions));
        assertThrows(IllegalArgumentException.class, () -> emptyNetwork.sortTopics(topicsEmpty));
    }
}



