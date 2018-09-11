package poly.manhnd.webapp.configurations;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import poly.manhnd.webapp.interceptors.GrammarQuizResultInterceptor;
import poly.manhnd.webapp.interceptors.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean("messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		
		messageSource.addBasenames("classpath:i18n/global/global");
		
		messageSource.addBasenames("classpath:i18n/message/message");
		
		messageSource.addBasenames("classpath:i18n/admin/admin.dashboard");
		messageSource.addBasenames("classpath:i18n/admin/admin.grammar");
		messageSource.addBasenames("classpath:i18n/admin/admin.navbar");
		messageSource.addBasenames("classpath:i18n/admin/admin.phrase");
		messageSource.addBasenames("classpath:i18n/admin/admin.sentence");
		messageSource.addBasenames("classpath:i18n/admin/admin.user");
		
		messageSource.addBasenames("classpath:i18n/user/user.dictionary");
		messageSource.addBasenames("classpath:i18n/user/user.grammar");
		messageSource.addBasenames("classpath:i18n/user/user.home");
		messageSource.addBasenames("classpath:i18n/user/user.navbar");
		messageSource.addBasenames("classpath:i18n/user/user.phrase");
		messageSource.addBasenames("classpath:i18n/user/user.profile");
		
		return messageSource;
	}

	@Bean("localeResolver")
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("en"));
		localeResolver.setCookieMaxAge(3600);
		return localeResolver;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login**");
		registry.addInterceptor(new GrammarQuizResultInterceptor()).addPathPatterns("/grammar/**-quiz-result");
	}
}
