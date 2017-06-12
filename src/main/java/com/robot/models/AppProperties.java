package com.robot.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

	public AppProperties() {
	}

	@Value("${spring.application.name}")
	private String applicationName;

	private String name;
	private String version;
	private String java;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getName() {
		this.name = this.applicationName.split("-")[0].trim();
		return this.name;
	}

	public String getVersion() {
		this.version = this.name = this.applicationName.split("-")[1].trim();
		return this.version;
	}

	public String getJava() {
		this.java = this.name = this.applicationName.split("-")[2].trim();
		return this.java;
	}

	@Override
	public String toString() {
		return "AppProperties [applicationName=" + applicationName 
				+ ", name=" + this.getName() 
				+ ", version=" 
				+ this.getVersion() 
				+ ", java="+this.getVersion()
				+ "]";
	}

}
