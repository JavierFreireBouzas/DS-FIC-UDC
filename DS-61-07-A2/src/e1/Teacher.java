package e1;

public class Teacher extends Person
{
    public enum subject {
        History(200, 50),
        Transfiguration(400, 50),
        Defence(500, 37.5),
        Herbology(250, 50),
        Potions(350, 50);

        private final int salary;
        private final double rewardPerHorcrux;

        public int getSalary()
        {
            return salary;
        }
        public double getRewardPerHorcrux()
        {
            return rewardPerHorcrux;
        }
        subject(int salary, double rewardPerHorcrux)
        {
            this.salary = salary;
            this.rewardPerHorcrux = rewardPerHorcrux;
        }
    }
    public Teacher(String firstName, String lastName, int age, double reward, int salary, int horcruxes, MemberType memberType, String houseOrSubject) {
        super(firstName, lastName, age, reward, salary, horcruxes, memberType, houseOrSubject);
    }
}
