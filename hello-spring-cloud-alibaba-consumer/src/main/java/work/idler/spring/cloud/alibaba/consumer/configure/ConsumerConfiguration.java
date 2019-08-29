package work.idler.spring.cloud.alibaba.consumer.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者配置类
 *
 * @author isColt
 * @date 2019/8/29
 */
@Configuration
public class ConsumerConfiguration {

    /**
     * 注入 RestTemplate
     *
     * @return
     */
    @Bean
    @LoadBalanced    // 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
