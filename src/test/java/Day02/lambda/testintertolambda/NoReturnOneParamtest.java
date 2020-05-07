package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.NoReturnOneParam;

public class NoReturnOneParamtest {
    public static void main(String[] args) {
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("NoReturnOneParam param:" + a);
        };
        noReturnOneParam.method(6);
    }
}
