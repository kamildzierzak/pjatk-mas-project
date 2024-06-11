package mas.ManagementSystem;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.types.PlantType;
import mas.ManagementSystem.repositories.PlantRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private PlantRepository plantRepository;

    @PostConstruct
    public void init() {
        if (plantRepository.count() == 0) {
            List<PlantEntity> plants = Arrays.asList(
                    new PlantEntity(1L, "Basil", "A common herb", PlantType.HERB),
                    new PlantEntity(2L, "Mint", "A refreshing herb", PlantType.HERB),
                    new PlantEntity(3L, "Lavender", "A purple fragrant herb", PlantType.HERB),
                    new PlantEntity(4L, "Rosemary", "A woody herb", PlantType.HERB),
                    new PlantEntity(5L, "Thyme", "A versatile herb", PlantType.HERB),
                    new PlantEntity(6L, "Sage", "A herb with a peppery flavor", PlantType.HERB),
                    new PlantEntity(7L, "Oregano", "A staple herb in Italian cuisine", PlantType.HERB),
                    new PlantEntity(8L, "Chives", "A herb with a mild onion flavor", PlantType.HERB),
                    new PlantEntity(9L, "Parsley", "A common garnish herb", PlantType.HERB),
                    new PlantEntity(10L, "Cilantro", "A herb with a unique flavor", PlantType.HERB),
                    new PlantEntity(11L, "Dill", "A herb often used with fish", PlantType.HERB),
                    new PlantEntity(12L, "Tarragon", "A herb with a hint of anise", PlantType.HERB),
                    new PlantEntity(13L, "Borage", "A herb with edible flowers", PlantType.HERB),
                    new PlantEntity(14L, "Marjoram", "A herb similar to oregano", PlantType.HERB),
                    new PlantEntity(15L, "Basil Mint", "A mint variety with basil flavor", PlantType.HERB),
                    new PlantEntity(16L, "Bee Balm", "A herb attracting bees", PlantType.HERB),
                    new PlantEntity(17L, "Catnip", "A herb loved by cats", PlantType.HERB),
                    new PlantEntity(18L, "Lemon Balm", "A lemon-scented herb", PlantType.HERB),
                    new PlantEntity(19L, "Stevia", "A sweet-leaf herb", PlantType.HERB),
                    new PlantEntity(20L, "Azalea", "A flowering shrub", PlantType.SHRUB),
                    new PlantEntity(21L, "Lilac", "A fragrant shrub", PlantType.SHRUB),
                    new PlantEntity(22L, "Hydrangea", "A colorful shrub", PlantType.SHRUB),
                    new PlantEntity(23L, "Forsythia", "A shrub with yellow flowers", PlantType.SHRUB),
                    new PlantEntity(24L, "Hibiscus", "A tropical flowering shrub", PlantType.SHRUB),
                    new PlantEntity(25L, "Rhododendron", "A large flowering shrub", PlantType.SHRUB),
                    new PlantEntity(26L, "Camellia", "A shrub with rose-like flowers", PlantType.SHRUB),
                    new PlantEntity(27L, "Boxwood", "A common landscaping shrub", PlantType.SHRUB),
                    new PlantEntity(28L, "Butterfly Bush", "A shrub attracting butterflies", PlantType.SHRUB),
                    new PlantEntity(29L, "Weigela", "A shrub with trumpet-shaped flowers", PlantType.SHRUB),
                    new PlantEntity(30L, "Honeysuckle", "A climbing plant with sweet-scented flowers", PlantType.CLIMBER),
                    new PlantEntity(31L, "Ivy", "A hardy climber", PlantType.CLIMBER),
                    new PlantEntity(32L, "Wisteria", "A climber with cascading flowers", PlantType.CLIMBER),
                    new PlantEntity(33L, "Bougainvillea", "A vibrant climber", PlantType.CLIMBER),
                    new PlantEntity(34L, "Clematis", "A climber with showy flowers", PlantType.CLIMBER),
                    new PlantEntity(35L, "Passionflower", "A unique flowering climber", PlantType.CLIMBER),
                    new PlantEntity(36L, "Sweet Pea", "A fragrant climber", PlantType.CLIMBER),
                    new PlantEntity(37L, "Morning Glory", "A fast-growing climber", PlantType.CLIMBER),
                    new PlantEntity(38L, "Trumpet Vine", "A vigorous climber", PlantType.CLIMBER),
                    new PlantEntity(39L, "Potato Vine", "A versatile climber", PlantType.CLIMBER),
                    new PlantEntity(40L, "Oak", "A large tree", PlantType.TREE),
                    new PlantEntity(41L, "Pine", "An evergreen tree", PlantType.TREE),
                    new PlantEntity(42L, "Maple", "A tree with maple leaves", PlantType.TREE),
                    new PlantEntity(43L, "Cherry Blossom", "A tree with beautiful spring flowers", PlantType.TREE),
                    new PlantEntity(44L, "Birch", "A tree with distinctive bark", PlantType.TREE),
                    new PlantEntity(45L, "Willow", "A tree with weeping branches", PlantType.TREE),
                    new PlantEntity(46L, "Magnolia", "A tree with large flowers", PlantType.TREE),
                    new PlantEntity(47L, "Cedar", "A fragrant evergreen tree", PlantType.TREE),
                    new PlantEntity(48L, "Redwood", "A towering tree", PlantType.TREE),
                    new PlantEntity(49L, "Banyan", "A tree with aerial roots", PlantType.TREE),
                    new PlantEntity(50L, "Jasmine", "A climber with fragrant flowers", PlantType.CREEPER)
            );

            plantRepository.saveAll(plants);
        }
    }
}
