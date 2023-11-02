package faang.school.achievement.mapper;

import faang.school.achievement.dto.achievement.DtoAchievement;
import faang.school.achievement.dto.publish_event.DtoUserEventAchievement;
import faang.school.achievement.model.Achievement;
import faang.school.achievement.model.UserAchievement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-08T13:49:11+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class UserAchievementEventMapperImpl implements UserAchievementEventMapper {

    @Override
    public DtoUserEventAchievement userAchievementToDto(UserAchievement userAchievement) {
        if ( userAchievement == null ) {
            return null;
        }

        DtoUserEventAchievement dtoUserEventAchievement = new DtoUserEventAchievement();

        dtoUserEventAchievement.setUserId( userAchievement.getUserId() );
        dtoUserEventAchievement.setAchievement( achievementToDtoAchievement( userAchievement.getAchievement() ) );

        return dtoUserEventAchievement;
    }

    protected DtoAchievement achievementToDtoAchievement(Achievement achievement) {
        if ( achievement == null ) {
            return null;
        }

        DtoAchievement dtoAchievement = new DtoAchievement();

        dtoAchievement.setId( achievement.getId() );
        dtoAchievement.setTitle( achievement.getTitle() );
        dtoAchievement.setDescription( achievement.getDescription() );
        dtoAchievement.setRarity( achievement.getRarity() );

        return dtoAchievement;
    }
}
