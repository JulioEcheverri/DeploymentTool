package com.deployment.tool.executors;

import com.deployment.tool.interfaces.IPackageChecker;

public class PackageChecker implements IPackageChecker {

	public boolean checkPackageContent() 
	{
		System.out.println("Verificando contenido del paquete...");
		return false;
	}

	public boolean checkFilesystemStructure() 
	{
		System.out.println("Verificando contenido del filesystem...");
		return false;
	}

	public boolean checkDeploymentStatus() 
	{
		System.out.println("Verificando estado del despliegue..."); 
		return false;
	}

}
