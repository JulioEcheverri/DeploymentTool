package com.deployment.tool.executors;

import com.deployment.tool.interfaces.IResourceDeployer;

public class ResourceDeployer implements IResourceDeployer 
{
	public boolean deployResources()
	{
		System.out.println("Desplegando recursos en el filesystem...");
		return false;
	}
}
