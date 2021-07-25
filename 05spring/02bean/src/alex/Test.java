package alex;

public class Test {

    public static void main(String args[]) {
        //xml搜索装载
        new TestContext().run();
        //xml配置装载
        new TestContext2().run();
        //JAVA隐式配置装载
        new TestAuto().run();
        //JAVA显式配置装载
        new TestManual().run();
        //自动发现装载
        new TestWire().run();
    }
}
