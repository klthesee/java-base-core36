package com.zk.test44myenum;

public enum Weather {
    Sunny(1,"晴天"); // 调用构造函数

    private int value;
    private String label;

    Weather(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static void main(String[] args) {
        Weather sunny = Weather.Sunny;
        System.out.println(sunny.label);
    }


}

//public class Weather{
//    private int value;
//    private String label;
//
//    public Weather(int value, String label) {
//        this.value = value;
//        this.label = label;
//    }
//
//    final static Weather Sunny;
//
//    static {
//        Sunny = new Weather(1, "晴天");
//    }
//
//    public static void main(String[] args) {
//        Weather sunny = Weather.Sunny;
//        System.out.println(sunny.label);
//    }
//}




