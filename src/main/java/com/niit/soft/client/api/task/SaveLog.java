package com.niit.soft.client.api.task;


import java.io.*;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/14 19:34
 * @Version 1.0
 **/
//注：如果这个类不加@EnableScheduling 注解，就需要在启动主类加上
//@Component
public class SaveLog {
//    @Scheduled(cron = "0 0 * * * ?")

    /**
     * 这个类先不要动
     * @param args
     * @throws IOException
     */
//    @Scheduled(cron = "0 * * * * ?")
//    private void saveLog() throws IOException {
    public static void main(String[] args) throws IOException {

        System.out.println("-----开始保存日志------");
        BufferedReader bufferedReader = null;
        File file = new File("D:\\logs");
        String[] fileList = file.list();
        for (int i = 0; i < fileList.length; i++) {
            File readFile = new File("D:\\logs" + "\\" + fileList[i]);
            bufferedReader = new BufferedReader(new FileReader(readFile));
            String tempLine = null;
            if (readFile.getName().startsWith("info")) {
                System.out.println("-----开始保存info日志------");
                while ((tempLine = bufferedReader.readLine()) != null) {
                    //判断标志符
                    if (tempLine.endsWith("**1**")) {
                        System.out.println(tempLine);
                    }
                }
            } else if (readFile.getName().startsWith("error")) {
                System.out.println("-----开始保存error日志------");
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        System.out.println("-----保存日志完毕------");
    }
}
