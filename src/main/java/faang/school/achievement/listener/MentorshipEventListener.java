package faang.school.achievement.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.achievement.dto.MentorshipStartEventDto;
import faang.school.achievement.handler.EventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MentorshipEventListener extends AbstractEventListener<MentorshipStartEventDto> implements RedisListener {
    @Value("${spring.data.redis.channels.mentorship_channel}")
    private String mentorshipChannel;

    public MentorshipEventListener(List<EventHandler<MentorshipStartEventDto>> eventHandlers, ObjectMapper objectMapper) {
        super(eventHandlers, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        handleEvent(getMessageBody(message), MentorshipStartEventDto.class);
    }

    @Override
    public ChannelTopic getChannel() {
        return new ChannelTopic(mentorshipChannel);
    }
}
