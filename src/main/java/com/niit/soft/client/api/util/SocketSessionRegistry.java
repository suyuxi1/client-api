package com.niit.soft.client.api.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;


@Component
@Scope("singleton")
@Slf4j
public class SocketSessionRegistry {

    /**
     * 这个集合存储session
     */
    private final ConcurrentMap<String, Set<String>> userSessionIds = new ConcurrentHashMap();

    private final Object lock = new Object();

    public SocketSessionRegistry() {
    }

    /**
     * 获取sessionId
     *
     * @param userId
     * @return
     */
    public Set<String> getSessionIds(String userId) {
        Set set = (Set) this.userSessionIds.get(userId);
        return set != null ? set : Collections.emptySet();
    }

    /**
     * 获取所有session
     *
     * @return
     */
    public ConcurrentMap<String, Set<String>> getAllSessionIds() {
        return this.userSessionIds;
    }

    /**
     * register session
     *
     * @param userId
     * @param sessionId
     */
    public void registerSessionId(String userId, String sessionId) {
        Assert.notNull(userId, "User ID must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        synchronized (this.lock) {
            Object set = (Set) this.userSessionIds.get(userId);
            if (set == null) {
                set = new CopyOnWriteArraySet();
                this.userSessionIds.put(userId, (Set<String>) set);
            }

            ((Set) set).add(sessionId);
        }
        log.info("===============当前在线人数=============:   " + userSessionIds.size());

    }

    /**
     * remove session
     *
     * @param userId
     * @param sessionId
     */
    public void unregisterSessionId(String userId, String sessionId) {
        Assert.notNull(userId, "User ID must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        synchronized (this.lock) {
            Set set = (Set) this.userSessionIds.get(userId);
            if (set != null && set.remove(sessionId) && set.isEmpty()) {
                this.userSessionIds.remove(userId);
            }
        }
        log.info("===============当前在线人数=============:   " + userSessionIds.size());
    }
}

