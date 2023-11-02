package faang.school.achievement.listener;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;

public interface RedisListener extends MessageListener {
    ChannelTopic getChannel();
}
