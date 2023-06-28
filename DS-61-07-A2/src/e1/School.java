package e1;

import java.util.ArrayList;

public class School {

    ArrayList<Person> members = new ArrayList<>();

    public void addPerson(String firstname, String lastname, int age, int horcruxes, Person.MemberType memberType, String houseOrSubject)
    {
        int LNULL = -1;
        int salary = LNULL;
        String houseSubject = "NULL";
        double reward = LNULL;
        Person newPerson;

        switch (memberType) {
            case Student -> {
                for (Residents.houses i : Residents.houses.values()) {
                    if (i.name().equals(houseOrSubject))
                        houseSubject = i.name();
                }
                if (houseSubject.equals("NULL"))
                    throw new IllegalArgumentException();
                reward = horcruxes * Residents.residentType.student.getRewardPerHorcrux();
                if (houseSubject.equals("Slytherin"))
                    reward = reward * 2;
                newPerson = new Residents(firstname, lastname, age, reward, salary, horcruxes, memberType, houseOrSubject);
                members.add(newPerson);
            }
            case Ghost -> {
                for (Residents.houses i : Residents.houses.values()) {
                    if (i.name().equals(houseOrSubject))
                        houseSubject = i.name();
                }
                if (houseSubject.equals("NULL"))
                    throw new IllegalArgumentException();
                reward = horcruxes * Residents.residentType.ghost.getRewardPerHorcrux();
                if (houseSubject.equals("Slytherin"))
                    reward = reward * 2;
                newPerson = new Residents(firstname, lastname, age, reward, salary, horcruxes, memberType, houseOrSubject);
                members.add(newPerson);
            }
            case Teacher -> {
                for (Teacher.subject i : Teacher.subject.values()) {
                    if (i.name().equals(houseOrSubject)) {
                        salary = Teacher.subject.valueOf(houseOrSubject).getSalary();
                        houseSubject = i.name();
                        reward = horcruxes * Teacher.subject.valueOf(houseOrSubject).getRewardPerHorcrux();
                    }
                }
                if (salary == LNULL || houseSubject.equals("NULL"))
                    throw new IllegalArgumentException();
                newPerson = new Teacher(firstname, lastname, age, reward, salary, horcruxes, memberType, houseOrSubject);
                members.add(newPerson);
            }
            case Caretaker -> {
                salary = Staff.staffType.caretakers.getSalary();
                reward = horcruxes * Staff.staffType.caretakers.getRewardPerHorcrux();
                newPerson = new Staff(firstname, lastname, age, reward, salary, horcruxes, memberType,"NULL");
                members.add(newPerson);
            }
            case Gamekeeper -> {
                salary = Staff.staffType.gamekeepers.getSalary();
                reward = horcruxes * Staff.staffType.gamekeepers.getRewardPerHorcrux();
                newPerson = new Staff(firstname, lastname, age, reward, salary, horcruxes, memberType,"NULL");
                members.add(newPerson);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public double countReward()
    {
        double totalReward = 0;
        for (Person i : members) {
            totalReward += i.getReward();
        }
        return totalReward;
    }

    public int countPayroll()
    {
        int payroll = 0;
        for (Person i : members) {
            if((i.getMemberType() != Person.MemberType.Student) && (i.getMemberType() != Person.MemberType.Ghost))
                payroll += i.getSalary();
        }
        return payroll;
    }

    public String printRewards()
    {
        StringBuilder strRewards = new StringBuilder();
        for (Person i : members) {
            if((i.getMemberType() != Person.MemberType.Caretaker) && (i.getMemberType() != Person.MemberType.Gamekeeper))
                strRewards.append(i.getFirstName()).append(" ").append(i.getLastName()).append("(").append(i.getMemberType()).append(" of ").append(i.getHouseOrSubject()).append(",").append(i.getHorcruxes()).append(" horcruxes): ").append(i.getReward()).append(" galleons");
            else
            strRewards.append(i.getFirstName()).append(" ").append(i.getLastName()).append("(").append(i.getMemberType()).append(",").append(i.getHorcruxes()).append(" horcruxes): ").append(i.getReward()).append(" galleons");
            strRewards.append("\n");
        }
        strRewards.append("The total reward for Hogwarts School is ").append(countReward()).append(" galleons");

        return strRewards.toString();
    }

    public String printSalaries()
    {
        StringBuilder strSalaries = new StringBuilder();
        for (Person i : members) {
            if(i.getMemberType() == Person.MemberType.Teacher){
                strSalaries.append(i.getFirstName()).append(" ").append(i.getLastName()).append("(").append(i.getMemberType()).append(" of ").append(i.getHouseOrSubject()).append("): ").append(i.getSalary()).append(" galleons");
                strSalaries.append("\n");
            }
            else if((i.getMemberType() != Person.MemberType.Student) && (i.getMemberType() != Person.MemberType.Ghost)) {
                strSalaries.append(i.getFirstName()).append(" ").append(i.getLastName()).append("(").append(i.getMemberType()).append("): ").append(i.getSalary()).append(" galleons");
                strSalaries.append("\n");
            }
        }
        strSalaries.append("The total payroll for Hogwarts School is ").append(countPayroll()).append(" galleons");

        return strSalaries.toString();
    }
}
