package com.deployment.tool;

import com.deployment.tool.control.DeployToolControl;
import com.deployment.tool.executors.BackupExecutor;
import com.deployment.tool.executors.PackageChecker;
import com.deployment.tool.executors.ResourceDeployer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DeployToolControl deployTool = new DeployToolControl();
        BackupExecutor   be = new BackupExecutor();
        PackageChecker   pc = new PackageChecker();
        ResourceDeployer rd = new ResourceDeployer();
        
        deployTool.setBackupExecutor(be);
        deployTool.setPackageChecker(pc);
        deployTool.setResourceDeployer(rd);
        
        deployTool.executeDeploy();
    }
}
