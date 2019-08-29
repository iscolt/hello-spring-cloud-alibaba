package work.idler.spring.cloud.alibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import work.idler.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallback;

/**
 * Echo Service
 *
 * @author isColt
 * @date 2019/8/29
 */
@FeignClient(value = "service-provider", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable("string") String string);
}
