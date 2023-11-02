package faang.school.achievement.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.achievement.dto.ProfilePicEventDto;
import faang.school.achievement.handler.EventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfilePicListener extends AbstractEventListener<ProfilePicEventDto> implements RedisListener {
    @Value("${spring.data.redis.channels.profile_pic_channel.name}")
    private String profilePicChannel;

    public ProfilePicListener(List<EventHandler<ProfilePicEventDto>> eventHandlers, ObjectMapper objectMapper) {
        super(eventHandlers, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        handleEvent(getMessageBody(message), ProfilePicEventDto.class);
    }

    @Override
    public ChannelTopic getChannel() {
        return new ChannelTopic(profilePicChannel);
    }
}