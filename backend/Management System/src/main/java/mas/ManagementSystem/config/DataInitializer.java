package mas.ManagementSystem.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.types.PlantType;
import mas.ManagementSystem.repositories.PlantRepository;
import mas.ManagementSystem.services.WarehouseService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private WarehouseService warehouseService;
    private PlantRepository plantRepository;

    @PostConstruct
    public void init() {

        warehouseService.initializeWarehouse();

//        Plants
        if (plantRepository.count() == 0) {
            List<PlantEntity> plants = Arrays.asList(
                    new PlantEntity(1L, "Bazylia", "Zioło kulinarne", PlantType.HERB, 10.0, 20.0, 10.0, 0.2, 960, null),
                    new PlantEntity(2L, "Róża", "Kwiat ogrodowy", PlantType.SHRUB, 15.0, 30.0, 20.0, 0.3, 720, null),
                    new PlantEntity(3L, "Bluszcz", "Roślina pnąca", PlantType.CREEPER, 5.0, 25.0, 15.0, 0.1, 480, null),
                    new PlantEntity(4L, "Dąb", "Potężne drzewo liściaste", PlantType.TREE, 50.0, 150.0, 100.0, 1.0, 1440, null),
                    new PlantEntity(5L, "Malina", "Krzew owocowy", PlantType.SHRUB, 8.0, 20.0, 12.0, 0.4, 600, null),
                    new PlantEntity(6L, "Jagoda", "Roślina wrzosowata", PlantType.SHRUB, 7.0, 18.0, 10.0, 0.3, 540, null),
                    new PlantEntity(7L, "Tulipan", "Kwiat wiosenny", PlantType.HERB, 12.0, 25.0, 18.0, 0.2, 840, null),
                    new PlantEntity(8L, "Klon", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0, 0.8, 1200, null),
                    new PlantEntity(9L, "Orzech włoski", "Drzewo owocowe", PlantType.TREE, 60.0, 180.0, 150.0, 1.5, 1800, null),
                    new PlantEntity(10L, "Rumianek", "Zioło lecznicze", PlantType.HERB, 5.0, 15.0, 8.0, 0.1, 360, null),
                    new PlantEntity(11L, "Żurawina", "Krzew owocowy", PlantType.SHRUB, 10.0, 22.0, 14.0, 0.5, 720, null),
                    new PlantEntity(12L, "Brzoza", "Drzewo liściaste", PlantType.TREE, 30.0, 90.0, 60.0, 0.6, 1080, null),
                    new PlantEntity(13L, "Paproć", "Roślina ozdobna", PlantType.HERB, 18.0, 35.0, 25.0, 0.3, 960, null),
                    new PlantEntity(14L, "Sosna", "Drzewo iglaste", PlantType.TREE, 55.0, 160.0, 110.0, 1.2, 1560, null),
                    new PlantEntity(15L, "Jabłoń", "Drzewo owocowe", PlantType.TREE, 45.0, 130.0, 90.0, 0.9, 1320, null),
                    new PlantEntity(16L, "Lawenda", "Zioło ozdobne", PlantType.HERB, 8.0, 18.0, 12.0, 0.2, 720, null),
                    new PlantEntity(17L, "Mirt", "Krzew ozdobny", PlantType.SHRUB, 12.0, 28.0, 20.0, 0.4, 840, null),
                    new PlantEntity(18L, "Dzika róża", "Krzew dziki", PlantType.SHRUB, 10.0, 25.0, 15.0, 0.3, 600, null),
                    new PlantEntity(19L, "Oliwka", "Drzewo owocowe", PlantType.TREE, 25.0, 80.0, 50.0, 0.5, 1080, null),
                    new PlantEntity(20L, "Mięta", "Zioło lecznicze", PlantType.HERB, 7.0, 15.0, 10.0, 0.2, 480, null),
                    new PlantEntity(21L, "Cyprys", "Drzewo iglaste", PlantType.TREE, 40.0, 110.0, 70.0, 0.7, 1200, null),
                    new PlantEntity(22L, "Chryzantema", "Roślina ozdobna", PlantType.HERB, 10.0, 20.0, 15.0, 0.3, 720, null),
                    new PlantEntity(23L, "Jałowiec", "Krzew iglasty", PlantType.SHRUB, 8.0, 25.0, 18.0, 0.3, 960, null),
                    new PlantEntity(24L, "Śliwa", "Drzewo owocowe", PlantType.TREE, 35.0, 100.0, 70.0, 0.6, 1320, null),
                    new PlantEntity(25L, "Cynamonowiec", "Drzewo przyprawowe", PlantType.TREE, 30.0, 90.0, 60.0, 0.5, 1080, null),
                    new PlantEntity(26L, "Goździk", "Roślina ozdobna", PlantType.HERB, 12.0, 30.0, 20.0, 0.4, 840, null),
                    new PlantEntity(27L, "Kapusta", "Warzywo", PlantType.HERB, 10.0, 25.0, 15.0, 0.3, 600, null),
                    new PlantEntity(28L, "Kwiat magnolii", "Kwiat ozdobny", PlantType.SHRUB, 15.0, 35.0, 25.0, 0.5, 960, null),
                    new PlantEntity(29L, "Juka", "Roślina ozdobna", PlantType.HERB, 20.0, 40.0, 30.0, 0.6, 1200, null),
                    new PlantEntity(30L, "Dziurawiec", "Zioło lecznicze", PlantType.HERB, 6.0, 12.0, 8.0, 0.2, 480, null),
                    new PlantEntity(31L, "Lilak", "Krzew ozdobny", PlantType.SHRUB, 12.0, 30.0, 20.0, 0.4, 720, null),
                    new PlantEntity(32L, "Buk", "Drzewo liściaste", PlantType.TREE, 35.0, 100.0, 70.0, 0.7, 1320, null),
                    new PlantEntity(33L, "Eukaliptus", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0, 0.8, 1440, null),
                    new PlantEntity(34L, "Papryka", "Warzywo", PlantType.HERB, 12.0, 28.0, 18.0, 0.3, 720, null),
                    new PlantEntity(35L, "Kaktus", "Roślina ozdobna", PlantType.SHRUB, 5.0, 15.0, 10.0, 0.2, 480, null),
                    new PlantEntity(36L, "Żywotnik", "Krzew iglasty", PlantType.SHRUB, 8.0, 20.0, 15.0, 0.3, 600, null),
                    new PlantEntity(37L, "Dynia", "Warzywo", PlantType.HERB, 15.0, 40.0, 25.0, 0.4, 840, null),
                    new PlantEntity(38L, "Kwiat storczyka", "Kwiat ozdobny", PlantType.HERB, 10.0, 25.0, 18.0, 0.3, 720, null),
                    new PlantEntity(39L, "Kasztanowiec", "Drzewo liściaste", PlantType.TREE, 50.0, 150.0, 100.0, 1.0, 1440, null),
                    new PlantEntity(40L, "Fiołek", "Roślina ozdobna", PlantType.HERB, 6.0, 12.0, 8.0, 0.2, 480, null),
                    new PlantEntity(41L, "Czosnek", "Zioło kulinarne", PlantType.HERB, 8.0, 15.0, 10.0, 0.2, 600, null),
                    new PlantEntity(42L, "Różówka", "Roślina ozdobna", PlantType.SHRUB, 12.0, 30.0, 20.0, 0.4, 720,
                            null),
                    new PlantEntity(43L, "Karczocha", "Warzywo", PlantType.HERB, 10.0, 22.0, 15.0, 0.3, 840, null),
                    new PlantEntity(44L, "Aloes", "Roślina lecznicza", PlantType.HERB, 5.0, 18.0, 12.0, 0.1, 480, null),
                    new PlantEntity(45L, "Jabłoń ozdobna", "Drzewo ozdobne", PlantType.TREE, 25.0, 80.0, 50.0, 0.5, 1080, null),
                    new PlantEntity(46L, "Różanecznik", "Krzew ozdobny", PlantType.SHRUB, 15.0, 35.0, 25.0, 0.4, 960, null),
                    new PlantEntity(47L, "Chaber bławatek", "Roślina ozdobna", PlantType.HERB, 8.0, 20.0, 15.0, 0.3, 720, null),
                    new PlantEntity(48L, "Kasztanowiec jadalny", "Drzewo owocowe", PlantType.TREE, 45.0, 130.0, 90.0, 0.9, 1320, null),
                    new PlantEntity(49L, "Bazyliszek czerwony", "Roślina ozdobna", PlantType.SHRUB, 10.0, 25.0, 18.0, 0.3, 600, null),
                    new PlantEntity(50L, "Rukiew wodna", "Roślina wodna", PlantType.HERB, 5.0, 12.0, 8.0, 0.2, 480, null)

            );

            plantRepository.saveAll(plants);
        }
    }
}
