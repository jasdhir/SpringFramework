package com.jasdhir.springdemo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@Configurable
@EnableCaching
public class SpringConfig {

	private static EhCacheManagerFactoryBean cacheManagerfactoryBean;

	@Bean
	public Employee getEmployee(){
		return  new Employee();	
	}

	@Bean
	public CacheManager getEhCacheManager() {
		return  new EhCacheCacheManager(getEhCacheFactory().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory() {
		cacheManagerfactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerfactoryBean.setShared(true);
		cacheManagerfactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));		
		return cacheManagerfactoryBean;
	}
}