package faang.school.achievement.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.achievement.dto.GoalSetEventDto;
import faang.school.achievement.handler.EventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoalSetListener extends AbstractEventListener<GoalSetEventDto> implements RedisListener {
    @Value("${spring.data.redis.channels.goal_set_channel.name}")
    private String goalSetChannel;

    public GoalSetListener(List<EventHandler<GoalSetEventDto>> eventHandlers, ObjectMapper objectMapper) {
        super(eventHandlers, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        handleEvent(getMessageBody(message), GoalSetEventDto.class);
    }

    @Override
    public ChannelTopic getChannel() {
        return new ChannelTopic(goalSetChannel);
    }
}
