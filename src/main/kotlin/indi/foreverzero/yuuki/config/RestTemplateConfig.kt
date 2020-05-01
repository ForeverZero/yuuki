package indi.foreverzero.yuuki.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {

    @Bean
    fun restTemplate(factory: ClientHttpRequestFactory): RestTemplate? {
        return RestTemplate(factory)
    }

    @Bean
    fun simpleClientHttpRequestFactory(): ClientHttpRequestFactory {
        //TODO 配置项控制时间
        val factory = SimpleClientHttpRequestFactory()
        factory.setReadTimeout(10000) //单位为ms
        factory.setConnectTimeout(5000) //单位为ms
        return factory
    }
}