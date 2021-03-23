package com.zk;

public class Test07_Integer {

    public static void main(String[] args) {

    }
    /**
     * 不可能所有的缓存页都刷回磁盘的，因为有的缓存页可能是因为查询的时候被读取到Buffer Pool里去的，可能根本没修改过！
     * 所以数据库在这里引入了另外一个跟free链表类似的flush链表，这个flush链表本质也是通过缓存页的描述数据块中的两个指
     * 针，让被修改过的缓存页的描述数据块，组成一个双向链表。
     * 使用MAT分析对象大小
     *
     */

}
