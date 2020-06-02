package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.Noreturnmulpara;

public class Noreturnmulparatest {
    public static void main(String[] args) {
        Noreturnmulpara noReturnMultiParam = (int a, int b) -> {
            System.out.println("NoReturnMultiParam param:" + "{" + a +"," + + b +"}");
        };
        noReturnMultiParam.method(6, 8);
    }
}

