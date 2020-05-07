package Day07.IO;

import java.io.*;

public class copyfile {
    private String oldpath1;
    private String newPath1;

    private static void filecopy(String oldpath, String newPath) {
        InputStream in = null;
        OutputStream out = null;
        InputStream in2 = null;
        OutputStream out2 = null;

        try {
            in = new FileInputStream(oldpath);
            out = new FileOutputStream(newPath);

            in2 = new BufferedInputStream(in);
            out2 = new BufferedOutputStream(out);

            int read = -1;
            while ((read = in2.read()) != -1) {
                out2.write(read);
            }
            out2.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out2.close();
                out.close();
                in2.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copy2(String name){
        File filea1 = new File(name);
        File[] filearr = filea1.listFiles();

        if (filearr != null) {
            for (int i = 0; i < filearr.length; ++i) {
                //URL为新文件或目录位置
                String URL = newPath1 + filearr[i].getAbsolutePath().substring(oldpath1.length());
                //System.out.println(URL);
                if(filearr[i].isDirectory()){
                    //如果是目录，递归创建
                    Createflies(URL);
                }else{
                    //文件就复制书写
                    copyfile.filecopy(filearr[i].getAbsolutePath(), URL);
                }
                if(filearr[i].isDirectory()){
                    copy2(filearr[i].getAbsolutePath());
                }
            }
        }
    }

    public static boolean Createflies(String name) {
        boolean flag = false;
        File file = new File(name);
        //创建目录
        if (file.mkdir() == true) {
            System.out.println("文件夹创建成功！");
            flag = true;
        } else {
            System.out.println("文件夹创建失败！");
            flag = false;
        }
        return flag;
    }

    public String getOldpath() {
        return oldpath1;
    }

    public void setOldpath(String oldpath) {
        this.oldpath1 = oldpath;
    }

    public String getNewPath() {
        return newPath1;
    }

    public void setNewPath(String newPath) {
        this.newPath1 = newPath;
    }
}
