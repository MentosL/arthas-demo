package xyz.lushun.arthas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.lushun.arthas.entity.User;

/**
 * @author Montos
 * @create 2021/1/15 3:43 下午
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private static Integer count = 0;


    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Integer id) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("findUserById id is {}", id);
        }
        if (id == null)
            throw new IllegalArgumentException("id must not be null");
        if (id < 1)
            throw new IllegalArgumentException("id < 1");
        count++;
        if (count > 5) {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new User(id, "montos");
    }


}
