package faang.school.achievement.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.achievement.dto.InviteSentEventDto;
import faang.school.achievement.handler.EventHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InviteEventListener extends AbstractEventListener<InviteSentEventDto> implements RedisListener {
    @Value("${spring.data.redis.channels.invite_channel.name}")
    private String inviteChannel;

    public InviteEventListener(List<EventHandler<InviteSentEventDto>> eventHandlers, ObjectMapper objectMapper) {
        super(eventHandlers, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        handleEvent(getMessageBody(message), InviteSentEventDto.class);
    }

    @Override
    public ChannelTopic getChannel() {
        return new ChannelTopic(inviteChannel);
    }
}
