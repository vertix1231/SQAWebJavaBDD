package com.test.kerja.sqa.sqawebjavabdd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Getter
@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	@Value("${browser}")
	private String browser;
	@Value("${expectedtext}")
	private String expectedtext;
	@Value("${dashboardexpectedtext}")
	private String dashboardexpectedtext;
	@Value("${loginhighlightexpected}")
	private String loginhighlightexpected;
	@Value("${admintabadminmenu}")
	private String admintabadminmenu;
}
