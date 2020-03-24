package com.deployment.tool;

import com.deployment.tool.control.DeployToolControl;
import com.deployment.tool.executors.BackupExecutor;
import com.deployment.tool.executors.PackageChecker;
import com.deployment.tool.executors.PackageGenerator;
import com.deployment.tool.executors.ResourceDeployer;
import com.deployment.tool.executors.ResourceMapperFromExcel;
import com.deployment.tool.interfaces.IResourceMapper;


public class App 
{
    public static void main( String[] args)
    {
        DeployToolControl deployTool = new DeployToolControl();
        BackupExecutor   be = new BackupExecutor();
        PackageChecker   pc = new PackageChecker();
        ResourceDeployer rd = new ResourceDeployer();
        PackageGenerator pg = new PackageGenerator();
        IResourceMapper  rm = new ResourceMapperFromExcel("C:\\Users\\julio.c.echeverri\\Downloads\\Recursos_Impactados.xlsx");
        
        pg.setResourceMapper(rm);
        deployTool.setPackageGenerator(pg);
        deployTool.executePackageGeneration();
        
        
        
        /*deployTool.setBackupExecutor(be);
        deployTool.setPackageChecker(pc);
        deployTool.setResourceDeployer(rd);
        deployTool.executeDeploy();*/
    }
}
