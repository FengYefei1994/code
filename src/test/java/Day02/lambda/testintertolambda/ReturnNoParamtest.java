package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.ReturnNoParam;

public class ReturnNoParamtest {
    public static void main(String[] args) {
        ReturnNoParam returnNoParam = () -> {
            System.out.print("ReturnNoParam");
            return 1;
        };

        int res = returnNoParam.method();
        System.out.println("return:" + res);
    }
}
