package faang.school.achievement.mapper;

import faang.school.achievement.dto.achievement.DtoAchievement;
import faang.school.achievement.model.Achievement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-31T21:29:52+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public Achievement dtoToAchievement(DtoAchievement dtoAchievement) {
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

    @Override
    public DtoAchievement achievementToDto(Achievement achievement) {
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
