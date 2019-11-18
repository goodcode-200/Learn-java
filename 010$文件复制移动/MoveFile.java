import java.io.File;
class MoveFile
{
	public static void main(String[] agrs)
	{
		try
		{
			File file=new File("E:\\栅格1.png"); //源文件
			if (file.renameTo(new File("E:\\jjjj\\"+file.getName()))) //源文件移动至目标文件目录
			{
				System.out.println("File is moved successful!");//输出移动成功
			}
			else
			{
				System.out.println("File is failed to move !");//输出移动失败
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}