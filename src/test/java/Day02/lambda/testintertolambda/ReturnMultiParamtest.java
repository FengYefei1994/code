package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.ReturnMultiParam;

public class ReturnMultiParamtest {
    public static void main(String[] args) {
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b +"}");
            return a+b;
        };

        int res3 = returnMultiParam.method(6, 8);
        System.out.println("return:" + res3);
    }
}
