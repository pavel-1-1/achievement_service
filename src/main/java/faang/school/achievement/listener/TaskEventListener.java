package faang.school.achievement.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.achievement.dto.TaskEventDto;
import faang.school.achievement.handler.EventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskEventListener extends AbstractEventListener<TaskEventDto> implements RedisListener {
    @Value("${spring.data.redis.channels.task_channel.name}")
    private String taskChannel;

    public TaskEventListener(List<EventHandler<TaskEventDto>> eventHandlers, ObjectMapper objectMapper) {
        super(eventHandlers, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        handleEvent(getMessageBody(message), TaskEventDto.class);
    }

    @Override
    public ChannelTopic getChannel() {
        return new ChannelTopic(taskChannel);
    }
}
