package indi.chen.hellojava.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverEncoding {

    public static void main(String[] args) throws Exception {
        String srcDir = "D:\\WORKSPACE\\zjkjtSimilarity";
        List<String> files = new ArrayList<String>();
        fetchFileList(srcDir, files, ".xml");
        for (String fileName : files) {
            String oldCharset = get_charset(new File(fileName));
            convert(fileName, oldCharset, fileName, "UTF-8");
        }
    }

    public static void convert(String oldFile, String oldCharset, String newFlie, String newCharset) {
        BufferedReader bin;
        FileOutputStream fos;
        StringBuffer content = new StringBuffer();
        try {
            System.out.println(oldFile);
            bin = new BufferedReader(
                    new InputStreamReader(new FileInputStream(oldFile), oldCharset));
            String line = null;
            while ((line = bin.readLine()) != null) {
                content.append(line);
                content.append(System.getProperty("line.separator"));
            }
            bin.close();
            File dir = new File(newFlie.substring(0, newFlie.lastIndexOf("\\")));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            fos = new FileOutputStream(newFlie);
            Writer out = new OutputStreamWriter(fos, newCharset);
            out.write(content.toString());
            out.close();
            fos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fetchFileList(String strPath, List<String> filelist, final String regex) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        Pattern p = Pattern.compile(regex);
        if (files == null)
            return;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                fetchFileList(files[i].getAbsolutePath(), filelist, regex);
            } else {
                String strFileName = files[i].getAbsolutePath();
                Matcher m = p.matcher(strFileName);
                if (m.find()) {
                    filelist.add(strFileName);
                }
            }
        }
    }

    public static String get_charset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80
                            // - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }

}