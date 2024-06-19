package mas.ManagementSystem.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import mas.ManagementSystem.domain.types.PlantType;
import mas.ManagementSystem.repositories.BatchRepository;
import mas.ManagementSystem.repositories.PlantRepository;
import mas.ManagementSystem.services.PlantService;
import mas.ManagementSystem.services.WarehouseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final WarehouseService warehouseService;
    private final PlantRepository plantRepository;
    private final PlantService plantService;
    private final BatchRepository batchRepository;

    @PostConstruct
    public void init() {

        warehouseService.initializeWarehouse();

//        Plants
        if (plantRepository.count() == 0) {
            List<PlantEntity> plants = Arrays.asList(
                    new PlantEntity(null, "Bazylia", "Zioło kulinarne", PlantType.HERB, 10.0, 20.0, 10.0, 0.2, 960,
                            null),
                    new PlantEntity(null, "Róża", "Kwiat ogrodowy", PlantType.SHRUB, 15.0, 30.0, 20.0, 0.3, 720, null),
                    new PlantEntity(null, "Bluszcz", "Roślina pnąca", PlantType.CREEPER, 5.0, 25.0, 15.0, 0.1, 480,
                            null),
                    new PlantEntity(null, "Dąb", "Potężne drzewo liściaste", PlantType.TREE, 50.0, 150.0, 100.0, 1.0,
                            1440, null),
                    new PlantEntity(null, "Malina", "Krzew owocowy", PlantType.SHRUB, 8.0, 20.0, 12.0, 0.4, 600, null),
                    new PlantEntity(null, "Jagoda", "Roślina wrzosowata", PlantType.SHRUB, 7.0, 18.0, 10.0, 0.3, 540,
                            null),
                    new PlantEntity(null, "Tulipan", "Kwiat wiosenny", PlantType.HERB, 12.0, 25.0, 18.0, 0.2, 840,
                            null),
                    new PlantEntity(null, "Klon", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0, 0.8, 1200,
                            null),
                    new PlantEntity(null, "Orzech włoski", "Drzewo owocowe", PlantType.TREE, 60.0, 180.0, 150.0, 1.5,
                            1800, null),
                    new PlantEntity(null, "Rumianek", "Zioło lecznicze", PlantType.HERB, 5.0, 15.0, 8.0, 0.1, 360,
                            null),
                    new PlantEntity(null, "Żurawina", "Krzew owocowy", PlantType.SHRUB, 10.0, 22.0, 14.0, 0.5, 720,
                            null),
                    new PlantEntity(null, "Brzoza", "Drzewo liściaste", PlantType.TREE, 30.0, 90.0, 60.0, 0.6, 1080,
                            null),
                    new PlantEntity(null, "Paproć", "Roślina ozdobna", PlantType.HERB, 18.0, 35.0, 25.0, 0.3, 960,
                            null),
                    new PlantEntity(null, "Sosna", "Drzewo iglaste", PlantType.TREE, 55.0, 160.0, 110.0, 1.2, 1560,
                            null),
                    new PlantEntity(null, "Jabłoń", "Drzewo owocowe", PlantType.TREE, 45.0, 130.0, 90.0, 0.9, 1320,
                            null),
                    new PlantEntity(null, "Lawenda", "Zioło ozdobne", PlantType.HERB, 8.0, 18.0, 12.0, 0.2, 720, null),
                    new PlantEntity(null, "Mirt", "Krzew ozdobny", PlantType.SHRUB, 12.0, 28.0, 20.0, 0.4, 840, null),
                    new PlantEntity(null, "Dzika róża", "Krzew dziki", PlantType.SHRUB, 10.0, 25.0, 15.0, 0.3, 600,
                            null),
                    new PlantEntity(null, "Oliwka", "Drzewo owocowe", PlantType.TREE, 25.0, 80.0, 50.0, 0.5, 1080,
                            null),
                    new PlantEntity(null, "Mięta", "Zioło lecznicze", PlantType.HERB, 7.0, 15.0, 10.0, 0.2, 480, null),
                    new PlantEntity(null, "Cyprys", "Drzewo iglaste", PlantType.TREE, 40.0, 110.0, 70.0, 0.7, 1200,
                            null),
                    new PlantEntity(null, "Chryzantema", "Roślina ozdobna", PlantType.HERB, 10.0, 20.0, 15.0, 0.3, 720,
                            null),
                    new PlantEntity(null, "Jałowiec", "Krzew iglasty", PlantType.SHRUB, 8.0, 25.0, 18.0, 0.3, 960,
                            null),
                    new PlantEntity(null, "Śliwa", "Drzewo owocowe", PlantType.TREE, 35.0, 100.0, 70.0, 0.6, 1320,
                            null),
                    new PlantEntity(null, "Cynamonowiec", "Drzewo przyprawowe", PlantType.TREE, 30.0, 90.0, 60.0, 0.5,
                            1080, null),
                    new PlantEntity(null, "Goździk", "Roślina ozdobna", PlantType.HERB, 12.0, 30.0, 20.0, 0.4, 840,
                            null),
                    new PlantEntity(null, "Kapusta", "Warzywo", PlantType.HERB, 10.0, 25.0, 15.0, 0.3, 600, null),
                    new PlantEntity(null, "Kwiat magnolii", "Kwiat ozdobny", PlantType.SHRUB, 15.0, 35.0, 25.0, 0.5, 960
                            , null),
                    new PlantEntity(null, "Juka", "Roślina ozdobna", PlantType.HERB, 20.0, 40.0, 30.0, 0.6, 1200, null),
                    new PlantEntity(null, "Dziurawiec", "Zioło lecznicze", PlantType.HERB, 6.0, 12.0, 8.0, 0.2, 480,
                            null),
                    new PlantEntity(null, "Lilak", "Krzew ozdobny", PlantType.SHRUB, 12.0, 30.0, 20.0, 0.4, 720, null),
                    new PlantEntity(null, "Buk", "Drzewo liściaste", PlantType.TREE, 35.0, 100.0, 70.0, 0.7, 1320,
                            null),
                    new PlantEntity(null, "Eukaliptus", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0, 0.8, 1440
                            , null),
                    new PlantEntity(null, "Papryka", "Warzywo", PlantType.HERB, 12.0, 28.0, 18.0, 0.3, 720, null),
                    new PlantEntity(null, "Kaktus", "Roślina ozdobna", PlantType.SHRUB, 5.0, 15.0, 10.0, 0.2, 480,
                            null),
                    new PlantEntity(null, "Żywotnik", "Krzew iglasty", PlantType.SHRUB, 8.0, 20.0, 15.0, 0.3, 600,
                            null),
                    new PlantEntity(null, "Dynia", "Warzywo", PlantType.HERB, 15.0, 40.0, 25.0, 0.4, 840, null),
                    new PlantEntity(null, "Kwiat storczyka", "Kwiat ozdobny", PlantType.HERB, 10.0, 25.0, 18.0, 0.3, 720
                            , null),
                    new PlantEntity(null, "Kasztanowiec", "Drzewo liściaste", PlantType.TREE, 50.0, 150.0, 100.0, 1.0,
                            1440, null),
                    new PlantEntity(null, "Fiołek", "Roślina ozdobna", PlantType.HERB, 6.0, 12.0, 8.0, 0.2, 480, null),
                    new PlantEntity(null, "Czosnek", "Zioło kulinarne", PlantType.HERB, 8.0, 15.0, 10.0, 0.2, 600,
                            null),
                    new PlantEntity(null, "Różówka", "Roślina ozdobna", PlantType.SHRUB, 12.0, 30.0, 20.0, 0.4, 720,
                            null),
                    new PlantEntity(null, "Karczocha", "Warzywo", PlantType.HERB, 10.0, 22.0, 15.0, 0.3, 840, null),
                    new PlantEntity(null, "Aloes", "Roślina lecznicza", PlantType.HERB, 5.0, 18.0, 12.0, 0.1, 480,
                            null),
                    new PlantEntity(null, "Jabłoń ozdobna", "Drzewo ozdobne", PlantType.TREE, 25.0, 80.0, 50.0, 0.5,
                            1080, null),
                    new PlantEntity(null, "Różanecznik", "Krzew ozdobny", PlantType.SHRUB, 15.0, 35.0, 25.0, 0.4, 960,
                            null),
                    new PlantEntity(null, "Chaber bławatek", "Roślina ozdobna", PlantType.HERB, 8.0, 20.0, 15.0, 0.3,
                            720, null),
                    new PlantEntity(null, "Kasztanowiec jadalny", "Drzewo owocowe", PlantType.TREE, 45.0, 130.0, 90.0,
                            0.9, 1320, null),
                    new PlantEntity(null, "Bazyliszek czerwony", "Roślina ozdobna", PlantType.SHRUB, 10.0, 25.0, 18.0,
                            0.3, 600, null),
                    new PlantEntity(null, "Rukiew wodna", "Roślina wodna", PlantType.HERB, 5.0, 12.0, 8.0, 0.2, 480,
                            null)
            );

            plantRepository.saveAll(plants);
        }

//        Batches
        if (batchRepository.count() == 0) {
            List<ShelfEntity> shelves = warehouseService.getWarehouseShelves();
            List<PlantEntity> plants = plantService.getPlants();
            List<BatchEntity> batches = new ArrayList<>();
            Random random = new Random();

            for (int i = 1; i <= 25; i++) {
                PlantEntity randomPlant = plants.get(random.nextInt(plants.size()));
                Double randomPrice = Double.valueOf(Math.round(i * Math.random() * 100));

                ShelfEntity shelfEntity = shelves.get(i);
                BatchEntity newBatch = new BatchEntity(null, randomPlant, randomPrice,
                        randomPlant.getMaximumQuantityInBatch(),
                        shelfEntity, null);
                batches.add(newBatch);
            }

            batchRepository.saveAll(batches);
        }

    }
}
