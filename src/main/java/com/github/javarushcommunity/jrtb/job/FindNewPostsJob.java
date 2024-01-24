package com.github.javarushcommunity.jrtb.job;

import com.github.javarushcommunity.jrtb.service.FindNewPostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Job for finding new posts.
 */
@Slf4j
@Component
public class FindNewPostsJob {

    private final FindNewPostsService findNewPostsService;

    @Autowired
    public FindNewPostsJob(FindNewPostsService findNewPostsService) {
        this.findNewPostsService = findNewPostsService;
    }

    @Scheduled(fixedRateString = "${bot.recountNewPostFixedRate}")
    public void findNewPosts() {
        Instant start = Instant.now();

        log.info("Find new posts job started.");

        findNewPostsService.findNewPosts();

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        log.info("Find new posts job finished. Took seconds: {}", duration.getSeconds());
    }
}
