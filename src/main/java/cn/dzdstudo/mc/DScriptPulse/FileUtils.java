package cn.dzdstudo.mc.DScriptPulse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils {

    /**
     * 解压指定的 ZIP 文件到目标位置
     *
     * @param zipFilePath ZIP 文件的路径
     * @param destDir 目标目录
     * @return 如果成功返回 true，失败返回 false
     */
    public static boolean unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // 创建目标目录（如果不存在）
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 创建输入流读取 ZIP 文件
        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;
            // 遍历 ZIP 文件中的每个条目
            while ((entry = zis.getNextEntry()) != null) {
                String filePath = destDir + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    // 如果条目是文件，则解压缩文件
                    extractFile(zis, filePath);
                } else {
                    // 如果条目是目录，则创建目录
                    File dirEntry = new File(filePath);
                    dirEntry.mkdirs();
                }
                zis.closeEntry();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 解压缩文件
     *
     * @param zis ZIP 输入流
     * @param filePath 目标文件路径
     * @throws IOException 如果发生 I/O 错误
     */
    private static void extractFile(ZipInputStream zis, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zis.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    /**
     * 获取指定文件夹内的所有文件
     *
     * @param dirPath 目标文件夹路径
     * @return 文件列表
     */
    public static List<File> listFiles(String dirPath) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(dirPath);

        // 检查目录是否存在且是一个目录
        if (dir.exists() && dir.isDirectory()) {
            // 获取目录中的所有文件和子目录
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // 如果是文件，则添加到结果列表中
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }

    /**
     * 删除指定的文件
     *
     * @param filePath 要删除的文件路径
     * @return 如果成功删除返回 true，失败返回 false
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        // 尝试删除文件
        return file.delete();
    }

    /**
     * 清空目录
     *
     * @param filePath 要清空的目录路径
     */
    public static void clearDirectory(String filePath) {
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    } else if (file.isDirectory()) {
                        clearDirectory(file.getAbsolutePath());
                        file.delete();
                    }
               }
           }
       }
   }

    /**
     * 读取指定文件的内容
     * @param filePath 文件路径
     * @return 文件内容
     * @throws IOException 如果读取文件时发生错误
     */
    public static String readFileContent(String filePath) throws IOException {
        // 3. 使用 Files.readAllBytes 方法读取文件内容
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);

        // 4. 将字节数组转换为字符串
        String fileContent = new String(fileBytes);

        // 5. 返回文件内容字符串
        return fileContent;
    }

    /**
     * 新建文件夹
     * @param path 文件夹路径
     */
    public static void newFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
