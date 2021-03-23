package com.zk;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Test12_ByteBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(80);
        String value = "netty 权威指南";
        try {
            byteBuffer.put(value.getBytes("utf-8")); // pos=bytes.length limit=pos cap
            byteBuffer.flip(); // 切换到读取模式 // pos=0 limit=之前的pos cap
            byte[] vByte = new byte[byteBuffer.remaining()];
            byteBuffer.get(vByte);
            String str = new String(vByte,"utf-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

/**
 * mark属性，这个属性是一个标识的作用，即记录当前position的位置，
 * 在后续如果调用reset()或者flip()方法时，ByteBuffer的position就会被重置到mark所记录的位置。
 *
 * 对于rewind()方法，它的主要作用在于将当前的position重置为0，并且mark重置为-1，而且无论mark是否进行过标记。
 */
