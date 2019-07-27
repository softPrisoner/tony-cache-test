public class Test {
    //ARM 1.7+数字分隔符
    public static void main(String[] args) {
//        分不清是多少位的时候
//          可以通过加下划线来区分位数
//        比如每三个数字或者四个数字加一个下划线
        System.out.println((int) 1000_____________________________________________________1000);
        System.out.println(10_000_10_00.5);
        System.out.println(10_000_10_00);
    }
}