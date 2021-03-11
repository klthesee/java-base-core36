package com.zk;

import java.io.*;
import java.nio.channels.FileChannel;

public class Test12_FileCopy {

    public static void main(String[] args) throws IOException {
        File source = new File("F:\\h\\ubuntukylin-18.04.4-enhanced-amd64.iso");
        File desc = new File("F:\\ubuntukylin-18.04.4-enhanced-amd64.iso");
        long l = System.currentTimeMillis();
        copyFileByStream(source,desc);
//        copyFileByChannel(source,desc);
        System.out.println(System.currentTimeMillis() - l);
    }

    public static void copyFileByStream(File source, File dest) throws IOException {
        FileInputStream is = new FileInputStream(source);
        FileOutputStream outStream = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = is.read(buffer)) > 0) {
            outStream.write(buffer,0,length);
        }
    }


    public static void copyFileByStream2(File source, File dest) throws IOException {
        FileInputStream is = new FileInputStream(source);
        FileOutputStream outStream = new FileOutputStream(dest);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outStream);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = bufferedInputStream.read(buffer)) > 0) {
            bufferedOutputStream.write(buffer,0,length);
        }
    }

    public static void copyFileByChannel(File source, File dest) throws IOException {
        FileChannel isChannel = new FileInputStream(source).getChannel();
        FileChannel osChannel = new FileOutputStream(dest).getChannel();
        for (long count = isChannel.size(); count > 0; ) {
            long tranfered = isChannel.transferTo(isChannel.position(), count, osChannel);
            count -= tranfered;
        }

    }


}
