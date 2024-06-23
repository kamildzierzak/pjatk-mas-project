package mas.ManagementSystem.config;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.AddressEntity;
import mas.ManagementSystem.domain.entities.OrderEntity;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.entities.people.CustomerEntity;
import mas.ManagementSystem.domain.entities.people.EmployeeEntity;
import mas.ManagementSystem.domain.entities.people.PersonEntity;
import mas.ManagementSystem.domain.entities.people.SupplierEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import mas.ManagementSystem.domain.types.EmployeeRole;
import mas.ManagementSystem.domain.types.PlantType;
import mas.ManagementSystem.services.BatchService;
import mas.ManagementSystem.services.OrderService;
import mas.ManagementSystem.services.PersonService;
import mas.ManagementSystem.services.PlantService;
import mas.ManagementSystem.services.ShelfService;
import mas.ManagementSystem.services.WarehouseService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {

  private final WarehouseService warehouseService;
  private final ShelfService shelfService;
  private final PersonService personService;
  private final OrderService orderService;
  private final BatchService batchService;
  private final PlantService plantService;

  @PostConstruct
  public void init() {

    warehouseService.initializeWarehouse();

//      Plants - TODO move some business logic to services
    if (plantService.getNumberOfPlants() == 0) {
      List<PlantEntity> plants = Arrays.asList(
          new PlantEntity(null, "Bazylia", "Zioło kulinarne", PlantType.HERB, 10.0, 20.0, 10.0, 0.2,
              960,
              null),
          new PlantEntity(null, "Róża", "Kwiat ogrodowy", PlantType.SHRUB, 15.0, 30.0, 20.0, 0.3,
              720, null),
          new PlantEntity(null, "Bluszcz", "Roślina pnąca", PlantType.CREEPER, 5.0, 25.0, 15.0, 0.1,
              480,
              null),
          new PlantEntity(null, "Dąb", "Potężne drzewo liściaste", PlantType.TREE, 50.0, 150.0,
              100.0, 1.0,
              1440, null),
          new PlantEntity(null, "Malina", "Krzew owocowy", PlantType.SHRUB, 8.0, 20.0, 12.0, 0.4,
              600, null),
          new PlantEntity(null, "Jagoda", "Roślina wrzosowata", PlantType.SHRUB, 7.0, 18.0, 10.0,
              0.3, 540,
              null),
          new PlantEntity(null, "Tulipan", "Kwiat wiosenny", PlantType.HERB, 12.0, 25.0, 18.0, 0.2,
              840,
              null),
          new PlantEntity(null, "Klon", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0, 0.8,
              1200,
              null),
          new PlantEntity(null, "Orzech włoski", "Drzewo owocowe", PlantType.TREE, 60.0, 180.0,
              150.0, 1.5,
              1800, null),
          new PlantEntity(null, "Rumianek", "Zioło lecznicze", PlantType.HERB, 5.0, 15.0, 8.0, 0.1,
              360,
              null),
          new PlantEntity(null, "Żurawina", "Krzew owocowy", PlantType.SHRUB, 10.0, 22.0, 14.0, 0.5,
              720,
              null),
          new PlantEntity(null, "Brzoza", "Drzewo liściaste", PlantType.TREE, 30.0, 90.0, 60.0, 0.6,
              1080,
              null),
          new PlantEntity(null, "Paproć", "Roślina ozdobna", PlantType.HERB, 18.0, 35.0, 25.0, 0.3,
              960,
              null),
          new PlantEntity(null, "Sosna", "Drzewo iglaste", PlantType.TREE, 55.0, 160.0, 110.0, 1.2,
              1560,
              null),
          new PlantEntity(null, "Jabłoń", "Drzewo owocowe", PlantType.TREE, 45.0, 130.0, 90.0, 0.9,
              1320,
              null),
          new PlantEntity(null, "Lawenda", "Zioło ozdobne", PlantType.HERB, 8.0, 18.0, 12.0, 0.2,
              720, null),
          new PlantEntity(null, "Mirt", "Krzew ozdobny", PlantType.SHRUB, 12.0, 28.0, 20.0, 0.4,
              840, null),
          new PlantEntity(null, "Dzika róża", "Krzew dziki", PlantType.SHRUB, 10.0, 25.0, 15.0, 0.3,
              600,
              null),
          new PlantEntity(null, "Oliwka", "Drzewo owocowe", PlantType.TREE, 25.0, 80.0, 50.0, 0.5,
              1080,
              null),
          new PlantEntity(null, "Mięta", "Zioło lecznicze", PlantType.HERB, 7.0, 15.0, 10.0, 0.2,
              480, null),
          new PlantEntity(null, "Cyprys", "Drzewo iglaste", PlantType.TREE, 40.0, 110.0, 70.0, 0.7,
              1200,
              null),
          new PlantEntity(null, "Chryzantema", "Roślina ozdobna", PlantType.HERB, 10.0, 20.0, 15.0,
              0.3, 720,
              null),
          new PlantEntity(null, "Jałowiec", "Krzew iglasty", PlantType.SHRUB, 8.0, 25.0, 18.0, 0.3,
              960,
              null),
          new PlantEntity(null, "Śliwa", "Drzewo owocowe", PlantType.TREE, 35.0, 100.0, 70.0, 0.6,
              1320,
              null),
          new PlantEntity(null, "Cynamonowiec", "Drzewo przyprawowe", PlantType.TREE, 30.0, 90.0,
              60.0, 0.5,
              1080, null),
          new PlantEntity(null, "Goździk", "Roślina ozdobna", PlantType.HERB, 12.0, 30.0, 20.0, 0.4,
              840,
              null),
          new PlantEntity(null, "Kapusta", "Warzywo", PlantType.HERB, 10.0, 25.0, 15.0, 0.3, 600,
              null),
          new PlantEntity(null, "Kwiat magnolii", "Kwiat ozdobny", PlantType.SHRUB, 15.0, 35.0,
              25.0, 0.5, 960
              , null),
          new PlantEntity(null, "Juka", "Roślina ozdobna", PlantType.HERB, 20.0, 40.0, 30.0, 0.6,
              1200, null),
          new PlantEntity(null, "Dziurawiec", "Zioło lecznicze", PlantType.HERB, 6.0, 12.0, 8.0,
              0.2, 480,
              null),
          new PlantEntity(null, "Lilak", "Krzew ozdobny", PlantType.SHRUB, 12.0, 30.0, 20.0, 0.4,
              720, null),
          new PlantEntity(null, "Buk", "Drzewo liściaste", PlantType.TREE, 35.0, 100.0, 70.0, 0.7,
              1320,
              null),
          new PlantEntity(null, "Eukaliptus", "Drzewo liściaste", PlantType.TREE, 40.0, 120.0, 80.0,
              0.8, 1440
              , null),
          new PlantEntity(null, "Papryka", "Warzywo", PlantType.HERB, 12.0, 28.0, 18.0, 0.3, 720,
              null),
          new PlantEntity(null, "Kaktus", "Roślina ozdobna", PlantType.SHRUB, 5.0, 15.0, 10.0, 0.2,
              480,
              null),
          new PlantEntity(null, "Żywotnik", "Krzew iglasty", PlantType.SHRUB, 8.0, 20.0, 15.0, 0.3,
              600,
              null),
          new PlantEntity(null, "Dynia", "Warzywo", PlantType.HERB, 15.0, 40.0, 25.0, 0.4, 840,
              null),
          new PlantEntity(null, "Kwiat storczyka", "Kwiat ozdobny", PlantType.HERB, 10.0, 25.0,
              18.0, 0.3, 720
              , null),
          new PlantEntity(null, "Kasztanowiec", "Drzewo liściaste", PlantType.TREE, 50.0, 150.0,
              100.0, 1.0,
              1440, null),
          new PlantEntity(null, "Fiołek", "Roślina ozdobna", PlantType.HERB, 6.0, 12.0, 8.0, 0.2,
              480, null),
          new PlantEntity(null, "Czosnek", "Zioło kulinarne", PlantType.HERB, 8.0, 15.0, 10.0, 0.2,
              600,
              null),
          new PlantEntity(null, "Różówka", "Roślina ozdobna", PlantType.SHRUB, 12.0, 30.0, 20.0,
              0.4, 720,
              null),
          new PlantEntity(null, "Karczocha", "Warzywo", PlantType.HERB, 10.0, 22.0, 15.0, 0.3, 840,
              null),
          new PlantEntity(null, "Aloes", "Roślina lecznicza", PlantType.HERB, 5.0, 18.0, 12.0, 0.1,
              480,
              null),
          new PlantEntity(null, "Jabłoń ozdobna", "Drzewo ozdobne", PlantType.TREE, 25.0, 80.0,
              50.0, 0.5,
              1080, null),
          new PlantEntity(null, "Różanecznik", "Krzew ozdobny", PlantType.SHRUB, 15.0, 35.0, 25.0,
              0.4, 960,
              null),
          new PlantEntity(null, "Chaber bławatek", "Roślina ozdobna", PlantType.HERB, 8.0, 20.0,
              15.0, 0.3,
              720, null),
          new PlantEntity(null, "Kasztanowiec jadalny", "Drzewo owocowe", PlantType.TREE, 45.0,
              130.0, 90.0,
              0.9, 1320, null),
          new PlantEntity(null, "Bazyliszek czerwony", "Roślina ozdobna", PlantType.SHRUB, 10.0,
              25.0, 18.0,
              0.3, 600, null),
          new PlantEntity(null, "Rukiew wodna", "Roślina wodna", PlantType.HERB, 5.0, 12.0, 8.0,
              0.2, 480,
              null)
      );

      plantService.createPlants(plants);
    }

//      Persons - TODO move some business logic to services
    if (personService.getNumberOfPeople() == 0) {
      List<PersonEntity> persons = new ArrayList<>();

      PersonEntity personEntity1 = new PersonEntity(null, "Janusz", "Tester", null, "123456789",
          "tester" +
              "@example.com", null, null, null, null);
      AddressEntity addressEntity1 = new AddressEntity(null, "Pogodna", "Warszawa", "Mazowieckie",
          "12-345",
          "Polska", personEntity1);
      personEntity1.setAddressEntity(addressEntity1);
      EmployeeEntity employeeEntity1 = new EmployeeEntity(null, personEntity1, LocalDate.now(),
          null, 5555D
      );
      personEntity1.setEmployeeEntity(employeeEntity1);
      personEntity1.getEmployeeEntity().addRole(EmployeeRole.WAREHOUSE_WORKER);
      SupplierEntity supplierEntity1 = new SupplierEntity(null, personEntity1, null);
      personEntity1.setSupplierEntity(supplierEntity1);

      PersonEntity personEntity2 = new PersonEntity(null, "Marlena", "Testerka", null, "987654321",
          "marlo@test.com", null, null, null, null);
      AddressEntity addressEntity2 = new AddressEntity(null, "Deszczowa", "Warszawa", "Mazowieckie",
          "12-345",
          "Polska", personEntity1);
      personEntity2.setAddressEntity(addressEntity2);
      EmployeeEntity employeeEntity2 = new EmployeeEntity(null, personEntity2, LocalDate.now(),
          null, 6666D
      );
      personEntity2.setEmployeeEntity(employeeEntity2);
      personEntity2.getEmployeeEntity().addRole(EmployeeRole.ADMINISTRATOR);
      CustomerEntity customerEntity2 = new CustomerEntity(null, personEntity2, null);
      personEntity2.setCustomerEntity(customerEntity2);

      persons.add(personEntity1);
      persons.add(personEntity2);
      personService.createPeople(persons);
    }

//      Batches - TODO move some business logic to services
    if (batchService.getNumberOfBatches() == 0) {
      List<ShelfEntity> shelves = warehouseService.getWarehouseShelves();
      List<PlantEntity> plants = plantService.getPlants();
      List<BatchEntity> batches = new ArrayList<>();
      Random random = new Random();

      for (int i = 1; i <= 100; i++) {
        PlantEntity randomPlant = plants.get(random.nextInt(plants.size()));
        Double randomPrice = Double.valueOf(Math.round(i * Math.random() * 100));

        ShelfEntity shelfEntity = shelves.get(i);
        BatchEntity newBatch = new BatchEntity(null, randomPlant, randomPrice,
            randomPlant.getMaximumQuantityInBatch(),
            shelfEntity, null);
        batches.add(newBatch);
      }

      batchService.createBatches(batches);
    }

//      Orders
    if (orderService.getNumberOfOrder() == 0) {
      List<PlantEntity> plants = plantService.getPlants();
      Random random = new Random();

      for (int i = 1; i <= 10; i++) {
        PlantEntity randomPlant1 = plants.get(random.nextInt(plants.size()));
        PlantEntity randomPlant2 = plants.get(random.nextInt(plants.size()));
        Double randomPrice = Double.valueOf(Math.round(i * Math.random() * 10000));

        OrderEntity orderEntity = orderService.createPurchaseOrder(LocalDateTime.now(), randomPrice,
            1L);
        BatchEntity batchEntity1 = batchService.createBatch(randomPlant1, randomPrice / 10,
            randomPlant1.getMaximumQuantityInBatch());
        BatchEntity batchEntity2 = batchService.createBatch(randomPlant2, randomPrice / 10,
            randomPlant2.getMaximumQuantityInBatch());
        BatchEntity batchEntity3 = batchService.createBatch(randomPlant2, randomPrice / 10,
            randomPlant2.getMaximumQuantityInBatch());

        orderService.addBatchToOrder(orderEntity.getId(), batchEntity1);
        orderService.addBatchToOrder(orderEntity.getId(), batchEntity2);
        orderService.addBatchToOrder(orderEntity.getId(), batchEntity3);
      }
    }

  }

}
