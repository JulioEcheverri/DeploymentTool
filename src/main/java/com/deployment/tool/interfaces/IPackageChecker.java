package com.deployment.tool.interfaces;

public interface IPackageChecker 
{
	public boolean checkPackageContent();
	public boolean checkFilesystemStructure();
	public boolean checkDeploymentStatus();
}
