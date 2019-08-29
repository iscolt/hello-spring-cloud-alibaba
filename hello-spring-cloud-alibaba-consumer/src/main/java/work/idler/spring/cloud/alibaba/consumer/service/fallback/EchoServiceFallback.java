package work.idler.spring.cloud.alibaba.consumer.service.fallback;

import org.springframework.stereotype.Component;
import work.idler.spring.cloud.alibaba.consumer.service.EchoService;

/**
 * 熔断后返回固定值
 *
 * @author isColt
 * @date 2019/8/29
 */
@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String string) {
        return "熔断了, 熔断了" + string;
    }
}
