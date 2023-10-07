package com.demo._File;

public class FileDemo {
    public static void main(String[] args) {
//        	* File(String pathname)：根据一个路径得到File对象
//          * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
//          * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象(将一个父级路径封装成File类，可以方便的使用File里的功能和方法)


//        	* public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了，创建成功返回true,创建失败则放回false
//          * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了   单级文件夹
//	        * public boolean mkdirs():创建多级文件夹,如果父文件夹不存在，会帮你创建出来u876
//          注意事项:
//          在创建了File对象后,如果不调用对应的创建方法,文件或文件夹是创建无效的,必须配套使用才有效


//        	* public boolean renameTo(File dest):把文件重命名为指定的文件路径
//          * public boolean delete():删除文件或者文件夹
//          重命名注意事项
//          * 如果路径名相同，就是改名。
//	        * 如果路径名不同，就是改名并剪切。
//          删除注意事项：
//	        * Java中的删除不走回收站。
//	        * 要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹


//          判断功能
//          * public boolean isDirectory():判断是否是目录  文件夹
//	        * public boolean isFile():判断是否是文件
//          * public boolean exists():判断是否存在


//          获取功能
//          * public String getAbsolutePath()：获取绝对路径
//          * public String getPath():获取路径（获取构造方法中传入路径）
//	        * public String getName():获取名称（获取当前文件或者文件夹的名称）
//	        * public long length():获取长度。字节数
//          * public long lastModified():获取最后一次的修改时间，毫秒值
//          * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
//          * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File对象数
    }
}
