package com.zk;


import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

public class MvMusic {

    public static void main(String[] args) throws IOException {
        mv();
    }

    public static void mv() throws IOException {
        CustomizableThreadFactory customizableThreadFactory = new CustomizableThreadFactory("cp jksjzl thread-pool");
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(1000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 100, 10, TimeUnit.MILLISECONDS,
                arrayBlockingQueue, customizableThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

        File file = new File("G:\\Java\\极客时间\\01-专栏课");
        File[] files = file.listFiles();
        int count = 0;
        int idx = 0;
        for (File file1 : files) {  //1
            File[] files1 = file1.listFiles();
            if (count == 1) {
                break;
            }

            for (File file2 : files1) { // 2
                File[] files2 = file2.listFiles();
                if (count == 1) {
                    break;
                }
                // 处理一个专栏
                idx++;
                System.out.println("正在处理第"+idx+"个专栏");
//                String topPath = file2.getPath();
//                String topPath = "E:\\tempio";
                String topPath = "E:\\tempio\\"+idx;
                File tempFile = new File(topPath);
//                if (!tempFile.exists()) {
//                    tempFile.mkdir();
//                }
                for (File file3 : files2) { // 3
                    File[] files3 = file3.listFiles();
                    if (files3 == null) {
                        continue;
                    }

                    for (File file4 : files3) { // 4
                        threadPoolExecutor.submit(()->{

                            String path = file4.getPath();
                            int i = path.lastIndexOf(".");
                            int i2 = path.lastIndexOf("\\");
                            String fileType = path.substring(i+1);
                            String fileName = path.substring(i2+1);
                            if (fileType.equals("m4a") || fileType.equals("mp3")) {
                                String fullFilePath  = topPath + "\\" + fileName;
                                File dest = new File(fullFilePath);
                                try {
                                    cpFile(file4, dest);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

//                        System.out.println(fullFilePath);
                    }
                }
//                count++;

            }
        }


    }

    public static void cpFile(File src, File dest) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        FileChannel isChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        for ( long size = isChannel.size() ; size>0 ; ) {
            long tranfered = isChannel.transferTo(isChannel.position(), size, outChannel);
            size -= tranfered;
        }
    }

    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    }
}
