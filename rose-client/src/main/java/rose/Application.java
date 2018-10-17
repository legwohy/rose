package rose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * eureka 客户端
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class,args);

    }

    // 需要添加注解@EnableEurekaClient
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/client",method = RequestMethod.GET)
    public String home(){
        ServiceInstance instance=client.getLocalServiceInstance();

        return "serviceId"+instance.getServiceId()+"host:post="+instance.getHost()+":"+instance.getPort();


    }

}
