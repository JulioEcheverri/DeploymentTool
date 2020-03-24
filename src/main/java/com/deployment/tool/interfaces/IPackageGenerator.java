package com.deployment.tool.interfaces;

public interface IPackageGenerator {

		public boolean importImpactedResources();

		public boolean generateFilesystemStructure();

		public boolean copyImpactedResources();

		public boolean importArtifacts();
}
