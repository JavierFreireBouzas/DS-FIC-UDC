package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HogwartsTest {

    private School hogwarts, emptySchool;
    private final int LNULL = -1;

    @BeforeEach
    void setUp(){
        hogwarts = new School();
        emptySchool = new School();
        hogwarts.addPerson("Hermione","Granger", 20, 3, Person.MemberType.Student, "Gryffindor");
        hogwarts.addPerson("Bloody","Baron", 60, 1, Person.MemberType.Ghost, "Slytherin");
        hogwarts.addPerson("Rubeus","Hagrid", 50, 2, Person.MemberType.Gamekeeper, "NULL");
        hogwarts.addPerson("Minerva","MacGonagall", 75, 1, Person.MemberType.Teacher, "Transfiguration");
        hogwarts.addPerson("Severus","Snape", 46, 2, Person.MemberType.Teacher, "Defence");
        hogwarts.addPerson("Argus","Filch", 55, 0, Person.MemberType.Caretaker, "NULL");
    }

    @Test
    void testBasic(){
        assertEquals(0, emptySchool.members.size());
        assertEquals(6, hogwarts.members.size());
        assertEquals("Rubeus", hogwarts.members.get(2).getFirstName());
        assertEquals("Argus", hogwarts.members.get(5).getFirstName());
        assertEquals("Granger", hogwarts.members.get(0).getLastName());
        assertEquals("Baron", hogwarts.members.get(1).getLastName());
        assertEquals(60, hogwarts.members.get(1).getAge());
        assertEquals(46, hogwarts.members.get(4).getAge());
        assertEquals(1, hogwarts.members.get(3).getHorcruxes());
        assertEquals(0, hogwarts.members.get(5).getHorcruxes());
        assertEquals(Person.MemberType.Teacher, hogwarts.members.get(4).getMemberType());
        assertEquals(Person.MemberType.Ghost, hogwarts.members.get(1).getMemberType());
        assertEquals("Slytherin", hogwarts.members.get(1).getHouseOrSubject());
        assertEquals("NULL", hogwarts.members.get(5).getHouseOrSubject());
        assertEquals(500, hogwarts.members.get(4).getSalary());
        assertEquals(LNULL, hogwarts.members.get(0).getSalary());
        assertEquals(0.0, hogwarts.members.get(5).getReward());
        assertEquals(160.0, hogwarts.members.get(1).getReward());

    }

    @Test
    void testExceptions(){
        School h = new School();

        assertThrows(IllegalArgumentException.class, () -> h.addPerson("Pedro", "Castiñeiras", 18, 1, Person.MemberType.Ghost, "SLYTHERIN"));
        assertThrows(IllegalArgumentException.class, () -> h.addPerson("Alberto", "Melio", 50, 3, Person.MemberType.Teacher, "Maths"));
        assertThrows(IllegalArgumentException.class, () -> h.addPerson("Ana", "Mola", 12, 1, Person.MemberType.Student, "Real Madrid"));
    }

    @Test
    void countReward(){
        assertEquals(705.0, hogwarts.countReward());
        assertEquals(0.0, emptySchool.countReward());
    }

    @Test
    void countPayroll(){
        assertEquals(1240, hogwarts.countPayroll());
        assertEquals(0, emptySchool.countPayroll());
    }

    @Test
    void addPerson(){
        School newSchool = new School();

        newSchool.addPerson("Fernando","Jordan", 23, 2, Person.MemberType.Student, "Slytherin");
        newSchool.addPerson("Ramon","Rodriguez", 67, 4, Person.MemberType.Caretaker, "Null");
        newSchool.addPerson("Maria","Remedios", 93, 0, Person.MemberType.Teacher, "Defence");
        newSchool.addPerson("Pepe","Martinez", 24, 9, Person.MemberType.Gamekeeper, "Null");
        newSchool.addPerson("Armando","Perez", 104, 12, Person.MemberType.Ghost, "Gryffindor");
    }

    @Test
    void PrintRewards() {
        String strRewHogwarts = """
                Hermione Granger(Student of Gryffindor,3 horcruxes): 270.0 galleons
                Bloody Baron(Ghost of Slytherin,1 horcruxes): 160.0 galleons
                Rubeus Hagrid(Gamekeeper,2 horcruxes): 150.0 galleons
                Minerva MacGonagall(Teacher of Transfiguration,1 horcruxes): 50.0 galleons
                Severus Snape(Teacher of Defence,2 horcruxes): 75.0 galleons
                Argus Filch(Caretaker,0 horcruxes): 0.0 galleons
                The total reward for Hogwarts School is 705.0 galleons""";
        assertEquals(strRewHogwarts,hogwarts.printRewards());
        assertEquals("The total reward for Hogwarts School is 0.0 galleons",emptySchool.printRewards());

    }

    @Test
    void printSalaries() {
        String strSalHogwarts = """
                Rubeus Hagrid(Gamekeeper): 180 galleons
                Minerva MacGonagall(Teacher of Transfiguration): 400 galleons
                Severus Snape(Teacher of Defence): 500 galleons
                Argus Filch(Caretaker): 160 galleons
                The total payroll for Hogwarts School is 1240 galleons""";
        assertEquals(strSalHogwarts,hogwarts.printSalaries());
        assertEquals("The total payroll for Hogwarts School is 0 galleons",emptySchool.printSalaries());
    }
}

