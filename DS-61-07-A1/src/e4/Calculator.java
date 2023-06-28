package e4;
import java.util.ArrayList;

public class Calculator {

    public enum Operation {

        SUM("+"),
        SUBS("-"),
        MULT("*"),
        DIV("/");

        public String symbol;
        Operation(String symbol) {
            this.symbol = symbol;
        }

        private float selectOperation(float op1, float op2) {
            float result = 0;
            if(this == SUM)
                result = (op1 + op2);
            if(this == SUBS)
                result = (op1 - op2);
            if(this == MULT)
                result = (op1 * op2);
            if(this == DIV)
                result = (op1 / op2);
            return result;
        }
    }
    ArrayList<CalcState> state = new ArrayList <>();
    /**
     * Public constructor of the calculator .
     */
    public Calculator () {
    }
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations () {
        state.clear();
    }
    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values Operands of the new operation ( one or two operands ).
     * Uses the varargs feature .
     * https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation ( String operation , float ... values ) {

        Operation op;
        CalcState stateNew;

        if( operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            op = switch (operation) {
                case "+" -> Operation.SUM;
                case "-" -> Operation.SUBS;
                case "*" -> Operation.MULT;
                default -> Operation.DIV;
            };
            if(state.isEmpty())
                stateNew = new CalcState(op, values[0], values[1]);
            else
                stateNew = new CalcState(op, values[0], 0);
            state.add(stateNew);
        } else
            throw new IllegalArgumentException();
        }
    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     * ( division by zero )
     */
    public float executeOperations () {

        float result;
        int i = 0;

        if(state.get(i).sign() == Operation.DIV && state.get(i).value2() == 0) {
            cleanOperations();
            throw new ArithmeticException();
        }
        else {
            result  = (state.get(i).sign()).selectOperation(state.get(i).value1(), state.get(i).value2());
            CalcState currState;

            for (i = 1; i < state.size(); i++) {
                currState = state.get(i);
                if (currState.sign() == Operation.DIV && currState.value1() == 0) {
                    cleanOperations();
                    throw new ArithmeticException();
                }
                else
                    result = (currState.sign()).selectOperation(result, currState.value1());
            }
            cleanOperations();
            return result;
        }
    }
    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString () {

        StringBuilder strCalculator = new StringBuilder("[STATE:");
        int i;

        if(!state.isEmpty())  {
            CalcState firstElement = this.state.get(0);
            if (firstElement.sign() == Operation.SUM)
                strCalculator.append("[+]");
            else if (firstElement.sign() == Operation.SUBS)
                strCalculator.append("[-]");
            else if (firstElement.sign() == Operation.MULT)
                strCalculator.append("[*]");
            else if (firstElement.sign() == Operation.DIV)
                strCalculator.append("[/]");
            strCalculator.append(firstElement.value1()).append("_").append(firstElement.value2());
            for (i = 1; i < state.size(); i++) {
                CalcState thisElement = this.state.get(i);
                if (thisElement.sign() == Operation.SUM)
                    strCalculator.append("[+]");
                else if (thisElement.sign() == Operation.SUBS)
                    strCalculator.append("[-]");
                else if (thisElement.sign() == Operation.MULT)
                    strCalculator.append("[*]");
                else if (thisElement.sign() == Operation.DIV)
                    strCalculator.append("[/]");
                strCalculator.append(thisElement.value1());
            }
        }
        strCalculator.append("]");
        return strCalculator.toString();
    }
}