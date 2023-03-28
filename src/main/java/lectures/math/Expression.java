package lectures.math;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expression {
    private int a;
    private int b;
    private Operator operator;

    public enum Operator {
        plus("+"),
        minus("-"),
        multiply("*"),
        divide("/");

        private String humanReadableRepresentation;

        Operator(String humanReadableRepresentation) {
            this.humanReadableRepresentation = humanReadableRepresentation;
        }

        @Override
        public String toString() {
            return humanReadableRepresentation;
        }

        public char toChar() {
            return toString().charAt(0);
        }
    }
}
