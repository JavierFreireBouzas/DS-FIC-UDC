package e1;

public abstract class Person
{
    private String firstName;
    private String lastName;
    private int age;
    private double reward;
    private int salary;
    private int horcruxes;
    public enum MemberType {Student, Ghost, Teacher, Caretaker, Gamekeeper}
    private MemberType memberType;
    private String houseOrSubject;

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public double getReward()
    {
        return reward;
    }
    public void setReward(double reward)
    {
        this.reward = reward;
    }
    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    public int getHorcruxes()
    {
        return horcruxes;
    }
    public void setHorcruxes(int horcruxes)
    {
        this.horcruxes = horcruxes;
    }
    public MemberType getMemberType()
    {
        return memberType;
    }
    public void setMemberType(MemberType memberType)
    {
        this.memberType = memberType;
    }
    public String getHouseOrSubject()
    {
        return houseOrSubject;
    }
    public void setHouseOrSubject(String houseOrSubject)
    {
        this.houseOrSubject = houseOrSubject;
    }

    public Person(String firstName, String lastName, int age, double reward, int salary, int horcruxes, MemberType memberType, String houseOrSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.reward = reward;
        this.salary = salary;
        this.horcruxes = horcruxes;
        this.memberType = memberType;
        this.houseOrSubject = houseOrSubject;
    }
}
