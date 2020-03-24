package com.deployment.tool.executors;

import java.util.ArrayList;

import com.deployment.tool.interfaces.IPackageGenerator;
import com.deployment.tool.interfaces.IResourceMapper;

public class PackageGenerator implements IPackageGenerator
{
	private IResourceMapper resourceMapper;
	private ArrayList<String> packageFilesystemPaths;
	private ArrayList<String> fileNameList;
	private ArrayList<String> cartridgeNameList;
	private ArrayList<String> actionTypeList;
	
	public PackageGenerator()
	{
		packageFilesystemPaths = new ArrayList<String>();
		this.fileNameList = new ArrayList<String>();
		this.cartridgeNameList = new ArrayList<String>();
		this.actionTypeList = new ArrayList<String>();
	}
	
	public void setResourceMapper(IResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
		this.resourceMapper.setDataStructures(packageFilesystemPaths, fileNameList, actionTypeList, cartridgeNameList);
	}

	@Override
	public boolean importImpactedResources() {
		if(!resourceMapper.openFile())
			return false;
		resourceMapper.importImpactedResources();
		return true;
	}

	@Override
	public boolean generateFilesystemStructure() {
		System.out.println("Generando la siguiente estructura de carpetas...");
		for(String path : packageFilesystemPaths)
			System.out.println(path);
		return true;
	}

	@Override
	public boolean copyImpactedResources() {
		System.out.println("Almacenando recursos impactados en el paquete...");
		return true;
	}

	@Override
	public boolean importArtifacts() {
		System.out.println("Importanto artefactos...");
		System.out.println("Renombrando artefactos...");
		return true;
	}
	
}
