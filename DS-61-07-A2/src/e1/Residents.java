package e1;

public class Residents extends Person
{
 public enum houses {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}
 public enum residentType {
  student(90),
  ghost(80);

  private final double rewardPerHorcrux;

  public double getRewardPerHorcrux() {
   return rewardPerHorcrux;
  }

  residentType(double rewardPerHorcrux) {
   this.rewardPerHorcrux = rewardPerHorcrux;
  }
  }

 public Residents(String firstName, String lastName, int age, double reward, int salary, int horcruxes, MemberType memberType, String houseOrSubject) {
  super(firstName, lastName, age, reward, salary, horcruxes, memberType, houseOrSubject);
 }
}
