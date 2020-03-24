package com.deployment.tool.interfaces;

import java.util.ArrayList;

public interface IResourceMapper {

	public boolean openFile();
	public boolean importImpactedResources();
	public void setDataStructures(ArrayList<String> packageFilesystemPaths, ArrayList<String> fileNameList, ArrayList<String> actionTypeList, ArrayList<String> cartridgeNameList);
}
