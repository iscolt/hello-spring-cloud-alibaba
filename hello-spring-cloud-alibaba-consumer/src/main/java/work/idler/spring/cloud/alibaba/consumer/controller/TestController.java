package work.idler.spring.cloud.alibaba.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import work.idler.spring.cloud.alibaba.consumer.service.EchoService;

/**
 * This is description
 *
 * @author isColt
 * @date 2019/8/29
 */
@RefreshScope // 动态刷新
@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * restTemplate 请求
     *
     * @param str
     * @return
     */
    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable(value = "str") String str) {
        // 使用服务名请求服务提供者
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @Autowired
    private EchoService echoService;

    /**
     * 通过feign 请求
     *
     * @param str
     * @return
     */
    @GetMapping(value = "/feign/echo/{str}")
    public String echoFeign(@PathVariable(value = "str") String str) {
        return echoService.echo(str);
    }
}
