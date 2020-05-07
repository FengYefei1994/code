package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.NoReturnNoParam;

public class NoReturnNoParamtest {
    public static void main(String[] args) {
        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();
    }
}
