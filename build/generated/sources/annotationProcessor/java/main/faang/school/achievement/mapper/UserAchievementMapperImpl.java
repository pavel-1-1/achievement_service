package faang.school.achievement.mapper;

import faang.school.achievement.dto.achievement.DtoAchievement;
import faang.school.achievement.dto.achievement.DtoUserAchievement;
import faang.school.achievement.model.Achievement;
import faang.school.achievement.model.UserAchievement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-31T21:29:52+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class UserAchievementMapperImpl implements UserAchievementMapper {

    @Override
    public UserAchievement dtoToUserAchievement(DtoUserAchievement dtoUserAchievement) {
        if ( dtoUserAchievement == null ) {
            return null;
        }

        UserAchievement.UserAchievementBuilder userAchievement = UserAchievement.builder();

        userAchievement.id( dtoUserAchievement.getId() );
        userAchievement.achievement( dtoAchievementToAchievement( dtoUserAchievement.getAchievement() ) );
        userAchievement.userId( dtoUserAchievement.getUserId() );

        return userAchievement.build();
    }

    @Override
    public DtoUserAchievement userAchievementToDto(UserAchievement userAchievement) {
        if ( userAchievement == null ) {
            return null;
        }

        DtoUserAchievement dtoUserAchievement = new DtoUserAchievement();

        dtoUserAchievement.setId( userAchievement.getId() );
        dtoUserAchievement.setAchievement( achievementToDtoAchievement( userAchievement.getAchievement() ) );
        dtoUserAchievement.setUserId( userAchievement.getUserId() );

        return dtoUserAchievement;
    }

    protected Achievement dtoAchievementToAchievement(DtoAchievement dtoAchievement) {
        if ( dtoAchievement == null ) {
            return null;
        }

        Achievement.AchievementBuilder achievement = Achievement.builder();

        achievement.id( dtoAchievement.getId() );
        achievement.title( dtoAchievement.getTitle() );
        achievement.description( dtoAchievement.getDescription() );
        achievement.rarity( dtoAchievement.getRarity() );

        return achievement.build();
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
