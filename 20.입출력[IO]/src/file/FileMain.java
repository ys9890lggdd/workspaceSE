package file;

import java.io.File;

public class FileMain {

	public static void main(String[] args)throws Exception {
		/*
		 * 현재파일경로[기준경로]
		 *    eclise--> C:\2022-11-JAVA-DEVELOPER\workspaceSE\20.입출력[IO]
		 * 
		 * 상대경로(relative)경로
		 * 		현재경로를 기준으로 경로를기술
		 * 		sample\a.txt
		 * 		.\sample\a.txt
		 * 절대경로(absolute)경로
		 *      C:,D: 드라이브를 기준으로 경로기술
		 * 
		 */
		System.out.println(File.separatorChar);
		File file1=new File("데미안.txt");
		File file2=new File("sample\\car1.jpg");
		File file3=new File("sample/subSample/00.VariableDeclare.txt");
		File file4=new File("C:\\2022-11-JAVA-DEVELOPER\\workspaceSE\\20.입출력[IO]\\sample\\subSample2\\19.Overriding[재정의].txt");
		
		System.out.println("---------1.file path[relative]------");
		System.out.println(file1.getPath());
		System.out.println(file2.getPath());
		System.out.println(file3.getPath());
		System.out.println(file4.getPath());
		System.out.println("---------2.file absolute path------");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file4.getAbsolutePath());
		System.out.println("---------3.file name------");
		System.out.println(file1.getName());
		System.out.println(file2.getName());
		System.out.println(file3.getName());
		System.out.println(file4.getName());
		System.out.println("---------4.file parent------");
		System.out.println(file1.getParent());
		System.out.println(file2.getParent());
		System.out.println(file3.getParent());
		System.out.println(file4.getParent());
		
		File dir1=new File("sample");
		File dir2=new File("sample/subSample1");
		File dir3=new File("sample","subSample2");
		System.out.println("------5.isDirectory,isFile-----");
		System.out.println(dir1.isDirectory());
		System.out.println(dir2.isDirectory());
		System.out.println(dir3.isDirectory());
		System.out.println(dir1.isFile());
		System.out.println(dir2.isFile());
		System.out.println(dir3.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());
		System.out.println(file3.isDirectory());
		System.out.println(file4.isDirectory());
		System.out.println("-----6.디렉토리안에 파일(디렉토리)목록(String[])-------");
		String[] fileNameList = dir1.list();
		for (String fileName : fileNameList) {
			System.out.println(fileName);
		}
		System.out.println("-----7.디렉토리안에 파일(디렉토리)목록(File[])-------");
		File[] fileList=dir1.listFiles();
		for (File file : fileList) {
			if(file.isDirectory()) {
				//Directory
				System.out.println("\tD:"+file.getName());
				File[] subFileList=file.listFiles();
				for (File subFile : subFileList) {
					System.out.println("\t\t└ "+subFile.getName());
				}
			}else {
				//File
				System.out.println("\tF:"+file.getName());
			}
		}
		System.out.println("-----8. root directory목록------");
		File[] rootDriveFileList=File.listRoots();
		for (File file : rootDriveFileList) {
			System.out.println(file.getPath());
		}
		System.out.println("c:/ 파일목록출력");
		File cDrive = rootDriveFileList[0];
		File[] cDriveFileList = cDrive.listFiles();
		for (File file : cDriveFileList) {
			System.out.println(file.getName());
		}
		System.out.println("----------10.디렉토리생성-------");
		File newDir1=new File("newDir1");
		File newDir2=new File("newDir2");
		File newDir3=new File("sample","subSample3");
		File newDir4=new File("C:/2022-11-JAVA-DEVELOPER/newDir4");
		
		System.out.println(">> newDir1 디렉토리 존재여부:"+newDir1.exists());
		System.out.println(">> newDir2 디렉토리 존재여부:"+newDir2.exists());
		System.out.println(">> newDir3 디렉토리 존재여부:"+newDir3.exists());
		System.out.println(">> newDir4 디렉토리 존재여부:"+newDir4.exists());
		
		System.out.println(">> newDir1 디렉토리생성:"+newDir1.mkdir());
		System.out.println(">> newDir2 디렉토리생성:"+newDir2.mkdir());
		System.out.println(">> newDir3 디렉토리생성:"+newDir3.mkdir());
		System.out.println(">> newDir4 디렉토리생성:"+newDir4.mkdir());
		
		System.out.println("------11.디렉토리 이름변경--------");
		newDir2.renameTo(new File("renameDir2"));
		System.out.println("------12.디렉토리 삭제--------");
		System.out.println("newDir3삭제여부:"+newDir3.delete());
		System.out.println("-------13.파일생성,삭제,이름변경-----");
		File newFile1=new File("newDir1","newFile1.txt");
		File newFile2=new File("newDir1","newFile2.txt");
		File newFile3=new File("C:\\2022-11-JAVA-DEVELOPER\\newDir4\\newFile3.txt");
		System.out.println("newFile1 생성여부:"+newFile1.createNewFile());
		System.out.println("newFile2 생성여부:"+newFile2.createNewFile());
		System.out.println("newFile3 생성여부:"+newFile3.createNewFile());
		
		System.out.println("newFile1삭제여부:"+newFile1.delete());
		
		
		
		
		
	}

}


     










