import java.io.File;
class MoveFile
{
	public static void main(String[] agrs)
	{
		try
		{
			File file=new File("E:\\դ��1.png"); //Դ�ļ�
			if (file.renameTo(new File("E:\\jjjj\\"+file.getName()))) //Դ�ļ��ƶ���Ŀ���ļ�Ŀ¼
			{
				System.out.println("File is moved successful!");//����ƶ��ɹ�
			}
			else
			{
				System.out.println("File is failed to move !");//����ƶ�ʧ��
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}