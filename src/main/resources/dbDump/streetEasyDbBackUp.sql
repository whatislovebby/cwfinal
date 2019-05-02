-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: street_easy
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_for_rent`
--

DROP TABLE IF EXISTS `address_for_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address_for_rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `house` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_for_rent`
--

LOCK TABLES `address_for_rent` WRITE;
/*!40000 ALTER TABLE `address_for_rent` DISABLE KEYS */;
INSERT INTO `address_for_rent` VALUES (1,'Московский район','3','пр. Победителей ','Минск',53.919333,27.570742),(3,'Фрунзенский район','91','ул. Грушевская ','Минск',53.909838,27.473428),(4,'Советский район','26','ул. Бельского ','Минск',53.93959,27.45502),(5,'Первомайский район','3','ул. Ратомская','Минск',53.858521,27.595785),(7,'Первомайский район','27','ул. Стариновская ','Минск',53.873097,27.495236),(9,'Фрунзенский район','4 ','ул. Скрыганова 4 ','Минск',53.93959,27.473428);
/*!40000 ALTER TABLE `address_for_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_for_sale`
--

DROP TABLE IF EXISTS `address_for_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address_for_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `house` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_for_sale`
--

LOCK TABLES `address_for_sale` WRITE;
/*!40000 ALTER TABLE `address_for_sale` DISABLE KEYS */;
INSERT INTO `address_for_sale` VALUES (1,'Центральный район','11',53.916497,27.526979,'ул. Грибоедова','Минск');
/*!40000 ALTER TABLE `address_for_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment_for_rent`
--

DROP TABLE IF EXISTS `apartment_for_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `apartment_for_rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `room_count` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `max_floor` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `visitors_count` int(11) DEFAULT NULL,
  `address` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk8rcbdqvenpxf49b65dssc1c8` (`address`),
  KEY `FK9w3vr39prj5wesqnkw1h4daep` (`user`),
  CONSTRAINT `FK9w3vr39prj5wesqnkw1h4daep` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKk8rcbdqvenpxf49b65dssc1c8` FOREIGN KEY (`address`) REFERENCES `address_for_rent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment_for_rent`
--

LOCK TABLES `apartment_for_rent` WRITE;
/*!40000 ALTER TABLE `apartment_for_rent` DISABLE KEYS */;
INSERT INTO `apartment_for_rent` VALUES (1,'1-комнатная квартира на пр. Победителей 3 , Минск','Сдается новая, комфортабельная 1 комнатная квартира по ул. Червякова 62. В новом доме с подземным паркингом, видео наблюдением и круглосуточным консьержем. В квартире выполнен дизайнерский ремонт, имеется вся необходимая мебель и техника. Наличие отдельной спальной зоны. Коммунальные не высокие. В стоимость могут быть включены все коммунальные расходы',1,17,20,400,550,1,5),(3,'3-комнатная квартира на ул. Грушевская 91 , Минск','Сдается просторная 3-комн. квартира рядом со ст.м. Грушевка на ул. Грушевская 91. Квартира полностью меблирована, есть все необходимое для комфортного проживания, включая посудомоечную машину, 3 телевизора. Отличный ремонт, на полу паркетная доска и плитка, есть вместительные шкафы-купе, 2 сан.узла, 2 лоджии. Площадь квартиры составляет 105 кв.м., располагается на 7 этаже. Дом 2007 года постройки, есть парковка. Всего 3 минуты ходьбы от ст. метро Грушевка. Рядом магазины, школа, сквер, оздоровительный спортивный центр с бассейном, отличная инфраструктура. Коммунальные платежи небольшие. Оплата по факту.',3,7,10,400,12,3,4),(4,'2-комнатная квартира на ул. Бельского 26 , Минск','Сдаётся уютная двухкомнатная квартира по адресу Бельского 26.В квартире имеется вся необходимая мебель и бытовая техника для комфортного проживания: холодильник,посуда, свч-печь, стиральная машина, плазменный телевизор, интернет и т.д. Квартира площадью 74/45/12 находится на 8-ом этаже в 9-ти этажном доме. Имеется застеклённый балкон. Рядом благоустроенный двор,парковка, детская площадка, на заднем дворе пруд с рыбками.Рядом магазин, супермаркет, рынок, спортивный центр.',2,6,9,480,77,4,5),(5,'3-комнатная квартира на ул. Ратомская , Минск','Трехкомнатная квартира в которой вы почувствуете уют и комфорт, который покорит вас !Площадь квартиры 102/47.1/15 кв.м. Полностью укомплектована всей бытовой техникой мировых брендов, хорошая итальянская мебель ,сантехника, установлены кондиционеры, подогрев пола, посудомоечная машина,свч печь, кофемашина, чайник, мультиварка, вся посуда, ковер, пылесосс, гладильная доска, видео-домофон, сигнализация.Развита инфраструктура, рядом много магазинов шаговой доступности, ТЦ «Аrena City», СК «Арена-Минск», «Мир фитнеса», дет.сады, школы, почта, несколько отделений банков, кинотеатры и мн.др. Отличное транспортное сообщение. Так же рядом Биологический заказник «Лебяжий», водохранилище «Дрозды», большое количество мест для отдыха и активного проведения досуга, в нескольких километрах – Заславское водохранилище.Комунальные платежи входят в сумму аренды!',3,6,15,1100,13,5,2),(6,'4-комнатная квартира на ул. Стариновская 27 , Минск','Сдается современная 4-комнатная квартира на 4 этаже 5-ти этажного кирпичного дома, общей площадью 120/100/16 м². Дом находится в живописном месте, рядом с лесом, на территории выполнен ландшафтный дизайн. Качественный ремонт выполнен из дорогостоящих, современных материалов, на полу паркет плитка. Большая гостиная. Кухня полностью укомплектована всей необходимой техникой, посудомоечная машина, духовой шкаф, микроволновая печь. Дом элитного уровня, камеры слежения, детская площадка, охраняемая парковка, подземный гараж! В шаговой достyпности метpо Уручье! Хоpошая pазвязка, недалёко от МКАД. Квартира идеальна для тех, кто предпочитает жить с удобством, но при этом ценит тишину.',4,4,5,400,1,7,3),(7,'-комнатная квартира на ул. Скрыганова 4 -Б , Минск','Сдается просторная 3-х комн. квартира с евроремонтом по ул. Скрыганова, 4б (рядом ТЦ \"Корона\", 5 мин. до ст.м. Молодежная\"). Имеется подземный паркинг. Современная планировка, французские окна: 2 спальни (имеется 2 двуспальные кровати), вместительная гардеробная, просторный зал совмещенный с кухней со встроенной бытовой техникой,застекленной лоджия с отоплением - открывается прекрасный вид, (большая ванная комната). Шикарная квартира с качественным, дизайнерским ремонтом. Квартира оснащена бойлером, видео-домофоном, посудомоечной машиной, холодильником, СВЧ, варочная поверхность, духовой шкаф, вытяжка, холодильник, телевизор. Дом современный, повышенной комфортности с видеонаблюдением по периметру, хорошие лифты. Готова для заселения и комфортного проживания.',3,2,13,700,12,9,10);
/*!40000 ALTER TABLE `apartment_for_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment_for_sale`
--

DROP TABLE IF EXISTS `apartment_for_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `apartment_for_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `floor` int(11) DEFAULT NULL,
  `max_floor` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `room_count` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `visitors_count` int(11) DEFAULT NULL,
  `address` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8gcqjir2c36nqu1brws1fbjp4` (`address`),
  KEY `FKg4qthbjhbfj6t2x4tss3vlq8y` (`user`),
  CONSTRAINT `FK8gcqjir2c36nqu1brws1fbjp4` FOREIGN KEY (`address`) REFERENCES `address_for_sale` (`id`),
  CONSTRAINT `FKg4qthbjhbfj6t2x4tss3vlq8y` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment_for_sale`
--

LOCK TABLES `apartment_for_sale` WRITE;
/*!40000 ALTER TABLE `apartment_for_sale` DISABLE KEYS */;
INSERT INTO `apartment_for_sale` VALUES (1,'Квартал «Залаты Маёнтак»: «Залаты Маёнтак» представляет собой композицию семи малоэтажных домов клубного типа с общей придомовой территорией. Квартал расположился в тихом сквере Грибоедова, что создаёт благоприятную атмосферу домашнего уюта и спокойствия. Социальный уровень жильцов комплекса «Залаты Маёнтак» на высоком, однородном уровне и клубность комплекса, позволяет конструктивно вести совместное домовладение. Интеллигентные и дружелюбные соседи, при случайной встрече Вам всегда пожелают хорошего дня! В шаговой доступности Современный Парк Победы, Комсомольское озеро, единственная в городе полноценная велотрасса, протяжностью 27 километров. Полная инфраструктура района (гипермаркет ”Корона”, средняя школа, музыкальная школа, гимназия, детские садики и многое другое). Близость проспекта Победителей, проспекта Машерова позволит Вам быстро и удобно добраться в любую точку города. P.S. Дом введён в эксплуатацию осенью 2014 года. Некоторые квартиры уже с отделкой и первые счастливые жильцы заселяются! Звоните прямо сейчас и мы договоримся о презентации этой квартиры! «Правильное решение, принятое вовремя, приводит к успеху»',6,10,336555,3,'3-комнатная квартира на ул. Грибоедова 11 , Минск',12,1,5);
/*!40000 ALTER TABLE `apartment_for_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aa','Admin','aa','aa','aa','aa',''),(2,'$2a$08$NyY5LP3KQiMdvwD2h0nAvOHmu.iFPmBwzDaDljce0YaIj47Jwul82','USER','zz@zz',NULL,NULL,NULL,NULL),(3,'$2a$08$pt3T//0wS.nYYhG86w9sa.hNQG665U1iSd8PvNkVlcHSg.YxQKd6m','USER','egor@egor',NULL,NULL,NULL,NULL),(4,'$2a$08$MQrd4EP7pfWGPSFEXyYiDuPfnJCpbhtoDq/l84c13Z2xbc6w5G6H.','USER','qwerty@mail.com',NULL,NULL,NULL,NULL),(5,'$2a$08$mFinL9mSW48uKVSKq.pqyu1i9ouCvKftWB04eLpMJY3Lu0kLT/F/W','USER','zx','egor.kirilenko.99@gmail.com','egor','egor','+375445686574'),(10,'$2a$08$Yrg1Om6z3wE56V/AUX.e1u0ACtD2IISzYaFsPRJ5.lrFDtbwVCmGW','USER','qw','','','','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'street_easy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-02 11:58:08
