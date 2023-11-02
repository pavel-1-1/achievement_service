package faang.school.achievement.mapper;

import faang.school.achievement.dto.achievement.DtoAchievement;
import faang.school.achievement.dto.achievement.DtoAchievementProgress;
import faang.school.achievement.model.Achievement;
import faang.school.achievement.model.AchievementProgress;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-02T17:09:41+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class AchievementProgressMapperImpl implements AchievementProgressMapper {

    @Override
    public AchievementProgress dtoToAchievementProgress(DtoAchievementProgress achievementProgress) {
        if ( achievementProgress == null ) {
            return null;
        }

        AchievementProgress.AchievementProgressBuilder achievementProgress1 = AchievementProgress.builder();

        achievementProgress1.achievement( dtoAchievementToAchievement( achievementProgress.getAchievement() ) );
        achievementProgress1.userId( achievementProgress.getUserId() );
        achievementProgress1.currentPoints( achievementProgress.getCurrentPoints() );
        achievementProgress1.version( achievementProgress.getVersion() );

        return achievementProgress1.build();
    }

    @Override
    public DtoAchievementProgress achievementProgressToDto(AchievementProgress achievementProgress) {
        if ( achievementProgress == null ) {
            return null;
        }

        DtoAchievementProgress dtoAchievementProgress = new DtoAchievementProgress();

        dtoAchievementProgress.setAchievement( achievementToDtoAchievement( achievementProgress.getAchievement() ) );
        dtoAchievementProgress.setUserId( achievementProgress.getUserId() );
        dtoAchievementProgress.setCurrentPoints( achievementProgress.getCurrentPoints() );
        dtoAchievementProgress.setVersion( achievementProgress.getVersion() );

        return dtoAchievementProgress;
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
