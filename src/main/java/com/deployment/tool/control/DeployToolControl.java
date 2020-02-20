package com.deployment.tool.control;

import com.deployment.tool.interfaces.IBackupExecutor;
import com.deployment.tool.interfaces.IPackageChecker;
import com.deployment.tool.interfaces.IResourceDeployer;

public class DeployToolControl 
{
	private IBackupExecutor backupExecutor;
	private IPackageChecker packageChecker;
	private IResourceDeployer resourceDeployer;
	
	
	public void setBackupExecutor(IBackupExecutor backupExecutor) {
		this.backupExecutor = backupExecutor;
	}

	public void setPackageChecker(IPackageChecker packageChecker) {
		this.packageChecker = packageChecker;
	}

	public void setResourceDeployer(IResourceDeployer resourceDeployer) {
		this.resourceDeployer = resourceDeployer;
	}
	
	public DeployToolControl()
	{
		
	}
	
	public boolean executeDeploy()
	{
		System.out.println("Inicio de la ejecución del despliegue...");
		
		packageChecker.checkPackageContent();
		packageChecker.checkFilesystemStructure();
		
		backupExecutor.executeBackup();
		backupExecutor.checkBackup();
		
		resourceDeployer.deployResources();
		packageChecker.checkDeploymentStatus();
		
		System.out.println("Despliegue finalizado exitosamente...");
		return true;
	}
}
