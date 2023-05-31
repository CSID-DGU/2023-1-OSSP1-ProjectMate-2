-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: akobot
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jungsi`
--

DROP TABLE IF EXISTS `jungsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jungsi` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `condition_text` varchar(1000) DEFAULT NULL,
  `elseData` varchar(1000) DEFAULT NULL,
  `point` varchar(1000) DEFAULT NULL,
  `level` int NOT NULL,
  `else_data` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school-jungsi` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jungsi`
--

LOCK TABLES `jungsi` WRITE;
/*!40000 ALTER TABLE `jungsi` DISABLE KEYS */;
INSERT INTO `jungsi` VALUES (11111,'jungsi','jungsi_basic','재외국민 전형에서는 재외국민과 12년 해외 전교육과정 이수자 및 새터민인 경우 해당하고 인문계열/영화영상학과에서는 1단계 국어 50%, 영어 50%로 6배수를 뽑고 2단계에서는 1단계 성적으로 지원자격심사릃 진행해. 그리고 자연계열에서는 1단계 영어 50%, 수학 50%로 6배수를 뽑고 2단계에서는 1단계 성적으로 지원자격심사를 진행해. 외국인 전형은 부모 모두 외국인인 경우에 대항하고 인문/자연/예능(영화영상)에서는 서류종합평가 100%, 예능(미술/연극)에서는 실기구술 100%로 뽑아','\"\"','인문계열 / 자연계열 / 영화영상학과는 수능 100%로 바로 합격자를 뽑아! 체육교육과 / 조소 전공은 수능 60% 실기 40%로 바로 합격자를 뽑아!',4,NULL),(11111,'jungsi','jungsi_farming','? 농어촌 지역 또는 「도서?벽지 교육진흥법」 제2조에 따른 고등학교 졸업(예정)자로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득하고 아래 중 하나에 해당하는 자 [유형1] <농어촌지역> 중','\"\"','수능 100%로 바로 합격자를 뽑아!',4,NULL),(11111,'jungsi','jungsi_incumbent','? 아래 중 하나에 해당하는 자로서 산업체 근무경력이 통산 3년 이상인 재직자','\"\"','수능 최저는 적용하지 않고, 학생부 교과 70%, 서류 종합 30%로 합격자를 뽑아!',4,NULL),(11111,'jungsi','jungsi_normal','국내ㆍ외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되 는 자(외국 검정고시 합격자 제외)로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득한 자','\"\"','수능 100%로 바로 합격자를 뽑아',4,NULL),(11111,'jungsi','jungsi_specialized','특성화고등학교 졸업(예정)자로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득하고 고교 이수 과와 우리대학 지원 모집단위가 동일계열인 자','\"\"','수능 100%로 바로 합격자를 뽑아!',4,NULL);
/*!40000 ALTER TABLE `jungsi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31 23:26:25
