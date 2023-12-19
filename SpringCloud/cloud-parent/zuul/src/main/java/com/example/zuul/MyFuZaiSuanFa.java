package com.example.zuul;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 把随机改造为轮询算法，并且每台机器轮询5次在切换机器。
 */
public class MyFuZaiSuanFa extends AbstractLoadBalancerRule {
    /**
     *  记录端口的运行次数和当前下标
     */
    private int myCount = 0;
    private int myIndex = 0;
    /**
     * Randomly choose from  all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            myCount++;
            int index = chooseRandomInt(serverCount);
            server = upList.get(index);

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        // 如果访问了五次，就让计数器归零重新计算，并且返回下一个下标
        if (myCount == 6){
            myCount = 0;
            // 如果下标大于长度就归零重新轮询，否则让下标+1
            if (myIndex < serverCount-1){
                return myIndex++;
            }else {
                myIndex = 0;
                return myIndex;
            }
        }else {
            return myIndex;
        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
