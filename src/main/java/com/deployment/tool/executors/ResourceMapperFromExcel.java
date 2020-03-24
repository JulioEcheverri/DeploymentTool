package com.deployment.tool.executors;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.deployment.tool.interfaces.IResourceMapper;

public class ResourceMapperFromExcel implements IResourceMapper {
	
	private String filePath;
	private ArrayList<String> packageFilesystemPaths;
	private ArrayList<String> fileNameList;
	private ArrayList<String> cartridgeNameList;
	private ArrayList<String> actionTypeList;
	private XSSFWorkbook workBook;
	private InputStream ExcelFileToRead;
	
	public ResourceMapperFromExcel(String filePath)
	{
		this.filePath = filePath;
	}
	
	public void setDataStructures(ArrayList<String> packageFilesystemPaths, ArrayList<String> fileNameList, ArrayList<String> actionTypeList, ArrayList<String> cartridgeNameList)
	{
		this.packageFilesystemPaths = packageFilesystemPaths; 
		this.fileNameList = fileNameList;
		this.actionTypeList = actionTypeList;
		this.cartridgeNameList = cartridgeNameList;
	}
	
	public boolean openFile()
	{
		try
		{
			ExcelFileToRead = new FileInputStream(this.filePath);
			workBook = new XSSFWorkbook(ExcelFileToRead);
		}catch (Exception e)
		{
			System.out.println("Failed opening excel file");
			return false;
		}
		return true;
	}
	
	public boolean importImpactedResources()
	{
		System.out.println("Importando lista de recursos impactados desde Excel...");
		readXLSXFile();
		/*for(int i = 0; i < fileNameList.size(); i++)
		{
			System.out.println(packageFilesystemPaths.get(i));
			System.out.println(fileNameList.get(i));
			System.out.println(cartridgeNameList.get(i));
			System.out.println(actionTypeList.get(i));
		}*/
			
		return true;
	}

	public void readXLSXFile()
	{	
		XSSFSheet sheet = workBook.getSheet("Recursos");
		XSSFRow row;
		XSSFCell cellFilePath;
		XSSFCell cellCartridgeName;
		XSSFCell cellActionType;
		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			cellFilePath = row.getCell(0);
			cellCartridgeName = row.getCell(1);
			cellActionType = row.getCell(2);
			
			if(cellFilePath.getCellType() == CellType.STRING)
			{
				String fullPath = cellFilePath.getStringCellValue();
				String actionType = cellActionType.getStringCellValue();
				String cartridgeName = cellCartridgeName.getStringCellValue();
				
				if(fullPath.equals("Objeto"))
					continue;
				
				packageFilesystemPaths.add(fullPath.substring(0, fullPath.lastIndexOf("/")));
				fileNameList.add(fullPath.substring(fullPath.lastIndexOf("/") + 1, fullPath.length()));
				cartridgeNameList.add(cartridgeName);
				actionTypeList.add(actionType);
			}
		}
		try
		{
			workBook.close();
		}
		catch(Exception e)
		{
			System.out.println("Error cerrando el libro de excel");
		}
	}
}
