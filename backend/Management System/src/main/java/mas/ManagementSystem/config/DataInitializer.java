package mas.ManagementSystem.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.repositories.PlantRepository;
import mas.ManagementSystem.services.WarehouseService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {

    private WarehouseService warehouseService;
    private PlantRepository plantRepository;

    @PostConstruct
    public void init() {

        warehouseService.initializeWarehouse();

//        Plants
//        if (plantRepository.count() == 0) {
//            List<PlantEntity> plants = Arrays.asList(
//                    new PlantEntity(1L, "Lavender", "A purple fragrant herb", 0.5, 1.0, 0.5, 0.2, PlantType.HERB, null),
//                    new PlantEntity(2L, "Rosemary", "A woody herb", 1.0, 1.2, 0.6, 0.3, PlantType.HERB, null),
//                    new PlantEntity(3L, "Thyme", "A versatile herb", 0.3, 0.4, 0.3, 0.1, PlantType.HERB, null),
//                    new PlantEntity(4L, "Sage", "A herb with a peppery flavor", 0.6, 0.8, 0.4, 0.2, PlantType.HERB, null),
//                    new PlantEntity(5L, "Oregano", "A staple herb in Italian cuisine", 0.5, 0.6, 0.5, 0.2, PlantType.HERB, null),
//                    new PlantEntity(6L, "Chives", "A herb with a mild onion flavor", 0.3, 0.4, 0.2, 0.1, PlantType.HERB, null),
//                    new PlantEntity(7L, "Parsley", "A common garnish herb", 0.4, 0.5, 0.3, 0.1, PlantType.HERB, null),
//                    new PlantEntity(8L, "Cilantro", "A herb with a unique flavor", 0.5, 0.6, 0.3, 0.1, PlantType.HERB, null),
//                    new PlantEntity(9L, "Dill", "A herb often used with fish", 0.4, 1.2, 0.5, 0.3, PlantType.HERB, null),
//                    new PlantEntity(10L, "Tarragon", "A herb with a hint of anise", 0.6, 0.8, 0.5, 0.2, PlantType.HERB, null),
//                    new PlantEntity(11L, "Borage", "A herb with edible flowers", 0.5, 0.6, 0.4, 0.2, PlantType.HERB, null),
//                    new PlantEntity(12L, "Marjoram", "A herb similar to oregano", 0.4, 0.5, 0.3, 0.2, PlantType.HERB, null),
//                    new PlantEntity(13L, "Basil Mint", "A mint variety with basil flavor", 0.6, 0.7, 0.4, 0.2, PlantType.HERB
//                            , null),
//                    new PlantEntity(14L, "Bee Balm", "A herb attracting bees", 0.7, 1.2, 0.6, 0.3, PlantType.HERB, null),
//                    new PlantEntity(15L, "Catnip", "A herb loved by cats", 0.5, 1.0, 0.4, 0.2, PlantType.HERB, null),
//                    new PlantEntity(16L, "Lemon Balm", "A lemon-scented herb", 0.6, 0.8, 0.4, 0.2, PlantType.HERB, null),
//                    new PlantEntity(17L, "Stevia", "A sweet-leaf herb", 0.5, 1.0, 0.4, 0.3, PlantType.HERB, null),
//                    new PlantEntity(18L, "Azalea", "A flowering shrub", 1.0, 1.5, 1.0, 0.8, PlantType.SHRUB, null),
//                    new PlantEntity(19L, "Lilac", "A fragrant shrub", 1.2, 2.0, 1.0, 1.0, PlantType.SHRUB, null),
//                    new PlantEntity(20L, "Hydrangea", "A colorful shrub", 1.5, 2.0, 1.0, 1.2, PlantType.SHRUB, null),
//                    new PlantEntity(21L, "Forsythia", "A shrub with yellow flowers", 1.5, 2.0, 1.0, 1.0, PlantType.SHRUB, null),
//                    new PlantEntity(22L, "Hibiscus", "A tropical flowering shrub", 1.5, 2.5, 1.2, 1.5, PlantType.SHRUB, null),
//                    new PlantEntity(23L, "Rhododendron", "A large flowering shrub", 1.8, 2.5, 1.5, 2.0, PlantType.SHRUB, null),
//                    new PlantEntity(24L, "Camellia", "A shrub with rose-like flowers", 1.2, 1.8, 1.0, 1.2, PlantType.SHRUB,
//                            null),
//                    new PlantEntity(25L, "Boxwood", "A common landscaping shrub", 1.0, 1.5, 1.0, 0.8, PlantType.SHRUB, null),
//                    new PlantEntity(26L, "Butterfly Bush", "A shrub attracting butterflies", 1.5, 2.0, 1.2, 1.0,
//                            PlantType.SHRUB, null),
//                    new PlantEntity(27L, "Weigela", "A shrub with trumpet-shaped flowers", 1.5, 2.0, 1.0, 1.0,
//                            PlantType.SHRUB, null),
//                    new PlantEntity(28L, "Honeysuckle", "A climbing plant with sweet-scented flowers", 2.0, 3.0, 1.0, 1.2,
//                            PlantType.CLIMBER, null),
//                    new PlantEntity(29L, "Ivy", "A hardy climber", 1.5, 2.0, 0.8, 0.7, PlantType.CLIMBER, null),
//                    new PlantEntity(30L, "Wisteria", "A climber with cascading flowers", 2.0, 3.0, 1.0, 1.5,
//                            PlantType.CLIMBER, null),
//                    new PlantEntity(31L, "Bougainvillea", "A vibrant climber", 2.5, 3.5, 1.2, 1.5, PlantType.CLIMBER, null),
//                    new PlantEntity(32L, "Clematis", "A climber with showy flowers", 1.5, 2.0, 1.0, 1.0, PlantType.CLIMBER,
//                            null),
//                    new PlantEntity(33L, "Passionflower", "A unique flowering climber", 1.5, 2.5, 1.2, 1.2, PlantType.CLIMBER
//                            , null),
//                    new PlantEntity(34L, "Sweet Pea", "A fragrant climber", 1.0, 2.0, 0.8, 0.5, PlantType.CLIMBER, null),
//                    new PlantEntity(35L, "Morning Glory", "A fast-growing climber", 1.5, 2.5, 1.0, 1.0, PlantType.CLIMBER, null),
//                    new PlantEntity(36L, "Trumpet Vine", "A vigorous climber", 2.0, 3.0, 1.0, 1.5, PlantType.CLIMBER, null),
//                    new PlantEntity(37L, "Potato Vine", "A versatile climber", 1.5, 2.0, 1.0, 1.0, PlantType.CLIMBER, null),
//                    new PlantEntity(38L, "Oak", "A large tree", 5.0, 20.0, 4.0, 70.0, PlantType.TREE, null),
//                    new PlantEntity(39L, "Pine", "An evergreen tree", 3.0, 25.0, 3.0, 60.0, PlantType.TREE, null),
//                    new PlantEntity(40L, "Maple", "A tree with maple leaves", 4.0, 15.0, 3.0, 55.0, PlantType.TREE, null),
//                    new PlantEntity(41L, "Cherry Blossom", "A tree with beautiful spring flowers", 4.0, 10.0, 2.5, 50.0,
//                            PlantType.TREE, null),
//                    new PlantEntity(42L, "Birch", "A tree with distinctive bark", 3.0, 15.0, 2.5, 45.0, PlantType.TREE, null),
//                    new PlantEntity(43L, "Willow", "A tree with weeping branches", 4.0, 20.0, 3.0, 55.0, PlantType.TREE, null),
//                    new PlantEntity(44L, "Magnolia", "A tree with large flowers", 4.0, 15.0, 3.0, 50.0, PlantType.TREE, null),
//                    new PlantEntity(45L, "Cedar", "A fragrant evergreen tree", 4.0, 20.0, 3.0, 60.0, PlantType.TREE, null),
//                    new PlantEntity(46L, "Redwood", "A towering tree", 6.0, 70.0, 5.0, 80.0, PlantType.TREE, null),
//                    new PlantEntity(47L, "Banyan", "A tree with aerial roots", 5.0, 25.0, 4.0, 75.0, PlantType.TREE, null),
//                    new PlantEntity(48L, "Jasmine", "A climber with fragrant flowers", 1.5, 2.5, 1.0, 0.7, PlantType.CREEPER,
//                            null),
//                    new PlantEntity(49L, "Sweet Potato Vine", "A fast-growing creeper", 1.0, 1.5, 0.8, 0.5, PlantType.CREEPER
//                            , null),
//                    new PlantEntity(50L, "Pumpkin", "A creeper producing large fruits", 1.5, 0.3, 1.0, 5.0, PlantType.CREEPER
//                            , null)
//            );
//
//            plantRepository.saveAll(plants);
//        }
    }
}
