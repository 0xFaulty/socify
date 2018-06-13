package cloud.socify.config;

import cloud.socify.entity.FifoBlockingDeque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class AsyncExecutorConfig implements AsyncConfigurer {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${crawler.queue.capacity}")
    private int capacity;

    @Value("${crawler.threadpool.size}")
    private int size;

//    @Bean
//    public GrubService getGrubService(WorkerService ws) {
//        return new GrubServiceImpl(ws);
//    }
//
//    @Bean
//    public WorkerService workerService() {
//        return new WorkerService();
//    }

    @Override
    @Bean(destroyMethod = "shutdown")
    public ThreadPoolExecutor getAsyncExecutor() {
        return new ThreadPoolExecutor(size,
                                      size,
                                      0L,
                                      TimeUnit.MILLISECONDS,
                                      new FifoBlockingDeque(capacity),
                                      new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) ->
                logger.error("Exception message:{}, Stack: {}, Method name: {}, Parameter value:  ",
                             ex.getMessage(),
                             ex.getStackTrace(),
                             method.getName(),
                             params);
    }

}
