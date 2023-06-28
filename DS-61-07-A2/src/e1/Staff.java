package e1;

public class Staff extends Person
{
    public enum staffType{
        caretakers(160, 65),
        gamekeepers(180, 75);

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
        staffType(int salary, double rewardPerHorcrux)
        {
            this.salary = salary;
            this.rewardPerHorcrux = rewardPerHorcrux;
        }
    }
    public Staff(String firstName, String lastName, int age, double reward, int salary, int horcruxes, MemberType memberType, String houseOrSubject) {
        super(firstName, lastName, age, reward, salary, horcruxes, memberType, houseOrSubject);
    }
}
