package com.deployment.tool.executors;

import com.deployment.tool.interfaces.IBackupExecutor;

public class BackupExecutor implements IBackupExecutor {

	public void executeBackup() 
	{
		System.out.println("Ejecutando backup...");
	}

	public void checkBackup() 
	{
		System.out.println("Verificando backup");
	}

}
